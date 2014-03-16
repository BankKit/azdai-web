/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2013 All Rights Reserved.
 */
package com.azdai.core.web.form;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.azdai.core.das.dal.DBSize;
import com.github.obullxl.lang.web.form.AbstractForm;
import com.github.obullxl.lang.web.form.EnumBaseValidate;

/**
 * 新用户注册表单
 * 
 * @author obullxl@gmail.com
 * @version $Id: UserRegistForm.java, V1.0.1 2013年12月29日 上午11:07:31 $
 */
public class UserRegistForm extends AbstractForm {
    private static final long serialVersionUID = 4246838516504646955L;

    @NotNull
    @Size(min = 3, max = DBSize.USER_INFO.NICK_NAME_MAX)
    private String            nickName;

    @NotNull
    @Size(min = 5, max = DBSize.USER_INFO.EMAIL_MAX)
    private String            email;

    @NotNull
    @Size(min = 6, max = DBSize.USER_INFO.PASSWD_MAX)
    private String            passwd;

    @NotNull
    @Size(min = 6, max = DBSize.USER_INFO.PASSWD_MAX)
    private String            repeatPasswd;

    /** 
     * @see com.github.obullxl.jeesite.web.form.AbstractForm#enumBases(java.util.List)
     */
    public void enumBases(List<EnumBaseValidate> validates) {
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getRepeatPasswd() {
        return repeatPasswd;
    }

    public void setRepeatPasswd(String repeatPasswd) {
        this.repeatPasswd = repeatPasswd;
    }

}
