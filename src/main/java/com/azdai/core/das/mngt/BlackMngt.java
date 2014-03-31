/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.das.mngt;

/**
 * 黑名单管理器
 * 
 * @author obullxl@gmail.com
 * @version $Id: BlackMngt.java, V1.0.1 2014年3月15日 下午6:52:18 $
 */
public interface BlackMngt {

    /**
     * 是否为用户黑名单
     */
    public boolean isBlackUserName(String name);
    
}
