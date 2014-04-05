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

import com.azdai.AZD;
import com.azdai.core.model.CarouselModel;
import com.azdai.core.model.convert.ParamConfigConvert;
import com.azdai.core.model.enums.BizResponseEnum;
import com.azdai.core.web.form.CarouselStoreForm;
import com.github.obullxl.lang.biz.BizResponse;
import com.github.obullxl.model.cfg.CfgModel;
import com.github.obullxl.model.cfg.CfgUtils;
import com.github.obullxl.model.cfg.service.CfgService;

/**
 * 幻灯片图片管理
 * 
 * @author obullxl@gmail.com
 * @version $Id: CarouselMngtController.java, V1.0.1 2014年3月29日 下午5:59:28 $
 */
@Controller
@RequestMapping("/mngt")
public class CarouselMngtController extends AbstractController {

    /** 幻灯片图片服务 */
    @Autowired
    private CfgService paramService;

    /**
     * 新增/更新幻灯片图片
     */
    @ResponseBody
    @RequestMapping(value = "/carousel/store.htm", method = RequestMethod.POST)
    public BizResponse createCarousel(@Valid CarouselStoreForm form, BindingResult errors) {
        // 操作结果
        BizResponse response = this.newBizResponse(true);
        try {
            // 校验
            form.validateEnumBase(errors);

            if (errors.hasErrors()) {
                this.buildResponse(response, BizResponseEnum.INVALID_PARAM);
                return response;
            }

            CarouselModel carousel = ParamConfigConvert.carousel(form);
            CfgModel model = ParamConfigConvert.convert(carousel);
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

            response.getBizData().put(BizResponse.BIZ_ID_KEY, form.getNo());
        } catch (Exception e) {
            logger.error("新增/更新幻灯片图片配置异常!", e);
            this.buildResponse(response, BizResponseEnum.SYSTEM_ERROR);
        }

        // JSON返回
        return response;
    }

    /**
     * 删除幻灯片图片
     */
    @ResponseBody
    @RequestMapping(value = "/carousel/delete.htm", method = RequestMethod.POST)
    public BizResponse deleteCarousel(@RequestParam("no") String no) {
        // 操作结果
        BizResponse response = this.newBizResponse(true);
        try {
            logger.warn("[参数配置]-删除幻灯片图片[{}].", no);

            // 删除
            this.paramService.remove(AZD.CFG_CAROUSEL, no);

            response.getBizData().put(BizResponse.BIZ_ID_KEY, no);
        } catch (Exception e) {
            logger.error("删除幻灯片图片异常!", e);
            this.buildResponse(response, BizResponseEnum.SYSTEM_ERROR);
        }

        // JSON返回
        return response;
    }

}
