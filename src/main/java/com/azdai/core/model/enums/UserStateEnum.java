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
 * 激活状态枚举
 * 
 * @author obullxl@gmail.com
 * @version $Id: UserStateEnum.java, V1.0.1 2014年1月28日 上午9:42:08 $
 */
public enum UserStateEnum implements EnumBase {
    //
    WAITE_ACTIVE("等待激活"),
    //
    WAITE_AUTH("等待认证"),
    //
    ACTIVE_NORMAL("激活认证正常"),
    //
    ;

    private final String desp;

    /**
     * CTOR
     */
    private UserStateEnum(String desp) {
        this.desp = desp;
    }

    /**
     * 获取默认类型
     */
    public static final UserStateEnum findDefault() {
        return WAITE_ACTIVE;
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
    public static final UserStateEnum findDefault(String code) {
        for (UserStateEnum enm : values()) {
            if (StringUtils.equalsIgnoreCase(enm.code(), code)) {
                return enm;
            }
        }

        return findDefault();
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
        return this.name();
    }

    /** 
     * @see com.github.obullxl.lang.enums.EnumBase#desp()
     */
    public String desp() {
        return this.desp;
    }

}
