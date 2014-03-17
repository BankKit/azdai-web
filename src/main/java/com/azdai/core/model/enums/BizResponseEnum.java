/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.model.enums;

import com.github.obullxl.lang.enums.EnumBase;

/**
 * 业务返回状态枚举
 * 
 * @author obullxl@gmail.com
 * @version $Id: BizResponseEnum.java, V1.0.1 2014年3月17日 下午9:54:23 $
 */
public enum BizResponseEnum implements EnumBase {
    //
    SYSTEM_ERROR("服务器业务执行异常"),
    //
    INVALID_PARAM("参数值输入非法"),
    //
    ;

    private final String desp;

    /**
     * CTOR
     */
    private BizResponseEnum(String desp) {
        this.desp = desp;
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
