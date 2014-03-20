/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.model;

/**
 * 角色信息模型
 * 
 * @author obullxl@gmail.com
 * @version $Id: RoleInfoModel.java, V1.0.1 2014年3月20日 下午2:16:53 $
 */
public class RoleInfoModel extends AbstractModel {
    private static final long serialVersionUID = 1012390778544896699L;

    /** ID */
    private long              id;

    /** 标题 */
    private String            title;

    /** 描述 */
    private String            memo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
