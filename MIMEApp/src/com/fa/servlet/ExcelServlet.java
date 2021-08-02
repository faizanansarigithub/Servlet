//HtmlServlet.java
package com.fa.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ExcelServlet extends HttpServlet{
	protected void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		PrintWriter pw=null;
		//get PrintWriter
		pw=res.getWriter();
		//set response content type/MIME type
		res.setContentType("application/vnd.ms-excel");
		//write output message to response object
		pw.println("<table align='center' border='1' bgcolor='cyan'>");
		pw.println("<tr><th> Country </th><th>President/PrimeMinister</th></tr>");
		pw.println("<tr><td>India</td><td>Modi</td></tr>");
		pw.println("<tr><td>Pakistan</td><td>Imran Khan</td></tr>");
		pw.println("<tr><td>USA</td><td>Trump</td></tr>");
		pw.println("<tr><td>china</td><td>Xi-xing ping</td></tr>");
		pw.println("</table>");

		//close stream
		pw.close();

	}
}