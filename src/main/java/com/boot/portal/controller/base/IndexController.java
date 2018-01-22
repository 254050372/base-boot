package com.boot.portal.controller.base;/**
 * @description
 * @autor xbwu on 2017/11/28.
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 首页
 * @author xbwu
 * @create 2017-11-28 
 **/
@RestController
public class IndexController extends BaseController {

    @RequestMapping("/")
    public ModelAndView login(HttpServletRequest request) throws Exception{
        ModelAndView mv = getMV("login");
        return mv;
    }

    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request) throws Exception{
        ModelAndView mv = getMV("index");
        return mv;
    }
}
