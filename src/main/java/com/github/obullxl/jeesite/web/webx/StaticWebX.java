/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.github.obullxl.jeesite.web.webx;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.github.obullxl.lang.web.WebContext;
import com.github.obullxl.lang.webx.WebX;

/**
 * 静态资源X工具
 * 
 * @author obullxl@gmail.com
 * @version $Id: StaticWebX.java, V1.0.1 2014年1月6日 下午12:56:42 $
 */
@Component("staticWebX")
public class StaticWebX implements WebX {

    /**
     * 检查URL是否为网络路径
     */
    public static boolean isNetworkURL(String url) {
        if (StringUtils.startsWith(url, "http") || StringUtils.contains(url, "://")) {
            return true;
        }

        return false;
    }

    /**
     * 检查URL是否为本地路径
     */
    public static boolean isRelativeURL(String url) {
        return !isNetworkURL(url);
    }

    /**
     * 获取相册图片路径
     */
    public static String findImageURL(String url) {
        url = StringUtils.trimToEmpty(url);

        if (!isRelativeURL(url)) {
            return url;
        }

        if (!StringUtils.startsWith(url, "/")) {
            url = "/" + url;
        }

        String ictx = StringUtils.trimToEmpty(WebContext.getImageHostCtx());
        if (StringUtils.endsWith(ictx, "/")) {
            ictx = StringUtils.substringBeforeLast(ictx, "/");
        }

        return (ictx + url);
    }

}
