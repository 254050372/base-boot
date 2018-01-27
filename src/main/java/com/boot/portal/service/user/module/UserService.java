package com.boot.portal.service.user.module;/**
 * @description
 * @autor xbwu on 2017/8/12.
 */

import com.boot.portal.entity.module.user.User;
import com.boot.portal.service.user.base.BaseJPAService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 用户服务
 * @author xbwu
 * @create 2017-08-12 
 **/
public interface UserService extends BaseJPAService<User> {

    Page<User> findPageByUserAccount(String account, Pageable pageable);

    User findByUserAccount(String account);
}
