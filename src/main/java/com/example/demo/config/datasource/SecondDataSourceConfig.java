package com.example.demo.config.datasource;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.alibaba.druid.pool.DruidDataSource;

/**  
* @Description: springboot+mybatis 第二数据源配置
* @author wdm  
* @date 2018年9月13日  上午11:16:14
*/
//@Configuration
//@MapperScan(basePackages = "com.example.demo.mapper.seconddao", sqlSessionTemplateRef = "secondSqlSessionTemplate")
public class SecondDataSourceConfig {
	
	@ConfigurationProperties(prefix = "mds.second.datasource")
	@Bean(initMethod = "init",destroyMethod = "close",name = "secondDataSource")
	public DataSource secondDataSource() {
		return new DruidDataSource();
	}

	@Bean(name = "secondSqlSessionFactory")
	public SqlSessionFactory setSqlSessionFactory(@Qualifier("secondDataSource") DataSource dataSource)throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setMapperLocations( new PathMatchingResourcePatternResolver().getResources("classpath:com/example/demo/mapper/*Mapper.xml"));
		bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis/Config.xml"));
		return bean.getObject();
	}

	@Bean(name = "secondSqlSessionTemplate")
	public SqlSessionTemplate setSqlSessionTemplate(@Qualifier("secondSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}
