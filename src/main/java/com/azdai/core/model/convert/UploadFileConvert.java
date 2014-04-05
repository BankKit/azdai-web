/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.model.convert;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;

import com.azdai.core.das.dal.dto.UploadFileDTO;
import com.azdai.core.das.dal.query.UploadFileQuery;
import com.azdai.core.model.UploadFileModel;
import com.azdai.core.model.enums.UploadFileCatgEnum;
import com.azdai.core.web.form.UploadFileQueryForm;
import com.github.obullxl.lang.utils.QueryLikeUtils;

/**
 * 上传文件转换器
 * 
 * @author obullxl@gmail.com
 * @version $Id: UploadFileConvert.java, V1.0.1 2014年3月14日 下午12:01:12 $
 */
public class UploadFileConvert {

    /**
     * 数据对象到模型对象
     */
    public static UploadFileModel convert(UploadFileDTO srcObj) {
        if (srcObj == null) {
            return null;
        }

        UploadFileModel dstObj = new UploadFileModel();

        BeanUtils.copyProperties(srcObj, dstObj);
        dstObj.setCatgEnum(UploadFileCatgEnum.find(srcObj.getCatg()));

        return dstObj;
    }

    /**
     * 数据对象列表到模型对象列表
     */
    public static List<UploadFileModel> convert(List<UploadFileDTO> srcObjs) {
        List<UploadFileModel> dstObjs = new ArrayList<UploadFileModel>();

        if (srcObjs == null || srcObjs.isEmpty()) {
            return dstObjs;
        }

        for (UploadFileDTO srcObj : srcObjs) {
            UploadFileModel dstObj = convert(srcObj);
            if (dstObj != null) {
                dstObjs.add(dstObj);
            }
        }

        return dstObjs;
    }

    /**
     * 模型对象到数据对象
     */
    public static UploadFileDTO convert(UploadFileModel srcObj) {
        if (srcObj == null) {
            return null;
        }

        UploadFileDTO dstObj = new UploadFileDTO();

        BeanUtils.copyProperties(srcObj, dstObj);
        dstObj.setCatg(srcObj.getCatgEnum().code());

        return dstObj;
    }
    
    /**
     * Web查询对象转换为DB查询对象
     */
    public static UploadFileQuery convert(UploadFileQueryForm srcObj) {
        UploadFileQuery dstObj = new UploadFileQuery();

        if (srcObj == null) {
            return dstObj;
        }

        dstObj.setId(srcObj.getId());
        dstObj.setUserNo(StringUtils.trimToNull(srcObj.getUserNo()));
        dstObj.setCatg(StringUtils.trimToNull(srcObj.getCatg()));
        dstObj.setTitle(QueryLikeUtils.format(srcObj.getTitle()));
        dstObj.setMemo(QueryLikeUtils.format(srcObj.getMemo()));

        return dstObj;
    }

}
