package com.wanted.onepeople.controller;

import cn.hutool.core.util.ObjectUtil;
import com.wanted.onepeople.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 功能描述：Spring Boot Admin Client
 *
 * @author xiyouquedongxing
 * @Date 2020-08-03
 */
@RestController
public class IndexController {

	@GetMapping(value = {"", "/"})
	public ModelAndView index(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        User user = (User) request.getSession().getAttribute("user");
        if(ObjectUtil.isNull(user)){
            mv.setViewName("redirect:/users/login");
        }else {
            mv.setViewName("/page/index");
            mv.addObject(user);
        }
        return mv;
	}


}
