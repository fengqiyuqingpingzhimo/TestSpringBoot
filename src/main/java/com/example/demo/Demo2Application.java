package com.example.demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.config.WebConfig;
import com.example.demo.dto.DataSourceProperties;
import com.example.demo.listener.TestListener;

@SpringBootApplication
public class Demo2Application {
	 public void onStartup(ServletContext servletContext) throws ServletException {
	        // 配置 Servlet
//	        servletContext.addServlet("servletTest",new ServletTest())
//	                      .addMapping("/servletTest");
	        // 配置过滤器
//	        servletContext.addFilter("timeFilter",new TimeFilter())
//	                      .addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST),true,"/*");
	        // 配置监听器
	        servletContext.addListener(new TestListener());
	    }
    /**
     * springboot 模板引擎 Freemarker 和 Thymeleaf
     * @param args
     */
	public static void main(String[] args) {
//		SpringApplication.run(Demo2Application.class, args);
		ConfigurableApplicationContext context = SpringApplication.run(Demo2Application.class, args);
        context.getBean(WebConfig.class).show();
        context.getBean(DataSourceProperties.class).show();
	}
}
