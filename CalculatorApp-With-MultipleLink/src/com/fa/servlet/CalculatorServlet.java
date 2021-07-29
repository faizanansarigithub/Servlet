package com.fa.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculatorServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String pval=null;
		float val1=0.0f,val2=0.0f;
		Calendar calendar=null;
		//get printWriter
		pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		//read addition req parameter
		pval=req.getParameter("s1");
		//read form data only when hyper link are not clicked
		if(!pval.equalsIgnoreCase("link1")&& !pval.equalsIgnoreCase("link2")) {
			val1=Float.parseFloat(req.getParameter("t1"));
			val2=Float.parseFloat(req.getParameter("t2"));
		}
		else {
			calendar=Calendar.getInstance();
		}
		//different logic
		if(pval.equalsIgnoreCase("add")) {
			pw.println("<h1 style='color:blue;text-align:center'> Addition :: "+(val1+val2)+"</h1>");
		}
		else if(pval.equalsIgnoreCase("sub")) {
			pw.println("<h1 style='color:blue;text-align:center'> Substration :: "+(val1-val2)+"</h1>");
		}
		
		else if(pval.equalsIgnoreCase("mul")) {
			pw.println("<h1 style='color:blue;text-align:center'> Multiplication :: "+(val1*val2)+"</h1>");
		}
		
		else if(pval.equalsIgnoreCase("div")) {
			pw.println("<h1 style='color:blue;text-align:center'> Division :: "+(val1/val2)+"</h1>");
		}
		
		else if(pval.equalsIgnoreCase("link1")) {
			pw.println("<h1 style='color:blue;text-align:center'> Current Day in the year :: "+calendar.get(Calendar.DAY_OF_YEAR)+"</h1>");
		}
		
		else{
			pw.println("<h1 style='color:blue;text-align:center'> Current Week Number of the year :: "+calendar.get(Calendar.WEEK_OF_YEAR)+"</h1>");
		}
		pw.println("<br><a href='form.html'><img src='images/home.gif' width='50' height='50'/></a>");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
}
