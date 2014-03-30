/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.das.mngt;

import java.util.List;
import java.util.Set;

import com.azdai.core.model.RightInfoModel;
import com.azdai.core.model.RoleInfoModel;

/**
 * 权限管理器
 * 
 * @author obullxl@gmail.com
 * @version $Id: RightMngt.java, V1.0.1 2014年3月20日 下午2:15:07 $
 */
public interface RightMngt {

    /**
     * 创建权限信息
     */
    public void createRightInfo(RightInfoModel right);

    /**
     * 删除权限信息
     */
    public void removeRightInfo(String rgtCode);

    /**
     * 创建角色信息
     */
    public void createRoleInfo(RoleInfoModel role);

    /**
     * 删除角色信息
     */
    public void removeRoleInfo(long roleId);

    /**
     * 创建角色权限
     */
    public void createRoleRight(RoleInfoModel role, RightInfoModel right);

    /**
     * 删除角色权限
     */
    public void removeRoleRight(long roleId, String rgtCode);

    /**
     * 创建用户角色
     */
    public void createUserRole(String userNo, String nickName, RoleInfoModel role);

    /**
     * 删除用户角色
     */
    public void removeUserRole(String userNo, long roleId);

    /**
     * 获取用户权限代码
     */
    public Set<String> findUserRgtCodes(String userNo);

    /**
     * 获取用户权限代码
     */
    public List<RightInfoModel> findUserRights(String userNo);

}
