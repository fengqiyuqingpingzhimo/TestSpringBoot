package com.example.demo.config.datasource;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**  
* @Description: springboot+mybatis 多数据源配置   主数据源
* @author wdm  
* @date 2018年9月13日  上午11:05:54
*/
//@Configuration
//@MapperScan(basePackages = "com.example.demo.mapper.dao", sqlSessionTemplateRef = "baseSqlSessionTemplate")
public class FirstDataSourceConfig {
	
//	@Bean(name = "baseTransactionManager")
//    public DataSourceTransactionManager setTransactionManager(@Qualifier("baseDataSource") DataSource dataSource) {
//		return new DataSourceTransactionManager(dataSource);
//    }
 
    @Bean(name = "baseSqlSessionFactory")
    public SqlSessionFactory setSqlSessionFactory(@Qualifier("baseDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/example/demo/mapper/*Mapper.xml"));
        bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis/Config.xml"));
        return bean.getObject();
    }
 
    @Bean(name = "baseSqlSessionTemplate")
    public SqlSessionTemplate setSqlSessionTemplate(@Qualifier("baseSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
