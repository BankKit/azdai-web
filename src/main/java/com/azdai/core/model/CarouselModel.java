/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.model;

import com.azdai.core.model.enums.CarouselCatgEnum;
import com.github.obullxl.lang.ToString;
import com.github.obullxl.lang.enums.ValveBoolEnum;

/**
 * 系统首页图片模型
 * 
 * @author obullxl@gmail.com
 * @version $Id: CarouselModel.java, V1.0.1 2014年4月5日 下午2:15:46 $
 */
public class CarouselModel extends ToString implements Comparable<CarouselModel> {
    private static final long serialVersionUID = 4079312905672509646L;

    /** 编号 */
    private String            no;

    /** 分类 */
    private CarouselCatgEnum  catgEnum;

    /** 显示 */
    private ValveBoolEnum     showEnum;

    /** 排序值 */
    private String            sort;

    /** 标题 */
    private String            title;

    /** 图片 */
    private String            imgPath;

    /** 链接地址 */
    private String            linkUrl;

    /** 
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public int compareTo(CarouselModel other) {
        if (this.sort == null) {
            return -1;
        }

        if (other.getSort() == null) {
            return 1;
        }

        return this.sort.compareTo(other.getSort());
    }

    // ~~~~~~~~~~~~~~~ getters and setters ~~~~~~~~~~~~~~ //

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public CarouselCatgEnum getCatgEnum() {
        return catgEnum;
    }

    public void setCatgEnum(CarouselCatgEnum catgEnum) {
        this.catgEnum = catgEnum;
    }

    public ValveBoolEnum getShowEnum() {
        return showEnum;
    }

    public void setShowEnum(ValveBoolEnum showEnum) {
        this.showEnum = showEnum;
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
