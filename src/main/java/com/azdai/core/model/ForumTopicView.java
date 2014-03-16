/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.model;

import com.github.obullxl.lang.ToString;

/**
 * 论坛主贴视图
 * 
 * @author obullxl@gmail.com
 * @version $Id: ForumTopicView.java, V1.0.1 2014年3月16日 下午5:15:21 $
 */
public class ForumTopicView extends ToString {
    private static final long  serialVersionUID = 677736770153760402L;

    /** 主贴ID */
    private long               id;

    /** 是否存在 */
    private boolean            exist;

    /** 主贴模型 */
    private ForumTopicModel    topic;

    /** 回帖分页列表 */
    private ForumTopicPageList pageList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }

    public ForumTopicModel getTopic() {
        return topic;
    }

    public void setTopic(ForumTopicModel topic) {
        this.topic = topic;
    }

    public ForumTopicPageList getPageList() {
        return pageList;
    }

    public void setPageList(ForumTopicPageList pageList) {
        this.pageList = pageList;
    }

}
