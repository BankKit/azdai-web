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
public enum ForumTopicReplyEnum implements EnumBase {
    //
    OPEN("开放"),
    //
    CLOSE("关闭"),
    //
    ;

    private final String desp;

    private ForumTopicReplyEnum(String desp) {
        this.desp = desp;
    }
    
    /**
     * 是否允许评论
     */
    public boolean isAllowReply() {
        return (CLOSE != this);
    }

    /**
     * 获取枚举
     */
    public static ForumTopicReplyEnum find(String code) {
        if (StringUtils.isBlank(code)) {
            return null;
        }

        for (ForumTopicReplyEnum enm : values()) {
            if (StringUtils.equals(code, enm.code())) {
                return enm;
            }
        }

        return null;
    }

    /**
     * 枚举映射
     */
    public static Map<String, ForumTopicReplyEnum> toMap() {
        Map<String, ForumTopicReplyEnum> enums = new LinkedHashMap<String, ForumTopicReplyEnum>();

        for (ForumTopicReplyEnum enm : values()) {
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
