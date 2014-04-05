/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.web.webx;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.azdai.AZD;
import com.azdai.core.model.CarouselModel;
import com.azdai.core.model.convert.ParamConfigConvert;
import com.azdai.core.model.enums.CarouselCatgEnum;
import com.github.obullxl.lang.enums.ValveBoolEnum;
import com.github.obullxl.lang.events.EventConsts;
import com.github.obullxl.lang.events.EventSubscriber;
import com.github.obullxl.lang.events.UniformEvent;
import com.github.obullxl.lang.webx.WebX;
import com.github.obullxl.model.cfg.CfgModel;
import com.github.obullxl.model.cfg.CfgUtils;
import com.google.common.collect.Lists;

/**
 * 导航图片WebX
 * 
 * @author obullxl@gmail.com
 * @version $Id: CarouselWebX.java, V1.0.1 2014年4月5日 下午2:22:13 $
 */
@Component("carouselWebX")
public class CarouselWebX implements WebX, InitializingBean, EventSubscriber {
    /** 接受主题 */
    public static final String               TOPIC = EventConsts.CFG.TOPIC;

    /** 图片缓存 */
    private static final List<CarouselModel> CACHE = Lists.newArrayList();

    /** 
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    public void afterPropertiesSet() {
        this.findRefresh();
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
        this.findRefresh();

        return true;
    }

    /**
     * 刷新
     */
    public List<CarouselModel> findRefresh() {
        List<CfgModel> cfgs = CfgUtils.find(AZD.CFG_CAROUSEL);
        List<CarouselModel> models = Lists.newArrayList();
        for (CfgModel cfg : cfgs) {
            CarouselModel model = ParamConfigConvert.convert(cfg);
            if (model != null) {
                models.add(model);
            }
        }

        Collections.sort(models);
        CACHE.clear();
        CACHE.addAll(models);

        return CACHE;
    }

    /**
     * 获取所有图片
     */
    public List<CarouselModel> findAll() {
        return Lists.newArrayList(CACHE);
    }

    /**
     * 获取单个图片
     */
    public CarouselModel findOne(String no) {
        CfgModel cfg = CfgUtils.find(AZD.CFG_CAROUSEL, no);
        return ParamConfigConvert.convert(cfg);
    }

    /**
     * 获取首页图片
     */
    public static List<CarouselModel> findHome() {
        List<CarouselModel> models = Lists.newArrayList();

        for (CarouselModel model : CACHE) {
            if (model.getCatgEnum() == CarouselCatgEnum.HOME_PAGE && model.getShowEnum() == ValveBoolEnum.TRUE) {
                models.add(model);
            }
        }

        Collections.sort(models);
        return models;
    }

}
