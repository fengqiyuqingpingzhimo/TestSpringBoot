package com.example.demo.config.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**  
* @Title: ShiroRealm.java  
* @Package com.example.demo.config.shiro  
* @Description: TODO
* @author wdm  
* @date 2018年6月15日  上午10:16:09
* @version V1.0  
*/
public class ShiroRealm extends AuthorizingRealm {

	/* (non-Javadoc)
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	/* 身份认证
	 * (non-Javadoc)
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String)token.getPrincipal();  				//得到用户名 
        String password = new String((char[])token.getCredentials()); 	//得到密码
        if(null != username && null != password){
    	    return new SimpleAuthenticationInfo(username, password, getName());//验证成功
        }else{
    	    return null;//验证失败	
        }
	}

}
