/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.web.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import com.azdai.core.das.dal.DBSize;
import com.github.obullxl.lang.ToString;

/**
 * 上传文件表单
 * 
 * @author obullxl@gmail.com
 * @version $Id: UploadFileUploadForm.java, V1.0.1 2014年4月5日 下午8:07:39 $
 */
public class UploadFileUploadForm extends ToString {
    private static final long serialVersionUID = 7051979548856111500L;

    /** 标题 */
    @NotNull
    @Size(max = DBSize.UPLOAD_FILE.TITLE_MAX)
    private String            title;

    /** 备注 */
    @Size(max = DBSize.UPLOAD_FILE.MEMO_MAX)
    private String            memo;

    /** 上传文件 */
    private MultipartFile     file1;
    private MultipartFile     file2;
    private MultipartFile     file3;

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

    public MultipartFile getFile1() {
        return file1;
    }

    public void setFile1(MultipartFile file1) {
        this.file1 = file1;
    }

    public MultipartFile getFile2() {
        return file2;
    }

    public void setFile2(MultipartFile file2) {
        this.file2 = file2;
    }

    public MultipartFile getFile3() {
        return file3;
    }

    public void setFile3(MultipartFile file3) {
        this.file3 = file3;
    }

}
