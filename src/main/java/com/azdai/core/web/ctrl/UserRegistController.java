/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.web.ctrl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.azdai.core.das.mngt.BlackMngt;
import com.azdai.core.das.mngt.UserMngt;
import com.azdai.core.model.UserInfoModel;
import com.azdai.core.model.convert.UserInfoConvert;
import com.azdai.core.model.enums.BizResponseEnum;
import com.azdai.core.web.form.UserRegistForm;
import com.github.obullxl.lang.biz.BizResponse;

/**
 * 用户注册控制器
 * 
 * @author obullxl@gmail.com
 * @version $Id: UserRegistController.java, V1.0.1 2014年3月15日 下午6:31:46 $
 */
@Controller
public class UserRegistController extends AbstractController {

    /** 用户管理器 */
    @Autowired
    private UserMngt  userMngt;

    /** 黑名单管理器 */
    @Autowired
    private BlackMngt blackMngt;

    /**
     * 新用户注册
     */
    @ResponseBody
    @RequestMapping(value = "/user-regist.htm", method = { RequestMethod.POST })
    public BizResponse createRegistUser(UserRegistForm form) {
        // 操作结果
        BizResponse response = this.newBizResponse(true);
        try {
            // 校验
            form.setNickName(StringUtils.trim(form.getNickName()));
            if (StringUtils.isBlank(form.getNickName())) {
                this.buildResponse(response, "PARAMS", "用户名不能为空！");
                return response;
            }

            if (this.blackMngt.isBlackUser(form.getNickName())) {
                this.buildResponse(response, "PARAMS", "用户名已经被注册！");
                return response;
            }

            if (!StringUtils.equals(form.getPasswd(), form.getRepeatPasswd())) {
                this.buildResponse(response, "PARAMS", "用户登录密码2次输入不一致！");
                return response;
            }

            form.setEmail(StringUtils.trim(form.getEmail()));
            if (StringUtils.isBlank(form.getNickName())) {
                this.buildResponse(response, "PARAMS", "电子邮箱不能为空！");
                return response;
            }

            if (this.userMngt.findByEmail(form.getEmail()) != null) {
                this.buildResponse(response, "PARAMS", "电子邮箱已经被注册！");
                return response;
            }

            if (this.userMngt.findByNickName(form.getNickName()) != null) {
                this.buildResponse(response, "PARAMS", "用户名已经被注册！");
                return response;
            }

            // 新建
            UserInfoModel model = UserInfoConvert.convert(form);
            model.setNo(this.userMngt.findUserNo());
            model.setPasswd(this.userMngt.findLoginPasswd(form.getPasswd()));

            this.userMngt.createUserInfo(model);

            response.getBizData().put(BizResponse.BIZ_ID_KEY, model.getNo());
        } catch (Exception e) {
            logger.error("新增注册用户信息异常!", e);
            this.buildResponse(response, BizResponseEnum.SYSTEM_ERROR);
        }

        // JSON返回
        return response;
    }
}
