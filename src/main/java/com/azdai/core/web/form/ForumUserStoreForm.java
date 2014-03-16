/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2013 All Rights Reserved.
 */
package com.azdai.core.web.form;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.azdai.core.das.dal.DBSize;
import com.github.obullxl.lang.web.form.AbstractForm;
import com.github.obullxl.lang.web.form.EnumBaseValidate;

/**
 * 更新/创建论坛信息存储表单
 * 
 * @author obullxl@gmail.com
 * @version $Id: ForumInfoStoreForm.java, V1.0.1 2013年12月29日 上午11:07:31 $
 */
public class ForumUserStoreForm extends AbstractForm {
    private static final long serialVersionUID = 4246838516504646955L;

    @NotNull
    @Size(max = DBSize.FORUM_INFO.CODE_MAX)
    private String            forumCode;

    @Size(max = DBSize.FORUM_INFO.TITLE_MAX)
    private String            forumTitle;

    @NotNull
    @Size(min = 1, max = DBSize.FORUM_INFO.STATE_MAX)
    private String            userNo;

    @NotNull
    @Size(min = 1, max = DBSize.FORUM_INFO.OPEN_EXT_MAX)
    private String            nickName;

    @NotNull
    private Date              gmtExpire;

    /** 
     * @see com.github.obullxl.jeesite.web.form.AbstractForm#enumBases(java.util.List)
     */
    public void enumBases(List<EnumBaseValidate> validates) {
    }

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

    public Date getGmtExpire() {
        return gmtExpire;
    }

    public void setGmtExpire(Date gmtExpire) {
        this.gmtExpire = gmtExpire;
    }

}
