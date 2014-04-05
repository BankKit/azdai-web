/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.das.mngt.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.azdai.AZD;
import com.azdai.core.das.dal.dao.UploadFileDAO;
import com.azdai.core.das.dal.dto.UploadFileDTO;
import com.azdai.core.das.dal.query.UploadFileQuery;
import com.azdai.core.das.mngt.UploadMngt;
import com.azdai.core.model.UploadFileModel;
import com.azdai.core.model.UploadFilePageList;
import com.azdai.core.model.convert.UploadFileConvert;
import com.azdai.core.web.form.UploadFileQueryForm;
import com.github.obullxl.lang.Paginator;

/**
 * 文件上传管理器
 * 
 * @author obullxl@gmail.com
 * @version $Id: UploadMngtImpl.java, V1.0.1 2014年4月5日 下午7:08:33 $
 */
@Component("uploadMngt")
public class UploadMngtImpl implements UploadMngt {

    /** 文件上传DAO */
    @Autowired
    private UploadFileDAO uploadFileDAO;

    /** 
     * @see com.azdai.core.das.mngt.UploadMngt#create(com.azdai.core.model.UploadFileModel)
     */
    public void create(UploadFileModel model) {
        UploadFileDTO upload = UploadFileConvert.convert(model);
        long id = this.uploadFileDAO.insert(upload);
        model.setId(id);
    }

    /** 
     * @see com.azdai.core.das.mngt.UploadMngt#update(com.azdai.core.model.UploadFileModel)
     */
    public int update(UploadFileModel model) {
        UploadFileDTO upload = UploadFileConvert.convert(model);
        return this.uploadFileDAO.update(upload);
    }
    
    /** 
     * @see com.azdai.core.das.mngt.UploadMngt#updateName(com.azdai.core.model.UploadFileModel)
     */
    public int updateName(UploadFileModel model) {
        UploadFileDTO upload = UploadFileConvert.convert(model);
        return this.uploadFileDAO.updateName(upload);
    }

    /** 
     * @see com.azdai.core.das.mngt.UploadMngt#remove(long)
     */
    public int remove(long id) {
        return this.uploadFileDAO.delete(id);
    }

    /** 
     * @see com.azdai.core.das.mngt.UploadMngt#removeByUser(java.lang.String)
     */
    public int removeByUser(String userNo) {
        return this.uploadFileDAO.deleteByUser(userNo);
    }
    
    /** 
     * @see com.azdai.core.das.mngt.UploadMngt#find(long)
     */
    public UploadFileModel find(long id) {
        UploadFileDTO srcObj = this.uploadFileDAO.find(id);
        return UploadFileConvert.convert(srcObj);
    }

    /** 
     * @see com.azdai.core.das.mngt.UploadMngt#findUploadFileFuzzy(com.azdai.core.web.form.UploadFileQueryForm)
     */
    public UploadFilePageList findUploadFileFuzzy(UploadFileQueryForm form) {
        UploadFileQuery query = UploadFileConvert.convert(form);
        UploadFilePageList pageList = null;

        int count = (int) this.uploadFileDAO.findFuzzyCount(query);
        Paginator paginator = new Paginator(AZD.PAGE_SIZE_MNGT, count);
        paginator.setPageNo(form.getPageNo());

        if (count > 0) {
            query.setOffset(paginator.getOffset());
            query.setPageSize(AZD.PAGE_SIZE_MNGT);

            List<UploadFileDTO> list = this.uploadFileDAO.findFuzzy(query);
            pageList = new UploadFilePageList(paginator, UploadFileConvert.convert(list));
        } else {
            // 没有记录
            pageList = new UploadFilePageList(paginator, new ArrayList<UploadFileModel>());
        }

        return pageList;
    }

}
