/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.das.mngt.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.azdai.core.das.dal.dao.ForumInfoDAO;
import com.azdai.core.das.dal.dao.ForumTopicDAO;
import com.azdai.core.das.dal.dao.ForumUserDAO;
import com.azdai.core.das.dal.dto.ForumInfoDTO;
import com.azdai.core.das.dal.dto.ForumTopicDTO;
import com.azdai.core.das.dal.dto.ForumUserDTO;
import com.azdai.core.das.dal.query.ForumTopicQuery;
import com.azdai.core.das.mngt.ForumMngt;
import com.azdai.core.model.ForumInfoModel;
import com.azdai.core.model.ForumTopicModel;
import com.azdai.core.model.ForumTopicPageList;
import com.azdai.core.model.ForumTopicView;
import com.azdai.core.model.ForumUserModel;
import com.azdai.core.model.convert.ForumInfoConvert;
import com.azdai.core.model.convert.ForumTopicConvert;
import com.azdai.core.model.convert.ForumUserConvert;
import com.azdai.core.model.enums.ForumTopicCatgEnum;
import com.azdai.core.model.enums.ForumTopicStateEnum;
import com.azdai.core.model.enums.ForumTopicTopEnum;
import com.azdai.core.web.form.ForumTopicQueryForm;
import com.github.obullxl.lang.Paginator;
import com.github.obullxl.lang.enums.ValveBoolEnum;
import com.github.obullxl.lang.timer.TickTimer;
import com.github.obullxl.lang.utils.DateUtils;
import com.github.obullxl.lang.utils.LogUtils;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;

/**
 * 论坛管理器实现
 * 
 * @author obullxl@gmail.com
 * @version $Id: ForumMngtImpl.java, V1.0.1 2014年3月13日 下午10:09:59 $
 */
@Component("forumMngt")
public class ForumMngtImpl implements TickTimer, ForumMngt {
    private static final Logger                         logger        = LogUtils.get();

    /** 论坛模型-最近执行时间 */
    private static Date                                 EXEC_TIME;

    /** 论坛模型-执行时间间隔(11分钟) */
    private static final long                           INTERVAL      = 11 * 60 * 1000;

    /** 论坛模型-论坛管理员 */
    private static final List<ForumUserModel>           USER_CACHE    = new ArrayList<ForumUserModel>();

    /** 论坛模型-论坛模型 */
    private static final List<ForumInfoModel>           FORUM_CACHE   = new ArrayList<ForumInfoModel>();

    /** 论坛信息DAO */
    @Autowired
    private ForumInfoDAO                                forumInfoDAO;

    /** 论坛主贴DAO */
    @Autowired
    private ForumTopicDAO                               forumTopicDAO;

    /** 论坛用户DAO */
    @Autowired
    private ForumUserDAO                                forumUserDAO;

    /** 置顶主贴列表缓存 */
    private LoadingCache<String, List<ForumTopicModel>> topTopicCache = CacheBuilder.newBuilder() //
                                                                          .maximumSize(20).expireAfterWrite(30, TimeUnit.MINUTES)//
                                                                          .build(new CacheLoader<String, List<ForumTopicModel>>() { //
                                                                                  public List<ForumTopicModel> load(String forum) {
                                                                                      String top = ForumTopicTopEnum.FORUM.code();
                                                                                      if (StringUtils.isBlank(forum)) {
                                                                                          forum = null;
                                                                                          top = ForumTopicTopEnum.GLOBAL.code();
                                                                                      }

                                                                                      String catg = ForumTopicCatgEnum.TOPIC.code();
                                                                                      String state = ForumTopicStateEnum.ACTIVE.code();

                                                                                      List<ForumTopicDTO> srcObjs = forumTopicDAO.findTopTopics(forum, catg, state, top);
                                                                                      return ForumTopicConvert.convert(srcObjs);
                                                                                  }
                                                                              });

    /** 
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    public void afterPropertiesSet() {
        this.onRefresh();
    }

    /**
     * 是否进行缓存刷新
     */
    private boolean isMustExecute() {
        if (EXEC_TIME == null) {
            EXEC_TIME = DateUtils.toDateDW("1988-08-08");
        }

        Date now = new Date();
        if (now.getTime() - EXEC_TIME.getTime() >= INTERVAL) {
            EXEC_TIME = now;
            return true;
        }

        return false;
    }

    /** 
     * @see com.github.obullxl.lang.timer.TickTimer#tick()
     */
    public void tick() {
        if (!this.isMustExecute()) {
            if (logger.isInfoEnabled()) {
                logger.info("[论坛模型]-本次无需操作, [" + DateUtils.toStringDL(EXEC_TIME) + "].");
            }

            return;
        }

        // 定时刷新
        this.onRefresh();
    }

