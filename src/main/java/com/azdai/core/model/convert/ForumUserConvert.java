/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.model.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.azdai.core.das.dal.dto.ForumUserDTO;
import com.azdai.core.model.ForumUserModel;
import com.azdai.core.model.utils.ForumUtils;

/**
 * 论坛用户转换器
 * 
 * @author obullxl@gmail.com
 * @version $Id: ForumUserConvert.java, V1.0.1 2014年3月14日 下午12:01:12 $
 */
public class ForumUserConvert {

    /**
     * 数据对象到模型对象
     */
    public static ForumUserModel convert(ForumUserDTO srcObj) {
        if (srcObj == null) {
            return null;
        }

        ForumUserModel dstObj = new ForumUserModel();

        BeanUtils.copyProperties(srcObj, dstObj);
        dstObj.setRightEnums(ForumUtils.parseRights(srcObj.getRightExt()));

        return dstObj;
    }

    /**
     * 数据对象列表到模型对象列表
     */
    public static List<ForumUserModel> convert(List<ForumUserDTO> srcObjs) {
        List<ForumUserModel> dstObjs = new ArrayList<ForumUserModel>();

        if (srcObjs == null || srcObjs.isEmpty()) {
            return dstObjs;
        }

        for (ForumUserDTO srcObj : srcObjs) {
            ForumUserModel dstObj = convert(srcObj);
            if (dstObj != null) {
                dstObjs.add(dstObj);
            }
        }

        return dstObjs;
    }

    /**
     * 模型对象到数据对象
     */
    public static ForumUserDTO convert(ForumUserModel srcObj) {
        if (srcObj == null) {
            return null;
        }

        ForumUserDTO dstObj = new ForumUserDTO();

        BeanUtils.copyProperties(srcObj, dstObj);
        dstObj.setRightExt(ForumUtils.formatRights(srcObj.getRightEnums()));

        return dstObj;
    }

}
