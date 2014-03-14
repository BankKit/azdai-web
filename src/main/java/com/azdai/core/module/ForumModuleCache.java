/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.module;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import com.azdai.core.model.ForumInfoModel;
import com.azdai.core.model.ForumUserModel;
import com.github.obullxl.lang.utils.DateUtils;
import com.github.obullxl.lang.utils.LogUtils;
import com.github.obullxl.model.cfg.CfgUtils;

/**
 * 模型缓存
 * 
 * @author obullxl@gmail.com
 * @version $Id: ModelCache.java, V1.0.1 2014年3月14日 下午2:54:22 $
 */
@Component("forumModuleCache")
public class ForumModuleCache {
    private static final Logger               logger           = LogUtils.get();

    /** 论坛模型-最近执行时间 */
    private static Date                       FORUM_EXEC_TIME;

    /** 论坛模型-执行时间间隔(11分钟) */
    private static final long                 FORUM_INTERVAL   = 11 * 60 * 1000;

    /** 论坛模型-论坛管理员 */
    private static final List<ForumUserModel> FORUM_USER_CACHE = new ArrayList<ForumUserModel>();

    /** 论坛模型-论坛模型 */
    private static final List<ForumInfoModel> FORUM_INFO_CACHE = new ArrayList<ForumInfoModel>();

    /**
     * 是否进行缓存刷新
     */
    public static boolean isForumMustExecute() {
        if (FORUM_EXEC_TIME == null) {
            FORUM_EXEC_TIME = DateUtils.toDateDW("1988-08-08");
        }

        Date now = new Date();
        if (now.getTime() - FORUM_EXEC_TIME.getTime() >= FORUM_INTERVAL) {
            FORUM_EXEC_TIME = now;
            return true;
        }

        return false;
    }

    /**
     * 刷新缓存
     */
    public void onRefresh() {
        logger.warn("[论坛模型]-开始刷新论坛模型缓存......");

        long start = System.currentTimeMillis();
        try {
            //List<ForumInfoDTO> srcObjs = this.forumInfoDAO.findState(ValveBoolEnum.TRUE.code());
            //List<ForumInfoModel> forums = ForumInfoConvert.convert(srcObjs);

        } finally {
            logger.warn("[论坛模型]-论坛模型缓存刷新完成, 耗时[{}]ms, 论坛列表: \n{}", (System.currentTimeMillis() - start), CfgUtils.find());
        }
    }

}
