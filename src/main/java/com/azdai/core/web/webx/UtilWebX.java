/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.web.webx;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.azdai.core.das.mngt.ForumMngt;
import com.github.obullxl.lang.utils.DateUtils;
import com.github.obullxl.lang.webx.WebX;

/**
 * 工具X工具
 * 
 * @author obullxl@gmail.com
 * @version $Id: UtilWebX.java, V1.0.1 2014年2月1日 下午2:10:12 $
 */
@Component("utilWebX")
public class UtilWebX implements WebX {

    /**
     * 判断是否为当天
     */
    public static final boolean isToday(Date date) {
        String today = DateUtils.toStringDS(new Date());
        return StringUtils.equals(today, DateUtils.toStringDS(date));
    }

    /**
     * 转换为日期格式
     */
    public static final String toDateFormat(long value) {
        return DateUtils.toStringDL(new Date(value));
    }

    /**
     * 获取回帖楼层数
     */
    public static final int findReplyNo(int page, int vcount) {
        return (page - 1) * ForumMngt.PAGE_SIZE + vcount;
    }

}
