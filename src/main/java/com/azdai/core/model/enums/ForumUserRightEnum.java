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
 * 论坛用户权限枚举
 * 
 * @author obullxl@gmail.com
 * @version $Id: ForumInfoOpenEnum.java, V1.0.1 2014年3月14日 下午12:00:31 $
 */
public enum ForumUserRightEnum implements EnumBase {
    //
    TOPIC_DELETE("删除主题"),
    //
    TOPIC_UPDATE("更新主题"),
    //
    TOPIC_META_TOP("置顶标志"),
    //
    TOPIC_META_ELITE("加精标志"),
    //
    TOPIC_META_REPLY("评论标志"),
    //
    REPLY_DELETE("删除主题回复"),
    //
    REPLY_UPDATE("更新主题回复"),
    //
    ;

    private final String desp;

    private ForumUserRightEnum(String desp) {
        this.desp = desp;
    }

    /**
     * 获取枚举
     */
    public static ForumUserRightEnum find(String code) {
        if (StringUtils.isBlank(code)) {
            return null;
        }

        for (ForumUserRightEnum enm : values()) {
            if (StringUtils.equals(code, enm.code())) {
                return enm;
            }
        }

        return null;
    }

    /**
     * 枚举映射
     */
    public static Map<String, ForumUserRightEnum> toMap() {
        Map<String, ForumUserRightEnum> enums = new LinkedHashMap<String, ForumUserRightEnum>();

        for (ForumUserRightEnum enm : values()) {
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
