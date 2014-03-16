/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.model.convert;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.azdai.core.das.dal.dto.UserInfoDTO;
import com.azdai.core.model.UserInfoModel;
import com.azdai.core.model.enums.UserStateEnum;
import com.azdai.core.web.form.UserRegistForm;
import com.github.obullxl.lang.enums.ValveBoolEnum;
import com.github.obullxl.lang.user.UserContext;
import com.github.obullxl.lang.utils.DateUtils;

/**
 * 用户信息转换器
 * 
 * @author obullxl@gmail.com
 * @version $Id: UserInfoConvert.java, V1.0.1 2014年3月15日 下午7:16:36 $
 */
public class UserInfoConvert {

    /**
     * 数据对象到模型对象
     */
    public static UserInfoModel convert(UserInfoDTO srcObj) {
        if (srcObj == null) {
            return null;
        }

        UserInfoModel dstObj = new UserInfoModel();

        BeanUtils.copyProperties(srcObj, dstObj);

        dstObj.setStateEnum(UserStateEnum.findDefault(srcObj.getState()));
        dstObj.setLoginEnum(ValveBoolEnum.findDefault(srcObj.getLoginState()));

        return dstObj;
    }

    /**
     * 模型对象到数据对象
     */
    public static UserInfoDTO convert(UserInfoModel srcObj) {
        if (srcObj == null) {
            return null;
        }

        UserInfoDTO dstObj = new UserInfoDTO();

        BeanUtils.copyProperties(srcObj, dstObj);

        dstObj.setState(srcObj.getStateEnum().code());
        dstObj.setLoginState(srcObj.getLoginEnum().code());

        return dstObj;
    }

    /**
     * 用户注册表单到模型对象
     */
    public static UserInfoModel convert(UserRegistForm srcObj) {
        if (srcObj == null) {
            return null;
        }

        UserInfoModel dstObj = new UserInfoModel();

        BeanUtils.copyProperties(srcObj, dstObj);

        dstObj.setStateEnum(UserStateEnum.WAITE_ACTIVE);
        dstObj.setLoginEnum(ValveBoolEnum.TRUE);
        dstObj.setRegistDate(DateUtils.toStringDW(new Date()));

        return dstObj;
    }

    /**
     * 用户上下文转换
     */
    public static void merge(UserInfoModel srcObj, UserContext dstObj) {
        if (srcObj == null || dstObj == null) {
            return;
        }

        dstObj.setUserNo(srcObj.getNo());
        dstObj.setUserName(srcObj.getNickName());
        dstObj.setUserEmail(srcObj.getEmail());
        dstObj.setUserNick(srcObj.getNickName());

        // 用户模型
        dstObj.getUserExtData().put("MODEL", srcObj);
    }

    /**
     * 用户上下文转换
     */
    public static UserInfoModel convert(UserContext srcObj) {
        if (srcObj == null) {
            return null;
        }

        Object data = srcObj.getUserExtData().get("MODEL");
        if (data != null) {
            return (UserInfoModel) data;
        }

        UserInfoModel dstObj = new UserInfoModel();

        dstObj.setNo(srcObj.getUserNo());
        dstObj.setNickName(srcObj.getUserName());
        dstObj.setEmail(srcObj.getUserEmail());

        return dstObj;
    }

}
