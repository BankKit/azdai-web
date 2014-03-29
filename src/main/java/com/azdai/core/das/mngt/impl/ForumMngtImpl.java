/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.das.mngt.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.InitializingBean;
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
public class ForumMngtImpl implements ForumMngt, InitializingBean {
    private static final Logger                         logger            = LogUtils.get();

    /** 论坛缓存KEY */
    public static final String                          FORUM_CACHE_KEY   = "_forum_cache_key_";

    /** 全局置顶主贴缓存KEY */
    public static final String                          GLOBAL_TOPICS_KEY = "_global_topics_key_";

    /** 论坛信息DAO */
    @Autowired
    private ForumInfoDAO                                forumInfoDAO;

    /** 论坛主贴DAO */
    @Autowired
    private ForumTopicDAO                               forumTopicDAO;

    /** 论坛用户DAO */
    @Autowired
    private ForumUserDAO                                forumUserDAO;

    /** 有效论坛列表缓存 */
    private LoadingCache<String, List<ForumInfoModel>>  forumCache;

    /** 置顶主贴列表缓存 */
    private LoadingCache<String, List<ForumTopicModel>> topTopicCache;

    /** 论坛最新主贴列表缓存 */
    private LoadingCache<String, List<ForumTopicModel>> lastTopicCache;

    /** 
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    public void afterPropertiesSet() {
        // 有效论坛列表
        this.forumCache = CacheBuilder.newBuilder() //
            .maximumSize(20).expireAfterWrite(30, TimeUnit.MINUTES)//
            .build(new CacheLoader<String, List<ForumInfoModel>>() { //
                    public List<ForumInfoModel> load(String key) {
                        List<ForumUserDTO> srcUsers = forumUserDAO.findAll();
                        List<ForumUserModel> dstUsers = ForumUserConvert.convert(srcUsers);

                        List<ForumInfoDTO> srcForums = forumInfoDAO.findState(ValveBoolEnum.TRUE.code());
                        List<ForumInfoModel> dstForums = ForumInfoConvert.convert(srcForums);

                        // 论坛用户
                        for (ForumInfoModel forum : dstForums) {
                            for (ForumUserModel user : dstUsers) {
                                if (StringUtils.equals(forum.getCode(), user.getForumCode())) {
                                    forum.getForumUsers().add(user);
                                }
                            }
                        }

                        // 论坛主贴统计
                        String catg = ForumTopicCatgEnum.TOPIC.code();
                        String state = ForumTopicStateEnum.ACTIVE.code();
                        List<Map<String, Object>> stats = forumTopicDAO.findTopicStats(catg, state);

                        for (ForumInfoModel forum : dstForums) {
                            for (Map<String, Object> stat : stats) {
                                Object value = stat.get(STAT_FORUM_KEY);
                                if (StringUtils.equals(forum.getCode(), ObjectUtils.toString(value))) {
                                    String count = ObjectUtils.toString(stat.get(STAT_COUNT_KEY));
                                    forum.setTopicCount(NumberUtils.toInt(count));
                                    break;
                                }
                            }
                        }

                        return dstForums;
                    }
                });

        // 置顶主题列表
        this.topTopicCache = CacheBuilder.newBuilder() //
            .maximumSize(20).expireAfterWrite(30, TimeUnit.MINUTES)//
            .build(new CacheLoader<String, List<ForumTopicModel>>() { //
                    public List<ForumTopicModel> load(String forum) {
                        String top = ForumTopicTopEnum.FORUM.code();
                        if (StringUtils.equals(forum, GLOBAL_TOPICS_KEY)) {
                            forum = null;
                            top = ForumTopicTopEnum.GLOBAL.code();
                        }

                        String catg = ForumTopicCatgEnum.TOPIC.code();
                        String state = ForumTopicStateEnum.ACTIVE.code();

                        List<ForumTopicDTO> srcObjs = forumTopicDAO.findTopTopics(forum, catg, state, top);
                        return ForumTopicConvert.convert(srcObjs);
                    }
                });

        // 最新主贴列表
        this.lastTopicCache = CacheBuilder.newBuilder() //
            .maximumSize(20).expireAfterWrite(30, TimeUnit.MINUTES)//
            .build(new CacheLoader<String, List<ForumTopicModel>>() { //
                    public List<ForumTopicModel> load(String forum) {
                        String catg = ForumTopicCatgEnum.TOPIC.code();
                        String state = ForumTopicStateEnum.ACTIVE.code();

                        List<ForumTopicDTO> srcObjs = forumTopicDAO.findLastTopics(LAST_TOPIC_SIZE, forum, catg, state);
                        return ForumTopicConvert.convert(srcObjs);
                    }
                });
    }

    /** 
     * @see com.azdai.core.das.mngt.ForumMngt#findValidForums()
     */
    public List<ForumInfoModel> findValidForums() {
        try {
            return this.forumCache.get(FORUM_CACHE_KEY);
        } catch (Exception e) {
            logger.error("[论坛]-缓存获取有效论坛列表异常！", e);
            return Lists.newArrayList();
        }
    }

    /** 
     * @see com.azdai.core.das.mngt.ForumMngt#findLastTopics(java.lang.String)
     */
    public List<ForumTopicModel> findLastTopics(String forum) {
        try {
            return this.lastTopicCache.get(forum);
        } catch (Exception e) {
            logger.error("[论坛]-缓存获取论坛[{}]最新主题列表异常！", forum, e);
            return Lists.newArrayList();
        }
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
        for (ForumInfoModel model : this.findValidForums()) {
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
        long id = this.forumTopicDAO.insertTopic(dstObj);
        model.setId(id);
    }

    /** 
     * @see com.azdai.core.das.mngt.ForumMngt#createTopicReply(com.azdai.core.model.ForumTopicModel)
     */
    public void createTopicReply(ForumTopicModel model) {
        ForumTopicDTO dstObj = ForumTopicConvert.convert(model);
        long id = this.forumTopicDAO.insertReply(dstObj);
        model.setId(id);
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
            return this.topTopicCache.get(GLOBAL_TOPICS_KEY);
        } catch (Exception e) {
            logger.error("[论坛]-缓存获取全局置顶主贴列表异常！", e);
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
            logger.error("[论坛]-缓存获取论坛[{}]置顶主贴列表异常！", forum, e);
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

    /** 
     * @see com.azdai.core.das.mngt.ForumMngt#removeForumTopic(long)
     */
    public int removeForumTopic(long id) {
        return this.forumTopicDAO.delete(id);
    }

    /** 
     * @see com.azdai.core.das.mngt.ForumMngt#updateForumTopic(com.azdai.core.model.ForumTopicModel)
     */
    public int updateForumTopic(ForumTopicModel model) {
        ForumTopicDTO dstObj = ForumTopicConvert.convert(model);
        return this.forumTopicDAO.update(dstObj);
    }

}
