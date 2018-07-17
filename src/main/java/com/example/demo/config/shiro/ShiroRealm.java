package com.example.demo.config.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

/**  
* @Title: ShiroRealm.java  
* @Package com.example.demo.config.shiro  
* @Description: shiro 身份认证及权限配置
* @author wdm  
* @date 2018年6月15日  上午10:16:09
*/
public class ShiroRealm extends AuthorizingRealm {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired private UserService userService;
	/* 权限配置
	 * (non-Javadoc)
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		logger.debug("---用户权限信息加载---");
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		System.err.println(principals.getPrimaryPrincipal());
		authorizationInfo.addStringPermission("list");
		authorizationInfo.addStringPermission("admin");
		authorizationInfo.addRole("admin");
		return authorizationInfo;
	}

	/* 身份认证
	 * (non-Javadoc)
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		logger.debug("---用户身份认证---");
		String username = (String)token.getPrincipal();  				//得到用户名 
        String password = new String((char[])token.getCredentials()); 	//得到密码
        logger.debug("登录用户名(loginname):{},登录密码(password):{}",username,password);
        User user=this.userService.selectByLoginName(username);
        if(user == null){
        	return null;
        }
        logger.debug("获取到当前登录信息:{}",user.toString());
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
        		user, //shiro 保存当前登录者信息 可以加入该登录者角色/权限信息 ,用于后面的权限验证
        		user.getPassword(), //密码
//                ByteSource.Util.bytes(userInfo.getCredentialsSalt()),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
	}
	
	

}
