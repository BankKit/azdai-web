/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2013 All Rights Reserved.
 */
package com.azdai.core.web.form;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Size;

import com.azdai.core.das.dal.DBSize;
import com.github.obullxl.lang.web.form.AbstractForm;
import com.github.obullxl.lang.web.form.EnumBaseValidate;

/**
 * 论坛主贴查询表单
 * 
 * @author obullxl@gmail.com
 * @version $Id: ForumTopicQueryForm.java, V1.0.1 2013年12月29日 上午11:07:31 $
 */
public class ForumTopicQueryForm extends AbstractForm {
    private static final long serialVersionUID = 4246838516504646955L;

    private int               pageNo;

    private Long              id;

    @Size(max = DBSize.FORUM_TOPIC.CATG_MAX)
    private String            catg;

    @Size(max = DBSize.FORUM_TOPIC.FORUM_MAX)
    private String            forum;

    @Size(max = DBSize.FORUM_TOPIC.STATE_MAX)
    private String            state;

    @Size(max = DBSize.FORUM_TOPIC.TOP_FLAG_MAX)
    private String            topFlag;

    @Size(max = DBSize.FORUM_TOPIC.ELITE_FLAG_MAX)
    private String            eliteFlag;

    @Size(max = DBSize.FORUM_TOPIC.REPLY_FLAG_MAX)
    private String            replyFlag;

    private Long              topic;

    @Size(max = DBSize.FORUM_TOPIC.POST_USER_NO_MAX)
    private String            postUserNo;

    private Date              gmtPostBegin;

    private Date              gmtPostFinish;

    @Size(max = DBSize.FORUM_TOPIC.REPLY_USER_NO_MAX)
    private String            replyUserNo;

    private Date              gmtReplyBegin;

    private Date              gmtReplyFinish;

    @Size(max = DBSize.FORUM_TOPIC.TITLE_MAX)
    private String            title;

    @Size(max = DBSize.FORUM_TOPIC.TITLE_MAX)
    private String            content;

    /** 
     * @see com.github.obullxl.jeesite.web.form.AbstractForm#enumBases(java.util.List)
     */
    public void enumBases(List<EnumBaseValidate> validates) {
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCatg() {
        return catg;
    }

    public void setCatg(String catg) {
        this.catg = catg;
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

    public Long getTopic() {
        return topic;
    }

    public void setTopic(Long topic) {
        this.topic = topic;
    }

    public String getPostUserNo() {
        return postUserNo;
    }

    public void setPostUserNo(String postUserNo) {
        this.postUserNo = postUserNo;
    }

    public Date getGmtPostBegin() {
        return gmtPostBegin;
    }

    public void setGmtPostBegin(Date gmtPostBegin) {
        this.gmtPostBegin = gmtPostBegin;
    }

    public Date getGmtPostFinish() {
        return gmtPostFinish;
    }

    public void setGmtPostFinish(Date gmtPostFinish) {
        this.gmtPostFinish = gmtPostFinish;
    }

    public String getReplyUserNo() {
        return replyUserNo;
    }

    public void setReplyUserNo(String replyUserNo) {
        this.replyUserNo = replyUserNo;
    }

    public Date getGmtReplyBegin() {
        return gmtReplyBegin;
    }

    public void setGmtReplyBegin(Date gmtReplyBegin) {
        this.gmtReplyBegin = gmtReplyBegin;
    }

    public Date getGmtReplyFinish() {
        return gmtReplyFinish;
    }

    public void setGmtReplyFinish(Date gmtReplyFinish) {
        this.gmtReplyFinish = gmtReplyFinish;
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
