/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.das.mngt;

import com.azdai.core.model.UploadFileModel;
import com.azdai.core.model.UploadFilePageList;
import com.azdai.core.web.form.UploadFileQueryForm;

/**
 * 上传文件管理器
 * 
 * @author obullxl@gmail.com
 * @version $Id: UploadMngt.java, V1.0.1 2014年4月5日 下午7:08:04 $
 */
public interface UploadMngt {

    /**
     * 新建上传记录
     */
    public void create(UploadFileModel model);

    /**
     * 更新上传记录
     */
    public int update(UploadFileModel model);

    /**
     * 更新上传文件名
     */
    public int updateName(UploadFileModel model);

    /**
     * 删除上传记录
     */
    public int remove(long id);

    /**
     * 删除上传记录
     */
    public int removeByUser(String userNo);

    /**
     * 查询单条记录
     */
    public UploadFileModel find(long id);

    /**
     * 模糊分页查询
     */
    public UploadFilePageList findUploadFileFuzzy(UploadFileQueryForm form);

}
