/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.web.webx;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.azdai.core.das.mngt.HelpMngt;
import com.azdai.core.model.HelpCenterModel;
import com.github.obullxl.lang.webx.WebX;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 帮助中心WebX
 * 
 * @author obullxl@gmail.com
 * @version $Id: HelpWebX.java, V1.0.1 2014年3月20日 上午11:04:27 $
 */
@Component("helpWebX")
public class HelpWebX implements WebX {

    /** 帮助中心管理器 */
    @Autowired
    private HelpMngt helpMngt;

    /**
     * 构建结构树
     */
    public static List<HelpCenterModel> constructTree(List<HelpCenterModel> dstObjs) {
        Map<Long, HelpCenterModel> map = Maps.newConcurrentMap();
        for (HelpCenterModel dstObj : dstObjs) {
            map.put(dstObj.getId(), dstObj);
        }

        List<HelpCenterModel> tree = Lists.newArrayList();
        for (HelpCenterModel dstObj : dstObjs) {
            HelpCenterModel parent = map.get(dstObj.getCatg());
            if (parent != null) {
                dstObj.setParent(parent);
                parent.getChildren().add(dstObj);
            } else {
                tree.add(dstObj);
            }
        }

        for (HelpCenterModel dstObj : dstObjs) {
            Collections.sort(dstObj.getChildren());
        }

        Collections.sort(tree);
        return tree;
    }

    /**
     * 获取结构树
     */
    public List<HelpCenterModel> findTree() {
        return this.helpMngt.findTree();
    }

    /**
     * 拉取结构树
     */
    public List<HelpCenterModel> fetchTree() {
        return this.helpMngt.fetchTree();
    }

    /**
     * 获取帮助内容
     */
    public HelpCenterModel find(long id) {
        return this.helpMngt.find(id);
    }
    
    /**
     * 拉取帮助内容
     */
    public HelpCenterModel fetch(long id) {
        return this.helpMngt.fetch(id);
    }

    /**
     * 拉取所有记录
     */
    public List<HelpCenterModel> fetchAll() {
        return this.helpMngt.fetchAll();
    }

}
