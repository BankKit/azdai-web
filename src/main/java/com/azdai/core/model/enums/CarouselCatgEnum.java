/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.model.enums;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.github.obullxl.lang.enums.EnumBase;
import com.google.common.collect.Maps;

/**
 * 图片分类枚举
 * 
 * @author obullxl@gmail.com
 * @version $Id: CarouselCatgEnum.java, V1.0.1 2014年4月5日 下午2:27:24 $
 */
public enum CarouselCatgEnum implements EnumBase {
    //
    HOME_PAGE("系统首页图片"),
    //
    ;

    private final String desp;

    private CarouselCatgEnum(String desp) {
        this.desp = desp;
    }

    /**
     * 获取枚举
     */
    public static CarouselCatgEnum find(String code) {
        if (StringUtils.isBlank(code)) {
            return null;
        }

        for (CarouselCatgEnum enm : values()) {
            if (StringUtils.equals(code, enm.code())) {
                return enm;
            }
        }

        return null;
    }

    /**
     * 枚举映射
     */
    public static Map<String, CarouselCatgEnum> toMap() {
        Map<String, CarouselCatgEnum> enums = Maps.newLinkedHashMap();

        for (CarouselCatgEnum enm : values()) {
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
