/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.model;

import java.util.List;

import com.github.obullxl.lang.Paginator;
import com.github.obullxl.lang.biz.BizPageList;

/**
 * 上传文件分页列表
 * 
 * @author obullxl@gmail.com
 * @version $Id: UploadFilePageList.java, V1.0.1 2014年3月15日 下午3:02:25 $
 */
public class UploadFilePageList extends BizPageList<UploadFileModel> {
    private static final long serialVersionUID = 3287483661237026243L;

    /**
     * CTOR
     */
    public UploadFilePageList(Paginator pager, List<UploadFileModel> items) {
        super(pager, items);
    }

}
