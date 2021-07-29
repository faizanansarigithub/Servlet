package com.fa.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null, pwd=null;
		//get printWriter
		pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		//get req obj
		name=req.getParameter("username");
		pwd=req.getParameter("pwd");
		if(name.equalsIgnoreCase("faizan@gmail.com")&& pwd.equalsIgnoreCase("faizan")) {
			pw.println("<h1 style='color:cyan;text-align:center'>Valid Credantial</h1>");
		}
		else
			pw.println("<br><br><h1 style='color:red;text-align:center'>InValid Credantial</h1>");
		
		pw.println("<br><br><h1 >"+name+"       "+pwd+"</h1>");
		
		pw.println("<a href='index.html'>Goto home</a>");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

}
