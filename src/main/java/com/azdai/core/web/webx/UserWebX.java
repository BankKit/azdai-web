/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.web.webx;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.azdai.core.das.mngt.UserMngt;
import com.azdai.core.model.UserInfoModel;
import com.azdai.core.model.convert.UserInfoConvert;
import com.azdai.core.model.utils.DateUtils;
import com.github.obullxl.lang.MapExt;
import com.github.obullxl.lang.user.UserContextHolder;
import com.github.obullxl.lang.user.UserContextUtils;
import com.github.obullxl.lang.webx.WebX;
import com.google.common.collect.Lists;

/**
 * 用户WebX
 * 
 * @author obullxl@gmail.com
 * @version $Id: UserWebX.java, V1.0.1 2014年3月14日 下午7:57:58 $
 */
@Component("userWebX")
public class UserWebX implements WebX {

    /** 用户管理器 */
    @Autowired
    private UserMngt userMngt;

    /**
     * 用户是否登录
     */
    public static boolean isLogin() {
        return UserContextUtils.isLogin();
    }

    /**
     * 获取登录用户
     */
    public UserInfoModel findSessionUser() {
        return UserInfoConvert.convert(UserContextHolder.get());
    }

    /**
     * 获取用户头像路径
     */
    public String findUserAvatar(UserInfoModel user) {
        String avatar = user.getAvatar();
        if (StringUtils.isBlank(avatar)) {
            // String idx = Integer.toString(RandomUtils.nextInt(15));
            // return "/avatar/avatar" + StringUtils.leftPad(idx, 2, "0") + ".gif";
            return "/avatar/avatar.jpg";
        } else {
            if (!StringUtils.startsWith(avatar, "/")) {
                avatar = "/" + avatar;
            }

            return "/avatar" + avatar;
        }
    }

    /**
     * 获取用户信息
     */
    public UserInfoModel findUserByNo(String no) {
        return this.userMngt.findByNo(no);
    }

    /**
     * 获取新增会员趋势图表数据
     */
    public List<MapExt> findUserRegistChartData() {
        List<MapExt> data = Lists.newArrayList();

        Date now = DateUtils.truncateDate(new Date());
        Date start = DateUtils.addDays(now, -30);

        while (!start.after(now)) {
            MapExt ext = new MapExt();
            ext.put("date", DateUtils.toString(start, "MM.dd"));
            ext.put("count", Integer.toString(RandomUtils.nextInt(100)));
            
            data.add(ext);
            
            // 下一日
            start = DateUtils.addDays(start, 1);
        }

        return data;
    }

}
