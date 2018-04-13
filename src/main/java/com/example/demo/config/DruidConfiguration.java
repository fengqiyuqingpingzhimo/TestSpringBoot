package com.example.demo.config;

import java.util.Arrays;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;

/**  
* @Title: DruidConfiguration.java  
* @Package com.example.demo.config  
* @Description: 配置 Druid 数据源
* @author wdm  
* @date 2018年4月13日  下午4:45:34
* @version V1.0  
*/
@Configuration
public class DruidConfiguration {
	
	    @ConfigurationProperties(prefix = "spring.datasource.druid")
	    @Bean(initMethod = "init",destroyMethod = "close")
	    public DruidDataSource dataSource() {
	        DruidDataSource ds = new DruidDataSource();
	        ds.setProxyFilters(Arrays.asList(statFilter()));
	        return ds;
	    }
	    @Bean
	    public Filter statFilter() {
	        StatFilter filter = new StatFilter();
	        filter.setSlowSqlMillis(5000);
	        filter.setLogSlowSql(true);
	        filter.setMergeSql(true);
	        return filter;
	    }

}
