//HtmlServlet.java
package com.fa.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class HtmlServlet extends HttpServlet{
	static {
		System.out.println("HTMLServlet static block is executed");
	}
	public HtmlServlet() {
		System.out.println("HtmlServlet:: 0 param constructor ");
	}
	
	/*
	 * @Override public void init(ServletConfig cfg) throws ServletException {
	 * super.init(cfg); System.out.println("HtmlServlet:: init()");
	 * System.out.println("dbuser init param value:: "+cfg.getInitParameter(
	 * "username"));
	 * System.out.println("dbpwd init param value:: "+cfg.getInitParameter(
	 * "password")); }
	 */
	@Override
	public void init() throws ServletException {
		System.out.println("HtmlServlet.init() no param method");
		ServletConfig cg=getServletConfig();
		System.out.println(cg.getInitParameter("username")+" from init no param method");
		System.out.println(cg.getInitParameter("password")+" from init no param method");
	}

	protected void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		System.out.println("HtmlServlet.service()");
		PrintWriter pw=null;
		//get PrintWriter
		pw=res.getWriter();
		//set response content type/MIME type
		res.setContentType("text/html");
		
		//write output message to response object
		pw.println("<table align='center' border='1' bgcolor='cyan'>");
		pw.println("<tr><th> Country </th><th>President/PrimeMinister</th></tr>");
		pw.println("<tr><td>India</td><td>Modi</td></tr>");
		pw.println("<tr><td>Pakistan</td><td>Imran Khan</td></tr>");
		pw.println("<tr><td>USA</td><td>Trump</td></tr>");
		pw.println("<tr><td>china</td><td>Xi-xing ping</td></tr>");
		pw.println("</table>");
		ServletConfig cg=getServletConfig();
		System.out.println(cg.getInitParameter("username")+" from service method");
		
		System.out.println();
		//close stream
		pw.close();

	}
}