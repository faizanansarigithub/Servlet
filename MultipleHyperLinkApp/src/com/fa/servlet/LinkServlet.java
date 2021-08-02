package com.fa.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinkServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String pval=null;
		Locale locales[]=null;
		//get printWriter
		pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		//read req param values
		pval=req.getParameter("s1");
		//get All available locale
		locales=Locale.getAvailableLocales();
		//differentiate logic for hyperlink
		if(pval.equalsIgnoreCase("link1")) {
			pw.println("<b> get all launguage</b>");
			for(Locale l:locales) {
				pw.println("<b>"+l.getDisplayLanguage()+"  ,  </b>");
			}
			
		}
		else if(pval.equalsIgnoreCase("link2")) {
			pw.println("<b> get all country</b>");
			for(Locale l:locales) {
				pw.println("<b>"+l.getDisplayCountry()+"  ,  </b>");
				
			}
		}
		else {
			pw.println("<br> System Properties are");
			pw.println("<b>"+System.getProperties()+"  ,   <b>");
		}
		pw.println("<h1><a href='link.html'>Go Home</a>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
