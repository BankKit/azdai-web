/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.das.dal.query;

import java.io.Serializable;

import com.github.obullxl.lang.ToString;

/**
 * 会员信息查询对象
 * 
 * @author obullxl@gmail.com
 * @version $Id: UserInfoQuery.java, V1.0.1 2014年3月14日 上午11:51:57 $
 */
public class UploadFileQuery extends ToString implements Serializable {
    private static final long serialVersionUID = -3141064291259916002L;

    private int               offset;
    private int               pageSize;

    private Long              id;

    /** 上传用户编号 */
    private String            userNo;

    /** 上传分类 */
    private String            catg;

    /** 文件标题 */
    private String            title;

    /** 备注 */
    private String            memo;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
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
