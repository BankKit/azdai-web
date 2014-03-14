/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.model.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.azdai.core.das.dal.dto.ForumInfoDTO;
import com.azdai.core.model.ForumInfoModel;
import com.azdai.core.model.enums.ForumInfoOpenEnum;
import com.github.obullxl.lang.enums.ValveBoolEnum;

/**
 * 论坛信息转换器
 * 
 * @author obullxl@gmail.com
 * @version $Id: ForumInfoConvert.java, V1.0.1 2014年3月14日 下午12:01:12 $
 */
public class ForumInfoConvert {

    /**
     * 数据对象到模型对象
     */
    public static ForumInfoModel convert(ForumInfoDTO srcObj) {
        if (srcObj == null) {
            return null;
        }

        ForumInfoModel dstObj = new ForumInfoModel();

        BeanUtils.copyProperties(srcObj, dstObj);
        dstObj.setStateEnum(ValveBoolEnum.findDefault(srcObj.getState()));
        dstObj.setOpenEnum(ForumInfoOpenEnum.find(srcObj.getOpenExt()));

        return dstObj;
    }

    /**
     * 数据对象列表到模型对象列表
     */
    public static List<ForumInfoModel> convert(List<ForumInfoDTO> srcObjs) {
        List<ForumInfoModel> dstObjs = new ArrayList<ForumInfoModel>();

        if (srcObjs == null || srcObjs.isEmpty()) {
            return dstObjs;
        }

        for (ForumInfoDTO srcObj : srcObjs) {
            ForumInfoModel dstObj = convert(srcObj);
            if (dstObj != null) {
                dstObjs.add(dstObj);
            }
        }

        return dstObjs;
    }

    /**
     * 模型对象到数据对象
     */
    public static ForumInfoDTO convert(ForumInfoModel srcObj) {
        if (srcObj == null) {
            return null;
        }

        ForumInfoDTO dstObj = new ForumInfoDTO();

        BeanUtils.copyProperties(srcObj, dstObj);
        dstObj.setState(srcObj.getStateEnum().code());
        dstObj.setOpenExt(srcObj.getOpenEnum().code());

        return dstObj;
    }

}
