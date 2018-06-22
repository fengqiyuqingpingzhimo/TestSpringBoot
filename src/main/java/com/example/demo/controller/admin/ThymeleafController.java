package com.example.demo.controller.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.component.AppProperties;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("thymeleaf")
public class ThymeleafController {
	
	@Autowired private AppProperties pro;
	@Autowired private UserService service;
	
	@RequestMapping("")
    public String hello(Map<String,Object> map) {
        map.put("msg", "Hello Thymeleaf");
        map.put("author", pro.getAuthor());
        map.put("bean", pro);
        map.put("list", getData());
        map.put("data", this.service.getUserList());
        map.put("html", "<div>This is an <em>HTML</em> text. <b>Enjoy yourself!</b></div>");
        return "test_thymeleaf/test";
    }
	
	@RequestMapping("footer")
    public String footer() {
        return "test_thymeleaf/footer";
    }
	
	private List<Map<String, Object>> getData(){
		List<Map<String, Object>> list=new ArrayList<>();
		for(int i=0;i<10;i++) {
			Map<String,Object> map =new HashMap<>();
			map.put("key", "key"+i);
			map.put("val", "val"+i);
			list.add(map);
		}
		return list;
	}
	
}
