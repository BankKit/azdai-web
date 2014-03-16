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
 * 论坛主题回复枚举
 * 
 * @author obullxl@gmail.com
 * @version $Id: ForumTopicReplyEnum.java, V1.0.1 2014年3月14日 下午12:00:31 $
 */
public enum ForumTopicCatgEnum implements EnumBase {
    //
    TOPIC("主贴"),
    //
    REPLY("回帖"),
    //
    ;

    private final String desp;

    private ForumTopicCatgEnum(String desp) {
        this.desp = desp;
    }

    /**
     * 获取枚举
     */
    public static ForumTopicCatgEnum find(String code) {
        if (StringUtils.isBlank(code)) {
            return null;
        }

        for (ForumTopicCatgEnum enm : values()) {
            if (StringUtils.equals(code, enm.code())) {
                return enm;
            }
        }

        return null;
    }

    /**
     * 枚举映射
     */
    public static Map<String, ForumTopicCatgEnum> toMap() {
        Map<String, ForumTopicCatgEnum> enums = new LinkedHashMap<String, ForumTopicCatgEnum>();

        for (ForumTopicCatgEnum enm : values()) {
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
