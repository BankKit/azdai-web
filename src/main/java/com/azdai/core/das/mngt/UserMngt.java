/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.das.mngt;

import com.azdai.core.model.UserInfoModel;

/**
 * 用户管理器
 * 
 * @author obullxl@gmail.com
 * @version $Id: UserMngt.java, V1.0.1 2014年3月15日 下午6:38:12 $
 */
public interface UserMngt {

    /**
     * 获取用户NO
     */
    public String findUserNo();

    /**
     * 加密用户密码
     */
    public String findLoginPasswd(String plain);

    /**
     * 获取用户模型
     */
    public UserInfoModel findByNo(String userNo);

    /**
     * 用户登录
     */
    public UserInfoModel findByLoginName(String name);

    /**
     * 获取用户信息
     */
    public UserInfoModel findByEmail(String email);

    /**
     * 获取用户信息
     */
    public UserInfoModel findByNickName(String nickName);

    /**
     * 新增用户信息
     */
    public void createUserInfo(UserInfoModel user);

}
