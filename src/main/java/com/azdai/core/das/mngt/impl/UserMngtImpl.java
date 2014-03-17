/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.azdai.core.das.mngt.impl;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.azdai.core.das.dal.dao.UserInfoDAO;
import com.azdai.core.das.dal.dto.UserInfoDTO;
import com.azdai.core.das.mngt.UserMngt;
import com.azdai.core.model.UserInfoModel;
import com.azdai.core.model.convert.UserInfoConvert;
import com.github.obullxl.lang.utils.DateUtils;
import com.github.obullxl.lang.utils.LogUtils;
import com.github.obullxl.lang.utils.MD5Utils;
import com.github.obullxl.ticket.TicketService;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * 用户模型管理器
 * 
 * @author obullxl@gmail.com
 * @version $Id: UserMngtImpl.java, V1.0.1 2014年3月15日 下午6:37:55 $
 */
@Component("userMngt")
public class UserMngtImpl implements UserMngt {
    private static final Logger                 logger    = LogUtils.get();

    /** 用户信息DAO */
    @Autowired
    private UserInfoDAO                         userInfoDAO;

    /** 用户票据服务 */
    @Autowired
    private TicketService                       userTicketService;

    /** 用户缓存 */
    private LoadingCache<String, UserInfoModel> userCache = CacheBuilder.newBuilder() //
                                                              .maximumSize(10000).expireAfterWrite(24, TimeUnit.HOURS)//
                                                              .build(new CacheLoader<String, UserInfoModel>() { //
                                                                      public UserInfoModel load(String no) {
                                                                          UserInfoDTO src = userInfoDAO.findByNo(no);
                                                                          return UserInfoConvert.convert(src);
                                                                      }
                                                                  });

    /** 
     * @see com.azdai.core.das.mngt.UserMngt#findUserNo()
     */
    public String findUserNo() {
        try {
            long id = this.userTicketService.nextValue();
            String no = StringUtils.leftPad(Long.toString(id), 10, "0");
            return DateUtils.toStringDS(new Date()) + "00" + no;
        } catch (Exception e) {
            logger.error("[用户]-获取用户编号异常!", e);
            throw new RuntimeException("获取用户编号异常", e);
        }
    }

    /** 
     * @see com.azdai.core.das.mngt.UserMngt#findLoginPasswd(java.lang.String)
     */
    public String findLoginPasswd(String plain) {
        return MD5Utils.digest(plain);
    }

    /** 
     * @see com.azdai.core.das.mngt.UserMngt#findByNo(java.lang.String)
     */
    public UserInfoModel findByNo(String userNo) {
        try {
            return this.userCache.get(userNo);
        } catch (Exception e) {
            logger.error("[用户]-从缓存中获取用户[{}]异常!", userNo, e);
            return null;
        }
    }

    /** 
     * @see com.azdai.core.das.mngt.UserMngt#findByLoginName(java.lang.String)
     */
    public UserInfoModel findByLoginName(String name) {
        UserInfoDTO info = this.userInfoDAO.findByLoginName(name);
        return UserInfoConvert.convert(info);
    }

    /**
     * 获取用户信息
     */
    public UserInfoModel findByEmail(String email) {
        UserInfoDTO srcObj = this.userInfoDAO.findByEmail(email);
        return UserInfoConvert.convert(srcObj);
    }

    /**
     * 获取用户信息
     */
    public UserInfoModel findByNickName(String nickName) {
        UserInfoDTO srcObj = this.userInfoDAO.findByNickName(nickName);
        return UserInfoConvert.convert(srcObj);
    }

    /** 
     * @see com.azdai.core.das.mngt.UserMngt#createUserInfo(com.azdai.core.model.UserInfoModel)
     */
    public void createUserInfo(UserInfoModel user) {
        UserInfoDTO dstObj = UserInfoConvert.convert(user);
        this.userInfoDAO.insert(dstObj);
    }

}
