package com.fa.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarrigeServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null,gender=null,tage=null;
		int age=0;
		//get PrintWriter
		pw=res.getWriter();
		//set Content Type
		res.setContentType("text/html");
		//get Form data (req object )
		name=req.getParameter("pname");
		gender=req.getParameter("gender");
		tage=req.getParameter("page");
		age=Integer.parseInt(tage);
		//write b. logic 
		if(gender.equalsIgnoreCase("M")) {
			if(age>=21) {
				pw.println("<h1 style='color:green;text-align:center'> Mr : "+name+" You are eligible for marrige</h1>");
			}//if
			else {
				pw.println("<h1 style='color:red;text-align:center'>  Mr : "+name+" You are Not eligible for marrige</h1>");
			}//else
		}//if
		
		else if(gender.equalsIgnoreCase("F")) {
			if(age>=18) {
				pw.println("<h1 style='color:green;text-align:center'> Miss : "+name+" You are eligible for marrige</h1>");
			}//if
			else {
				pw.println("<h1 style='color:red;text-align:center'> Miss : "+name+" You are Not eligible for marrige</h1>");
			}//else
		}//if
		pw.println("<h1 style='color:blue'><a href='input.html'>goto home</a></h1>");
	}//doPost(-,-)
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
}//class
