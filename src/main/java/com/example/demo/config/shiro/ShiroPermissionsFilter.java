package com.example.demo.config.shiro;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

/**  
* @Title: TestFilter.java  
* @Package com.example.demo.config.shiro  
* @Description: TODO
* @author wdm  
* @date 2018年7月17日  下午4:05:26
* @version V1.0  
*/
public class ShiroPermissionsFilter extends AuthorizationFilter {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	/* (non-Javadoc)
	 * @see org.apache.shiro.web.filter.AccessControlFilter#isAccessAllowed(javax.servlet.ServletRequest, javax.servlet.ServletResponse, java.lang.Object)
	 * 这个地方为啥这么难用,hasRole 或者isPermitted 都会去执行realm的权限加载  多角色时会重复执行 直到该方法返回true或者结束  这就是必须用缓存的理由?
	 */
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
//		PermissionsAuthorizationFilter
		logger.info("----------用户权限校验处理中心-------------");
		    Subject subject = getSubject(request, response);  
//  --------------------------------------> 校验权限		    
//	        String[] perms = (String[]) mappedValue;   
//	        boolean isPermitted = true;
//	        if (perms != null && perms.length > 0) {
//	            if (perms.length == 1) {
//	                if (!subject.isPermitted(perms[0])) {
//	                    isPermitted = false;
//	                }
//	            } else {
////	                if (!subject.isPermittedAll(perms)) {
////	                    isPermitted = false;
////	                }
//	                isPermitted = false;
//	                for(int i=0;i<perms.length;i++) {
//	                	if(subject.isPermitted(perms[i])) {
//	                		isPermitted=true;
//	                		break;
//	                	}
//	                }
//	            }
//	        }
//	        return isPermitted;
//---------------------------------------->校验角色
//		    String[] roles= (String[]) mappedValue;   
//		    
//	        if (roles == null || roles.length == 0) {   
//	            //no roles specified, so nothing to check - allow access.   
//	            return true;   
//	        }   
//	  
//	        for(int i=0;i<roles.length;i++){    
//	            if(subject.hasRole(roles[i])){    
//	                return true;    
//	            }    
//	        }    
//	        return false;
//--------------->因为上述无论是角色校验还是权限校验都会多次执行(某个菜单可以多个权限访问)realm的权限doGetAuthorizationInfo,所以在这里重写不在使用doGetAuthorizationInfo方法
			if(subject.getPrincipals()==null) {//用户掉线 （理论上不存在这种情况,只要是权限路径忘记加入authc）
//				 String unauthorizedUrl = getUnauthorizedUrl();
//	        	 WebUtils.issueRedirect(request, response, unauthorizedUrl);
				 return false;
			}else {
				System.err.println("当前登录者标识:"+subject.getPrincipals().getPrimaryPrincipal());
				//方法一:通过数据库查询登录者的全部角色(该查询比较频繁,加入缓存机制)////方法二:当执行doGetAuthenticationInfo直接把用户的角色权限信息存入subject中
				//和该路径能够访问的预设角色对比 并返回结果
			}
			return true;
	}
	
	 /**
     * shiro认证perms资源失败后回调方法
     * @param servletRequest
     * @param servletResponse
     * @return
     * @throws IOException
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        logger.info("----------用户疑似越权访问处理中心-------------");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String requestedWith = httpServletRequest.getHeader("X-Requested-With");
        if ("XMLHttpRequest".equalsIgnoreCase(requestedWith)) {//如果是ajax返回指定格式数据
            Map<String, Object> result = new HashMap<String, Object>();
            result.put("flag", false);
            result.put("msg", "权限不足！");
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType("application/json");
            httpServletResponse.getWriter().write(new Gson().toJson(result));
        } else {//如果是普通请求进行重定向
        	 String unauthorizedUrl = getUnauthorizedUrl();
        	 WebUtils.issueRedirect(request, response, unauthorizedUrl);
        }
        return false;
    }

}
