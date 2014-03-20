/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.das.mngt.impl;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.azdai.core.das.dal.dao.RightInfoDAO;
import com.azdai.core.das.dal.dao.RoleInfoDAO;
import com.azdai.core.das.dal.dao.RoleRightDAO;
import com.azdai.core.das.dal.dao.UserRoleDAO;
import com.azdai.core.das.dal.dto.RightInfoDTO;
import com.azdai.core.das.dal.dto.RoleInfoDTO;
import com.azdai.core.das.dal.dto.RoleRightDTO;
import com.azdai.core.das.dal.dto.UserRoleDTO;
import com.azdai.core.das.mngt.RightMngt;
import com.azdai.core.model.RightInfoModel;
import com.azdai.core.model.RoleInfoModel;
import com.azdai.core.model.convert.RightRoleConvert;
import com.google.common.collect.Sets;

/**
 * 权限管理器
 * 
 * @author obullxl@gmail.com
 * @version $Id: RightMngtImpl.java, V1.0.1 2014年3月20日 下午2:15:33 $
 */
public class RightMngtImpl implements RightMngt, InitializingBean {

    /** 权限信息DAO */
    @Autowired
    private RightInfoDAO rightInfoDAO;

    /** 角色信息DAO */
    @Autowired
    private RoleInfoDAO  roleInfoDAO;

    /** 角色权限DAO */
    @Autowired
    private RoleRightDAO roleRightDAO;

    /** 用户角色DAO */
    @Autowired
    private UserRoleDAO  userRoleDAO;

    /** 
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    public void afterPropertiesSet() {
    }

    /**
     * 创建权限信息
     */
    public void createRightInfo(RightInfoModel right) {
        RightInfoDTO info = RightRoleConvert.convert(right);
        this.rightInfoDAO.insert(info);
    }

    /**
     * 删除权限信息
     */
    public void removeRightInfo(String rgtCode) {
        this.roleRightDAO.deleteByRight(rgtCode);
        this.rightInfoDAO.delete(rgtCode);
    }

    /**
     * 创建角色信息
     */
    public void createRoleInfo(RoleInfoModel role) {
        RoleInfoDTO info = RightRoleConvert.convert(role);
        this.roleInfoDAO.insert(info);
    }

    /**
     * 删除角色信息
     */
    public void removeRoleInfo(long roleId) {
        this.userRoleDAO.deleteByRole(roleId);
        this.roleRightDAO.deleteByRole(roleId);
        this.roleInfoDAO.delete(roleId);
    }

    /**
     * 创建角色权限
     */
    public void createRoleRight(RoleInfoModel role, RightInfoModel right) {
        RoleRightDTO info = new RoleRightDTO();
        info.setRoleId(role.getId());
        info.setRgtCode(right.getCode());

        this.roleRightDAO.insert(info);
    }

    /**
     * 删除角色权限
     */
    public void removeRoleRight(long roleId, String rgtCode) {
        this.roleRightDAO.delete(roleId, rgtCode);
    }

    /**
     * 创建用户角色
     */
    public void createUserRole(String userNo, String nickName, RoleInfoModel role) {
        UserRoleDTO info = new UserRoleDTO();
        info.setUserNo(userNo);
        info.setNickName(nickName);
        info.setRoleId(role.getId());

        this.userRoleDAO.insert(info);
    }

    /**
     * 删除用户角色
     */
    public void removeUserRole(String userNo, long roleId) {
        this.userRoleDAO.delete(userNo, roleId);
    }

    /**
     * 获取用户权限代码
     */
    public Set<String> findUserRgtCodes(String userNo) {
        Set<String> rights = Sets.newHashSet();

        List<RightInfoModel> models = this.findUserRights(userNo);
        for (RightInfoModel model : models) {
            if (model != null) {
                String code = model.getCode();
                if (StringUtils.isNotBlank(code)) {
                    rights.add(code);
                }
            }
        }

        return rights;
    }

    /**
     * 获取用户权限代码
     */
    public List<RightInfoModel> findUserRights(String userNo) {
        List<RightInfoDTO> srcObjs = this.rightInfoDAO.findUserRights(userNo);
        return RightRoleConvert.convertRights(srcObjs);
    }

}
