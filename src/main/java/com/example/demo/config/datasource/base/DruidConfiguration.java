package com.example.demo.config.datasource.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

/**  
* @Description: 配置 Druid 数据源 (系统主数据源配置)
* @author wdm  
* @date 2018年4月13日  下午4:45:34
*/
@Configuration
public class DruidConfiguration {
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new WebStatFilter());
		filterRegistrationBean.addUrlPatterns("/*");
		filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		filterRegistrationBean.addInitParameter("profileEnable", "true");
		return filterRegistrationBean;
	}

	@Bean
	public ServletRegistrationBean druidServlet() {
		logger.debug("init Druid Servlet Configuration ");
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
		// IP白名单
		servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
		// IP黑名单(共同存在时，deny优先于allow)
		servletRegistrationBean.addInitParameter("deny", "");
		// 控制台管理用户
		servletRegistrationBean.addInitParameter("loginUsername", "admin");
		servletRegistrationBean.addInitParameter("loginPassword", "admin");
		// 是否能够重置数据 禁用HTML页面上的“Reset All”功能
		servletRegistrationBean.addInitParameter("resetEnable", "false");
		return servletRegistrationBean;
	}

	@ConfigurationProperties(prefix = "spring.datasource")
	@Bean(initMethod = "init", destroyMethod = "close", name = "baseDataSource")
	@Primary // 多数据源配置相关 单数据源无需该配置
	public DruidDataSource dataSource() {
		DruidDataSource ds = new DruidDataSource();
		// ds.setProxyFilters(Arrays.asList(statFilter()));mds.second.datasource
		return ds;
	}
	// @Bean
	// public Filter statFilter() {
	// StatFilter filter = new StatFilter();
	// filter.setSlowSqlMillis(5000);
	// filter.setLogSlowSql(true);
	// filter.setMergeSql(true);
	// return filter;
	// }

}
