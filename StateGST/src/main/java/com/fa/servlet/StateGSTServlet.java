package com.fa.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/stateurl")
public class StateGSTServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		ServletContext sc=null,fc=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		float billamt=Float.parseFloat(req.getParameter("amt"));
		if(billamt>50000)
			pw.println("<br>State GST (0.8%) is :::"+(billamt*.08));
		else if(billamt>30000)
			pw.println("<br>State GST (0.6%) is :::"+(billamt*.06));
		else if(billamt>15000)
			pw.println("<br>State GST (0.3%) is :::"+(billamt*.03));
		else 
			pw.println("<br>State GST (0.1%) is :::"+(billamt*.01));
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
