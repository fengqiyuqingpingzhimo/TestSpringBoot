package com.example.demo.config.shiro;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**  
* @Title: ShiroConfig.java  
* @Package com.example.demo.config  
* @Description: shiro配置相关
* @author wdm  
* @date 2018年6月8日  上午11:14:24
*/
@Configuration
public class ShiroConfig {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	//加入系统身份验证和权限验证
	@Bean
	public ShiroRealm myShiroRealm(){
		ShiroRealm myShiroRealm = new ShiroRealm();
		myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());//...
		return myShiroRealm;
	}
	//权限管理，配置主要是Realm的管理认证
	@Bean
	public org.apache.shiro.mgt.SecurityManager securityManager(){
		DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
		securityManager.setRealm(myShiroRealm());
		return securityManager;
	}
	/**shiro filter主要配置**/
	@Bean
	public ShiroFilterFactoryBean shiroFilterFactoryBean(org.apache.shiro.mgt.SecurityManager securityManager) {
		logger.debug("--------------------------Shiro Filter--------------------------------------------------");
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);//安全管理器
		Map<String, Filter> filters=shiroFilterFactoryBean.getFilters();
		filters.put("ShiroLoginFilter", shiroLoginFilter());//自定义shiro登录过滤器
		filters.put("ShiroPermissionsFilter", new ShiroPermissionsFilter());//自定义shiro权限过滤器
		filters.put("ShiroLogoutFilter", new ShiroLogoutFilter());//自定义shiro退出登录过滤器
		Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
		filterChainDefinitionMap.put("/login", "ShiroLoginFilter");//配置自定义过滤器**
		filterChainDefinitionMap.put("/favicon.ico", "anon");
		filterChainDefinitionMap.put("/css/**", "anon");
		filterChainDefinitionMap.put("/img/**", "anon");
		filterChainDefinitionMap.put("/js/**", "anon");
		filterChainDefinitionMap.put("/plugins/**", "anon");
		filterChainDefinitionMap.put("/test/**", "anon");
		filterChainDefinitionMap.put("/error/**", "anon");
		filterChainDefinitionMap.put("/static/**", "anon");// 配置不会被拦截的链接 顺序判断
//		filterChainDefinitionMap.put("/logout", "logout");//配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
		filterChainDefinitionMap.put("/logout", "ShiroLogoutFilter");
		//权限配置
		filterChainDefinitionMap.put("/index", "authc,ShiroPermissionsFilter[admin1,admin2,admin]");
		filterChainDefinitionMap.put("/thymeleaf", "authc,ShiroPermissionsFilter[admin,list1]");
		//<!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边  ,authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问 -->
		filterChainDefinitionMap.put("/**", "authc");
		shiroFilterFactoryBean.setLoginUrl("/login");// 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
		shiroFilterFactoryBean.setSuccessUrl("/index");// 登录成功后要跳转的链接
		shiroFilterFactoryBean.setUnauthorizedUrl("/error/403.html");//未授权界面
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);//路径拦截器.
		return shiroFilterFactoryBean;
	}

	/**
	 * 凭证匹配器 （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了）
	 * @return
	 */
	@Bean
	public HashedCredentialsMatcher hashedCredentialsMatcher(){
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
		hashedCredentialsMatcher.setHashAlgorithmName("SHA");//散列算法:这里使用MD5算法;
		hashedCredentialsMatcher.setHashIterations(1);//散列的次数，比如散列两次，相当于 md5(md5(""));
		return hashedCredentialsMatcher;
	}

	/**
	 *  开启shiro aop注解支持.
	 *  使用代理方式;所以需要开启代码支持;
	 * @param securityManager
	 * @return
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(org.apache.shiro.mgt.SecurityManager securityManager){
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}
	
	@Bean
    public ShiroLoginFilter shiroLoginFilter(){
		ShiroLoginFilter shiroFilter = new ShiroLoginFilter();
		shiroFilter.setUsernameParam("username");//与前台参数名一直 默认值username password
		shiroFilter.setPasswordParam("password");
        return shiroFilter;
    }
}
