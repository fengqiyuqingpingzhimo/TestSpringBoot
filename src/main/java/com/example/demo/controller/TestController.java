package com.example.demo.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.util.JsonResult;
import com.google.gson.Gson;

/**  
* @Title: TestController.java  
* @Package com.example.demo.controller  
* @Description: 测试
*/
@Controller
@RequestMapping("test")
public class TestController {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping
    public ResponseEntity<JsonResult> loginPost(HttpServletRequest request) {
		logger.debug("系统程序测试接口!");
		System.err.println(request.getParameter(""));
		System.err.println(new Gson().toJson(request.getParameterMap()));
		StringBuilder sb = new StringBuilder();
        try(BufferedReader reader = request.getReader();) {
              char[]buff = new char[1024];
              int len;
              while((len = reader.read(buff)) != -1) {
                       sb.append(buff,0, len);
              }
	     }catch (IOException e) {
	              e.printStackTrace();
	     }
        System.err.println(sb.toString());
		JsonResult r = new JsonResult();
		r.setResult("测试数据反馈!");
		r.setStatus("ok");
		return ResponseEntity.ok(r);
    }
	
	@PostMapping("t")
    public ResponseEntity<JsonResult> t(HttpServletRequest request) {
		System.err.println(request.getParameter("a"));
		logger.debug("用户在线中,重复发送了登录请求!");
		JsonResult r = new JsonResult();
		//String exception = (String) request.getAttribute("shiroLoginFailure");
	//	logger.debug("获取shiro异常类名称:{}",exception);
		String msg = "cssss",status="ok";
		r.setResult(msg);
		r.setStatus(status);
		return ResponseEntity.ok(r);
    }

}
