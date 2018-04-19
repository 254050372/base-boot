package com.boot.portal.web.service.impl;/**
 * @description
 * @autor xbwu on 2017/8/12.
 */


import com.boot.portal.core.service.impl.BaseJPAServiceImpl;
import com.boot.portal.web.dao.UserInfoRepo;
import com.boot.portal.web.entity.UserInfo;
import com.boot.portal.web.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户服务实现
 * @author xbwu
 * @create 2017-08-12 
 **/
@Service
public class UserInfoServiceImpl extends BaseJPAServiceImpl<UserInfo> implements UserInfoService {

    @Autowired
    private UserInfoRepo userInfoRepo;

}
