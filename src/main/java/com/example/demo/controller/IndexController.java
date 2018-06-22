package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**  
* @Title: IndexController.java  
* @Package com.example.demo.controller  
* @Description: 首页相关
* @author wdm  
* @date 2018年4月24日  下午3:22:47
* @version V1.0  
*/
@Controller
public class IndexController {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
    @GetMapping(value = "/")
    public String index(HttpServletRequest request) {
    	logger.debug("系统默认访问页面!");
        return "index";
    }
	

}
