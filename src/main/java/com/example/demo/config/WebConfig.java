package com.example.demo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.example.demo.filter.TextFilter;
import com.example.demo.servlet.TestServlet;

@Configuration
public class WebConfig {
	
	@Value("${ds.userName}")
    private String userName;
    @Autowired
    private Environment environment;
    public void show() {
        System.out.println("ds.userName:" + this.userName);
        System.out.println("ds.password:" + this.environment.getProperty("ds.password"));
    }
	
	@Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        HttpMessageConverter<?> converter = fastJsonHttpMessageConverter;
        return new HttpMessageConverters(converter);
    }
	/**
	* @Description: 注册servlet
	* @author wdm  
	* @date 2018年3月19日  上午9:10:23
	 */
	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
	    return new ServletRegistrationBean(new TestServlet(),"/testServlet");
	}
	/**
	* @Description:  添加到过滤器链中，此方式适用于使用第三方的过滤器
	* @author wdm  
	* @date 2018年3月19日  上午9:10:45
	 */
	@Bean
	public FilterRegistrationBean timeFilter() {
	    FilterRegistrationBean registrationBean = new FilterRegistrationBean();
	    
	    TextFilter timeFilter = new TextFilter();
	    registrationBean.setFilter(timeFilter);
	    
	    List<String> urls = new ArrayList<>();
	    urls.add("/*");
	    registrationBean.setUrlPatterns(urls);
	    
	    return registrationBean;
	}
	/**
	* @Description: 注册监听器
	* @author wdm  
	* @date 2018年3月21日  上午5:24:49
	 */
//	@Bean
//	public ServletListenerRegistrationBean<TestListener> servletListenerRegistrationBean() {
//	    return new ServletListenerRegistrationBean<TestListener>(new TestListener());
//	}
	@Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
