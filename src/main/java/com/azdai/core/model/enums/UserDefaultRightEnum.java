/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2013 All Rights Reserved.
 */
package com.azdai.core.model.enums;

import com.github.obullxl.lang.enums.EnumBase;

/**
 * 用户默认权限枚举
 * 
 * @author obullxl@gmail.com
 * @version $Id: UserDefaultRightEnum.java, V1.0.1 2013年12月15日 下午7:48:24 $
 */
public enum UserDefaultRightEnum implements EnumBase {
    //
    RGT_LOGIN_USER("用户登录"),
    //
    RGT_LOGIN_MNGT("登录后台"),
    //
    ;

    private final String desp;

    private UserDefaultRightEnum(String desp) {
        this.desp = desp;
    }

    /**
     * 根据代码获取枚举
     */
    public static final UserDefaultRightEnum findByCode(String code) {
        try {
            return UserDefaultRightEnum.valueOf(code);
        } catch (Exception e) {
            // ignore
            return null;
        }
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
