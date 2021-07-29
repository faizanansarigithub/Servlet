package com.fa.wrappers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyRequest extends HttpServletRequestWrapper {
	HttpServletRequest req;
	public MyRequest(HttpServletRequest request) {
		super(request);
		this.req=request;
	}
	@Override
	public String getParameter(String name) {
		String val=req.getParameter(name);
		if(val.equals("firstname")) {
			if(!val.endsWith("nit")) {
				val=val+"nit";
			}
		}
		return val;
	}

}
