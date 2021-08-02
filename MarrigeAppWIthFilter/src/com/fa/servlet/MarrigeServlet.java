package com.fa.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarrigeServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("MarrigeServlet:: doPost()");
		PrintWriter pw=null;
		String name=null,gender=null,tage=null;
		int age=0;
		ServletContext sc=null;
		//get PrintWriter
		pw=res.getWriter();
		//set Content Type
		res.setContentType("text/html");
		//get Form data (req object )
		name=req.getParameter("pname");
		gender=req.getParameter("gender");
		tage=req.getParameter("page");
		if(name.length()==0 || name.equals("") || name==null) {
			pw.println("<li style='color:red'> name is required please enter name</li>");
			return;
		}
		if(name.length()<5 || name.length()>15) {
			pw.println("<li style='color:red'> name should be minimum 5 char and maximum 15 char </li>");
			return;
		}
		
		if(tage.length()==0 ||name.equals("")||name==null) {
			pw.println("<li style='color:red'> age is required please enter age </li>");
			return;
		}
		else {
			try {
				age=Integer.parseInt(tage);
			}
			catch(NumberFormatException nfe) {
				pw.println("<li style='color:red'> age must have numeric value </li>");
				return;
			}
		}
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
		sc=getServletContext();
		pw.println("<br><br> request count ::: "+sc.getAttribute("reqCount"));
		pw.println("<h1 style='color:blue'><a href='input.jsp'>goto home</a></h1>");
		//close stream
		pw.close();
	}//doPost(-,-)
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("MarrigeServlet.doGet()");
		doPost(req, res);
	}
}//class
