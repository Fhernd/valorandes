package uniandes.cupi2.valorAndes.Servlets;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import net.sf.jasperreports.engine.*;
import java.io.*;
import java.sql.*;

public class GeneradorPdf extends HttpServlet 
{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException 
	{
		res.setContentType("application/PDF");// setting the content type
		PrintWriter pw = res.getWriter();// get the stream to write the data

		// writing html in the stream
		pw.println("<html><body>");
		pw.println("<embed src=\"http://www.tutorialspoint.com/servlets/pdf/servlets_interview_questions.pdf\" ></embed>");
		pw.println("</body></html>");

		pw.close();// closing the stream
	}
}
