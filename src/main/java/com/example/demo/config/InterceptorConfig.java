package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.example.demo.interceptor.VisitInterceptor;

/**  
* @Title: InterceptorConfig.java  
* @Package com.example.demo.config  
* @Description: 加载拦截器配置相关
* @author wdm  
* @date 2018年6月8日  上午9:58:32
* @version V1.0  
*/
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {
	
	 @Override  
    public void addInterceptors(InterceptorRegistry registry) {  
        // 多个拦截器组成一个拦截器链  
        // addPathPatterns 用于添加拦截规则  
        // excludePathPatterns 用户排除拦截  
        registry.addInterceptor(new VisitInterceptor()).addPathPatterns("/**");  
//        registry.addInterceptor(new MyInterceptor2()).addPathPatterns("/**");  
        super.addInterceptors(registry);  
    }  

}
