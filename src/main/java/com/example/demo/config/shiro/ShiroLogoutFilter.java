package com.example.demo.config.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**  
* @Title: ShiroLogoutFilter.java  
* @Package com.example.demo.config.shiro  
* @Description: TODO
* @author wdm  
* @date 2018年7月21日  下午3:04:11
*/
public class ShiroLogoutFilter extends LogoutFilter {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override//确保重载
	protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
		logger.debug("---------------------用户退出登录--------------------------------");
		Subject subject = getSubject(request, response); // 在这里执行退出系统前需要清空的数据
		String redirectUrl = getRedirectUrl(request, response, subject);
		try {
			logger.debug("==>正在退出的系统用户:{}",subject.getPrincipals().getPrimaryPrincipal());
			subject.logout();
			logger.debug("==>系统用户退出成功!");
		} catch (SessionException e) {
			logger.error("==>系统用户退出失败!");
			e.printStackTrace();
		}
		issueRedirect(request, response, redirectUrl);
		return false;// 返回false表示不执行后续的过滤器，直接返回跳转到登录页面
    }
	

}
