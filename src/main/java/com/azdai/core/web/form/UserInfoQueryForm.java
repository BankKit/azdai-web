/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2013 All Rights Reserved.
 */
package com.azdai.core.web.form;

import java.util.List;

import javax.validation.constraints.Size;

import com.azdai.core.das.dal.DBSize;
import com.github.obullxl.lang.web.form.AbstractForm;
import com.github.obullxl.lang.web.form.EnumBaseValidate;

/**
 * 会员信息查询表单
 * 
 * @author obullxl@gmail.com
 * @version $Id: UserInfoQueryForm.java, V1.0.1 2013年12月29日 上午11:07:31 $
 */
public class UserInfoQueryForm extends AbstractForm {
    private static final long serialVersionUID = 4246838516504646955L;

    private int               pageNo;

    @Size(max = DBSize.USER_INFO.NO_MAX)
    private String            no;

    @Size(max = DBSize.USER_INFO.NICK_NAME_MAX)
    private String            nickName;

    @Size(max = DBSize.USER_INFO.STATE_MAX)
    private String            state;

    @Size(max = DBSize.USER_INFO.LOGIN_STATE_MAX)
    private String            loginState;

    private Integer           passwdErrCount;

    @Size(max = DBSize.USER_INFO.REGIST_DATE_MAX)
    private String            registDateBegin;

    @Size(max = DBSize.USER_INFO.REGIST_DATE_MAX)
    private String            registDateFinish;

    @Size(max = DBSize.USER_INFO.EMAIL_MAX)
    private String            email;

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

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLoginState() {
        return loginState;
    }

    public void setLoginState(String loginState) {
        this.loginState = loginState;
    }

    public Integer getPasswdErrCount() {
        return passwdErrCount;
    }

    public void setPasswdErrCount(Integer passwdErrCount) {
        this.passwdErrCount = passwdErrCount;
    }

    public String getRegistDateBegin() {
        return registDateBegin;
    }

    public void setRegistDateBegin(String registDateBegin) {
        this.registDateBegin = registDateBegin;
    }

    public String getRegistDateFinish() {
        return registDateFinish;
    }

    public void setRegistDateFinish(String registDateFinish) {
        this.registDateFinish = registDateFinish;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
