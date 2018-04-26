package com.boot.portal.web.controller;/**
 * @description
 * @autor xbwu on 2017/8/9.
 */

import com.boot.portal.core.controller.BaseController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用户入口
 *
 * @author xbwu
 * @create 2017-08-09
 **/
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {


    @GetMapping(value = "/userList")
    public ModelAndView userList() throws Exception {
        ModelAndView mv = getMV("/module/user/userList");
        return mv;
    }
}