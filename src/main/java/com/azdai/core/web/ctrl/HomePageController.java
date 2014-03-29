/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2013 All Rights Reserved.
 */
package com.azdai.core.web.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 主页控制器
 * 
 * @author obullxl@gmail.com
 * @version $Id: HomePageController.java, V1.0.1 2013年12月4日 上午9:44:12 $
 */
@Controller
public class HomePageController extends AbstractController {

    /**
     * 前台首页
     */
    @RequestMapping("/")
    public String index() {
        return this.indexHtml();
    }

    @RequestMapping("/default.htm")
    public String defaultHtm() {
        return this.indexHtml();
    }
    
    @RequestMapping("/default.html")
    public String defaultHtml() {
        return this.indexHtml();
    }
    
    @RequestMapping("/index.htm")
    public String indexHtm() {
        return this.indexHtml();
    }
    
    @RequestMapping("/index.html")
    public String indexHtml() {
        return this.toHomeView("index");
    }

}
