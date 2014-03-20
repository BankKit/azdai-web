/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.web.form;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.azdai.core.das.dal.DBSize;
import com.github.obullxl.lang.enums.ValveBoolEnum;
import com.github.obullxl.lang.web.form.AbstractForm;
import com.github.obullxl.lang.web.form.EnumBaseValidate;

/**
 * 帮助中心数据存储表单
 * 
 * @author obullxl@gmail.com
 * @version $Id: HelpCenterStoreForm.java, V1.0.1 2014年3月20日 上午10:29:34 $
 */
public class HelpCenterStoreForm extends AbstractForm {
    private static final long serialVersionUID = -5450757961135547429L;

    /** ID */
    private long              id;

    /** 上级分类ID */
    private long              catg;

    /** 是否显示标志 */
    @NotNull
    @Size(min = 1, max = DBSize.HELP_CENTER.SHOW_FLAG_MAX)
    private String            showFlag;

    /** 排序值 */
    @NotNull
    @Size(min = 1, max = DBSize.HELP_CENTER.SORT_MAX)
    private String            sort;

    /** 标题 */
    @NotNull
    @Size(min = 3, max = DBSize.HELP_CENTER.TITLE_MAX)
    private String            title;

    /** 内容 */
    @NotNull
    @Size(min = 10, max = DBSize.HELP_CENTER.CONTENT_MAX)
    private String            content;

    /** 
     * @see com.github.obullxl.lang.web.form.AbstractForm#enumBases(java.util.List)
     */
    public void enumBases(List<EnumBaseValidate> validates) {
        validates.add(new EnumBaseValidate("showFlag", this.showFlag, ValveBoolEnum.values()));
    }

    // ~~~~~~~~~~~~~~~~ getters and setters ~~~~~~~~~~~~~~~~~ //

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCatg() {
        return catg;
    }

    public void setCatg(long catg) {
        this.catg = catg;
    }

    public String getShowFlag() {
        return showFlag;
    }

    public void setShowFlag(String showFlag) {
        this.showFlag = showFlag;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
