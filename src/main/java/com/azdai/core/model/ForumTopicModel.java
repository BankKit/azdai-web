/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.model;

import java.util.Date;

import com.azdai.core.model.enums.ForumTopicCatgEnum;
import com.azdai.core.model.enums.ForumTopicReplyEnum;
import com.azdai.core.model.enums.ForumTopicStateEnum;
import com.azdai.core.model.enums.ForumTopicTopEnum;
import com.github.obullxl.lang.enums.ValveBoolEnum;

/**
 * 论坛主题列表
 * 
 * @author obullxl@gmail.com
 * @version $Id: ForumTopicModel.java, V1.0.1 2014年3月15日 下午2:10:21 $
 */
public class ForumTopicModel extends AbstractModel {
    private static final long   serialVersionUID = 2803426694755090598L;

    /** ID */
    private long                id;

    /** 类型 */
    private ForumTopicCatgEnum  catgEnum;

    /** 论坛代码 */
    private String              forum;

    /** 帖子状态 */
    private ForumTopicStateEnum stateEnum;

    /** 置顶标志 */
    private ForumTopicTopEnum   topEnum;

    /** 加精标志 */
    private ValveBoolEnum       eliteEnum;

    /** 回复标志 */
    private ForumTopicReplyEnum replyEnum;

    /** 主题ID */
    private long                topic;

    /** 发帖UserNO */
    private String              postUserNo;

    /** 发帖昵称 */
    private String              postNickName;

    /** 发帖时间 */
    private Date                gmtPost;

    /** 点击次数 */
    private int                 visitCount;

    /** 回帖次数 */
    private int                 replyCount;

    /** 回帖UserNO */
    private String              replyUserNo;

    /** 回帖昵称 */
    private String              replyNickName;

    /** 回帖时间 */
    private Date                gmtReply;

    /** 主题样式 */
    private String              style;

    /** 主题标题 */
    private String              title;

    /** 主题内容 */
    private String              content;

    // ~~~~~~~~~~~~~~~ getters and setters ~~~~~~~~~~~~~~ //

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ForumTopicCatgEnum getCatgEnum() {
        return catgEnum;
    }

    public void setCatgEnum(ForumTopicCatgEnum catgEnum) {
        this.catgEnum = catgEnum;
    }

    public String getForum() {
        return forum;
    }

    public void setForum(String forum) {
        this.forum = forum;
    }

    public ForumTopicStateEnum getStateEnum() {
        return stateEnum;
    }

    public void setStateEnum(ForumTopicStateEnum stateEnum) {
        this.stateEnum = stateEnum;
    }

    public ForumTopicTopEnum getTopEnum() {
        return topEnum;
    }

    public void setTopEnum(ForumTopicTopEnum topEnum) {
        this.topEnum = topEnum;
    }

    public ValveBoolEnum getEliteEnum() {
        return eliteEnum;
    }

    public void setEliteEnum(ValveBoolEnum eliteEnum) {
        this.eliteEnum = eliteEnum;
    }

    public ForumTopicReplyEnum getReplyEnum() {
        return replyEnum;
    }

    public void setReplyEnum(ForumTopicReplyEnum replyEnum) {
        this.replyEnum = replyEnum;
    }

    public long getTopic() {
        return topic;
    }

    public void setTopic(long topic) {
        this.topic = topic;
    }

    public String getPostUserNo() {
        return postUserNo;
    }

    public void setPostUserNo(String postUserNo) {
        this.postUserNo = postUserNo;
    }

    public String getPostNickName() {
        return postNickName;
    }

    public void setPostNickName(String postNickName) {
        this.postNickName = postNickName;
    }

    public Date getGmtPost() {
        return gmtPost;
    }

    public void setGmtPost(Date gmtPost) {
        this.gmtPost = gmtPost;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    public String getReplyUserNo() {
        return replyUserNo;
    }

    public void setReplyUserNo(String replyUserNo) {
        this.replyUserNo = replyUserNo;
    }

    public String getReplyNickName() {
        return replyNickName;
    }

    public void setReplyNickName(String replyNickName) {
        this.replyNickName = replyNickName;
    }

    public Date getGmtReply() {
        return gmtReply;
    }

    public void setGmtReply(Date gmtReply) {
        this.gmtReply = gmtReply;
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
