/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.model.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.azdai.core.das.dal.dto.ForumTopicDTO;
import com.azdai.core.das.dal.query.ForumTopicQuery;
import com.azdai.core.model.ForumTopicModel;
import com.azdai.core.model.enums.ForumTopicCatgEnum;
import com.azdai.core.model.enums.ForumTopicReplyEnum;
import com.azdai.core.model.enums.ForumTopicStateEnum;
import com.azdai.core.model.enums.ForumTopicTopEnum;
import com.azdai.core.web.form.ForumTopicQueryForm;
import com.azdai.core.web.webx.EnumWebX;
import com.github.obullxl.lang.enums.ValveBoolEnum;
import com.github.obullxl.lang.utils.QueryLikeUtils;

/**
 * 论坛主题转换器
 * 
 * @author obullxl@gmail.com
 * @version $Id: ForumTopicConvert.java, V1.0.1 2014年3月14日 下午12:01:12 $
 */
public class ForumTopicConvert {

    /**
     * 数据对象到模型对象
     */
    public static ForumTopicModel convert(ForumTopicDTO srcObj) {
        if (srcObj == null) {
            return null;
        }

        ForumTopicModel dstObj = new ForumTopicModel();

        BeanUtils.copyProperties(srcObj, dstObj);

        dstObj.setCatgEnum(ForumTopicCatgEnum.find(srcObj.getCatg()));
        dstObj.setStateEnum(ForumTopicStateEnum.find(srcObj.getState()));
        dstObj.setTopEnum(ForumTopicTopEnum.find(srcObj.getTopFlag()));
        dstObj.setEliteEnum(ValveBoolEnum.findDefault(srcObj.getEliteFlag()));
        dstObj.setReplyEnum(ForumTopicReplyEnum.find(srcObj.getReplyFlag()));

        return dstObj;
    }

    /**
     * 数据对象列表到模型对象列表
     */
    public static List<ForumTopicModel> convert(List<ForumTopicDTO> srcObjs) {
        List<ForumTopicModel> dstObjs = new ArrayList<ForumTopicModel>();

        if (srcObjs == null) {
            return dstObjs;
        }

        for (ForumTopicDTO srcObj : srcObjs) {
            ForumTopicModel dstObj = convert(srcObj);
            if (dstObj != null) {
                dstObjs.add(dstObj);
            }
        }

        return dstObjs;
    }

    /**
     * 模型对象到数据对象
     */
    public static ForumTopicDTO convert(ForumTopicModel srcObj) {
        if (srcObj == null) {
            return null;
        }

        ForumTopicDTO dstObj = new ForumTopicDTO();

        BeanUtils.copyProperties(srcObj, dstObj);

        dstObj.setCatg(srcObj.getCatgEnum().code());
        
        dstObj.setState(EnumWebX.findEnumCode(srcObj.getStateEnum()));
        dstObj.setTopFlag(EnumWebX.findEnumCode(srcObj.getTopEnum()));
        dstObj.setEliteFlag(EnumWebX.findEnumCode(srcObj.getEliteEnum()));
        dstObj.setReplyFlag(EnumWebX.findEnumCode(srcObj.getReplyEnum()));

        return dstObj;
    }

    /**
     * Web查询对象转换为DB查询对象
     */
    public static ForumTopicQuery convert(ForumTopicQueryForm srcObj) {
        ForumTopicQuery dstObj = new ForumTopicQuery();

        if (srcObj == null) {
            return dstObj;
        }

        BeanUtils.copyProperties(srcObj, dstObj);

        dstObj.setTitle(QueryLikeUtils.format(srcObj.getTitle()));
        dstObj.setContent(QueryLikeUtils.format(srcObj.getContent()));

        return dstObj;
    }

}
