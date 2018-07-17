package com.example.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

public class TextFilter implements Filter {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void destroy() {
		logger.info("TextFilter销毁");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		 long start = System.currentTimeMillis();
		 arg2.doFilter(request, arg1);
		 HttpServletRequest re=((HttpServletRequest)request);
		 String visitPath=re.getServletPath();
//		 System.err.println(new Gson().toJson(re.getParameterMap()));
		 logger.info("TextFilter过滤时间耗时监控,使用时间:{},转接路径:{}",System.currentTimeMillis() - start,visitPath);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		logger.info("TextFilter初始化");
	}

}
