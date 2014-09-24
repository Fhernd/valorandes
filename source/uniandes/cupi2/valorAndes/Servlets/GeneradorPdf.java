package uniandes.cupi2.valorAndes.Servlets;

import uniandes.cupi2.valorAndes.DAO.*;

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
		
		// Creación de instancia `ConsultaDAO`:
		ConsultaDAO cdao = new ConsultaDAO();
		
		// Obtención del objeto `Connection`:
		Connection conexion;
		try 
		{			
			conexion = cdao.establecerConexion(cdao.cadenaConexion, cdao.usuario, cdao.clave);
			byte[] bytesReporte = JasperRunManager.runReportToPdf("", null, conexion);
			
			res.setContentLength(bytesReporte.length);
			
			ServletOutputStream outputStream = res.getOutputStream();
			outputStream.write(bytesReporte, 0, bytesReporte.length);
			
			conexion.close();
			
			outputStream.flush();
			outputStream.close();
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/* 

		// writing html in the stream
		pw.println("<html><body>");
		pw.println("<embed src=\"http://www.tutorialspoint.com/servlets/pdf/servlets_interview_questions.pdf\" height=\"900\" width=\"800\"></embed>");
		pw.println("</body></html>");

		pw.close();// closing the stream
		
		*/
	}
}
