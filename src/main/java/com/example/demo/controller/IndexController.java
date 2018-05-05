package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

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
	
	 @GetMapping(value = "/")
	    public String index(HttpServletRequest request) {
	        return "index";
	    }
	

}
