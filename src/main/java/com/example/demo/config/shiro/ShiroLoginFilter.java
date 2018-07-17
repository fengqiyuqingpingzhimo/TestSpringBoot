package com.example.demo.config.shiro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.util.JsonResult;
import com.google.gson.Gson;
/**  
* @Title: ShiroFilter.java  
* @Package com.example.demo.config.shiro  
* @Description: shiro 登录过滤器  重写 FormAuthenticationFilter 过滤器 使之能够正确处理前台ajax请求
* @author wdm  
* @date 2018年7月17日10:39:28
*/
public class ShiroLoginFilter extends FormAuthenticationFilter {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
 
	/**用户登录成功**/
	@Override
	protected boolean onLoginSuccess(AuthenticationToken token,Subject subject, ServletRequest request, ServletResponse response) throws Exception {
		logger.debug("用户登录成功,开始反馈信息!");
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		if (!"XMLHttpRequest".equalsIgnoreCase(httpServletRequest.getHeader("X-Requested-With"))) {// 不是ajax请求
			issueSuccessRedirect(request, response);
		} else {
			httpServletResponse.setCharacterEncoding("UTF-8");
			PrintWriter out = httpServletResponse.getWriter();
			JsonResult r = new JsonResult();
			r.setResult("登录成功!");
			r.setStatus("ok");
			out.println(new Gson().toJson(r));
			out.flush();
			out.close();
		}
		return false;
	}
 
	/**用户登录失败**/
	@Override
	protected boolean onLoginFailure(AuthenticationToken token,AuthenticationException e, ServletRequest request,ServletResponse response) {
		logger.debug("登陆失败,开始反馈信息!");
		if (!"XMLHttpRequest".equalsIgnoreCase(((HttpServletRequest) request).getHeader("X-Requested-With"))) {// 不是ajax请求
			setFailureAttribute(request, e);
			return true;
		}
		try {
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			String message = e.getClass().getSimpleName();
			JsonResult r = new JsonResult();
			String msg="";
			if ("IncorrectCredentialsException".equals(message)) {
				msg = "密码不正确";
			} else if ("UnknownAccountException".equals(message)) {
				msg = "账号不存在";
			} else {
//				out.println("{success:false,message:'未知错误'}");
				msg = "未知错误";
			}
			r.setResult(msg);
			r.setStatus("fail");
			out.println(new Gson().toJson(r));
			out.flush();
			out.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	}
 
	/**用户登录跳转、用户登录及前置校验等**/
	@Override
	protected boolean onAccessDenied(ServletRequest request,ServletResponse response) throws Exception {
        logger.debug("登录验证！！！！！！！！！！！！！！！！！");
		if (isLoginRequest(request, response)) {
			logger.debug("isLoginRequest");
			if (isLoginSubmission(request, response)) {
				if (logger.isDebugEnabled()) {
					logger.debug("检测到登录提交,尝试执行登录!");
				}
//				HttpServletRequest httpservletrequest = (HttpServletRequest) request;
//				if ("XMLHttpRequest".equalsIgnoreCase(httpservletrequest.getHeader("X-Requested-With"))) {// ajax请求处理
//				// TODO:该处可以做验证码校验等相关操作!
//				}
				return executeLogin(request, response);
			} else {
				if (logger.isDebugEnabled()) {
					logger.debug("跳转用户登录页面!");
				}
				return true;
			}
		} else {
			if (logger.isTraceEnabled()) {
				logger.trace("Attempting to access a path which requires authentication.  Forwarding to the "
						+ "Authentication url [" + getLoginUrl() + "]");
			}
			if (!"XMLHttpRequest".equalsIgnoreCase(((HttpServletRequest) request).getHeader("X-Requested-With"))) {// 不是ajax请求
				saveRequestAndRedirectToLogin(request, response);
			} else {
				response.setCharacterEncoding("UTF-8");
				PrintWriter out = response.getWriter();
				out.println("{message:'login'}");
				out.flush();
				out.close();
			}
			return false;
		}
	}


}
