/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.model;

import com.azdai.core.model.enums.UserStateEnum;
import com.github.obullxl.lang.enums.ValveBoolEnum;

/**
 * 用户模型
 * 
 * @author obullxl@gmail.com
 * @version $Id: UserInfoModel.java, V1.0.1 2014年3月15日 下午6:40:01 $
 */
public class UserInfoModel extends AbstractModel {
    private static final long serialVersionUID = 8014766142436805011L;

    /** 编号 */
    private String            no;

    /** 昵称 */
    private String            nickName;

    /** 状态 */
    private UserStateEnum     stateEnum;

    /** 登录状态 */
    private ValveBoolEnum     loginEnum;

    /** 登录密码 */
    private String            passwd;

    /** 登录错误次数 */
    private int               passwdErrCount;

    /** 注册日期 */
    private String            registDate;

    /** 电子邮箱 */
    private String            email;

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

    public UserStateEnum getStateEnum() {
        return stateEnum;
    }

    public void setStateEnum(UserStateEnum stateEnum) {
        this.stateEnum = stateEnum;
    }

    public ValveBoolEnum getLoginEnum() {
        return loginEnum;
    }

    public void setLoginEnum(ValveBoolEnum loginEnum) {
        this.loginEnum = loginEnum;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public int getPasswdErrCount() {
        return passwdErrCount;
    }

    public void setPasswdErrCount(int passwdErrCount) {
        this.passwdErrCount = passwdErrCount;
    }

    public String getRegistDate() {
        return registDate;
    }

    public void setRegistDate(String registDate) {
        this.registDate = registDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
