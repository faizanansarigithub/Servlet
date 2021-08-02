package com.fa.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/s1url")
public class FirstServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null,addrs=null,ms=null;
		Cookie ck1=null,ck2=null,ck3=null;
		//get PrintWriter
		pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read data from req obj
		name=req.getParameter("pname");
		addrs=req.getParameter("paddrs");
		ms=req.getParameter("ms");
		//use cookies
		ck1=new Cookie("cname", name);
		ck2=new Cookie("caddrs", addrs);
		ck3=new Cookie("cms", ms);
		res.addCookie(ck1);res.addCookie(ck2);res.addCookie(ck3);
		if(ms==null)
			ms="unmarride";
		
		if(ms.equalsIgnoreCase("marride")) {
			pw.println("<h1 style='color:blue;text-align:center'> Married Life Details </h1>");
			pw.println("<form action='s2url' method='POST'>");
			pw.println("<table border='1' bgcolor='cyan' align='center'>");
			pw.println("<tr><td>spouse name:::</td<td><input type='text'name='f2txt1'/></td></tr>");
			pw.println("<tr><td>No. of kids:::</td<td><input type='text'name='f2txt2'/></td></tr>");
			pw.println("<tr><td colspan='2'><input type='submit' value='submit'/></td></tr>");
			pw.println("</table>");
			pw.println("</form>");
		}
		else {
			pw.println("<h1 style='color:blue;text-align:center'> Bachelors Life Details </h1>");
			pw.println("<form action='s2url' method='POST'>");
			pw.println("<table border='1' bgcolor='cyan' align='center'>");
			pw.println("<tr><td>When You Want to Marry:::</td<td><input type='text'name='f2txt1'/></td></tr>");
			pw.println("<tr><td>Why You Want to Marry:::</td<td><input type='text'name='f2txt2'/></td></tr>");
			pw.println("<tr><td colspan='2'><input type='submit' value='submit'/></td></tr>");
			pw.println("</table>");
			pw.println("</form>");
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
