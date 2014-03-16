/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.web.webx;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.azdai.core.model.enums.ForumInfoOpenEnum;
import com.azdai.core.model.enums.ForumUserRightEnum;
import com.github.obullxl.lang.enums.EnumBase;
import com.github.obullxl.lang.enums.ValveBoolEnum;
import com.github.obullxl.lang.webx.WebX;

/**
 * 枚举WebX
 * 
 * @author obullxl@gmail.com
 * @version $Id: EnumWebX.java, V1.0.1 2014年3月14日 下午8:54:06 $
 */
@Component("enumWebX")
public class EnumWebX implements WebX {

    /**
     * 获取枚举代码
     */
    public static String findEnumCode(EnumBase enm) {
        if(enm == null) {
            return StringUtils.EMPTY;
        }
        
        return enm.code();
    }
    
    /**
     * Bool开关值枚举列表
     */
    public List<ValveBoolEnum> findValveBoolEnums() {
        return Arrays.asList(ValveBoolEnum.values());
    }
    
    /**
     * 论坛开放类型枚举列表
     */
    public List<ForumInfoOpenEnum> findForumOpenEnums() {
        return Arrays.asList(ForumInfoOpenEnum.values());
    }

    /**
     * 论坛用户权限枚举列表
     */
    public List<ForumUserRightEnum> findForumUserRgtEnums() {
        return Arrays.asList(ForumUserRightEnum.values());
    }

}
