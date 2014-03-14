/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.das.mngt.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.azdai.core.das.dal.dao.ForumInfoDAO;
import com.azdai.core.das.dal.dto.ForumInfoDTO;
import com.azdai.core.das.mngt.ForumMngt;
import com.azdai.core.model.ForumInfoModel;
import com.azdai.core.model.convert.ForumInfoConvert;
import com.github.obullxl.lang.enums.ValveBoolEnum;
import com.github.obullxl.lang.timer.TickTimer;
import com.github.obullxl.lang.utils.DateUtils;
import com.github.obullxl.lang.utils.LogUtils;
import com.github.obullxl.model.cfg.CfgModel;
import com.github.obullxl.model.cfg.CfgUtils;

/**
 * 论坛管理器实现
 * 
 * @author obullxl@gmail.com
 * @version $Id: ForumMngtImpl.java, V1.0.1 2014年3月13日 下午10:09:59 $
 */
@Component("forumMngt")
public class ForumMngtImpl implements ForumMngt, TickTimer {
    private static final Logger               logger   = LogUtils.get();

    /** 最近执行时间 */
    private static Date                       EXEC_TIME;

    /** 执行时间间隔(11分钟) */
    private static final long                 INTERVAL = 11 * 60 * 1000;

    /** 缓存 */
    private static final List<ForumInfoModel> forums   = new ArrayList<ForumInfoModel>();

    @Autowired
    private ForumInfoDAO                      forumInfoDAO;

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
     * 获取所有有效论坛模型
     */
    public List<ForumInfoModel> findValidForums() {
        List<ForumInfoDTO> srcObjs = this.forumInfoDAO.findState(ValveBoolEnum.TRUE.code());
        List<ForumInfoModel> forums = ForumInfoConvert.convert(srcObjs);

        return forums;
    }

}
