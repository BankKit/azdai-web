/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.web.webx;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.azdai.core.model.enums.CarouselCatgEnum;
import com.azdai.core.model.enums.DataCacheCatgEnum;
import com.azdai.core.model.enums.ForumInfoOpenEnum;
import com.azdai.core.model.enums.ForumTopicCatgEnum;
import com.azdai.core.model.enums.ForumTopicReplyEnum;
import com.azdai.core.model.enums.ForumTopicStateEnum;
import com.azdai.core.model.enums.ForumTopicTopEnum;
import com.azdai.core.model.enums.ForumUserRightEnum;
import com.azdai.core.model.enums.UploadFileCatgEnum;
import com.azdai.core.model.enums.UserStateEnum;
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
        if (enm == null) {
            return StringUtils.EMPTY;
        }

        return enm.code();
    }

    /**
     * 数据缓存枚举列表
     */
    public List<DataCacheCatgEnum> findDataCacheCatgEnums() {
        return Arrays.asList(DataCacheCatgEnum.values());
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

    /**
     * 论坛主贴类型枚举列表
     */
    public List<ForumTopicCatgEnum> findForumTopicCatgEnums() {
        return Arrays.asList(ForumTopicCatgEnum.values());
    }

    /**
     * 论坛主贴状态枚举列表
     */
    public List<ForumTopicStateEnum> findForumTopicStateEnums() {
        return Arrays.asList(ForumTopicStateEnum.values());
    }

    /**
     * 论坛主贴置顶枚举列表
     */
    public List<ForumTopicTopEnum> findForumTopicTopEnums() {
        return Arrays.asList(ForumTopicTopEnum.values());
    }

    /**
     * 论坛主贴加精枚举列表
     */
    public List<ValveBoolEnum> findForumTopicEliteEnums() {
        return Arrays.asList(ValveBoolEnum.values());
    }

    /**
     * 论坛主贴回复枚举列表
     */
    public List<ForumTopicReplyEnum> findForumTopicReplyEnums() {
        return Arrays.asList(ForumTopicReplyEnum.values());
    }

    /**
     * 帮助中心前台显示枚举列表
     */
    public List<ValveBoolEnum> findHelpCenterShowEnums() {
        return Arrays.asList(ValveBoolEnum.values());
    }

    /**
     * 会员信息激活状态枚举列表
     */
    public List<UserStateEnum> findUserInfoStateEnums() {
        return Arrays.asList(UserStateEnum.values());
    }

    /**
     * 会员信息登录状态枚举列表
     */
    public List<ValveBoolEnum> findUserLoginStateEnums() {
        return Arrays.asList(ValveBoolEnum.values());
    }

    /**
     * 幻灯片图片分类枚举列表
     */
    public List<CarouselCatgEnum> findCarouselCatgEnums() {
        return Arrays.asList(CarouselCatgEnum.values());
    }

    /**
     * 幻灯片图片显示枚举列表
     */
    public List<ValveBoolEnum> findCarouselShowEnums() {
        return Arrays.asList(ValveBoolEnum.values());
    }
    
    /**
     * 上传文件分类枚举列表
     */
    public List<UploadFileCatgEnum> findUploadFileCatgEnums() {
        return Arrays.asList(UploadFileCatgEnum.values());
    }

}
