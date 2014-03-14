/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.model;

import java.util.ArrayList;
import java.util.List;

import com.azdai.core.model.enums.ForumInfoOpenEnum;
import com.github.obullxl.lang.enums.ValveBoolEnum;

/**
 * 论坛信息模型
 * 
 * @author obullxl@gmail.com
 * @version $Id: ForumInfoModel.java, V1.0.1 2014年3月13日 下午10:11:31 $
 */
public class ForumInfoModel extends AbstractModel {
    private static final long    serialVersionUID = 4375075483736882505L;

    /** 代码 */
    private String               code;

    /** 排序值 */
    private String               sort;

    /** 状态 */
    private ValveBoolEnum        stateEnum;

    /** 访问权限 */
    private ForumInfoOpenEnum    openEnum;

    /** 标题 */
    private String               title;

    /** 描述 */
    private String               summary;

    /** 论坛管理员 */
    private List<ForumUserModel> forumUsers;

    // ~~~~~~~~~~~~~~~ getters and setters ~~~~~~~~~~~~~~ //

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public ValveBoolEnum getStateEnum() {
        return stateEnum;
    }

    public void setStateEnum(ValveBoolEnum stateEnum) {
        this.stateEnum = stateEnum;
    }

    public ForumInfoOpenEnum getOpenEnum() {
        return openEnum;
    }

    public void setOpenEnum(ForumInfoOpenEnum openEnum) {
        this.openEnum = openEnum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setForumUsers(List<ForumUserModel> forumUsers) {
        this.getForumUsers().clear();
        this.getForumUsers().addAll(forumUsers);
    }

    public List<ForumUserModel> getForumUsers() {
        if (this.forumUsers == null) {
            this.forumUsers = new ArrayList<ForumUserModel>();
        }

        return forumUsers;
    }

}
