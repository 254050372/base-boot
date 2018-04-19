package com.boot.portal.web.service;/**
 * @description
 * @autor xbwu on 2017/8/12.
 */

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.boot.portal.web.entity.User;
import com.boot.portal.core.service.BaseJPAService;

/**
 * 用户服务
 * @author xbwu
 * @create 2017-08-12 
 **/
public interface UserService extends BaseJPAService<User> {

    Page<User> findPageByUserAccount(String account, Pageable pageable);

    User findByUserAccount(String account);
}
