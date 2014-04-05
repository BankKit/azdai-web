/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.web.servlet;

import java.util.Map;

import com.github.obullxl.lang.web.AbstractWebToolBox;
import com.google.common.collect.Maps;

/**
 * Web工具箱
 * 
 * @author obullxl@gmail.com
 * @version $Id: WebToolBoxImpl.java, V1.0.1 2014年4月5日 上午11:33:12 $
 */
public class WebToolBoxImpl extends AbstractWebToolBox {

    /** 
     * @see com.github.obullxl.lang.web.AbstractWebToolBox#findToolBox()
     */
    public Map<String, Object> findToolBox() {
        Map<String, Object> tools = Maps.newConcurrentMap();

        return tools;
    }

}