    /**
     * 刷新缓存
     */
    public void onRefresh() {
        logger.warn("[论坛模型]-开始刷新论坛模型缓存......");

        long start = System.currentTimeMillis();
        try {
            List<ForumUserDTO> srcUsers = this.forumUserDAO.findAll();
            List<ForumUserModel> dstUsers = ForumUserConvert.convert(srcUsers);
            USER_CACHE.clear();
            USER_CACHE.addAll(dstUsers);

            List<ForumInfoDTO> srcForums = this.forumInfoDAO.findState(ValveBoolEnum.TRUE.code());
            List<ForumInfoModel> dstForums = ForumInfoConvert.convert(srcForums);
            FORUM_CACHE.clear();
            FORUM_CACHE.addAll(dstForums);

            // 论坛用户
            for (ForumInfoModel forum : dstForums) {
                for (ForumUserModel user : dstUsers) {
                    if (StringUtils.equals(forum.getCode(), user.getForumCode())) {
                        forum.getForumUsers().add(user);
                    }
                }
            }
        } finally {
            logger.warn("[论坛模型]-论坛模型缓存刷新完成, 耗时[{}]ms, 论坛列表: \n{}", (System.currentTimeMillis() - start), FORUM_CACHE);
        }
    }

    /**
     * 获取有效论坛模型
     */
    public List<ForumInfoModel> findValidForums() {
        return new ArrayList<ForumInfoModel>(FORUM_CACHE);
    }

    /**
     * 拉取有效论坛模型
     */
    public List<ForumInfoModel> fetchValidForums() {
        return this.fetchForums(ValveBoolEnum.TRUE);
    }

    /**
     * 拉取有效论坛模型
     */
    public List<ForumInfoModel> fetchForums(ValveBoolEnum stateEnum) {
        List<ForumUserDTO> srcUsers = this.forumUserDAO.findAll();
        List<ForumUserModel> dstUsers = ForumUserConvert.convert(srcUsers);

        List<ForumInfoDTO> srcObjs = null;
        if (stateEnum == null) {
            srcObjs = this.forumInfoDAO.findAll();
        } else {
            srcObjs = this.forumInfoDAO.findState(ValveBoolEnum.TRUE.code());
        }
        List<ForumInfoModel> dstObjs = ForumInfoConvert.convert(srcObjs);

        // 论坛用户
        for (ForumInfoModel forum : dstObjs) {
            for (ForumUserModel user : dstUsers) {
                if (StringUtils.equals(forum.getCode(), user.getForumCode())) {
                    forum.getForumUsers().add(user);
                }
            }
        }

        return dstObjs;
    }

    /**
     * 获取论坛信息
     */
    public ForumInfoModel findForumInfo(String code) {
        for (ForumInfoModel model : FORUM_CACHE) {
            if (StringUtils.equals(code, model.getCode())) {
                return model;
            }
        }

        return this.fetchForumInfo(code);
    }

    /**
     * 拉取论坛信息
     */
    public ForumInfoModel fetchForumInfo(String code) {
        ForumInfoDTO srcObj = this.forumInfoDAO.find(code);
        return ForumInfoConvert.convert(srcObj);
    }

    /**
     * 增加论坛信息
     */
    public void createForumInfo(ForumInfoModel srcObj) {
        ForumInfoDTO dstObj = ForumInfoConvert.convert(srcObj);
        if (dstObj != null) {
            this.forumInfoDAO.insert(dstObj);
        }
    }

    /**
     * 更新论坛信息
     */
    public int updateForumInfo(ForumInfoModel srcObj) {
        ForumInfoDTO dstObj = ForumInfoConvert.convert(srcObj);
        if (dstObj != null) {
            return this.forumInfoDAO.update(dstObj);
        }

        return 0;
    }

    /**
     * 删除论坛信息
     */
    public int removeForumInfo(String code) {
        this.forumUserDAO.deleteForum(code);
        return this.forumInfoDAO.delete(code);
    }

    /**
     * 增加论坛用户
     */
    public void createForumUser(ForumUserModel srcObj) {
        ForumUserDTO dstObj = ForumUserConvert.convert(srcObj);
        if (dstObj != null) {
            this.forumUserDAO.insert(dstObj);
        }
    }

    /**
     * 删除论坛用户
     */
    public int removeForumUser(String code, String userNo) {
        return this.forumUserDAO.delete(code, userNo);
    }

    /** 
     * @see com.azdai.core.das.mngt.ForumMngt#createForumTopic(com.azdai.core.model.ForumTopicModel)
     */
    public void createForumTopic(ForumTopicModel model) {
        ForumTopicDTO dstObj = ForumTopicConvert.convert(model);
        this.forumTopicDAO.insertTopic(dstObj);
    }

    /** 
     * @see com.azdai.core.das.mngt.ForumMngt#createTopicReply(com.azdai.core.model.ForumTopicModel)
     */
    public void createTopicReply(ForumTopicModel model) {
        ForumTopicDTO dstObj = ForumTopicConvert.convert(model);
        this.forumTopicDAO.insertReply(dstObj);
    }

