/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.das.mngt.impl;

import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;

import com.azdai.core.das.mngt.BlackMngt;
import com.github.obullxl.lang.utils.LogUtils;

/**
 * 黑名单管理器
 * 
 * @author obullxl@gmail.com
 * @version $Id: BlackMngtImpl.java, V1.0.1 2014年3月15日 下午6:52:48 $
 */
// @Component("blackMngt")
public class BlackMngtImpl implements BlackMngt, InitializingBean {
    private static final Logger logger     = LogUtils.get();

    /** 用户黑名单 */
    private final Set<String>   blackUsers = new HashSet<String>();

    /** 用户名黑名单 */
    private Resource            blackUserPath;

    /** 
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    public void afterPropertiesSet() {
        logger.warn("[黑名单]-加载用户黑名单[{}].", this.blackUserPath);

        try {
            InputStream input = null;
            try {
                input = this.blackUserPath.getInputStream();
                this.parse(input, this.blackUsers);
            } finally {
                IOUtils.closeQuietly(input);
            }
        } catch (Exception e) {
            logger.error("[黑名单]-加载用户黑名单异常，直接忽略!", e);
        }
    }

    /**
     * 解析黑名单文件
     */
    private void parse(InputStream input, Set<String> blacks) throws Exception {
        List<String> lines = IOUtils.readLines(input);
        for (String line : lines) {
            line = StringUtils.trim(line);
            if (StringUtils.isBlank(line) || StringUtils.startsWith(line, "#")) {
                continue;
            }

            String[] words = StringUtils.split(line, ",");
            for (String word : words) {
                blacks.add(word);
            }
        }
    }

    /** 
     * @see com.azdai.core.das.mngt.BlackMngt#isBlackUserName(java.lang.String)
     */
    public boolean isBlackUserName(String name) {
        for (String black : this.blackUsers) {
            if (StringUtils.containsIgnoreCase(name, black)) {
                return true;
            }
        }

        return false;
    }

    // ~~~~~~~~~~~~~~~~~~~~~~ 依赖注入 ~~~~~~~~~~~~~~~~~~~~ //

    public void setBlackUserPath(Resource blackUserPath) {
        this.blackUserPath = blackUserPath;
    }

}
