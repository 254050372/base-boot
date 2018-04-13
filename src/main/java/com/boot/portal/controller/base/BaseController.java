package com.boot.portal.controller.base;/**
 * @description
 * @autor xbwu on 2017/8/17.
 */

import com.boot.portal.common.config.BaseConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

/**
 * 基础控制器
 * @author xbwu
 * @create 2017-08-17 
 **/
public abstract class BaseController {

    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    public ModelAndView getMV(String viewName){
        return new ModelAndView(BaseConstant.templatesPrefix+"/"+viewName); //返回的view就是templetes下面文件的名称
    }

    public ModelAndView forwardController(String viewName){
        return new ModelAndView("forward:/"+viewName);
    }
    public ModelAndView redirectController(String viewName){
        return new ModelAndView("redirect:/"+viewName);
    }
}
