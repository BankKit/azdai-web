/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.model.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * 
 * @author obullxl@gmail.com
 * @version $Id: DateUtils.java, V1.0.1 2014年4月4日 下午11:01:28 $
 */
public class DateUtils extends com.github.obullxl.lang.utils.DateUtils {

    /**
     * 截取日期
     */
    public static Date truncateDate(Date date) {
        return org.apache.commons.lang.time.DateUtils.truncate(date, Calendar.DAY_OF_MONTH);
    }
    
}
