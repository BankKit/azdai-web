/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.model.enums;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.github.obullxl.lang.enums.EnumBase;

/**
 * 论坛开放类型枚举
 * 
 * @author obullxl@gmail.com
 * @version $Id: ForumInfoOpenEnum.java, V1.0.1 2014年3月14日 下午12:00:31 $
 */
public enum ForumInfoOpenEnum implements EnumBase {
    //
    ALL_OPEN("完全开放"),
    //
    LOGIN_USER("登录用户"),
    //
    FORUM_USER("论坛管理员"),
    //
    // SPECIAL_USER("指定用户"),
    //
    ;

    private final String desp;

    private ForumInfoOpenEnum(String desp) {
        this.desp = desp;
    }

    /**
     * 获取枚举
     */
    public static ForumInfoOpenEnum find(String code) {
        if (StringUtils.isBlank(code)) {
            return null;
        }

        for (ForumInfoOpenEnum enm : values()) {
            if (StringUtils.equals(code, enm.code())) {
                return enm;
            }
        }

        return null;
    }

    /**
     * 枚举映射
     */
    public static Map<String, ForumInfoOpenEnum> toMap() {
        Map<String, ForumInfoOpenEnum> enums = new LinkedHashMap<String, ForumInfoOpenEnum>();

        for (ForumInfoOpenEnum enm : values()) {
            enums.put(enm.code(), enm);
        }

        return enums;
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
