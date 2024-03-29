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
     * 刷新缓存
     */
    public boolean cleanCache();
    
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
     * 拉取所有记录
     */
    public List<HelpCenterModel> fetchAll();
    
    /**
     * 拉取所有记录结构树
     */
    public List<HelpCenterModel> fetchTree();
    
    /**
     * 拉取儿子节点列表
     */
    public List<HelpCenterModel> fetchChildren(long id);
    
    /**
     * 新增帮助中心
     */
    public void create(HelpCenterModel model);
    
    /**
     * 更新帮助中心
     */
    public int update(HelpCenterModel model);
    
    /**
     * 删除帮助中心
     */
    public int remove(long id);

}