    /** 
     * @see com.azdai.core.das.mngt.ForumMngt#updateTopicReply(com.azdai.core.model.ForumTopicModel)
     */
    public int updateTopicReply(ForumTopicModel model) {
        return this.forumTopicDAO.updateReplyInfo(model.getId(), 1, model.getReplyUserNo(), model.getReplyNickName());
    }

    /** 
     * @see com.azdai.core.das.mngt.ForumMngt#findForumTopic(long)
     */
    public ForumTopicModel findForumTopic(long id) {
        ForumTopicDTO srcObj = this.forumTopicDAO.find(id);
        return ForumTopicConvert.convert(srcObj);
    }

    /** 
     * @see com.azdai.core.das.mngt.ForumMngt#findTopicView(int, long)
     */
    public ForumTopicView findTopicView(int page, long id) {
        ForumTopicView view = new ForumTopicView();

        ForumTopicPageList pageList = null;
        String catg = ForumTopicCatgEnum.REPLY.code();

        ForumTopicModel topic = this.findForumTopic(id);
        if (topic == null || topic.getStateEnum() != ForumTopicStateEnum.ACTIVE) {
            view.setExist(false);
            topic = null;
            pageList = new ForumTopicPageList(new Paginator(), new ArrayList<ForumTopicModel>());
        } else {
            view.setExist(true);
            int count = (int) this.forumTopicDAO.findTopicViewCount(catg, id);
            Paginator paginator = new Paginator(PAGE_SIZE, count);
            paginator.setPageNo(page);

            if (count > 0) {
                List<ForumTopicDTO> list = this.forumTopicDAO.findTopicView(paginator.getOffset(), PAGE_SIZE, catg, id);
                pageList = new ForumTopicPageList(paginator, ForumTopicConvert.convert(list));
            } else {
                pageList = new ForumTopicPageList(paginator, new ArrayList<ForumTopicModel>());
            }
        }

        // 填值
        view.setId(id);
        view.setTopic(topic);
        view.setPageList(pageList);

        // 增加主贴访问次数
        this.forumTopicDAO.updateVisitDelta(id, 1);

        // 返回
        return view;
    }

    /**
     * 查询论坛主贴
     */
    public ForumTopicPageList findForumTopicFuzzy(ForumTopicQueryForm form) {
        ForumTopicQuery query = ForumTopicConvert.convert(form);
        ForumTopicPageList pageList = null;

        int count = (int) this.forumTopicDAO.findFuzzyCount(query);
        Paginator paginator = new Paginator(PAGE_SIZE_MNGT, count);
        paginator.setPageNo(form.getPageNo());

        if (count > 0) {
            query.setOffset(paginator.getOffset());
            query.setPageSize(PAGE_SIZE_MNGT);

            List<ForumTopicDTO> list = this.forumTopicDAO.findFuzzy(query);
            pageList = new ForumTopicPageList(paginator, ForumTopicConvert.convert(list));
        } else {
            // 没有记录
            pageList = new ForumTopicPageList(paginator, new ArrayList<ForumTopicModel>());
        }

        return pageList;
    }

    /** 
     * @see com.azdai.core.das.mngt.ForumMngt#findGlobalTopTopics()
     */
    public List<ForumTopicModel> findGlobalTopTopics() {
        try {
            return this.topTopicCache.get(null);
        } catch (Exception e) {
            return Lists.newArrayList();
        }
    }

    /** 
     * @see com.azdai.core.das.mngt.ForumMngt#findForumTopTopics(java.lang.String)
     */
    public List<ForumTopicModel> findForumTopTopics(String forum) {
        try {
            return this.topTopicCache.get(forum);
        } catch (Exception e) {
            return Lists.newArrayList();
        }
    }

    /** 
     * @see com.azdai.core.das.mngt.ForumMngt#findNormalTopics(int, java.lang.String, com.azdai.core.model.enums.ForumTopicCatgEnum, com.azdai.core.model.enums.ForumTopicStateEnum, com.azdai.core.model.enums.ForumTopicTopEnum)
     */
    public ForumTopicPageList findNormalTopics(int pageNo, String forum, ForumTopicCatgEnum catgEnum, ForumTopicStateEnum stateEnum, ForumTopicTopEnum topEnum) {
        ForumTopicPageList pageList = null;

        int count = (int) this.forumTopicDAO.findNormalTopicCount(forum, catgEnum.code(), stateEnum.code(), topEnum.code());
        Paginator paginator = new Paginator(PAGE_SIZE, count);
        paginator.setPageNo(pageNo);

        if (count > 0) {
            List<ForumTopicDTO> list = this.forumTopicDAO.findNormalTopics(paginator.getOffset(), PAGE_SIZE, forum, catgEnum.code(), stateEnum.code(), topEnum.code());
            pageList = new ForumTopicPageList(paginator, ForumTopicConvert.convert(list));
        } else {
            // 没有记录
            pageList = new ForumTopicPageList(paginator, new ArrayList<ForumTopicModel>());
        }

        return pageList;
    }

}
