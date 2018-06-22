package com.example.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**  
* @Title: VisitInterceptor.java  
* @Package com.example.demo.interceptor  
* @Description: 访问拦截器1
* @author wdm  
* @date 2018年6月8日  上午9:50:52
* @version V1.0  
*/
public class VisitInterceptor implements HandlerInterceptor {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		this.logger.debug("==>afterCompletion:页面渲染之后调用，一般用于资源清理操作");

	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		this.logger.debug("==>postHandle: controller 执行之后，且页面渲染之前调用");

	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse arg1, Object arg2) throws Exception {
		this.logger.debug("==>preHandle: controller 执行之前调用");
		String path = request.getServletPath();
		this.logger.info("==>获取到当前请求路径：{} 发起ip:{}",path,getIp(request));
		return true;
	}
	
	/**
	 * 获取客户端IP地址
	 */
	public String getIp(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if(null!=ip && !"unKnown".equalsIgnoreCase(ip)){
			//多次反向代理后会有多个ip值，第一个ip才是真实ip
			int index = ip.indexOf(",");
			if(index != -1){
				return ip.substring(0,index);
			}else{
				return ip;
			}
		}
		ip = request.getHeader("X-Real-IP");
		if(null!=ip && !"unKnown".equalsIgnoreCase(ip)){
			return ip;
		}
		ip = request.getRemoteAddr();
		if(ip.equals("0:0:0:0:0:0:0:1")){
			ip = "127.0.0.1";
		}
		return ip;
	}

}
