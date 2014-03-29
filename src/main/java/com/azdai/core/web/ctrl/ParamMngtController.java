/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.web.ctrl;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.azdai.core.model.convert.ParamConfigConvert;
import com.azdai.core.model.enums.BizResponseEnum;
import com.azdai.core.web.form.ParamConfigStoreForm;
import com.azdai.core.web.webx.ParamWebX;
import com.github.obullxl.lang.biz.BizResponse;
import com.github.obullxl.model.cfg.CfgModel;
import com.github.obullxl.model.cfg.CfgUtils;
import com.github.obullxl.model.cfg.service.CfgService;

/**
 * 系统参数管理
 * 
 * @author obullxl@gmail.com
 * @version $Id: ParamMngtController.java, V1.0.1 2014年3月29日 下午5:59:28 $
 */
@Controller
@RequestMapping("/mngt")
public class ParamMngtController extends AbstractController {

    /** 系统参数服务 */
    @Autowired
    private CfgService paramService;

    /**
     * 新增/更新参数配置
     */
    @ResponseBody
    @RequestMapping(value = "/param-config/store.htm", method = RequestMethod.POST)
    public BizResponse createParamConfig(@Valid ParamConfigStoreForm form, BindingResult errors) {
        // 操作结果
        BizResponse response = this.newBizResponse(true);
        try {
            // 校验
            form.validateEnumBase(errors);

            if (errors.hasErrors()) {
                this.buildResponse(response, BizResponseEnum.INVALID_PARAM);
                return response;
            }

            CfgModel model = ParamConfigConvert.convert(form);
            CfgModel exist = CfgUtils.find(model.getCatg(), model.getName());
            if (exist != null) {
                // 更新
                model.setGmtCreate(exist.getGmtCreate());
                model.setGmtModify(new Date());
                this.paramService.update(model);
            } else {
                // 新建
                this.paramService.create(model);
            }

            response.getBizData().put(BizResponse.BIZ_ID_KEY, form.getName());
        } catch (Exception e) {
            logger.error("新增/更新系统参数配置异常!", e);
            this.buildResponse(response, BizResponseEnum.SYSTEM_ERROR);
        }

        // JSON返回
        return response;
    }

    /**
     * 删除参数配置
     */
    @ResponseBody
    @RequestMapping(value = "/param-config/delete.htm", method = RequestMethod.POST)
    public BizResponse deleteHelpCenter(@RequestParam("name") String name) {
        // 操作结果
        BizResponse response = this.newBizResponse(true);
        try {
            logger.warn("[参数配置]-删除参数配置[{}].", name);

            // 删除
            this.paramService.remove(ParamWebX.CATG, name);

            response.getBizData().put(BizResponse.BIZ_ID_KEY, name);
        } catch (Exception e) {
            logger.error("删除参数配置异常!", e);
            this.buildResponse(response, BizResponseEnum.SYSTEM_ERROR);
        }

        // JSON返回
        return response;
    }

}
