/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2013 All Rights Reserved.
 */
package com.azdai.core.web.form;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.azdai.core.das.dal.DBSize;
import com.azdai.core.model.enums.ForumInfoOpenEnum;
import com.github.obullxl.lang.enums.ValveBoolEnum;
import com.github.obullxl.lang.web.form.AbstractForm;
import com.github.obullxl.lang.web.form.EnumBaseValidate;

/**
 * 更新/创建论坛信息存储表单
 * 
 * @author obullxl@gmail.com
 * @version $Id: ForumInfoStoreForm.java, V1.0.1 2013年12月29日 上午11:07:31 $
 */
public class ForumInfoStoreForm extends AbstractForm {
    private static final long serialVersionUID = 4246838516504646955L;

    @NotNull
    @Size(max = DBSize.FORUM_INFO.CODE_MAX)
    private String            code;

    @NotNull
    @Size(min = 4, max = 4)
    private String            sort;

    @NotNull
    @Size(min = 1, max = DBSize.FORUM_INFO.STATE_MAX)
    private String            state;

    @NotNull
    @Size(min = 1, max = DBSize.FORUM_INFO.OPEN_EXT_MAX)
    private String            open;

    @NotNull
    @Size(min = 1, max = DBSize.FORUM_INFO.TITLE_MAX)
    private String            title;

    @NotNull
    @Size(min = 1, max = DBSize.FORUM_INFO.SUMMARY_MAX)
    private String            summary;

    /** 
     * @see com.github.obullxl.jeesite.web.form.AbstractForm#enumBases(java.util.List)
     */
    public void enumBases(List<EnumBaseValidate> validates) {
        validates.add(new EnumBaseValidate("state", this.state, ValveBoolEnum.values()));
        validates.add(new EnumBaseValidate("open", this.open, ForumInfoOpenEnum.values()));
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

}
