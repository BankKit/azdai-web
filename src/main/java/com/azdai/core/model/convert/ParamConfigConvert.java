/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.model.convert;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.azdai.core.web.form.ParamConfigStoreForm;
import com.azdai.core.web.webx.ParamWebX;
import com.github.obullxl.model.cfg.CfgModel;

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

        dstObj.setCatg(ParamWebX.CATG);
        dstObj.setGmtCreate(new Date());
        dstObj.setGmtModify(new Date());

        return dstObj;
    }

}
