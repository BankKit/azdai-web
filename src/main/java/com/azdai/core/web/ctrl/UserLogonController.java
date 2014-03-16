/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.web.ctrl;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.azdai.core.das.mngt.UserMngt;
import com.azdai.core.model.UserInfoModel;
import com.azdai.core.model.convert.UserInfoConvert;
import com.azdai.core.web.form.UserLoginForm;
import com.github.obullxl.jeesite.web.enums.BizResponseEnum;
import com.github.obullxl.lang.biz.BizResponse;
import com.github.obullxl.lang.enums.ValveBoolEnum;
import com.github.obullxl.lang.user.UserConstant;
import com.github.obullxl.lang.user.UserContext;
import com.github.obullxl.lang.user.UserContextUtils;
import com.github.obullxl.lang.web.WebContext;

/**
 * 用户登录/登出控制器
 * 
 * @author obullxl@gmail.com
 * @version $Id: UserLogonController.java, V1.0.1 2014年3月16日 上午11:31:09 $
 */
@Controller
public class UserLogonController extends AbstractController {

    /** 用户管理器 */
    @Autowired
    private UserMngt userMngt;

    /**
     * 用户登录
     */
    @ResponseBody
    @RequestMapping(value = "/user-login.htm", method = RequestMethod.POST)
    public BizResponse login(@Valid UserLoginForm form, BindingResult errors) {
        // 操作结果
        BizResponse response = this.newBizResponse(true);
        try {
            // 校验
            form.validateEnumBase(errors);

            if (errors.hasErrors()) {
                this.buildResponse(response, BizResponseEnum.INVALID_PARAM);
                return response;
            }

            // 获取用户
            UserInfoModel user = this.userMngt.findByLoginName(form.getLoginName());
            if (user == null) {
                this.buildResponse(response, "USER", "用户不存在！");
                return response;
            }

            if (user.getLoginEnum() != ValveBoolEnum.TRUE) {
                this.buildResponse(response, "USER", "用户禁止登录系统，请联系管理员！");
                return response;
            }

            if (!StringUtils.equals(user.getPasswd(), this.userMngt.findLoginPasswd(form.getPasswd()))) {
                this.buildResponse(response, "USER", "用户登录密码错误！");
                return response;
            }

            // 设置上下文
            HttpSession session = WebContext.get().getSession();
            UserContext uctx = UserContextUtils.findSessionContext(session);
            if (uctx == null) {
                uctx = UserContext.newMockContext();
            }

            UserInfoConvert.merge(user, uctx);
            UserContextUtils.setSessionContext(session, uctx);

            // 设置用户信息
            UserContextUtils.setLogin(uctx, true);

            // 页面跳转
            String gotoUrl = UserContextUtils.findGotoURL(uctx);
            if (StringUtils.isNotBlank(gotoUrl)) {
                response.getBizData().put(UserConstant.URL_GOTO_KEY, gotoUrl);
            }
        } catch (Exception e) {
            logger.error("新增注册用户信息异常!", e);
            this.buildResponse(response, BizResponseEnum.SYSTEM_ERROR);
        }

        // JSON返回
        return response;
    }

    /**
     * 用户登出
     */
    @RequestMapping("/user-logout.htm")
    public String logout() {
        HttpSession session = WebContext.get().getSession();
        UserContextUtils.setSessionContext(session, UserContext.newMockContext());

        return this.redirectTo("/index.htm");
    }

}
