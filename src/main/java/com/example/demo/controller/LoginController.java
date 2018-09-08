package com.example.demo.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.util.JsonResult;

/**  
* @Title: LoginController.java  
* @Package com.example.demo.controller  
* @Description: 系统登录相关
*/
@Controller
@RequestMapping("login")
public class LoginController {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@GetMapping
    public String loginGet(HttpServletRequest request, Map<String, Object> map) {
		logger.debug("跳转系统登录页面!");
		map.put("msg", "-用户登录");
		return "login";
    }
	/**当用户已经登录时,再次发送登录请求,shiro不在做处理,需要该类去正确响应**/
	@PostMapping
    public ResponseEntity<JsonResult> loginPost(HttpServletRequest request) {
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
//	@PostMapping("")
//    public ResponseEntity<JsonResult> loginPost(HttpServletRequest request) {
//		logger.debug("系统登录验证!");
//		JsonResult r = new JsonResult();
//		// 登录失败从request中获取shiro处理的异常信息。
//		// shiroLoginFailure:就是shiro异常类的全类名.
//		String exception = (String) request.getAttribute("shiroLoginFailure");
//		logger.debug("获取shiro异常类名称:{}",exception);
//		String msg = "",status="fail";
//		if (exception != null) {
//			if (UnknownAccountException.class.getName().equals(exception)) {
//				msg = "账号不存在";
//			} else if (IncorrectCredentialsException.class.getName().equals(exception)) {
//				msg = "密码不正确";
//			} else {
//				msg = "未知错误" ;
//				System.out.println("else -- >" + exception);
//			}
//		}else {
//			status="ok";
//		}
//		r.setResult(msg);
//		r.setStatus(status);
//		return ResponseEntity.ok(r);
//    }
	
}
