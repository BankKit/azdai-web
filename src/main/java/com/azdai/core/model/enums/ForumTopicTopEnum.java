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
 * 论坛主题置顶枚举
 * 
 * @author obullxl@gmail.com
 * @version $Id: ForumTopicTopEnum.java, V1.0.1 2014年3月14日 下午12:00:31 $
 */
public enum ForumTopicTopEnum implements EnumBase {
    //
    NONE("非置顶"),
    //
    FORUM("论坛"),
    //
    GLOBAL("全局"),
    //
    ;

    private final String desp;

    private ForumTopicTopEnum(String desp) {
        this.desp = desp;
    }

    /**
     * 获取枚举
     */
    public static ForumTopicTopEnum find(String code) {
        if (StringUtils.isBlank(code)) {
            return null;
        }

        for (ForumTopicTopEnum enm : values()) {
            if (StringUtils.equals(code, enm.code())) {
                return enm;
            }
        }

        return null;
    }

    /**
     * 枚举映射
     */
    public static Map<String, ForumTopicTopEnum> toMap() {
        Map<String, ForumTopicTopEnum> enums = new LinkedHashMap<String, ForumTopicTopEnum>();

        for (ForumTopicTopEnum enm : values()) {
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
