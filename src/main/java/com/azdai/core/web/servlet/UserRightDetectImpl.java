/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.web.servlet;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.Assert;
import org.springframework.util.PathMatcher;

import com.github.obullxl.lang.Consts;
import com.github.obullxl.lang.user.UserContext;
import com.github.obullxl.lang.user.UserContextHolder;
import com.github.obullxl.lang.user.UserContextUtils;
import com.github.obullxl.lang.utils.LogUtils;
import com.github.obullxl.lang.web.AbstractUserRightDetect;
import com.github.obullxl.lang.web.servlet.ServletUtils;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * 用户权限检测器
 * 
 * @author obullxl@gmail.com
 * @version $Id: UserRightDetectImpl.java, V1.0.1 2014年3月30日 下午7:19:40 $
 */
public class UserRightDetectImpl extends AbstractUserRightDetect implements InitializingBean {
    private static final Logger                   logger  = LogUtils.get();

    /** 路径匹配器 */
    private static final PathMatcher              matcher = new AntPathMatcher();

    /** URI前缀 */
    private Set<String>                           uriPrefixs;

    /** 跳转页面 */
    private String                                gotoUrl = "/login.htm";

    /** 
     * 权限配置
     * <p/>
     * /admin/**>RGT_LOGIN_NORMAL
     * <br/>
     * /admin/topic/create*>RGT_TOPIC_CREATE
     * <br/>
     * /admin/topic/create*.html>RGT_TOPIC_CREATE
     */
    private Resource                              rightConfig;

    /** 系统是否就绪 */
    private boolean                               ready   = false;

    /** URI权限映射 */
    private static final Map<String, Set<String>> PATHS   = Maps.newConcurrentMap();

    /**
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    public void afterPropertiesSet() {
        Assert.isTrue(!CollectionUtils.isEmpty(this.uriPrefixs), "权限拦截URL前缀必须配置！");
        Assert.notNull(this.rightConfig, "URL权限配置文件必须设置！");

        logger.warn("[权限拦截]-URI前缀-{}.", this.uriPrefixs);
        logger.warn("[权限拦截]-权限配置-{}.", this.rightConfig);

        InputStream input = null;
        try {
            input = this.rightConfig.getInputStream();
            List<String> lines = IOUtils.readLines(input, Consts.ENCODING);
            for (String line : lines) {
                if (StringUtils.isBlank(line) || StringUtils.startsWith(line, "#")) {
                    continue;
                }

                String[] kvs = StringUtils.split(line, ">", 2);
                if (kvs == null || kvs.length != 2) {
                    logger.warn("URI权限配置错误-{}.", line);
                    continue;
                }

                String uri = StringUtils.trimToEmpty(kvs[0]);
                Set<String> cfgs = PATHS.get(uri);
                if (cfgs == null) {
                    cfgs = Sets.newConcurrentHashSet();
                    PATHS.put(uri, cfgs);
                }

                String[] rgts = StringUtils.split(kvs[1], ",");
                for (String rgt : rgts) {
                    cfgs.add(StringUtils.trim(rgt));
                }
            }

            // 加载完成
            this.ready = true;
        } catch (Exception e) {
            throw new RuntimeException("URI权限解析异常.", e);
        } finally {
            IOUtils.closeQuietly(input);
        }
    }

    /** 
     * @see com.github.obullxl.lang.user.UserRightRequest#onRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public boolean onRequest(HttpServletRequest request, HttpServletResponse response) {
        String url = this.getQueryURL(request);
        if (!this.isURLNeedRights(url)) {
            return true;
        }

        if (logger.isInfoEnabled()) {
            logger.info("拦截后台请求{}-{}", StringUtils.upperCase(request.getMethod()), url);
        }

        if (!this.ready) {
            throw new RuntimeException("权限未加载完成，禁止权限校验逻辑！");
        }

        // 上下文检查
        HttpSession session = request.getSession(true);
        UserContext ctx = UserContextHolder.get();
        if (ctx == null) {
            throw new RuntimeException("权限检查失败-用户上线文未加载-" + url);
        }

        // 登录状态检查
        if (!UserContextUtils.isLogin()) {
            // 保持会话
            UserContextUtils.setGotoURL(UserContextHolder.get(), url);
            UserContextUtils.setSessionContext(session, ctx);

            // 页面跳转
            ServletUtils.redirectResponse(this.gotoUrl, request, response);

            // 禁止执行
            return false;
        }

        // URI权限检查
        Set<String> rgts = findURIRights(request.getRequestURI());
        if (!UserContextUtils.isRights(rgts)) {
            logger.warn("权限不足-{}", rgts);
            // throw new RightException(new ArrayList<String>(rgts));
            // 页面跳转
            ServletUtils.redirectResponse(this.gotoUrl, request, response);

            // 禁止执行
            return false;
        }

        // 权限检查通过
        return true;
    }

    /**
     * 取得URI+QueryString字符串
     */
    private String getQueryURL(HttpServletRequest request) {
        String uri = request.getRequestURI();
        String query = request.getQueryString();

        if (StringUtils.isNotBlank(query)) {
            uri += ("?" + query);
        }

        return uri;
    }

    /**
     * 检查是否需要检查权限
     */
    private boolean isURLNeedRights(String url) {
        for (String prefix : this.uriPrefixs) {
            if (StringUtils.startsWith(url, prefix)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 根据URI获取所有权限码
     */
    public static final Set<String> findURIRights(String uri) {
        Set<String> rgts = Sets.newConcurrentHashSet();

        for (Map.Entry<String, Set<String>> entry : PATHS.entrySet()) {
            String path = entry.getKey();

            if (StringUtils.endsWith(path, "*")) {
                if (matcher.matchStart(path, uri)) {
                    rgts.addAll(entry.getValue());
                }
            } else {
                if (matcher.match(path, uri)) {
                    rgts.addAll(entry.getValue());
                }
            }
        }

        return rgts;
    }

    // ~~~~~~~~~~~~~~~~ 依赖注入 ~~~~~~~~~~~~~~~ //

    public void setUriPrefixs(Set<String> uriPrefixs) {
        this.uriPrefixs = uriPrefixs;
    }

    public void setGotoUrl(String gotoUrl) {
        this.gotoUrl = gotoUrl;
    }

    public void setRightConfig(Resource rightConfig) {
        this.rightConfig = rightConfig;
    }

}
