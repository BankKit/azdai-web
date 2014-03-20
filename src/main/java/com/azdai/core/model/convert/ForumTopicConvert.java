/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.model.convert;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;

import com.azdai.core.das.dal.dto.ForumTopicDTO;
import com.azdai.core.das.dal.query.ForumTopicQuery;
import com.azdai.core.model.ForumTopicModel;
import com.azdai.core.model.enums.ForumTopicCatgEnum;
import com.azdai.core.model.enums.ForumTopicReplyEnum;
import com.azdai.core.model.enums.ForumTopicStateEnum;
import com.azdai.core.model.enums.ForumTopicTopEnum;
import com.azdai.core.web.form.ForumTopicQueryForm;
import com.azdai.core.web.form.ForumTopicStoreForm;
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

        dstObj.setId(srcObj.getId());

        dstObj.setCatg(StringUtils.trimToNull(srcObj.getCatg()));
        dstObj.setForum(StringUtils.trimToNull(srcObj.getForum()));
        dstObj.setState(StringUtils.trimToNull(srcObj.getState()));
        dstObj.setTopFlag(StringUtils.trimToNull(srcObj.getTopFlag()));
        dstObj.setEliteFlag(StringUtils.trimToNull(srcObj.getEliteFlag()));
        dstObj.setReplyFlag(StringUtils.trimToNull(srcObj.getReplyFlag()));

        dstObj.setPostUserNo(StringUtils.trimToNull(srcObj.getPostUserNo()));
        dstObj.setReplyUserNo(StringUtils.trimToNull(srcObj.getReplyUserNo()));

        dstObj.setGmtPostBegin(StringUtils.trimToNull(srcObj.getGmtPostBegin()));
        dstObj.setGmtPostFinish(StringUtils.trimToNull(srcObj.getGmtPostFinish()));
        dstObj.setGmtReplyBegin(StringUtils.trimToNull(srcObj.getGmtReplyBegin()));
        dstObj.setGmtReplyFinish(StringUtils.trimToNull(srcObj.getGmtReplyFinish()));

        dstObj.setTitle(QueryLikeUtils.format(srcObj.getTitle()));
        dstObj.setContent(QueryLikeUtils.format(srcObj.getContent()));

        return dstObj;
    }

    /**
     * 论坛主贴信息更新(合并表单数据到论坛主贴模型)
     */
    public static void merge(ForumTopicModel model, ForumTopicStoreForm form) {
        if (model == null || form == null) {
            return;
        }

        model.setForum(form.getForum());

        model.setStateEnum(ForumTopicStateEnum.find(form.getState()));
        model.setTopEnum(ForumTopicTopEnum.find(form.getTopFlag()));
        model.setEliteEnum(ValveBoolEnum.findDefault(form.getEliteFlag()));
        model.setReplyEnum(ForumTopicReplyEnum.find(form.getReplyFlag()));

        model.setStyle(form.getStyle());
        model.setTitle(form.getTitle());
        model.setContent(form.getContent());
    }

}
