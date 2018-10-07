package com.example.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//@Component
public class TimeFilter implements Filter {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void destroy() {
		logger.info("TimeFilter销毁");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		 long start = System.currentTimeMillis();

		 arg2.doFilter(arg0, arg1);
		 logger.info("TimeFilter过滤时间耗时监控,使用时间:{}",System.currentTimeMillis() - start);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		logger.info("TimeFilter初始化");
	}

}
