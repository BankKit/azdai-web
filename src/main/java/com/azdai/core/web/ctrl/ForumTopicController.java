/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.web.ctrl;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.azdai.core.das.dal.DBSize;
import com.azdai.core.das.mngt.ForumMngt;
import com.azdai.core.model.ForumInfoModel;
import com.azdai.core.model.ForumTopicModel;
import com.azdai.core.model.enums.BizResponseEnum;
import com.azdai.core.model.enums.ForumTopicCatgEnum;
import com.azdai.core.model.enums.ForumTopicReplyEnum;
import com.azdai.core.model.enums.ForumTopicStateEnum;
import com.azdai.core.model.enums.ForumTopicTopEnum;
import com.github.obullxl.lang.biz.BizResponse;
import com.github.obullxl.lang.enums.ValveBoolEnum;
import com.github.obullxl.lang.user.UserContext;
import com.github.obullxl.lang.user.UserContextHolder;
import com.github.obullxl.lang.user.UserContextUtils;
import com.github.obullxl.lang.utils.TextUtils;

/**
 * 论坛主贴（前台）
 * 
 * @author obullxl@gmail.com
 * @version $Id: ForumTopicController.java, V1.0.1 2014年3月16日 下午4:29:26 $
 */
@Controller
@RequestMapping("/forum")
public class ForumTopicController extends AbstractController {

    /** 论坛信息管理器 */
    @Autowired
    private ForumMngt forumMngt;

    /**
     * 发表论坛主贴
     */
    @ResponseBody
    @RequestMapping(value = "/forum-topic/create.htm", method = RequestMethod.POST)
    public BizResponse createForumTopic(String forum, String title, String content) {
        // 操作结果
        BizResponse response = this.newBizResponse(true);
        try {
            // 校验
            if (!UserContextUtils.isLogin()) {
                this.buildResponse(response, "PARAM", "只有会员才能发表主贴，请先登录！");
                return response;
            }

            if (StringUtils.isBlank(title)) {
                this.buildResponse(response, "PARAM", "主贴标题不能为空！");
                return response;
            }

            if (StringUtils.isBlank(content)) {
                this.buildResponse(response, "PARAM", "主贴内容不能为空！");
                return response;
            }

            ForumInfoModel forumInfo = this.forumMngt.fetchForumInfo(forum);
            if (forumInfo == null) {
                this.buildResponse(response, "PARAM", "论坛不存在，请刷新本页面重新发布主贴！");
                return response;
            }

            ForumTopicModel model = new ForumTopicModel();
            model.setCatgEnum(ForumTopicCatgEnum.TOPIC);
            model.setForum(forum);
            model.setStateEnum(ForumTopicStateEnum.ACTIVE);
            model.setTopEnum(ForumTopicTopEnum.NONE);
            model.setEliteEnum(ValveBoolEnum.FALSE);
            model.setReplyEnum(ForumTopicReplyEnum.OPEN);

            UserContext user = UserContextHolder.get();
            model.setPostUserNo(user.getUserNo());
            model.setPostNickName(user.getUserName());

            title = Jsoup.clean(title, Whitelist.relaxed());
            model.setTitle(TextUtils.truncate(title, DBSize.FORUM_TOPIC.TITLE_MAX));
            
            content = Jsoup.clean(content, Whitelist.relaxed());
            model.setContent(TextUtils.truncate(content, DBSize.FORUM_TOPIC.CONTENT_MAX));

            this.forumMngt.createForumTopic(model);

            response.getBizData().put(BizResponse.BIZ_ID_KEY, Long.toString(model.getId()));
        } catch (Exception e) {
            logger.error("发表论坛主贴信息异常!", e);
            this.buildResponse(response, BizResponseEnum.SYSTEM_ERROR);
        }

        // JSON返回
        return response;
    }
    
    /**
     * 发表论坛回贴
     */
    @ResponseBody
    @RequestMapping(value = "/topic-reply/create.htm", method = RequestMethod.POST)
    public BizResponse createTopicReply(String forum, long topic, String content) {
        // 操作结果
        BizResponse response = this.newBizResponse(true);
        try {
            // 校验
            if (!UserContextUtils.isLogin()) {
                this.buildResponse(response, "PARAM", "只有会员才能发表回贴，请先登录！");
                return response;
            }

            if (StringUtils.isBlank(content)) {
                this.buildResponse(response, "PARAM", "回贴内容不能为空！");
                return response;
            }

            // 创建回帖
            ForumTopicModel model = new ForumTopicModel();
            model.setCatgEnum(ForumTopicCatgEnum.REPLY);
            model.setForum(forum);
            model.setTopic(topic);
            
            UserContext user = UserContextHolder.get();
            model.setReplyUserNo(user.getUserNo());
            model.setReplyNickName(user.getUserName());

            content = Jsoup.clean(content, Whitelist.relaxed());
            model.setContent(TextUtils.truncate(content, DBSize.FORUM_TOPIC.CONTENT_MAX));

            this.forumMngt.createTopicReply(model);
            
            // 更新主贴
            model.setId(topic);
            this.forumMngt.updateTopicReply(model);

            response.getBizData().put(BizResponse.BIZ_ID_KEY, Long.toString(topic));
        } catch (Exception e) {
            logger.error("发表论坛主贴回贴信息异常!", e);
            this.buildResponse(response, BizResponseEnum.SYSTEM_ERROR);
        }

        // JSON返回
        return response;
    }

}
