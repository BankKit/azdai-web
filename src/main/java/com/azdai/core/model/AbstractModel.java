/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.model;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.github.obullxl.lang.ToString;

/**
 * 基础模型
 * 
 * @author obullxl@gmail.com
 * @version $Id: AbstractModel.java, V1.0.1 2014年3月13日 下午10:11:54 $
 */
public abstract class AbstractModel extends ToString {
    private static final long     serialVersionUID = 4815510805070451582L;

    /** CreateTime */
    protected Date                gmtCreate        = new Date();

    /** ModifyTime */
    protected Date                gmtModify        = new Date();

    /** ExtData */
    protected Map<String, Object> extData          = new ConcurrentHashMap<String, Object>();

    // ~~~~~~~~~~~ ExtData Functions ~~~~~~~~~~~ //

    @SuppressWarnings("unchecked")
    public <T> T findExtData(String key) {
        Object value = this.extData.get(key);
        if (value == null) {
            return null;
        }

        return (T) value;
    }

    @SuppressWarnings("unchecked")
    public <T> T findExtData(String key, Class<T> clz) {
        Object value = this.extData.get(key);

        if (value != null && clz.isAssignableFrom(value.getClass())) {
            return (T) value;
        }

        return null;
    }

    // ~~~~~~~~~~~ getters and setters ~~~~~~~~~~~ //

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    public Map<String, Object> getExtData() {
        if (this.extData == null) {
            this.extData = new ConcurrentHashMap<String, Object>();
        }

        return extData;
    }

    public void setExtData(Map<String, Object> extData) {
        this.extData = extData;
    }

}
