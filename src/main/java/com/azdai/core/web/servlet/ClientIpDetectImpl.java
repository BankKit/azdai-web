/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.web.servlet;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;

import com.azdai.AZD;
import com.github.obullxl.lang.events.EventConsts;
import com.github.obullxl.lang.events.EventSubscriber;
import com.github.obullxl.lang.events.UniformEvent;
import com.github.obullxl.lang.web.AbstractClientIpDetect;
import com.github.obullxl.model.cfg.CfgModel;
import com.github.obullxl.model.cfg.CfgUtils;
import com.google.common.collect.Lists;

/**
 * 客户端IP防御器
 * 
 * @author obullxl@gmail.com
 * @version $Id: ClientIpDetectImpl.java, V1.0.1 2014年4月5日 上午11:30:11 $
 */
public class ClientIpDetectImpl extends AbstractClientIpDetect implements InitializingBean, EventSubscriber {

    /** 接受主题 */
    public static final String TOPIC = EventConsts.CFG.TOPIC;

    /** 
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    public void afterPropertiesSet() {
    }

    /** 
     * @see com.github.obullxl.lang.events.EventSubscriber#accept(java.lang.String, java.lang.String)
     */
    public boolean accept(String topic, String evtCode) {
        return StringUtils.equals(topic, TOPIC);
    }

    /** 
     * @see com.github.obullxl.lang.events.EventSubscriber#onEvent(com.github.obullxl.lang.events.UniformEvent)
     */
    public boolean onEvent(UniformEvent event) {
        // 黑名单
        this.processIps(AZD.IP_DENY_KEY, super.findDenyIps());

        // 白名单
        this.processIps(AZD.IP_ALLOW_KEY, super.findAllowIps());

        return true;
    }

    /**
     * 处理IP名单
     */
    private void processIps(String key, List<String> ips) {
        ips.clear();

        CfgModel cfg = CfgUtils.find(AZD.CFG_CATG, key);
        if (cfg == null) {
            return;
        }

        String[] values = StringUtils.split(cfg.getValue() + "," + cfg.getValueExt(), ",");
        if (values == null || values.length <= 0) {
            return;
        }

        List<String> tmpIps = Lists.newArrayList();
        for (String value : values) {
            value = StringUtils.trimToEmpty(value);
            if (StringUtils.isNotBlank(value)) {
                tmpIps.add(value);
            }
        }

        // 更新
        ips.addAll(tmpIps);
    }

}
