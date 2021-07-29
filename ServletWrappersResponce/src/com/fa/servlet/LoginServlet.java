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
		String name=null,fathername;
		//get print writer
		pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		//get request param
		name=req.getParameter("firstname").trim();
		fathername=req.getParameter("fathername").trim();
		if(name.equalsIgnoreCase("faizannit")&& fathername.equalsIgnoreCase("moin")) {
			pw.println("<h1 style='color:green;text-align:center;'>Valid Creadiention <h1> "+name+"        "+fathername);
		}
		else {
			pw.println("<h1 style='color:red;text-align:center;'>InValid Creadiention <h1>"+name+"        "+fathername);
		}
		pw.println("<h1 style='color:red;text-align:center;'><a href='index.html'>Goto Home</a><h1> ");
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
}
