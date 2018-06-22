package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**  
* @Title: Swagger2Configuration.java  
* @Package com.example.demo.config  
* @Description: springboot+Swagger2相关配置  访问路径 项目+/swagger-ui.html
* @author wdm  
* @date 2018年4月3日  上午11:16:20
* @version V1.0  
*/
@Configuration
@EnableSwagger2
public class Swagger2Configuration {
	

    @Bean
    public Docket accessToken() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("api")// 定义组
                .select() // 选择那些路径和 api 会生成 document
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller")) // 拦截的包路径
                .paths(PathSelectors.regex("/*/.*"))// 拦截的接口路径
                .build() // 创建
                .apiInfo(apiInfo()); // 配置说明
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()//
                .title("SpringBoot+Swagger2生成接口文档")// 标题
                .description("接口详情")// 描述
//                .termsOfServiceUrl("http://www.extlight.com")//
//                .contact(new Contact("wdm", "http://www.extlight.com", "445847261@qq.com"))// 联系
                .version("1.0")// 版本
                .build();
    }

}
