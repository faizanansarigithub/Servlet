package com.shruti.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/loginurl")
public class Login extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String user=null,pwd=null;
		//get printWriter
		pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		//get form data
		user=req.getParameter("username");
		pwd=req.getParameter("userpass");
		if(user.equalsIgnoreCase("admin")&& pwd.equalsIgnoreCase("admin")) {
			pw.println("<h1> valid</h1>");
			req.getRequestDispatcher("data.html").include(req, res);
		}
		else {
			pw.println("<h1> Invalid</h1>");
		}
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

}
