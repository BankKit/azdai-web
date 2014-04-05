/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.web.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.azdai.core.das.mngt.UserMngt;
import com.azdai.core.web.form.UserInfoQueryForm;

/**
 * 会员信息管理控制器
 * 
 * @author obullxl@gmail.com
 * @version $Id: UserMngtController.java, V1.0.1 2014年3月14日 下午8:25:03 $
 */
@Controller
@RequestMapping("/mngt")
public class UserMngtController extends AbstractController {

    /** 会员信息管理器 */
    @Autowired
    private UserMngt userMngt;

    /**
     * 会员信息管理
     */
    @RequestMapping(value = "/user-info/manage.htm")
    public String userInfoManage(UserInfoQueryForm form) {
        try {
            this.setWebData("form", form);
            this.setWebData("userPageList", this.userMngt.findUserInfoFuzzy(form));
        } catch (Exception e) {
            logger.error("分页查询会员信息异常!", e);
        }

        return this.toMngtView("", "user-info-manage");
    }

}
