package com.fa.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//@WebFilter("/*")
public class BrowserFilter extends HttpFilter {
	static {
		System.out.println("BrowserFilter:: static block is executed");
	}
	public BrowserFilter() {
		System.out.println("BrowserFilter:: o-param constructor ");
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("BrowserFilter::init()");
	}
	
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		PrintWriter pw=null;
		String browser=null;
		//get printwriter
		pw=response.getWriter();
		//set contentType
		response.setContentType("text/html");
		browser=request.getHeader("user-agent");
		if(browser.indexOf("Chrome")== -1) {
			pw.println("<h1> Visit chrome browser to visit this website</h1>");
		}
		else {
			System.out.println("BrowserFilter.doFilter() befor");
			chain.doFilter(request, response);
			System.out.println("BrowserFilter.doFilter() After");
		}
	}
	@Override
	public void destroy() {
		System.out.println("destroy method executed");
	}
}
