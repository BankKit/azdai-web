/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.web.ctrl;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.azdai.core.das.mngt.ForumMngt;
import com.azdai.core.das.mngt.HelpMngt;
import com.azdai.core.model.enums.BizResponseEnum;
import com.azdai.core.model.enums.DataCacheCatgEnum;
import com.github.obullxl.lang.biz.BizResponse;
import com.github.obullxl.lang.utils.LogUtils;

/**
 * 数据缓存管理器
 * 
 * @author obullxl@gmail.com
 * @version $Id: CacheMngtController.java, V1.0.1 2014年4月4日 下午7:39:37 $
 */
@Controller
@RequestMapping("/mngt")
public class CacheMngtController extends AbstractController {
    private static final Logger logger = LogUtils.get();

    /** 论坛信息管理器 */
    @Autowired
    private ForumMngt           forumMngt;

    /** 帮助中心管理器 */
    @Autowired
    private HelpMngt            helpMngt;

    /**
     * 新增论坛
     */
    @ResponseBody
    @RequestMapping(value = "/data-cache/invalidate.htm", method = RequestMethod.POST)
    public BizResponse cleanDataCache(String catg) {
        // 操作结果
        BizResponse response = this.newBizResponse(true);
        try {
            if (StringUtils.isBlank(catg)) {
                return response;
            }

            DataCacheCatgEnum enm = DataCacheCatgEnum.findByCode(catg);
            if (enm == null) {
                this.buildResponse(response, "PARAMS", "缓存分类无效或不存在！");
                return response;
            }

            logger.warn("[缓存]-刷新缓存[{}].", enm);

            // 论坛缓存-论坛信息、置顶主贴、最新主贴
            if (enm == DataCacheCatgEnum.FORUM_INFO) {
                this.forumMngt.cleanCache();
            }

            // 帮助中心-结构树、帮助内容
            else if (enm == DataCacheCatgEnum.HELP_CENTER) {
                this.helpMngt.cleanCache();
            }
            
            // 其他
            else {
                logger.warn("[缓存]-刷新缓存逻辑不存在[{}].", enm);
            }
        } catch (Exception e) {
            logger.error("刷新缓存[{}]异常!", catg, e);
            this.buildResponse(response, BizResponseEnum.SYSTEM_ERROR);
        }

        // JSON返回
        return response;
    }
}
