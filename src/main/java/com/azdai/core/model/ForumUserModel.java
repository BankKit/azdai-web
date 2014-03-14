/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.azdai.core.model.enums.ForumUserRightEnum;

/**
 * 论坛管理员模型
 * 
 * @author obullxl@gmail.com
 * @version $Id: ForumUserModel.java, V1.0.1 2014年3月14日 下午12:48:38 $
 */
public class ForumUserModel extends AbstractModel {
    private static final long        serialVersionUID = 4016839903295771255L;

    /** 论坛代码 */
    private String                   forumCode;

    /** 论坛标题 */
    private String                   forumTitle;

    /** 用户编号 */
    private String                   userNo;

    /** 用户昵称 */
    private String                   nickName;

    /** 权限列表 */
    private List<ForumUserRightEnum> rightEnums;

    /** 失效时间 */
    private Date                     gmtExpire;

    // ~~~~~~~~~~~~~~~ getters and setters ~~~~~~~~~~~~~~ //

    public String getForumCode() {
        return forumCode;
    }

    public void setForumCode(String forumCode) {
        this.forumCode = forumCode;
    }

    public String getForumTitle() {
        return forumTitle;
    }

    public void setForumTitle(String forumTitle) {
        this.forumTitle = forumTitle;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public List<ForumUserRightEnum> getRightEnums() {
        if (this.rightEnums == null) {
            this.rightEnums = new ArrayList<ForumUserRightEnum>();
        }

        return rightEnums;
    }

    public void setRightEnums(List<ForumUserRightEnum> rightEnums) {
        this.getRightEnums().clear();
        this.getRightEnums().addAll(rightEnums);
    }

    public Date getGmtExpire() {
        return gmtExpire;
    }

    public void setGmtExpire(Date gmtExpire) {
        this.gmtExpire = gmtExpire;
    }

}
