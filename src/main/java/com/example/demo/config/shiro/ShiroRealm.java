package com.example.demo.config.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
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
* @Description: TODO
* @author wdm  
* @date 2018年6月15日  上午10:16:09
* @version V1.0  
*/
public class ShiroRealm extends AuthorizingRealm {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired private UserService userService;
	/* 权限验证
	 * (non-Javadoc)
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
		System.err.println(token.toString());
		String username = (String)token.getPrincipal();  				//得到用户名 
        String password = new String((char[])token.getCredentials()); 	//得到密码
        logger.debug("username111:{},password:{}",username,password);
        User user=this.userService.selectByLoginName(username);
        logger.debug("获取到当前登录信息:{}",user.toString());
        if(user == null){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
        		user.getLoginname(), //用户名
        		user.getPassword(), //密码
//                ByteSource.Util.bytes(userInfo.getCredentialsSalt()),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
//        if(null != username && null != password){
//    	    return new SimpleAuthenticationInfo(username, password, getName());//验证成功
//        }else{
//    	    return null;//验证失败	
//        }
	}

}
