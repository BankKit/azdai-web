/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.das.mngt;

import java.util.List;

import com.azdai.core.model.HelpCenterModel;

/**
 * 帮助中心管理器
 * 
 * @author obullxl@gmail.com
 * @version $Id: HelpMngt.java, V1.0.1 2014年3月20日 上午10:05:13 $
 */
public interface HelpMngt {

    /**
     * 获取单条记录
     */
    public HelpCenterModel find(long id);

    /**
     * 拉取单条记录
     */
    public HelpCenterModel fetch(long id);
    
    /**
     * 获取所有记录结构树
     */
    public List<HelpCenterModel> findTree();
    
    /**
     * 拉取所有记录结构树
     */
    public List<HelpCenterModel> fetchTree();

}
