package com.fa.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fa.wrappers.MyRequest;
@WebFilter("/*")
public class LoginFIlter extends HttpFilter {
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		MyRequest mreq=null;
		//create custom REquest
		mreq=new MyRequest(request);
		chain.doFilter(mreq, response);
	}

}
