/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.web.ctrl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.azdai.core.das.mngt.ForumMngt;
import com.azdai.core.model.ForumInfoModel;
import com.azdai.core.model.ForumTopicModel;
import com.azdai.core.model.ForumUserModel;
import com.azdai.core.model.convert.ForumTopicConvert;
import com.azdai.core.model.enums.BizResponseEnum;
import com.azdai.core.model.enums.ForumInfoOpenEnum;
import com.azdai.core.model.enums.ForumUserRightEnum;
import com.azdai.core.web.form.ForumInfoStoreForm;
import com.azdai.core.web.form.ForumTopicQueryForm;
import com.azdai.core.web.form.ForumTopicStoreForm;
import com.azdai.core.web.form.ForumUserStoreForm;
import com.github.obullxl.lang.biz.BizResponse;
import com.github.obullxl.lang.enums.ValveBoolEnum;

/**
 * 论坛管理控制器
 * 
 * @author obullxl@gmail.com
 * @version $Id: ForumMngtController.java, V1.0.1 2014年3月14日 下午8:25:03 $
 */
@Controller
@RequestMapping("/mngt")
public class ForumMngtController extends AbstractController {

    /** 论坛信息管理器 */
    @Autowired
    private ForumMngt forumMngt;

    /**
     * 新增论坛
     */
    @ResponseBody
    @RequestMapping(value = "/forum-info/create.htm", method = { RequestMethod.POST })
    public BizResponse createForumInfo(@Valid ForumInfoStoreForm form, BindingResult errors) {
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
            ForumInfoModel forum = new ForumInfoModel();

            forum.setCode(form.getCode());
            forum.setSort(form.getSort());
            forum.setStateEnum(ValveBoolEnum.findDefault(form.getState()));
            forum.setOpenEnum(ForumInfoOpenEnum.find(form.getOpen()));
            forum.setTitle(form.getTitle());
            forum.setSummary(form.getSummary());

            this.forumMngt.createForumInfo(forum);

            response.getBizData().put(BizResponse.BIZ_ID_KEY, form.getCode());
        } catch (Exception e) {
            logger.error("新增论坛信息异常!", e);
            this.buildResponse(response, BizResponseEnum.SYSTEM_ERROR);
        }

        // JSON返回
        return response;
    }

    /**
     * 更新论坛
     */
    @ResponseBody
    @RequestMapping(value = "/forum-info/update.htm", method = { RequestMethod.POST })
    public BizResponse updateForumInfo(@Valid ForumInfoStoreForm form, BindingResult errors) {
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
            ForumInfoModel forum = this.forumMngt.fetchForumInfo(form.getCode());
            forum.setSort(form.getSort());
            forum.setStateEnum(ValveBoolEnum.findDefault(form.getState()));
            forum.setOpenEnum(ForumInfoOpenEnum.find(form.getOpen()));
            forum.setTitle(form.getTitle());
            forum.setSummary(form.getSummary());

            this.forumMngt.updateForumInfo(forum);

            response.getBizData().put(BizResponse.BIZ_ID_KEY, form.getCode());
        } catch (Exception e) {
            logger.error("更新论坛信息异常!", e);
            this.buildResponse(response, BizResponseEnum.SYSTEM_ERROR);
        }

        // JSON返回
        return response;
    }

    /**
     * 新增论坛用户
     */
    @ResponseBody
    @RequestMapping(value = "/forum-user/create.htm", method = { RequestMethod.POST })
    public BizResponse createForumUser(@Valid ForumUserStoreForm form, BindingResult errors, @RequestParam("rights") String[] rights) {
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
            ForumUserModel fuser = new ForumUserModel();

            fuser.setForumCode(form.getForumCode());
            fuser.setForumTitle(form.getForumTitle());
            fuser.setUserNo(form.getUserNo());
            fuser.setNickName(form.getNickName());
            fuser.setGmtExpire(form.getGmtExpire());

            // 用户权限
            if (rights != null) {
                for (String right : rights) {
                    ForumUserRightEnum rgtEnum = ForumUserRightEnum.find(right);
                    if (rgtEnum != null) {
                        fuser.getRightEnums().add(rgtEnum);
                    }
                }
            }

            this.forumMngt.createForumUser(fuser);

            // 新增
            response.getBizData().put(BizResponse.BIZ_ID_KEY, form.getForumCode() + "-" + form.getUserNo());
        } catch (Exception e) {
            logger.error("新增论坛用户异常!", e);
            this.buildResponse(response, BizResponseEnum.SYSTEM_ERROR);
        }

        // JSON返回
        return response;
    }

    /**
     * 删除论坛
     */
    @ResponseBody
    @RequestMapping(value = "/forum-info/delete.htm", method = { RequestMethod.POST })
    public BizResponse deleteForumInfo(@RequestParam("code") String code) {
        // 操作结果
        BizResponse response = this.newBizResponse(true);
        try {
            logger.warn("[论坛]-删除论坛[{}].", code);

            this.forumMngt.removeForumInfo(code);

            response.getBizData().put(BizResponse.BIZ_ID_KEY, code);
        } catch (Exception e) {
            logger.error("删除论坛信息异常!", e);
            this.buildResponse(response, BizResponseEnum.SYSTEM_ERROR);
        }

        // JSON返回
        return response;
    }

    /**
     * 论坛主贴管理
     */
    @RequestMapping(value = "/forum-topic/manage.htm")
    public String forumTopicManage(ForumTopicQueryForm form) {
        try {
            this.setWebData("form", form).setWebData("topicPageList", this.forumMngt.findForumTopicFuzzy(form));
        } catch (Exception e) {
            logger.error("分页查询论坛主贴异常!", e);
        }

        return this.toMngtView("", "forum-topic-manage");
    }

    /**
     * 删除论坛主贴
     */
    @ResponseBody
    @RequestMapping(value = "/forum-topic/delete.htm", method = { RequestMethod.POST })
    public BizResponse deleteForumTopic(@RequestParam("id") long id) {
        // 操作结果
        BizResponse response = this.newBizResponse(true);
        try {
            logger.warn("[主贴]-删除主贴[{}].", id);

            this.forumMngt.removeForumTopic(id);

            response.getBizData().put(BizResponse.BIZ_ID_KEY, Long.toString(id));
        } catch (Exception e) {
            logger.error("删除论坛主贴异常!", e);
            this.buildResponse(response, BizResponseEnum.SYSTEM_ERROR);
        }

        // JSON返回
        return response;
    }

    /**
     * 更新论坛主贴
     */
    @ResponseBody
    @RequestMapping(value = "/forum-topic/update.htm", method = RequestMethod.POST)
    public BizResponse updateForumTopic(@Valid ForumTopicStoreForm form, BindingResult errors) {
        // 操作结果
        BizResponse response = this.newBizResponse(true);
        try {
            // 校验
            form.validateEnumBase(errors);

            if (errors.hasErrors()) {
                this.buildResponse(response, BizResponseEnum.INVALID_PARAM);
                return response;
            }
            
            long id = form.getId();
            ForumTopicModel model = this.forumMngt.findForumTopic(id);
            if(model == null) {
                this.buildResponse(response, "", "论坛主贴对象不存在！");
                return response;
            }
            
            ForumTopicConvert.merge(model, form);
            this.forumMngt.updateForumTopic(model);
            
            response.getBizData().put(BizResponse.BIZ_ID_KEY, Long.toString(id));
        } catch (Exception e) {
            logger.error("更新论坛主贴异常!", e);
            this.buildResponse(response, BizResponseEnum.SYSTEM_ERROR);
        }

        // JSON返回
        return response;
    }

}
