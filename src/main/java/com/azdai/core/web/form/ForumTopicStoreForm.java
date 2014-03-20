/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2013 All Rights Reserved.
 */
package com.azdai.core.web.form;

import java.util.List;

import javax.validation.constraints.Size;

import com.azdai.core.das.dal.DBSize;
import com.azdai.core.model.enums.ForumTopicReplyEnum;
import com.azdai.core.model.enums.ForumTopicStateEnum;
import com.azdai.core.model.enums.ForumTopicTopEnum;
import com.github.obullxl.lang.enums.ValveBoolEnum;
import com.github.obullxl.lang.web.form.AbstractForm;
import com.github.obullxl.lang.web.form.EnumBaseValidate;

/**
 * 论坛主贴新增/更新表单
 * 
 * @author obullxl@gmail.com
 * @version $Id: ForumTopicStoreForm.java, V1.0.1 2013年12月29日 上午11:07:31 $
 */
public class ForumTopicStoreForm extends AbstractForm {
    private static final long serialVersionUID = 4246838516504646955L;

    private long              id;

    @Size(min = 1, max = DBSize.FORUM_TOPIC.FORUM_MAX)
    private String            forum;

    @Size(min = 1, max = DBSize.FORUM_TOPIC.STATE_MAX)
    private String            state;

    @Size(min = 1, max = DBSize.FORUM_TOPIC.TOP_FLAG_MAX)
    private String            topFlag;

    @Size(min = 1, max = DBSize.FORUM_TOPIC.ELITE_FLAG_MAX)
    private String            eliteFlag;

    @Size(min = 1, max = DBSize.FORUM_TOPIC.REPLY_FLAG_MAX)
    private String            replyFlag;

    @Size(max = DBSize.FORUM_TOPIC.STYLE_MAX)
    private String            style;

    @Size(min = 3, max = DBSize.FORUM_TOPIC.TITLE_MAX)
    private String            title;

    @Size(min = 10, max = DBSize.FORUM_TOPIC.CONTENT_MAX)
    private String            content;

    /** 
     * @see com.github.obullxl.jeesite.web.form.AbstractForm#enumBases(java.util.List)
     */
    public void enumBases(List<EnumBaseValidate> validates) {
        validates.add(new EnumBaseValidate("state", this.state, ForumTopicStateEnum.values()));
        validates.add(new EnumBaseValidate("topFlag", this.topFlag, ForumTopicTopEnum.values()));
        validates.add(new EnumBaseValidate("eliteFlag", this.eliteFlag, ValveBoolEnum.values()));
        validates.add(new EnumBaseValidate("replyFlag", this.replyFlag, ForumTopicReplyEnum.values()));
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getForum() {
        return forum;
    }

    public void setForum(String forum) {
        this.forum = forum;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTopFlag() {
        return topFlag;
    }

    public void setTopFlag(String topFlag) {
        this.topFlag = topFlag;
    }

    public String getEliteFlag() {
        return eliteFlag;
    }

    public void setEliteFlag(String eliteFlag) {
        this.eliteFlag = eliteFlag;
    }

    public String getReplyFlag() {
        return replyFlag;
    }

    public void setReplyFlag(String replyFlag) {
        this.replyFlag = replyFlag;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
