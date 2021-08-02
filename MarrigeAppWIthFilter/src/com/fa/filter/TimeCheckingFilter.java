package com.fa.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimeCheckingFilter extends HttpFilter {
	static {
		System.out.println("TimeCheckingFilter:: static block");
	}
	public TimeCheckingFilter() {
		System.out.println("TimeCheckingFilter::0-param constructor");
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("TimeCheckingFilter::   init()");
	}
	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		PrintWriter pw=null;
		Calendar calendar=null;
		int hour=0;
		//get printWriter
		pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		System.out.println("TimeCheckingFilter:: doFilter()");
		calendar=Calendar.getInstance();
		hour=calendar.get(Calendar.HOUR_OF_DAY);
		
		if(hour<9|| hour>17) {
			pw.println("<h1 style='color:red;text-align:center;'> Request must be given between  9am  to 5pm only</h1>");
			return;
		}
		else {
			System.out.println("TimeCheckingFilter.doFilter() before");
			chain.doFilter(req, res);
			System.out.println("TimeCheckingFilter.doFilter() After");
		}
	}
	@Override
	public void destroy() {
		System.out.println("TimeCheckingFilter::destroy()");
	}//destroy

}//class
