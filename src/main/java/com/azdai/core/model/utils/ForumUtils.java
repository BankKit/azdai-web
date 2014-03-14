/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.model.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.azdai.core.model.enums.ForumUserRightEnum;

/**
 * 论坛权限工具类
 * 
 * @author obullxl@gmail.com
 * @version $Id: ForumRightUtils.java, V1.0.1 2014年3月14日 下午1:19:50 $
 */
public class ForumUtils {

    /**
     * 解析论坛权限
     */
    public static List<ForumUserRightEnum> parseRights(String rightExt) {
        List<ForumUserRightEnum> rgts = new ArrayList<ForumUserRightEnum>();

        if (StringUtils.isBlank(rightExt)) {
            return rgts;
        }

        // 去掉数组分割符
        rightExt = StringUtils.remove(rightExt, "[");
        rightExt = StringUtils.remove(rightExt, "]");

        String[] exts = StringUtils.split(rightExt, ",");
        for (String ext : exts) {
            ForumUserRightEnum rgt = ForumUserRightEnum.find(StringUtils.trim(ext));
            if (rgt != null) {
                rgts.add(rgt);
            }
        }

        return rgts;
    }

    /**
     * 格式化论坛权限
     */
    public static String formatRights(List<ForumUserRightEnum> rgts) {
        StringBuilder txt = new StringBuilder();
        txt.append("[");

        if (rgts != null) {
            Iterator<ForumUserRightEnum> iterator = rgts.iterator();
            while (iterator.hasNext()) {
                txt.append(iterator.next().code());

                if (iterator.hasNext()) {
                    txt.append(", ");
                }
            }
        }

        txt.append("]");
        return txt.toString();
    }

}
