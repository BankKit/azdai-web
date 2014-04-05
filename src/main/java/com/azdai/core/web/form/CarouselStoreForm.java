/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.web.form;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.azdai.core.model.enums.CarouselCatgEnum;
import com.github.obullxl.lang.enums.ValveBoolEnum;
import com.github.obullxl.lang.web.form.AbstractForm;
import com.github.obullxl.lang.web.form.EnumBaseValidate;

/**
 * 幻灯片图片存储表单
 * 
 * @author obullxl@gmail.com
 * @version $Id: CarouselStoreForm.java, V1.0.1 2014年4月5日 下午2:41:09 $
 */
public class CarouselStoreForm extends AbstractForm {
    private static final long serialVersionUID = 2148884421363920523L;

    /** 编号 */
    @NotNull
    @Size(min = 1, max = 16)
    private String            no;

    /** 分类 */
    @NotNull
    private String            catg;

    /** 显示 */
    @NotNull
    private String            show;

    /** 排序值 */
    @NotNull
    @Size(min = 1, max = 10)
    private String            sort;

    /** 标题 */
    @NotNull
    @Size(min = 3)
    private String            title;

    /** 图片 */
    @NotNull
    @Size(min = 3)
    private String            imgPath;

    /** 链接地址 */
    @NotNull
    @Size(min = 3)
    private String            linkUrl;

    /** 
     * @see com.github.obullxl.lang.web.form.AbstractForm#enumBases(java.util.List)
     */
    public void enumBases(List<EnumBaseValidate> validates) {
        validates.add(new EnumBaseValidate("catg", this.catg, CarouselCatgEnum.values()));
        validates.add(new EnumBaseValidate("show", this.show, ValveBoolEnum.values()));
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getCatg() {
        return catg;
    }

    public void setCatg(String catg) {
        this.catg = catg;
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
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

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

}
