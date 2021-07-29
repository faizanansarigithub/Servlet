package com.fa.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/centralurl")
public class CentralGSTServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	PrintWriter pw=null;
	ServletContext sc=null,fc=null;
	pw=res.getWriter();
	res.setContentType("text/html");
	float billamt=Float.parseFloat(req.getParameter("amt"));
	if(billamt>50000)
		pw.println("<br>Centarl GST (10%) is :::"+(billamt*.1));
	else if(billamt>30000)
		pw.println("<br>Central GST (8%) is :::"+(billamt*.08));
	else if(billamt>15000)
		pw.println("<br>Central GST (6%) is :::"+(billamt*.06));
	else 
		pw.println("<br>Central GST (3%) is :::"+(billamt*.03));
	
		sc=getServletContext();
		fc=sc.getContext("/StateGST");
		RequestDispatcher rd=fc.getRequestDispatcher("/stateurl");
		rd.include(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}

}
