package com.example.demo.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.example.demo.filter.TextFilter;
import com.example.demo.servlet.TestServlet;
import com.github.pagehelper.PageHelper;


@Configuration
public class WebConfig {
	
//	@Value("${ds.userName}")
//    private String userName;
//    @Autowired
//    private Environment environment;
//    public void show() {
//        System.out.println("ds.userName:" + this.userName);
//        System.out.println("ds.password:" + this.environment.getProperty("ds.password"));
//    }
	
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
	* @Description:  添加到过滤器链中，此方式适用于使用第三方/自定义的过滤器
	* @author wdm  
	* @date 2018年3月19日  上午9:10:45
	 */
	@Bean
	public FilterRegistrationBean textFilter() {
	    FilterRegistrationBean registrationBean = new FilterRegistrationBean();
	    registrationBean.setFilter(new TextFilter());
	    registrationBean.addUrlPatterns("/*");
	    registrationBean.addInitParameter(TextFilter.PARAM_NAME_EXCLUSIONS, "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/plugins/*");
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
	/**
	 * springboot整合 websocket
	 * 当项目打成war在tomcat运行是,该配置需注释
	 * @Description: TODO
	 * @author wdm  
	 * @date 2018年6月5日  上午10:33:05
	 */
//	@Bean
//    public ServerEndpointExporter serverEndpointExporter() {
//        return new ServerEndpointExporter();
//    }
	
	/**
	 * 
	 * @Description: springboot 集成mybatis 分页插件PageHelper
	 * @author wdm  
	 * @date 2018年4月14日  上午9:16:34
	 */
	@Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        pageHelper.setProperties(properties);
        return pageHelper;
    }
}
