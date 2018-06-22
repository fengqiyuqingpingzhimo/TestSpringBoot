package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**  
* @Title: LoginController.java  
* @Package com.example.demo.controller  
* @Description: 系统登录相关
* @author wdm  
* @date 2018年6月15日  下午1:58:48
* @version V1.0  
*/
@Controller
@RequestMapping("login")
public class LoginController {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@GetMapping("")
    public String login(HttpServletRequest request) {
		logger.debug("系统登录页面");
        return "login";
    }
	
}
