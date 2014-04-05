/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.das.dal.query;

import java.io.Serializable;

import com.github.obullxl.lang.ToString;

/**
 * 会员信息查询对象
 * 
 * @author obullxl@gmail.com
 * @version $Id: UserInfoQuery.java, V1.0.1 2014年3月14日 上午11:51:57 $
 */
public class UserInfoQuery extends ToString implements Serializable {
    private static final long serialVersionUID = -3141064291259916002L;

    private int               offset;
    private int               pageSize;

    private String            no;

    private String            nickName;

    private String            state;

    private String            loginState;

    private Integer           passwdErrCount;

    private String            registDateBegin;

    private String            registDateFinish;

    private String            email;

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
