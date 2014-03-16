/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.das.mngt;

import java.util.List;

import com.azdai.core.model.ForumInfoModel;
import com.azdai.core.model.ForumTopicModel;
import com.azdai.core.model.ForumTopicPageList;
import com.azdai.core.model.ForumTopicView;
import com.azdai.core.model.ForumUserModel;
import com.azdai.core.model.enums.ForumTopicCatgEnum;
import com.azdai.core.model.enums.ForumTopicStateEnum;
import com.azdai.core.model.enums.ForumTopicTopEnum;
import com.azdai.core.web.form.ForumTopicQueryForm;
import com.github.obullxl.lang.enums.ValveBoolEnum;

/**
 * 论坛管理器
 * 
 * @author obullxl@gmail.com
 * @version $Id: ForumMngt.java, V1.0.1 2014年3月13日 下午10:09:06 $
 */
public interface ForumMngt {

    /** 前台：分页大小 */
    public static final int PAGE_SIZE      = 10;

    /** 后台：分页大小 */
    public static final int PAGE_SIZE_MNGT = 30;

    /**
     * 获取有效论坛模型
     */
    public List<ForumInfoModel> findValidForums();

    /**
     * 拉取有效论坛模型
     */
    public List<ForumInfoModel> fetchValidForums();

    /**
     * 拉取有效论坛模型
     */
    public List<ForumInfoModel> fetchForums(ValveBoolEnum stateEnum);

    /**
     * 获取论坛信息
     */
    public ForumInfoModel findForumInfo(String code);

    /**
     * 拉取论坛信息
     */
    public ForumInfoModel fetchForumInfo(String code);

    /**
     * 增加论坛信息
     */
    public void createForumInfo(ForumInfoModel srcObj);

    /**
     * 更新论坛信息
     */
    public int updateForumInfo(ForumInfoModel srcObj);

    /**
     * 删除论坛信息
     */
    public int removeForumInfo(String code);

    /**
     * 增加论坛用户
     */
    public void createForumUser(ForumUserModel srcObj);

    /**
     * 删除论坛用户
     */
    public int removeForumUser(String code, String userNo);

    /**
     * 新增论坛主贴
     */
    public void createForumTopic(ForumTopicModel model);

    /**
     * 新增主贴回贴
     */
    public void createTopicReply(ForumTopicModel model);

    /**
     * 更新主贴回贴
     */
    public int updateTopicReply(ForumTopicModel model);

    /**
     * 根据ID查询主贴视图
     */
    public ForumTopicModel findForumTopic(long id);

    /**
     * 根据ID查询主贴视图
     */
    public ForumTopicView findTopicView(int page, long id);

    /**
     * 查询论坛主贴
     */
    public ForumTopicPageList findForumTopicFuzzy(ForumTopicQueryForm form);

    /**
     * 查找全局置顶主贴
     */
    public List<ForumTopicModel> findGlobalTopTopics(ForumTopicCatgEnum catgEnum, ForumTopicStateEnum stateEnum, ForumTopicTopEnum topEnum);

    /**
     * 查找论坛置顶主贴
     */
    public List<ForumTopicModel> findForumTopTopics(String forum, ForumTopicCatgEnum catgEnum, ForumTopicStateEnum stateEnum, ForumTopicTopEnum topEnum);

    /**
     * 分页查询普通主题主贴
     */
    public ForumTopicPageList findNormalTopics(int pageNo, String forum, ForumTopicCatgEnum catgEnum, ForumTopicStateEnum stateEnum, ForumTopicTopEnum topEnum);

}
