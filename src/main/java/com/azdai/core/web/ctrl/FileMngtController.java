/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.web.ctrl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.github.obullxl.lang.Consts;
import com.github.obullxl.lang.utils.DateUtils;
import com.google.common.collect.Lists;

/**
 * 远程文件控制器
 * 
 * @author obullxl@gmail.com
 * @version $Id: FileMngtController.java, V1.0.1 2014年1月15日 下午2:05:29 $
 */
@Controller
@RequestMapping("/mngt")
public class FileMngtController extends AbstractController {

    /**
     * 上传本地文件
     */
    @RequestMapping(value = "/remote-file/upload.htm", method = RequestMethod.POST)
    public String upload(String path, @RequestParam MultipartFile file) throws Exception {
        List<String> msgs = Lists.newArrayList();
        this.setWebData("messages", msgs);

        String view = "remote-file-manage";

        if (file == null || file.isEmpty()) {
            msgs.add("文件上传失败：请选择本地文件！");
            return this.toMngtView("", view);
        }

        path = FilenameUtils.normalize(StringUtils.trimToEmpty(path));
        File diskFile = new File(path);
        if (diskFile.exists()) {
            if (!diskFile.isFile()) {
                msgs.add("文件上传失败：目标目录已经存在，且不是文件！");
                return this.toMngtView("", view);
            }

            // 重命名
            String newPath = path + "." + DateUtils.toString(new Date(), "yyyyMMddHHmmssSSS");
            InputStream input = null;
            OutputStream output = null;
            try {
                input = new FileInputStream(path);
                output = new FileOutputStream(newPath);
                IOUtils.copy(input, output);
            } catch (Exception e) {
                IOUtils.closeQuietly(output);
                IOUtils.closeQuietly(input);
            }

            // 删除
            FileUtils.deleteQuietly(new File(path));

            msgs.add("文件上传提示：原文件已经存在，重命名为[" + newPath + "].");
        }
        
        // 创建目录
        FileUtils.forceMkdir(diskFile.getParentFile());

        // 文件上传
        InputStream input = null;
        OutputStream output = null;
        try {
            input = file.getInputStream();
            output = new FileOutputStream(path);
            IOUtils.copy(input, output);
            //file.transferTo(new File(path));
            msgs.add("文件上传成功：文件路径[" + path + "].");
        } finally {
            IOUtils.closeQuietly(output);
            IOUtils.closeQuietly(input);
        }

        return this.toMngtView("", view);
    }

    /**
     * 远程文件下载
     */
    @RequestMapping(value = "/remote-file/fetch.htm", method = RequestMethod.POST)
    public void download(HttpServletResponse response, String file) throws Exception {
        File diskFile = new File(FilenameUtils.normalize(StringUtils.trimToEmpty(file)));
        if (diskFile == null || !diskFile.exists()) {
            throw new RuntimeException("[文件提取]-文件[" + file + "]不存在或不是文件类型！");
        }

        String fileName = URLEncoder.encode(StringUtils.trimToEmpty(diskFile.getName()), Consts.ENCODING);
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
        response.addHeader("Content-Length", Long.toString(diskFile.length()));
        response.setContentType("application/octet-stream; charset=" + Consts.ENCODING);

        InputStream input = null;
        OutputStream output = null;
        try {
            input = new BufferedInputStream(new FileInputStream(diskFile));
            output = new BufferedOutputStream(response.getOutputStream());
            IOUtils.copy(input, output);
        } finally {
            IOUtils.closeQuietly(output);
            IOUtils.closeQuietly(input);
        }
    }

}
