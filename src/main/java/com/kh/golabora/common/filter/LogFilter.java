package com.kh.golabora.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class LogFilter
 */
//@WebFilter("/*")
public class LogFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LogFilter() {
    	System.out.println("[LogFilter 생성]");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("[LogFilter destroy]");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 전처리
		HttpServletRequest httpReq = (HttpServletRequest) request;
		String uri = httpReq.getRequestURI(); // /mvc/member/enroll
		String method = httpReq.getMethod();
		
		System.out.println("============================================");
		System.out.printf("%s %s%n", method, uri);
		System.out.println("--------------------------------------------");
		
		// filter chain의 다음 filter를 호출(마지막 필터라면 servlet 호출)
		chain.doFilter(request, response);
		
		//후처리
		HttpServletResponse httpRes = (HttpServletResponse) response;
		System.out.println("____________________________________________");
		System.out.println(httpRes.getStatus());
		System.out.println();
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("[LogFilter init]");
	}

}
