/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.das.dal.query;

import java.io.Serializable;
import java.util.Date;

/**
 * 主题查询对象
 * 
 * @author obullxl@gmail.com
 * @version $Id: ForumTopicQuery.java, V1.0.1 2014年3月14日 上午11:51:57 $
 */
public class ForumTopicQuery implements Serializable {
    private static final long serialVersionUID = -3141064291259916002L;

    private int               offset;
    private int               pageSize;

    private Long              id;

    private String            catg;

    private String            forum;

    private String            state;

    private String            topFlag;

    private String            eliteFlag;

    private String            replyFlag;

    private Long              topic;

    private String            postUserNo;

    private Date              gmtPostBegin;

    private Date              gmtPostFinish;

    private String            replyUserNo;

    private Date              gmtReplyBegin;

    private Date              gmtReplyFinish;

    private String            title;

    private String            content;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
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
