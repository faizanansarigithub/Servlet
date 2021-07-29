package com.fa.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.commons.io.IOUtils;


@WebServlet("/reporturl")
public class ReportServlet extends HttpServlet {
	private static final String GET_ALL_DETAILS="SELECT FSNO,ENAME,	EADDRS,EPHOTO,ERESUME FROM FILEUPLOAD";
	@Resource(name="DsJndi")
	private DataSource ds;
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String param=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ServletOutputStream sos=null;
		File file=null;
		String filePath=null;
		String mimeType=null;
		InputStream is=null;
		
		sos=res.getOutputStream();
		res.setContentType("text/html");
		param=req.getParameter("type");
		if(param.equalsIgnoreCase("report")) {
			try {
				//get polled connection object
				con=ds.getConnection();
				ps=con.prepareStatement(GET_ALL_DETAILS);
				rs=ps.executeQuery();
				sos.println("<table border='1' bgcolor='cyan'>");
				sos.println("<tr><th>EMPNO </th><th>EMP NAME </th><th>EMP ADDRS </th><th>EMP PHOTO </th> <th>EMP RESUME </th></tr>");
				while(rs.next()) {
					sos.println("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td><a href='reporturl?type=download&path="+rs.getString(4)+"'>Download</a></td><td>"+"<a href='reporturl?type=download&path="+rs.getString(5)+"'>Download</a></td></tr>");
				}//while
				sos.println("</table>");
			}//trye
			catch (Exception e) {
				e.printStackTrace();
			}
		}else {//downloading
			filePath=req.getParameter("path");
			file =new File(filePath);
			//get the length of the file and making it response length
			res.setContentLengthLong(file.length());
			//get MIME type 
			mimeType=getServletContext().getMimeType(filePath);
			res.setContentType(mimeType!=null?mimeType:"application/octet-stream");
			is=new FileInputStream(file);
			//set value to content-disposition
			res.addHeader("Content-Disposition","attechment;filename="+file.getName());
			//copy file
			IOUtils.copy(is, sos);
			//close stream
			is.close();
			sos.close();
			}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
