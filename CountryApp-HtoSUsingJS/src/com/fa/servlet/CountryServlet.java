package com.fa.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CountryServlet extends HttpServlet {
	
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		int code=0;
		String[] capitals= {"new delhi","Islamabad","Washington, D.C.","Beijing","Colombo"};
		//get printwriter
		pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		//get country code
		code=Integer.parseInt(req.getParameter("country"));
		//display the capitals
		pw.println("<br><h1 style='color:green;text-align:center'> The Capital is :: "+capitals[code]+"</h1>");
		//add home link
		pw.println("<br><h1><a href='form.html'>home</a></h1>");
	}
	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
	
	

}
