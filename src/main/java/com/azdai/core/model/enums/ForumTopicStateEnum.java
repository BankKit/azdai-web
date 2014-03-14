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
 * 论坛主题状态枚举
 * 
 * @author obullxl@gmail.com
 * @version $Id: ForumTopicStateEnum.java, V1.0.1 2014年3月14日 下午12:00:31 $
 */
public enum ForumTopicStateEnum implements EnumBase {
    //
    ACTIVE("正常"),
    //
    INVALID("无效"),
    //
    ;

    private final String desp;

    private ForumTopicStateEnum(String desp) {
        this.desp = desp;
    }

    /**
     * 获取枚举
     */
    public static ForumTopicStateEnum find(String code) {
        if (StringUtils.isBlank(code)) {
            return null;
        }

        for (ForumTopicStateEnum enm : values()) {
            if (StringUtils.equals(code, enm.code())) {
                return enm;
            }
        }

        return null;
    }

    /**
     * 枚举映射
     */
    public static Map<String, ForumTopicStateEnum> toMap() {
        Map<String, ForumTopicStateEnum> enums = new LinkedHashMap<String, ForumTopicStateEnum>();

        for (ForumTopicStateEnum enm : values()) {
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
