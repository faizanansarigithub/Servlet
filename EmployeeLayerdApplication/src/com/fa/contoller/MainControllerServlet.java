package com.fa.contoller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fa.dto.EmployeeDTO;
import com.fa.services.Services;
import com.fa.services.ServicesImpl;
import com.fa.vo.EmployeeVO;


@WebServlet("/controller")
public class MainControllerServlet extends HttpServlet {
	private Services services;
  
	public void init()  {
		 services =new ServicesImpl(); 
	}

	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		
		EmployeeDTO dto=null;
		EmployeeVO vo=null;
		String result=null;
		pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		vo=new EmployeeVO();
		vo.setEname(req.getParameter("ename"));
		vo.setEadd(req.getParameter("eadd"));
		vo.setDept(req.getParameter("dept"));
		vo.setSalary(req.getParameter("salary"));
		
		//convert VO to DTO
		dto=new EmployeeDTO();
		dto.setEname(vo.getEname());
		dto.setEadd(vo.getEadd());
		dto.setDept(vo.getDept());
		dto.setSalary(Integer.parseInt(vo.getSalary()));
		try {
		result= services.register(dto);
		pw.println("<br> <h1 style='color:green;text-align:center'>"+result+"</h1>");
	}
	catch(Exception e) {
		e.printStackTrace();
		pw.println("<br> <h1 style='color:red;text-align:center'>Internal Problem</h1>");
	}
		pw.println("<br><br> <a href='employee_register.html'>Home</a>");
		pw.close();
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}

}
