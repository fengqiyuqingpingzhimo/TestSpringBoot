package com.example.demo.controller.api;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.util.JsonResult;
import com.google.gson.Gson;

/**  
* @Title: ApiGsonTestController.java  
* @Package com.example.demo.controller.api  
* @Description: TODO
* @author wdm  
* @date 2018年9月7日  下午5:19:36
* @version V1.0  
*/
@Controller
@RequestMapping("api/gsontest")
public class ApiGsonTestController {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping
    public ResponseEntity<JsonResult> loginPost(HttpServletRequest request) {
		logger.debug("系统程序测试接口!");
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
		r.setResult(sb.toString());
		r.setStatus("ok");
		return ResponseEntity.ok(r);
    }
	

}
