/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.web.webx;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.azdai.core.das.mngt.ForumMngt;
import com.azdai.core.model.ForumInfoModel;
import com.azdai.core.model.ForumTopicModel;
import com.azdai.core.model.ForumTopicPageList;
import com.azdai.core.model.ForumTopicView;
import com.azdai.core.model.enums.ForumTopicCatgEnum;
import com.azdai.core.model.enums.ForumTopicStateEnum;
import com.azdai.core.model.enums.ForumTopicTopEnum;
import com.github.obullxl.lang.webx.WebX;

/**
 * 论坛WebX
 * 
 * @author obullxl@gmail.com
 * @version $Id: ForumWebX.java, V1.0.1 2014年3月14日 下午7:57:58 $
 */
@Component("forumWebX")
public class ForumWebX implements WebX {

    /** 论坛管理器 */
    @Autowired
    private ForumMngt forumMngt;

    /**
     * 拉取所有论坛
     */
    public List<ForumInfoModel> fetchForums() {
        return this.forumMngt.fetchForums(null);
    }

    /**
     * 获取有效论坛
     */
    public List<ForumInfoModel> findValidForums() {
        return this.forumMngt.findValidForums();
    }

    /**
     * 获取论坛信息
     */
    public ForumInfoModel findForum(String code) {
        return this.forumMngt.findForumInfo(code);
    }

    /**
     * 拉取有效论坛
     */
    public ForumInfoModel fetchForum(String code) {
        return this.forumMngt.fetchForumInfo(code);
    }

    /**
     * 获取主贴视图
     */
    public ForumTopicView findTopicView(int page, long id) {
        return this.forumMngt.findTopicView(page, id);
    }

    /**
     * 获取论坛公告主贴
     */
    public List<ForumTopicModel> findGlobalTopTopics() {
        return this.forumMngt.findGlobalTopTopics();
    }

    /**
     * 获取论坛置顶主贴
     */
    public List<ForumTopicModel> findForumTopTopics(String forum) {
        return this.forumMngt.findForumTopTopics(forum);
    }

    /**
     * 分页获取普通论坛主贴
     */
    public ForumTopicPageList findNormalTopics(int pageNo, String forum) {
        return this.forumMngt.findNormalTopics(pageNo, forum, ForumTopicCatgEnum.TOPIC, ForumTopicStateEnum.ACTIVE, ForumTopicTopEnum.NONE);
    }

}
