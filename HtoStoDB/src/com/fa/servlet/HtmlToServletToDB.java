package com.fa.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/dburl")
public class HtmlToServletToDB extends HttpServlet {
private static final String SELECT_EMP_BY_NO="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=?";
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		PrintWriter pw=null;
		Connection con=null;
		PreparedStatement ps;
		ResultSet rs=null;
		int eno=0;
		try{
		//get Print Writer
		pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		//get form data
		eno=Integer.parseInt(req.getParameter("eid"));
		//load jdbc driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//establish the conneetion 
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","manager");
		//create PraperedStatemet obj
		ps=con.prepareStatement(SELECT_EMP_BY_NO);
		//set parameter 
		ps.setInt(1, eno);
		//execute the query
		rs=ps.executeQuery();
		//process the ResultSet
		if(rs.next()){
			pw.println("<table border='1' align='center' bgcolor='pink'>");
			pw.println("<tr bgcolor='red'><th>EmpNo</th><th>EmpName</th><th>EmpJob</th><th>EmpSal</th><th>EmpDeptNo</th></tr>");
			pw.println("<tr bgcolor='yellow'><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td></tr>");
			pw.println("</table>");
		}
		else{
			pw.println("<h1 style='color:red;text-align:center'>No Employee Found</h1>");
		}
		//add hyper link
		pw.println("<br><h1 style='color:pink;text-align:center;'><a href='search.html'>GoTo home</a>");
		}//try
		catch(Exception e){
			e.printStackTrace();
			pw.println("<h1 style='color:red;text-align:center'>Internal Problem try again</h1>");
			pw.println("<br><h1 style='color:pink;text-align:center;'><a href='search.html'>GoTo home</a>");
		}
	}//method

}
