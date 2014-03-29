/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.model;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.github.obullxl.lang.enums.ValveBoolEnum;
import com.google.common.collect.Lists;

/**
 * 帮助中心模型
 * 
 * @author obullxl@gmail.com
 * @version $Id: HelpCenterModel.java, V1.0.1 2014年3月20日 上午9:51:42 $
 */
public class HelpCenterModel extends AbstractModel implements Comparable<HelpCenterModel> {
    private static final long     serialVersionUID = -4971648487860798552L;

    /** 默认图标样式类 */
    public static final String    DEFAULT_CLAZZ    = "fa fa-circle";

    /** ID */
    private long                  id;

    /** 上级分类ID */
    private long                  catg;

    /** 是否显示标志 */
    private ValveBoolEnum         showEnum;

    /** 排序值 */
    private String                sort;

    /** 点赞次数 */
    private int                   acceptCount;

    /** 我踩次数 */
    private int                   rejectCount;

    /** 图标类 */
    private String                clazz;

    /** 标题 */
    private String                title;

    /** 内容 */
    private String                content;

    /** 上级节点 */
    private HelpCenterModel       parent;

    /** 下级节点 */
    private List<HelpCenterModel> children;

    /** 
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public int compareTo(HelpCenterModel other) {
        if (this.sort == null) {
            return -1;
        }

        if (other.getSort() == null) {
            return 1;
        }

        return this.sort.compareTo(other.getSort());
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

    public int getAcceptCount() {
        return acceptCount;
    }

    public void setAcceptCount(int acceptCount) {
        this.acceptCount = acceptCount;
    }

    public int getRejectCount() {
        return rejectCount;
    }

    public void setRejectCount(int rejectCount) {
        this.rejectCount = rejectCount;
    }

    public String getClazz() {
        if (StringUtils.isBlank(this.clazz)) {
            this.clazz = DEFAULT_CLAZZ;
        }

        return this.clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
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

    public HelpCenterModel getParent() {
        return parent;
    }

    public void setParent(HelpCenterModel parent) {
        this.parent = parent;
    }

    public List<HelpCenterModel> getChildren() {
        if (this.children == null) {
            this.children = Lists.newArrayList();
        }

        return children;
    }

    public void setChildren(List<HelpCenterModel> children) {
        this.children = children;
    }

}
