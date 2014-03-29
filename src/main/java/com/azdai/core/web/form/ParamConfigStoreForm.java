/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.web.form;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.github.obullxl.lang.web.form.AbstractForm;
import com.github.obullxl.lang.web.form.EnumBaseValidate;

/**
 * 参数配置表单
 * 
 * @author obullxl@gmail.com
 * @version $Id: ParamConfigStoreForm.java, V1.0.1 2014年3月29日 下午6:03:22 $
 */
public class ParamConfigStoreForm extends AbstractForm {
    private static final long  serialVersionUID = 3203043333465306956L;

    /** 参数KEY */
    @NotNull
    private String             name;

    /** 参数说明 */
    @NotNull
    private String             title;

    /** 参数值 */
    private String             value;

    /** 参数扩展值 */
    private String             valueExt;

    /** 
     * @see com.github.obullxl.lang.web.form.AbstractForm#enumBases(java.util.List)
     */
    public void enumBases(List<EnumBaseValidate> validates) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValueExt() {
        return valueExt;
    }

    public void setValueExt(String valueExt) {
        this.valueExt = valueExt;
    }

}
