/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.model;

import com.azdai.core.model.enums.UploadFileCatgEnum;

/**
 * 上传文件模型
 * 
 * @author obullxl@gmail.com
 * @version $Id: UploadFileModel.java, V1.0.1 2014年4月5日 下午7:00:30 $
 */
public class UploadFileModel extends AbstractModel {
    private static final long  serialVersionUID = -3064465415986337983L;

    /** ID */
    private long               id;

    /** 上传用户编号 */
    private String             userNo;

    /** 上传用户昵称 */
    private String             nickName;

    /** 上传分类 */
    private UploadFileCatgEnum catgEnum;

    /** 文件类型 */
    private String             fileType;

    /** 文件标题 */
    private String             title;

    /** 文件大小 */
    private long               length;

    /** 文件路径 */
    private String             path;

    /** 文件名 */
    private String             name;

    /** 文件后缀 */
    private String             ext;

    /** 源文件名 */
    private String             srcName;

    /** 备注 */
    private String             memo;

    // ~~~~~~~~~~~ getters and setters ~~~~~~~~~~~ //

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public UploadFileCatgEnum getCatgEnum() {
        return catgEnum;
    }

    public void setCatgEnum(UploadFileCatgEnum catgEnum) {
        this.catgEnum = catgEnum;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getSrcName() {
        return srcName;
    }

    public void setSrcName(String srcName) {
        this.srcName = srcName;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

}
