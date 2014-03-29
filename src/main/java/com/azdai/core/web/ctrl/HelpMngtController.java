/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.web.ctrl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.azdai.core.das.mngt.HelpMngt;
import com.azdai.core.model.HelpCenterModel;
import com.azdai.core.model.convert.HelpCenterConvert;
import com.azdai.core.model.enums.BizResponseEnum;
import com.azdai.core.web.form.HelpCenterStoreForm;
import com.github.obullxl.lang.biz.BizResponse;

/**
 * 帮助中心管理控制器
 * 
 * @author obullxl@gmail.com
 * @version $Id: HelpMngtController.java, V1.0.1 2014年3月14日 下午8:25:03 $
 */
@Controller
@RequestMapping("/mngt")
public class HelpMngtController extends AbstractController {

    /** 帮助中心管理器 */
    @Autowired
    private HelpMngt helpMngt;

    /**
     * 新增帮助中心
     */
    @ResponseBody
    @RequestMapping(value = "/help-center/create.htm", method = RequestMethod.POST)
    public BizResponse createHelpCenter(@Valid HelpCenterStoreForm form, BindingResult errors) {
        // 操作结果
        BizResponse response = this.newBizResponse(true);
        try {
            // 校验
            form.validateEnumBase(errors);

            if (errors.hasErrors()) {
                this.buildResponse(response, BizResponseEnum.INVALID_PARAM);
                return response;
            }

            // 新建
            HelpCenterModel help = HelpCenterConvert.convert(form);
            this.helpMngt.create(help);

            response.getBizData().put(BizResponse.BIZ_ID_KEY, Long.toString(form.getId()));
        } catch (Exception e) {
            logger.error("新增帮助中心异常!", e);
            this.buildResponse(response, BizResponseEnum.SYSTEM_ERROR);
        }

        // JSON返回
        return response;
    }

    /**
     * 更新帮助中心
     */
    @ResponseBody
    @RequestMapping(value = "/help-center/update.htm", method = RequestMethod.POST)
    public BizResponse updateHelpCenter(@Valid HelpCenterStoreForm form, BindingResult errors) {
        // 操作结果
        BizResponse response = this.newBizResponse(true);
        try {
            // 校验
            form.validateEnumBase(errors);

            if (errors.hasErrors()) {
                this.buildResponse(response, BizResponseEnum.INVALID_PARAM);
                return response;
            }

            // 更新
            HelpCenterModel help = this.helpMngt.fetch(form.getId());
            HelpCenterConvert.merge(form, help);

            this.helpMngt.update(help);

            response.getBizData().put(BizResponse.BIZ_ID_KEY, Long.toString(form.getId()));
        } catch (Exception e) {
            logger.error("更新帮助中心异常!", e);
            this.buildResponse(response, BizResponseEnum.SYSTEM_ERROR);
        }

        // JSON返回
        return response;
    }

    /**
     * 删除帮助中心
     */
    @ResponseBody
    @RequestMapping(value = "/help-center/delete.htm", method = RequestMethod.POST)
    public BizResponse deleteHelpCenter(@RequestParam("id") long id) {
        // 操作结果
        BizResponse response = this.newBizResponse(true);
        try {
            logger.warn("[帮助中心]-删除帮助中心[{}].", id);

            List<HelpCenterModel> children = this.helpMngt.fetchChildren(id);
            if (!children.isEmpty()) {
                this.buildResponse(response, "OBJECTS", "节点非儿子节点，禁止删除！");
                return response;
            }

            // 删除
            this.helpMngt.remove(id);

            response.getBizData().put(BizResponse.BIZ_ID_KEY, Long.toString(id));
        } catch (Exception e) {
            logger.error("删除帮助中心异常!", e);
            this.buildResponse(response, BizResponseEnum.SYSTEM_ERROR);
        }

        // JSON返回
        return response;
    }

}
