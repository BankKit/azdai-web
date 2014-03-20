/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.model.convert;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.azdai.core.das.dal.dto.HelpCenterDTO;
import com.azdai.core.model.HelpCenterModel;
import com.github.obullxl.lang.enums.ValveBoolEnum;
import com.google.common.collect.Lists;

/**
 * 帮助中心模型转换工具类
 * 
 * @author obullxl@gmail.com
 * @version $Id: HelpCenterConvert.java, V1.0.1 2014年3月20日 上午9:59:19 $
 */
public class HelpCenterConvert {

    /**
     * 数据对象到模型对象
     */
    public static HelpCenterModel convert(HelpCenterDTO srcObj) {
        if (srcObj == null) {
            return null;
        }

        HelpCenterModel dstObj = new HelpCenterModel();

        BeanUtils.copyProperties(srcObj, dstObj);

        dstObj.setShowEnum(ValveBoolEnum.findDefault(srcObj.getShowFlag()));

        return dstObj;
    }

    /**
     * 数据对象到模型对象列表
     */
    public static List<HelpCenterModel> convert(List<HelpCenterDTO> srcObjs) {
        List<HelpCenterModel> dstObjs = Lists.newArrayList();

        if (srcObjs == null) {
            return dstObjs;
        }

        for (HelpCenterDTO srcObj : srcObjs) {
            HelpCenterModel dstObj = convert(srcObj);
            if (dstObj != null) {
                dstObjs.add(dstObj);
            }
        }

        return dstObjs;
    }

    /**
     * 模型对象到数据对象
     */
    public static HelpCenterDTO convert(HelpCenterModel srcObj) {
        if (srcObj == null) {
            return null;
        }

        HelpCenterDTO dstObj = new HelpCenterDTO();

        BeanUtils.copyProperties(srcObj, dstObj);

        dstObj.setShowFlag(srcObj.getShowEnum().code());

        return dstObj;
    }

}
