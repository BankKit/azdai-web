/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.github.obullxl.jeesite.web.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

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

/**
 * APP管理
 * 
 * @author obullxl@gmail.com
 * @version $Id: AppMngtController.java, V1.0.1 2014年3月4日 下午12:11:36 $
 */
@Controller
public class AppMngtController extends AbstractController {

    /**
     * APP列表
     */
    @RequestMapping(value = "/app.htm", method = RequestMethod.GET)
    public String apps() throws Exception {
        String path = this.findAppPath();
        if (StringUtils.isNotBlank(path)) {
            File apps = new File(path);
            super.setWebData("apps", apps.listFiles());
        }

        return this.toFrontView("app");
    }

    /**
     * APP上传
     */
    @RequestMapping(value = "/app-upload.htm", method = RequestMethod.POST)
    public String upload(@RequestParam MultipartFile app) throws Exception {
        String path = this.findAppPath();

        if (StringUtils.isNotBlank(path)) {
            app.transferTo(new File(path + "/" + app.getOriginalFilename()));
        }

        return this.redirectTo("/app.htm");
    }

    /**
     * APP下载
     */
    @RequestMapping(value = "/app-download.htm", method = RequestMethod.GET)
    public void download(HttpServletResponse response, String name) throws Exception {
        File diskFile = new File(FilenameUtils.normalize(this.findAppPath() + "/" + name));
        if (diskFile == null || !diskFile.exists()) {
            throw new RuntimeException("[文件提取]-文件[" + name + "]不存在或不是文件类型！");
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

    /**
     * APP删除
     */
    @RequestMapping(value = "/app-delete.htm")
    public String delete(String name) throws Exception {
        File file = new File(FilenameUtils.normalize(this.findAppPath() + "/" + name));
        FileUtils.deleteQuietly(file);

        return this.redirectTo("/app.htm");
    }

    /**
     * 获取APP目录
     */
    private String findAppPath() throws Exception {
        String path = this.findServletRealPath("/upload");

        if (StringUtils.isBlank(path)) {
            path = System.getenv("OPENSHIFT_DATA_DIR");
        }

        path = FilenameUtils.normalizeNoEndSeparator(path);

        if (StringUtils.isNotBlank(path)) {
            path = FilenameUtils.normalize(path + "/apps");
            FileUtils.forceMkdir(new File(path));
        }

        return path;
    }

}
