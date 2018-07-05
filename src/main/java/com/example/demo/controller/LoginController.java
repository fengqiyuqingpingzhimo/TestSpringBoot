package com.example.demo.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
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
* @author wdm  
* @date 2018年6月15日  下午1:58:48
* @version V1.0  
*/
@Controller
@RequestMapping("login")
public class LoginController {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@GetMapping("")
//	@RequestMapping
    public String loginGet(HttpServletRequest request, Map<String, Object> map) {
		logger.debug("跳转系统登录页面!");
		// 登录失败从request中获取shiro处理的异常信息。
		// shiroLoginFailure:就是shiro异常类的全类名.
		String exception = (String) request.getAttribute("shiroLoginFailure");
		System.out.println("exception=" + exception);
		String msg = "";
		if (exception != null) {
			if (UnknownAccountException.class.getName().equals(exception)) {
				System.out.println("UnknownAccountException -- > 账号不存在：");
				msg = "UnknownAccountException -- > 账号不存在：";
			} else if (IncorrectCredentialsException.class.getName().equals(exception)) {
				System.out.println("IncorrectCredentialsException -- > 密码不正确：");
				msg = "IncorrectCredentialsException -- > 密码不正确：";
			} else if ("kaptchaValidateFailed".equals(exception)) {
				System.out.println("kaptchaValidateFailed -- > 验证码错误");
				msg = "kaptchaValidateFailed -- > 验证码错误";
			} else {
				msg = "else >> " + exception;
				System.out.println("else -- >" + exception);
			}
		}
		map.put("msg", msg);
		return "login";
    }
	@PostMapping("")
    public ResponseEntity<JsonResult> loginPost(HttpServletRequest request) {
		logger.debug("系统登录验证00000!");
		JsonResult r = new JsonResult();
		// 登录失败从request中获取shiro处理的异常信息。
		// shiroLoginFailure:就是shiro异常类的全类名.
		String exception = (String) request.getAttribute("shiroLoginFailure");
		System.out.println("exception=" + exception);
		String msg = "";
		if (exception != null) {
			if (UnknownAccountException.class.getName().equals(exception)) {
				System.out.println("UnknownAccountException -- > 账号不存在：");
				msg = "UnknownAccountException -- > 账号不存在：";
			} else if (IncorrectCredentialsException.class.getName().equals(exception)) {
				System.out.println("IncorrectCredentialsException -- > 密码不正确：");
				msg = "IncorrectCredentialsException -- > 密码不正确：";
			} else if ("kaptchaValidateFailed".equals(exception)) {
				System.out.println("kaptchaValidateFailed -- > 验证码错误");
				msg = "kaptchaValidateFailed -- >1111 验证码错误";
			} else {
				msg = "else >> " + exception;
				System.out.println("else -- >" + exception);
			}
		}
		r.setResult(msg);
		r.setStatus("ok");
		return ResponseEntity.ok(r);
    }
	
}
