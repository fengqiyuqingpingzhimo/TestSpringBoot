package com.example.demo.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.util.PathMatcher;

public class TextFilter implements Filter {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	public static final String PARAM_NAME_EXCLUSIONS  = "exclusions";
	protected PathMatcher   pathMatcher   = new PathMatcher();
	private Set<String> excludesPattern;

	@Override
	public void destroy() {
		logger.info("TextFilter销毁");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		 long start = System.currentTimeMillis();
		 HttpServletRequest re=((HttpServletRequest)request);
		 String visitPath=re.getServletPath();
		 if (isExclusion(visitPath)) {
			 chain.doFilter(request, response);
			 return;
		 }
		 chain.doFilter(request, response);
		 logger.debug("TextFilter过滤时间耗时监控,使用时间:{},转接路径:{}",System.currentTimeMillis() - start,visitPath);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		logger.info("TextFilter初始化");
		{
            String exclusions = config.getInitParameter(PARAM_NAME_EXCLUSIONS);
            if (exclusions != null && exclusions.trim().length() != 0) {
                excludesPattern = new HashSet<String>(Arrays.asList(exclusions.split("\\s*,\\s*")));
            }
        }
	}

	public boolean isExclusion(String requestURI) {
		if (excludesPattern == null || requestURI == null) {
			return false;
		}

//		if (contextPath != null && requestURI.startsWith(contextPath)) {
//			requestURI = requestURI.substring(contextPath.length());
//			if (!requestURI.startsWith("/")) {
//				requestURI = "/" + requestURI;
//			}
//		}

		for (String pattern : excludesPattern) {
			if (pathMatcher.matches(pattern, requestURI)) {
				return true;
			}
		}

		return false;
	}

}
