/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.model.enums;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.github.obullxl.lang.enums.EnumBase;
import com.github.obullxl.lang.enums.EnumBaseUtils;

/**
 * 数据缓存分类枚举
 * 
 * @author obullxl@gmail.com
 * @version $Id: DataCacheCatgEnum.java, V1.0.1 2014年3月17日 下午9:54:23 $
 */
public enum DataCacheCatgEnum implements EnumBase {
    //
    FORUM_INFO("01", "论坛信息缓存"),
    //
    HELP_CENTER("02", "帮助中心缓存"),
    //
    //
    ;

    private final String code;
    private final String desp;

    /**
     * CTOR
     */
    private DataCacheCatgEnum(String code, String desp) {
        this.code = code;
        this.desp = desp;
    }

    /**
     * 转换为Map映射
     */
    public static final Map<String, EnumBase> toMap() {
        return EnumBaseUtils.toEnumMap(values());
    }

    /**
     * 根据代码获取枚举
     */
    public static final DataCacheCatgEnum findByCode(String code) {
        for (DataCacheCatgEnum enm : values()) {
            if (StringUtils.equalsIgnoreCase(enm.code(), code)) {
                return enm;
            }
        }

        return null;
    }

    /** 
     * @see com.github.obullxl.lang.enums.EnumBase#id()
     */
    public int id() {
        return this.ordinal();
    }

    /** 
     * @see com.github.obullxl.lang.enums.EnumBase#code()
     */
    public String code() {
        return this.code;
    }

    /** 
     * @see com.github.obullxl.lang.enums.EnumBase#desp()
     */
    public String desp() {
        return this.desp;
    }

}
