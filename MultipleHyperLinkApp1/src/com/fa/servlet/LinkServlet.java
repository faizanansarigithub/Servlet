package com.fa.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinkServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String url=null;
		Calendar calendar=null;
		//get printWriter
		pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		//read req param values
		url=req.getParameter("value");
		//calendar object
		calendar=Calendar.getInstance();
		//Differentiate logic for hyperlink
		if(url.equalsIgnoreCase("link1")) {
			pw.println("<h1 style='color:red;text-align:center'> Current Month is "+new SimpleDateFormat("MMM").format(calendar.getTime())+"</h1>");
			
		}
		else if(url.equalsIgnoreCase("link2")) {
			pw.println("<h1 style='color:red;text-align:center'> Current Day  is "+calendar.DAY_OF_WEEK+"</h1>");
			
		}
		
		else if(url.equalsIgnoreCase("link3")) {
			pw.println("<h1 style='color:red;text-align:center'> Current Week Day "+calendar.DAY_OF_WEEK_IN_MONTH+"</h1>");
		}
		else {
			pw.println("<h1 style='color:red;text-align:center'> Current year is "+new SimpleDateFormat("YYYY").format(calendar.getTime())+"</h1>");
		}
		pw.println("<h1 style='color:red;text-align:center'> <a href='links.html'>Home</a></h1>");
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	

}
