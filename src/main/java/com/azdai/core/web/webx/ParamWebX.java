/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.web.webx;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.azdai.AZD;
import com.github.obullxl.lang.webx.WebX;
import com.github.obullxl.model.cfg.CfgModel;
import com.github.obullxl.model.cfg.CfgUtils;

/**
 * 系统参数WebX
 * 
 * @author obullxl@gmail.com
 * @version $Id: ParamWebX.java, V1.0.1 2014年3月29日 下午5:57:22 $
 */
@Component("paramWebX")
public class ParamWebX implements WebX {

    /**
     * 获取所有参数配置
     */
    public static List<CfgModel> findAll() {
        List<CfgModel> models = CfgUtils.find(AZD.CFG_CATG);
        Collections.sort(models);
        return models;
    }

    /**
     * 获取单个系统参数
     */
    public static CfgModel find(String name) {
        return CfgUtils.find(AZD.CFG_CATG, name);
    }

}
