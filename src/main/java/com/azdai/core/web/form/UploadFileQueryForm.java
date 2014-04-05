/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.web.form;

import java.util.List;

import javax.validation.constraints.Size;

import com.azdai.core.das.dal.DBSize;
import com.github.obullxl.lang.web.form.AbstractForm;
import com.github.obullxl.lang.web.form.EnumBaseValidate;

/**
 * 上传文件查询表单
 * 
 * @author obullxl@gmail.com
 * @version $Id: UploadFileQueryForm.java, V1.0.1 2014年4月5日 下午7:13:40 $
 */
public class UploadFileQueryForm extends AbstractForm {
    private static final long serialVersionUID = -4777104075840480191L;

    private int               pageNo;

    /** ID */
    private Long              id;

    /** 上传用户编号 */
    @Size(max = DBSize.UPLOAD_FILE.USER_NO_MAX)
    private String            userNo;

    /** 上传分类 */
    @Size(max = DBSize.UPLOAD_FILE.CATG_MAX)
    private String            catg;

    /** 文件标题 */
    @Size(max = DBSize.UPLOAD_FILE.TITLE_MAX)
    private String            title;

    /** 备注 */
    @Size(max = DBSize.UPLOAD_FILE.MEMO_MAX)
    private String            memo;

    /** 
     * @see com.github.obullxl.lang.web.form.AbstractForm#enumBases(java.util.List)
     */
    public void enumBases(List<EnumBaseValidate> validates) {
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getCatg() {
        return catg;
    }

    public void setCatg(String catg) {
        this.catg = catg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

}
