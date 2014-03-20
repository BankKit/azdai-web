/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.model.convert;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.azdai.core.das.dal.dto.RightInfoDTO;
import com.azdai.core.das.dal.dto.RoleInfoDTO;
import com.azdai.core.model.RightInfoModel;
import com.azdai.core.model.RoleInfoModel;
import com.google.common.collect.Lists;

/**
 * 权限/角色对象转换器
 * 
 * @author obullxl@gmail.com
 * @version $Id: RightRoleConvert.java, V1.0.1 2014年3月20日 下午2:19:59 $
 */
public class RightRoleConvert {

    /**
     * 数据对象到模型对象
     */
    public static RightInfoModel convert(RightInfoDTO srcObj) {
        if (srcObj == null) {
            return null;
        }

        RightInfoModel dstObj = new RightInfoModel();
        BeanUtils.copyProperties(srcObj, dstObj);

        return dstObj;
    }

    /**
     * 数据对象到模型对象列表
     */
    public static List<RightInfoModel> convertRights(List<RightInfoDTO> srcObjs) {
        List<RightInfoModel> dstObjs = Lists.newArrayList();

        if (srcObjs == null) {
            return dstObjs;
        }

        for (RightInfoDTO srcObj : srcObjs) {
            RightInfoModel dstObj = convert(srcObj);
            if (dstObj != null) {
                dstObjs.add(dstObj);
            }
        }

        return dstObjs;
    }

    /**
     * 模型对象到数据对象
     */
    public static RightInfoDTO convert(RightInfoModel srcObj) {
        if (srcObj == null) {
            return null;
        }

        RightInfoDTO dstObj = new RightInfoDTO();
        BeanUtils.copyProperties(srcObj, dstObj);

        return dstObj;
    }

    /**
     * 数据对象到模型对象
     */
    public static RoleInfoModel convert(RoleInfoDTO srcObj) {
        if (srcObj == null) {
            return null;
        }

        RoleInfoModel dstObj = new RoleInfoModel();
        BeanUtils.copyProperties(srcObj, dstObj);

        return dstObj;
    }

    /**
     * 数据对象到模型对象列表
     */
    public static List<RoleInfoModel> convertRoles(List<RoleInfoDTO> srcObjs) {
        List<RoleInfoModel> dstObjs = Lists.newArrayList();

        if (srcObjs == null) {
            return dstObjs;
        }

        for (RoleInfoDTO srcObj : srcObjs) {
            RoleInfoModel dstObj = convert(srcObj);
            if (dstObj != null) {
                dstObjs.add(dstObj);
            }
        }

        return dstObjs;
    }

    /**
     * 模型对象到数据对象
     */
    public static RoleInfoDTO convert(RoleInfoModel srcObj) {
        if (srcObj == null) {
            return null;
        }

        RoleInfoDTO dstObj = new RoleInfoDTO();
        BeanUtils.copyProperties(srcObj, dstObj);

        return dstObj;
    }

}
