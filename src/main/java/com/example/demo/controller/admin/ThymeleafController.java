package com.example.demo.controller.admin;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.component.AppProperties;

@Controller
@RequestMapping("thymeleaf")
public class ThymeleafController {
	
	@Autowired private AppProperties pro;
	
	@RequestMapping("")
    public String hello(Map<String,Object> map) {
        map.put("msg", "Hello Thymeleaf");
        map.put("author", pro.getAuthor());
        return "webjars/hello";
    }
	@RequestMapping("vueRouter")
	public String vueRouter() {
		return "webjars/vue_router";
	}

}
