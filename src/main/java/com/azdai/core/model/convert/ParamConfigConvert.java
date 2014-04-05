/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.model.convert;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.JSON;
import com.azdai.AZD;
import com.azdai.core.model.CarouselModel;
import com.azdai.core.model.enums.CarouselCatgEnum;
import com.azdai.core.web.form.CarouselStoreForm;
import com.azdai.core.web.form.ParamConfigStoreForm;
import com.github.obullxl.lang.enums.ValveBoolEnum;
import com.github.obullxl.model.cfg.CfgModel;
import com.google.common.collect.Lists;

/**
 * 系统参数配置
 * 
 * @author obullxl@gmail.com
 * @version $Id: ParamConfigConvert.java, V1.0.1 2014年3月29日 下午6:05:52 $
 */
public class ParamConfigConvert {

    /**
     * 表单对象到模型对象
     */
    public static CfgModel convert(ParamConfigStoreForm srcObj) {
        if (srcObj == null) {
            return null;
        }

        CfgModel dstObj = new CfgModel();

        BeanUtils.copyProperties(srcObj, dstObj);

        dstObj.setCatg(AZD.CFG_CATG);
        dstObj.setGmtCreate(new Date());
        dstObj.setGmtModify(new Date());

        return dstObj;
    }

    /**
     * 表单对象到模型对象
     */
    public static CarouselModel carousel(CarouselStoreForm srcObj) {
        if (srcObj == null) {
            return null;
        }

        CarouselModel dstObj = new CarouselModel();

        BeanUtils.copyProperties(srcObj, dstObj);

        dstObj.setCatgEnum(CarouselCatgEnum.find(srcObj.getCatg()));
        dstObj.setShowEnum(ValveBoolEnum.findDefault(srcObj.getShow()));

        return dstObj;
    }

    /**
     * 图片模型对象到模型对象
     */
    public static CfgModel convert(CarouselModel srcObj) {
        if (srcObj == null) {
            return null;
        }

        CfgModel dstObj = new CfgModel();

        dstObj.setCatg(AZD.CFG_CAROUSEL);
        dstObj.setName(srcObj.getNo());
        dstObj.setTitle(srcObj.getTitle());
        dstObj.setValue(JSON.toJSONString(srcObj));

        dstObj.setGmtCreate(new Date());
        dstObj.setGmtModify(new Date());

        return dstObj;
    }

    /**
     * 模型对象到图片模型对象
     */
    public static CarouselModel convert(CfgModel srcObj) {
        if (srcObj == null) {
            return null;
        }

        CarouselModel dstObj = JSON.parseObject(srcObj.getValue(), CarouselModel.class);

        return dstObj;
    }

    /**
     * 模型对象到图片模型对象
     */
    public static List<CarouselModel> convert(List<CfgModel> srcObjs) {
        List<CarouselModel> dstObjs = Lists.newArrayList();

        if (srcObjs == null) {
            return dstObjs;
        }

        for (CfgModel srcObj : srcObjs) {
            CarouselModel dstObj = convert(srcObj);
            if (dstObj != null) {
                dstObjs.add(dstObj);
            }
        }

        return dstObjs;
    }

}
