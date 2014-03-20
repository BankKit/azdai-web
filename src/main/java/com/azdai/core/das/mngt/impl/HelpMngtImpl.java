/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.das.mngt.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.azdai.core.das.dal.dao.HelpCenterDAO;
import com.azdai.core.das.dal.dto.HelpCenterDTO;
import com.azdai.core.das.mngt.HelpMngt;
import com.azdai.core.model.HelpCenterModel;
import com.azdai.core.model.convert.HelpCenterConvert;
import com.azdai.core.web.webx.HelpWebX;
import com.github.obullxl.lang.enums.ValveBoolEnum;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * 帮助中心管理器实现
 * 
 * @author obullxl@gmail.com
 * @version $Id: HelpMngtImpl.java, V1.0.1 2014年3月20日 上午10:05:41 $
 */
@Component("helpMngt")
public class HelpMngtImpl implements HelpMngt, InitializingBean {
    /** 帮助中心结构缓存KEY */
    public static final String                          HELP_CACHE_KEY = "_help_cache_key_";

    /** 帮助中心DAO */
    @Autowired
    private HelpCenterDAO                               helpCenterDAO;

    /** 帮助中心结构缓存 */
    private LoadingCache<String, List<HelpCenterModel>> helpCenterCache;

    /** 帮助中心内容缓存 */
    private LoadingCache<Long, HelpCenterModel>         helpContentCache;

    /** 
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    public void afterPropertiesSet() {
        // 帮助中心结构
        this.helpCenterCache = CacheBuilder.newBuilder() //
            .maximumSize(2).expireAfterWrite(30, TimeUnit.MINUTES)//
            .build(new CacheLoader<String, List<HelpCenterModel>>() { //
                    public List<HelpCenterModel> load(String key) {
                        List<HelpCenterDTO> srcObjs = helpCenterDAO.findByShow(ValveBoolEnum.TRUE.code());
                        List<HelpCenterModel> dstObjs = HelpCenterConvert.convert(srcObjs);

                        return HelpWebX.constructTree(dstObjs);
                    }
                });

        // 帮助中心内容
        this.helpContentCache = CacheBuilder.newBuilder() //
            .maximumSize(1000).expireAfterWrite(30, TimeUnit.MINUTES)//
            .build(new CacheLoader<Long, HelpCenterModel>() { //
                    public HelpCenterModel load(Long id) {
                        HelpCenterDTO srcObj = helpCenterDAO.find(id);
                        return HelpCenterConvert.convert(srcObj);
                    }
                });
    }

    /** 
     * @see com.azdai.core.das.mngt.HelpMngt#find(long)
     */
    public HelpCenterModel find(long id) {
        try {
            return this.helpContentCache.get(id);
        } catch (Exception e) {
            throw new RuntimeException("根据ID获取帮助内容异常！", e);
        }
    }

    /** 
     * @see com.azdai.core.das.mngt.HelpMngt#fetch(long)
     */
    public HelpCenterModel fetch(long id) {
        HelpCenterDTO srcObj = this.helpCenterDAO.find(id);
        return HelpCenterConvert.convert(srcObj);
    }

    /** 
     * @see com.azdai.core.das.mngt.HelpMngt#findTree()
     */
    public List<HelpCenterModel> findTree() {
        try {
            return this.helpCenterCache.get(HELP_CACHE_KEY);
        } catch (Exception e) {
            throw new RuntimeException("获取帮助内容结构树异常！", e);
        }
    }

    /** 
     * @see com.azdai.core.das.mngt.HelpMngt#fetchTree()
     */
    public List<HelpCenterModel> fetchTree() {
        List<HelpCenterDTO> srcObjs = this.helpCenterDAO.findAll();
        List<HelpCenterModel> dstObjs = HelpCenterConvert.convert(srcObjs);

        return HelpWebX.constructTree(dstObjs);
    }

}
