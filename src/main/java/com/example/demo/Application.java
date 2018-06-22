package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**  
* @Title: Application.java  
* @Package com.example.demo  
* @Description: TODO
* @author wdm  
* @date 2018年6月5日  上午9:43:19
* @version V1.0  
*/
@SpringBootApplication
@EnableScheduling  //开启springboot 任务调度 
@EnableTransactionManagement //如果mybatis中service实现类中加入事务注解，需要此处添加该注解
@MapperScan("com.example.demo.mapper") //扫描mybatis mapper
public class Application extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		System.err.println("------------begin-----------------");
        SpringApplication.run(Application.class, args);
        System.err.println("------------end-----------------");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // TODO Auto-generated method stub
//      return super.configure(builder);
        return builder.sources(this.getClass());
    }

}
