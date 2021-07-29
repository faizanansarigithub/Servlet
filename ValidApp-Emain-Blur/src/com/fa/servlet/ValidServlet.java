package com.fa.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValidServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String email=null;
		//get printWriter
		pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		//get input
		email=req.getParameter("email");
		
		if(email.length()<5) {
			pw.println("<h1> your Enter password is Weak  "+email+"</h1>");
		}
		else if(email.length()>5) {
			if(email.contains("1")) {
				pw.println("<h1> Your Enter Password is strong   "+email+"</h1>");
			}
			else {
				pw.println("<h1> Your Enter Password is ewak becouse not content any number  "+email+"</h1>");
			}
		}
		pw.println("<h1><a href='form.html'>home</a></h1>");
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
	
}
