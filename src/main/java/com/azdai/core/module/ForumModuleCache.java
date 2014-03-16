/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.module;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.azdai.core.das.dal.dao.ForumInfoDAO;
import com.azdai.core.das.dal.dao.ForumUserDAO;
import com.azdai.core.das.dal.dto.ForumInfoDTO;
import com.azdai.core.das.dal.dto.ForumUserDTO;
import com.azdai.core.model.ForumInfoModel;
import com.azdai.core.model.ForumUserModel;
import com.azdai.core.model.convert.ForumInfoConvert;
import com.azdai.core.model.convert.ForumUserConvert;
import com.github.obullxl.lang.enums.ValveBoolEnum;
import com.github.obullxl.lang.timer.TickTimer;
import com.github.obullxl.lang.utils.DateUtils;
import com.github.obullxl.lang.utils.LogUtils;

/**
 * 模型缓存
 * 
 * @author obullxl@gmail.com
 * @version $Id: ModelCache.java, V1.0.1 2014年3月14日 下午2:54:22 $
 */
@Component("forumModuleCache")
public class ForumModuleCache implements TickTimer, InitializingBean {
    private static final Logger               logger      = LogUtils.get();

    /** 论坛模型-最近执行时间 */
    private static Date                       EXEC_TIME;

    /** 论坛模型-执行时间间隔(11分钟) */
    private static final long                 INTERVAL    = 11 * 60 * 1000;

    /** 论坛模型-论坛管理员 */
    private static final List<ForumUserModel> USER_CACHE  = new ArrayList<ForumUserModel>();

    /** 论坛模型-论坛模型 */
    private static final List<ForumInfoModel> FORUM_CACHE = new ArrayList<ForumInfoModel>();

    /**
     * 论坛信息DAO
     */
    @Autowired
    private ForumInfoDAO                      forumInfoDAO;

    /**
     * 论坛用户DAO
     */
    @Autowired
    private ForumUserDAO                      forumUserDAO;

    /** 
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    public void afterPropertiesSet() {
        this.onRefresh();
    }

    /**
     * 是否进行缓存刷新
     */
    private boolean isMustExecute() {
        if (EXEC_TIME == null) {
            EXEC_TIME = DateUtils.toDateDW("1988-08-08");
        }

        Date now = new Date();
        if (now.getTime() - EXEC_TIME.getTime() >= INTERVAL) {
            EXEC_TIME = now;
            return true;
        }

        return false;
    }

    /** 
     * @see com.github.obullxl.lang.timer.TickTimer#tick()
     */
    public void tick() {
        if (!this.isMustExecute()) {
            if (logger.isInfoEnabled()) {
                logger.info("[论坛模型]-本次无需操作, [" + DateUtils.toStringDL(EXEC_TIME) + "].");
            }

            return;
        }

        // 定时刷新
        this.onRefresh();
    }

    /**
     * 刷新缓存
     */
    public void onRefresh() {
        logger.warn("[论坛模型]-开始刷新论坛模型缓存......");

        long start = System.currentTimeMillis();
        try {
            List<ForumUserDTO> srcUsers = this.forumUserDAO.findAll();
            List<ForumUserModel> dstUsers = ForumUserConvert.convert(srcUsers);
            USER_CACHE.clear();
            USER_CACHE.addAll(dstUsers);

            List<ForumInfoDTO> srcForums = this.forumInfoDAO.findState(ValveBoolEnum.TRUE.code());
            List<ForumInfoModel> dstForums = ForumInfoConvert.convert(srcForums);
            FORUM_CACHE.clear();
            FORUM_CACHE.addAll(dstForums);

            // 论坛用户
            for (ForumInfoModel forum : dstForums) {
                for (ForumUserModel user : dstUsers) {
                    if (StringUtils.equals(forum.getCode(), user.getForumCode())) {
                        forum.getForumUsers().add(user);
                    }
                }
            }
        } finally {
            logger.warn("[论坛模型]-论坛模型缓存刷新完成, 耗时[{}]ms, 论坛列表: \n{}", (System.currentTimeMillis() - start), FORUM_CACHE);
        }
    }

    /**
     * 获取论坛模型
     */
    public static ForumInfoModel findForum(String code) {
        for (ForumInfoModel model : FORUM_CACHE) {
            if (StringUtils.equals(code, model.getCode())) {
                return model;
            }
        }

        return null;
    }

    /**
     * 获取有效论坛模型
     */
    public static List<ForumInfoModel> findValidForums() {
        return new ArrayList<ForumInfoModel>(FORUM_CACHE);
    }

}
