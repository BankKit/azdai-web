/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.web.ctrl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.azdai.AZD;
import com.azdai.core.das.mngt.UploadMngt;
import com.azdai.core.model.UploadFileModel;
import com.azdai.core.model.enums.BizResponseEnum;
import com.azdai.core.model.enums.UploadFileCatgEnum;
import com.azdai.core.web.form.UploadFileQueryForm;
import com.azdai.core.web.form.UploadFileUploadForm;
import com.github.obullxl.lang.biz.BizResponse;
import com.github.obullxl.lang.user.UserContextHolder;
import com.github.obullxl.lang.utils.DateUtils;
import com.google.common.collect.Lists;

/**
 * 上传文件管理控制器
 * 
 * @author obullxl@gmail.com
 * @version $Id: UploadMngtController.java, V1.0.1 2014年3月14日 下午8:25:03 $
 */
@Controller
@RequestMapping("/mngt")
public class UploadMngtController extends AbstractController {

    /** 上传文件管理器 */
    @Autowired
    private UploadMngt uploadMngt;

    /**
     * 上传文件管理
     */
    @RequestMapping(value = "/upload-file/manage.htm")
    public String uploadFileManage(UploadFileQueryForm form) {
        try {
            this.setWebData("form", form);
            this.setWebData("uploadPageList", this.uploadMngt.findUploadFileFuzzy(form));
        } catch (Exception e) {
            logger.error("分页查询上传文件异常!", e);
        }

        return this.toMngtView("", "upload-file-manage");
    }

    /**
     * 删除上传文件
     */
    @ResponseBody
    @RequestMapping(value = "/upload-file/delete.htm", method = RequestMethod.POST)
    public BizResponse upladFileDeleteManage(@RequestParam("id") long id) {
        // 操作结果
        BizResponse response = this.newBizResponse(true);
        try {
            logger.warn("[帮助中心]-删除上传文件[{}].", id);

            // 删除文件
            UploadFileModel model = this.uploadMngt.find(id);
            if (model != null) {
                String root = AZD.findUploadPath();
                String fname = AZD.constructFileName(model.getName(), model.getExt());
                String file = root + "/" + model.getPath() + "/" + fname;
                FileUtils.forceDelete(new File(file));
                
                // 删除DB记录
                this.uploadMngt.remove(id);
            }

            response.getBizData().put(BizResponse.BIZ_ID_KEY, Long.toString(id));
        } catch (Exception e) {
            logger.error("删除上传文件异常!", e);
            this.buildResponse(response, BizResponseEnum.SYSTEM_ERROR);
        }

        // JSON返回
        return response;
    }

    /**
     * 上传本地文件
     */
    @RequestMapping(value = "/upload-file/upload.htm", method = RequestMethod.POST)
    public String uploadFileUpload(@Valid UploadFileUploadForm form, BindingResult errors) {
        String view = "upload-file-upload";

        List<String> msgs = Lists.newArrayList();
        this.setWebData("messages", msgs).setWebData("form", form);

        try {
            if (errors.hasErrors()) {
                msgs.add("参数输入不合法！");
                return view;
            }

            // 根目录
            String root = AZD.findUploadPath();
            if (StringUtils.isBlank(root)) {
                msgs.add("上传文件根目录不存在！");
                return view;
            }

            // 二级目录
            String rpath = "/" + DateUtils.toString(new Date(), "yyyyMM");
            FileUtils.forceMkdir(new File(root + rpath));

            // 文件上传
            UploadFileModel model = new UploadFileModel();
            model.setUserNo(UserContextHolder.get().getUserNo());
            model.setNickName(UserContextHolder.get().getUserNick());
            model.setCatgEnum(UploadFileCatgEnum.ADMIN);
            model.setPath(rpath);
            model.setTitle(form.getTitle());
            model.setMemo(form.getMemo());

            // 文件1
            MultipartFile file = form.getFile1();
            if (file == null || file.getSize() <= 0L) {
                msgs.add("文件1不合法，忽略上传！");
            } else {
                this.uploadFile(model, file, root + rpath);
                msgs.add("文件1上传成功，文件ID为: " + model.getId());
            }

            // 文件2
            file = form.getFile2();
            if (file == null || file.getSize() <= 0L) {
                msgs.add("文件2不合法，忽略上传！");
            } else {
                this.uploadFile(model, file, root + rpath);
                msgs.add("文件2上传成功，文件ID为: " + model.getId());
            }

            // 文件3
            file = form.getFile1();
            if (file == null || file.getSize() <= 0L) {
                msgs.add("文件3不合法，忽略上传！");
            } else {
                this.uploadFile(model, file, root + rpath);
                msgs.add("文件3上传成功，文件ID为: " + model.getId());
            }
        } catch (Exception e) {
            msgs.add("文件上传异常: " + e.getLocalizedMessage());
        }

        return this.toMngtView("", view);
    }

    /**
     * 上传单个文件
     */
    public void uploadFile(UploadFileModel model, MultipartFile file, String path) throws Exception {
        model.setLength(file.getSize());
        model.setFileType(file.getContentType());
        model.setSrcName(file.getOriginalFilename());
        model.setExt(FilenameUtils.getExtension(model.getSrcName()));

        this.uploadMngt.create(model);
        String name = Long.toString(model.getId());
        String filePath = path + "/" + AZD.constructFileName(name, model.getExt());

        // 文件上传
        InputStream input = null;
        OutputStream output = null;
        try {
            input = file.getInputStream();
            output = new FileOutputStream(filePath);
            IOUtils.copy(input, output);
        } finally {
            IOUtils.closeQuietly(output);
            IOUtils.closeQuietly(input);
        }

        // 更新文件名
        model.setName(name);
        this.uploadMngt.updateName(model);
    }

}
