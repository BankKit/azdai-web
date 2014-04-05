/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;

import com.github.obullxl.lang.web.WebContext;

/**
 * 系统信息
 * 
 * @author obullxl@gmail.com
 * @version $Id: AZD.java, V1.0.1 2014年3月30日 下午8:13:56 $
 */
public abstract class AZD {

    /** 版本 */
    public static final String       VERSION         = "2.0.1";

    /** 管理员用户名 */
    public static final List<String> ROOT_USER_NAMES = Arrays.asList("root", "system", "admin", "administrator", "azdai", "anzhongdai");

    /**
     * 获取上传文件根目录
     */
    public static final String findUploadPath() {
        // 正常获取
        String path = WebContext.getServletContext().getRealPath("/upload");

        // OpenShift方式
        if (StringUtils.isBlank(path)) {
            path = System.getenv("OPENSHIFT_DATA_DIR");
        }

        return FilenameUtils.normalizeNoEndSeparator(path);
    }

    /**
     * 组装文件名
     */
    public static final String constructFileName(String name, String ext) {
        if (StringUtils.isBlank(ext)) {
            return name;
        } else {
            return name + "." + ext;
        }
    }

    /** 前台：分页大小 */
    public static final int    PAGE_SIZE      = 10;

    /** 后台：分页大小 */
    public static final int    PAGE_SIZE_MNGT = 30;

    /** 系统参数配置分类 */
    public static final String CFG_CATG       = "AZDAI";

    /** 图片参数配置分类 */
    public static final String CFG_CAROUSEL   = "CAROUSEL";

    /** IP黑名单参数KEY */
    public static final String IP_DENY_KEY    = "client_deny_ips";

    /** IP白名单参数KEY */
    public static final String IP_ALLOW_KEY   = "client_allow_ips";

}
