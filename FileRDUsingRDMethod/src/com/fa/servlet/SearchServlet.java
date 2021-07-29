package com.fa.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/searchurl")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String engine=null,url=null,input=null;
		
		pw=res.getWriter();
		res.setContentType("text/html");
		
		engine=req.getParameter("search");
		input=req.getParameter("ss");
		
		if(engine.equalsIgnoreCase("google"))
			url="https://www.google.com/search?q="+input;
		else if(engine.equalsIgnoreCase("yahoo"))
			url="https://in.search.yahoo.com/search?p="+input;
		else if(engine.equalsIgnoreCase("bing"))
			url="https://www.bing.com/search?q="+input;
		else
			url="https://duckduckgo.com/?q="+input;
		res.sendRedirect(url);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}

}