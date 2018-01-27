package com.boot.portal.service.user.module.impl;/**
 * @description
 * @autor xbwu on 2017/8/12.
 */


import com.boot.portal.dao.module.user.UserRepo;
import com.boot.portal.entity.module.user.User;
import com.boot.portal.service.user.module.UserService;
import com.boot.portal.service.user.base.impl.BaseJPAServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务实现
 * @author xbwu
 * @create 2017-08-12 
 **/
@Service(value="userServiceImpl")
public class UserServiceImpl extends BaseJPAServiceImpl<User> implements UserService {

    @Autowired
    private UserRepo userRepo;

    public Page<User> findPageByUserAccount(String account, Pageable pageable){
        return userRepo.findPageByUserAccount(account,pageable);
    }

    public User findByUserAccount(String account){
        List<User> lists= userRepo.findByUserAccount(account);
        if(lists!=null && lists.size()>0){
            return lists.get(0);
        }
        return null;
    }
}
