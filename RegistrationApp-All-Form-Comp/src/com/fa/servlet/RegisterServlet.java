package com.fa.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null,addrs=null,gender=null,ms=null,qly=null,crs[]=null,hb[]=null,fburl=null;
		String dob=null,dtime=null,time=null,month=null,week=null,email=null,color=null,salary=null,search=null;
		int age=0,fnumber=0,pin=0;
		long phone=0L;
		//get PrintWriter
		pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		//get req components
		name=req.getParameter("ename");
		age=Integer.parseInt(req.getParameter("age"));
		addrs=req.getParameter("addrs");
		gender=req.getParameter("gender");
		phone=Long.parseLong(req.getParameter("phone"));
		ms=req.getParameter("ms");
		qly=req.getParameter("qly");
		crs=req.getParameterValues("crs");
		hb=req.getParameterValues("bh");
		fburl=req.getParameter("url");
		dob=req.getParameter("dob");
		dtime=req.getParameter("dtime");
		time=req.getParameter("time");
		month=req.getParameter("month");
		week=req.getParameter("week");
		email=req.getParameter("email");
		color=req.getParameter("color");
		salary=req.getParameter("salry");
		fnumber=Integer.parseInt(req.getParameter("fnumber"));
		pin=Integer.parseInt(req.getParameter("pin"));
		search=req.getParameter("search");
		if(gender.equalsIgnoreCase("M")) {
			if(age<=5)
				pw.println("<h1 style='color:red;text-align:center'> Master. " +name+ " You are  BaBy Boy</h1>");
			else if(age<=12)
				pw.println("<h1 style='color:red;text-align:center'>Master. " +name+ " You are Small Boy</h1>");
			else if(age<=18)
				pw.println("<h1 style='color:red;text-align:center'>Mr. " +name+ " You are Teenage Boy</h1>");
			else if(age<=35)
				pw.println("<h1 style='color:red;text-align:center'>Mr. " +name+ " You are Young Man</h1>");
			else if(age<=50)
				pw.println("<h1 style='color:red;text-align:center'>Mr. " +name+ " You are Midle Age Man</h1>");
			else
				pw.println("<h1 style='color:red;text-align:center'>Mr. " +name+ " You are Old Man(Budha)</h1>");
		}
		else {
			if(age<=5)
				pw.println("<h1 style='color:red;text-align:center'> Master. " +name+ " You are  BaBy Girl</h1>");
			else if(age<=12)
				pw.println("<h1 style='color:red;text-align:center'>Master. " +name+ " You are Small Girl</h1>");
			else if(age<=18)
				pw.println("<h1 style='color:red;text-align:center'>Ms. " +name+ " You are Teenage Girl</h1>");
			else if(age<=35)
				pw.println("<h1 style='color:red;text-align:center'>Msr. " +name+ " You are Young Girl</h1>");
			else if(age<=50)
				pw.println("<h1 style='color:red;text-align:center'>Msr. " +name+ " You are Midle Age ladies</h1>");
			else
				pw.println("<h1 style='color:red;text-align:center'>Msr. " +name+ " You are Old ladies</h1>");
		}
		pw.println("<br><b><h2>Form Data </h1></b>");
		pw.println("<br><b>Name ::" +name+ "</b>");
		pw.println("<br><b>age ::" +age+ "</b>");
		pw.println("<br><b>addrs ::" +addrs+ "</b>");
		pw.println("<br><b>Phone ::" +phone+ "</b>");
		pw.println("<br><b>Gender ::" +gender+ "</b>");
		pw.println("<br><b>Married Status ::" +ms+ "</b>");
		pw.println("<br><b>Qualification ::" +qly+ "</b>");
		pw.println("<br><b>Course  ::" +Arrays.toString(crs)+ "</b>");
		pw.println("<br><b>Hobise  ::" +Arrays.toString(hb)+ "</b>");
		pw.println("<br><b>Facebook URL ::" +fburl+ "</b>");
		pw.println("<br><b> DOB ::" +dob+ "</b>");
		pw.println("<br><b> DOB Time ::" +dtime+ "</b>");
		pw.println("<br><b> DOB Week ::" +week+ "</b>");
		pw.println("<br><b> DOB Month ::" +month+ "</b>");
		pw.println("<br><b> Email  ::" +email+ "</b>");
		pw.println("<br><b> Color  ::" +color+ "</b>");
		pw.println("<br><b> Salary  ::" +salary+ "</b>");
		pw.println("<br><b> Favourite number ::" +fnumber+ "</b>");
		pw.println("<br><b> PIN number ::" +pin+ "</b>");
		pw.println("<br><b> Search  ::" +search+ "</b>");
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

}
