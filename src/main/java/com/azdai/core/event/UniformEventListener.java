/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.event;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.github.obullxl.lang.events.EventSubscriber;
import com.github.obullxl.lang.events.UniformEvent;
import com.github.obullxl.lang.utils.LogUtils;
import com.google.common.collect.Lists;

/**
 * 时间监听器
 * 
 * @author obullxl@gmail.com
 * @version $Id: UniformEventListener.java, V1.0.1 2014年4月5日 上午11:47:01 $
 */
@Component("uniformEventListener")
public class UniformEventListener implements ApplicationContextAware, ApplicationListener<UniformEvent> {
    private static final Logger         logger      = LogUtils.get();

    /** 消息订阅者 */
    private final List<EventSubscriber> subscribers = Lists.newArrayList();

    /** 
     * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
     */
    public void setApplicationContext(ApplicationContext context) {
        Map<String, EventSubscriber> beans = BeanFactoryUtils.beansOfTypeIncludingAncestors(context, EventSubscriber.class);
        this.subscribers.addAll(beans.values());

        for (EventSubscriber subscriber : this.subscribers) {
            logger.warn("[统一事件]-订阅者: {}", subscriber.getClass().getName());
        }
    }

    /** 
     * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent)
     */
    public void onApplicationEvent(UniformEvent event) {
        if (event == null) {
            return;
        }

        String topic = event.getTopic();
        String evtCode = event.getEvtCode();

        if (logger.isInfoEnabled()) {
            logger.info("[统一事件]-接收到事件-Topic[{}], EvtCode[{}].", topic, evtCode);
        }

        for (EventSubscriber subscriber : this.subscribers) {
            if (subscriber.accept(topic, evtCode)) {
                if (logger.isInfoEnabled()) {
                    logger.info("[统一事件]-Topic[{}], EvtCode[{}], 处理器[{}].", topic, evtCode, subscriber.getClass().getName());
                }

                subscriber.onEvent(event);
            }
        }
    }

}
