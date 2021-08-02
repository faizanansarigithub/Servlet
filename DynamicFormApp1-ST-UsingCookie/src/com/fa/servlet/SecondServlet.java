package com.fa.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/s2url")
public class SecondServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null,addrs=null,ms=null;
		String txt1=null,txt2=null;
		Cookie ck[]=null;
		//get PrintWriter
		pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read data from req obj
		ck=req.getCookies();
		if(ck!=null) {
			name=ck[0].getValue();
			addrs=ck[1].getValue();
			ms=ck[2].getValue();
		}
		
		
	
		txt1=req.getParameter("f2txt1");
		txt2=req.getParameter("f2txt2");
		pw.println("Name is "+name +" Address "+addrs+" Marriage Status "+ms+"<br>");
		pw.println("spouse name "+txt1 +" Number Of Kids "+txt2+"<br>");
		//close the stream
		pw.close();
	}

	
	public	 void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}

}
