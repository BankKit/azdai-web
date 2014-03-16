/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.web.ctrl;

import java.net.URLClassLoader;
import java.util.Date;

import javax.servlet.ServletContext;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.github.obullxl.lang.biz.BizResponse;
import com.github.obullxl.lang.enums.EnumBase;
import com.github.obullxl.lang.spring.DatePropertyEditor;
import com.github.obullxl.lang.utils.LogUtils;
import com.github.obullxl.lang.web.WebContext;

/**
 * 控制器基类
 * 
 * @author obullxl@gmail.com
 * @version $Id: AbstractController.java, V1.0.1 2014年3月14日 下午8:25:28 $
 */
public abstract class AbstractController {
    /** Logger */
    protected static final Logger logger = LogUtils.get();

    /** 校验器 */
    @Autowired
    private Validator             validator;

    /**
     * 初始化
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(this.validator);
        binder.registerCustomEditor(Date.class, new DatePropertyEditor());
    }

    /**
     * 设置Web数据值
     */
    public AbstractController setWebData(String key, Object value) {
        WebContext.get().getData().put(key, value);
        return this;
    }

    /**
     * 设置JSON请求标志
     */
    public AbstractController setRequestJSON() {
        WebContext.get().setRequestJSON();
        return this;
    }

    /**
     * 新建业务返回对象
     */
    public BizResponse newBizResponse() {
        return this.newBizResponse(true);
    }

    /**
     * 新建业务返回对象
     */
    public BizResponse newBizResponse(boolean json) {
        BizResponse response = new BizResponse();
        response.setBizLog(LogUtils.findLogID());
        response.setSuccess(true);

        if (json) {
            this.setRequestJSON();
        }

        return response;
    }

    /**
     * 后台视图
     */
    public String toMngtView(String vopt, String name) {
        this.setWebData("vopt", vopt);

        if (!StringUtils.startsWith(name, "/")) {
            name = "/" + name;
        }

        return "/mngt" + name;
    }

    /**
     * 前台视图
     */
    public String toHomeView(String name) {
        if (!StringUtils.startsWith(name, "/")) {
            name = "/" + name;
        }

        return "/home" + name;
    }

    /**
     * 获取论坛视图名
     */
    public String toForumView(String name) {
        if (!StringUtils.startsWith(name, "/")) {
            name = "/" + name;
        }

        return "/forum" + name;
    }

    /**
     * 获取帮助视图名
     */
    public String toHelpView(String name) {
        if (!StringUtils.startsWith(name, "/")) {
            name = "/" + name;
        }

        return "/help" + name;
    }

    /**
     * 获取用户中心视图名
     */
    public String toUserView(String name) {
        if (!StringUtils.startsWith(name, "/")) {
            name = "/" + name;
        }

        return "/user" + name;
    }

    /**
     * 重定向页面
     */
    public String redirectTo(String url) {
        WebContext.get().setRequestRedirect();
        return "redirect:" + url;
    }

    /**
     * Servlet上下文
     */
    public ServletContext findServletContext() {
        return WebContext.getServletContext();
    }

    /**
     * 获取Servlet真实路径
     */
    public String findServletRealPath(String path) {
        return this.findServletContext().getRealPath(path);
    }

    /**
     * 关闭类加载器
     */
    public void close(URLClassLoader loader) {
        try {
            loader.close();
        } catch (Exception e) {
            // ignore
        }
    }

    /**
     * 构建返回结果
     */
    public void buildResponse(BizResponse response, EnumBase enm) {
        this.buildResponse(response, enm.code(), enm.desp());
    }

    /**
     * 构建返回结果
     */
    public void buildResponse(BizResponse response, String code, String desp) {
        response.setSuccess(false);
        response.setRespCode(code);
        response.setRespDesp(desp);
    }

}
