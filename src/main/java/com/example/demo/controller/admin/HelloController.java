package com.example.demo.controller.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController =@Controller+@ResponseBody  代表当前类下所有方法返回json 不在执行跳转页面
 * */
@RestController 
@RequestMapping("hello")
public class HelloController {
//	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	 @RequestMapping(value="", method=RequestMethod.GET)  
	 public String hello() {  
		 logger.info("======> hello");
	        return "Hello World!";  
	 }  
	 
	 @RequestMapping(value="data", method=RequestMethod.GET)  
	 public List<Map<String, Object>> getData(HttpServletResponse r){
		 List<Map<String, Object>> data=new ArrayList<Map<String, Object>>();
		 for(int i=0;i<10;i++) {
			 Map<String, Object> map =new HashMap<String, Object>();
			 map.put("name", "name_"+i);
			 map.put("value", "value_"+i);
			 data.add(map);
		 }
		 r.setHeader("testHeader", "Wangdm");
		 return data;
	 }
	 
	 
	 
	 

}
