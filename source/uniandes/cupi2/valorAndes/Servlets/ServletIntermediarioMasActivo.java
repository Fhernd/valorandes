/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n18_colegioWeb
 * Autor: Pablo Barvo - Apr 26, 2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.valorAndes.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;













import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uniandes.cupi2.valorAndes.Fachada.ValorAndes;
import uniandes.cupi2.valorAndes.ValueObjetcts.Valor;



/**
 * Servlet de muestra de resultados de una búsqueda
 */
@SuppressWarnings("serial")
public class ServletIntermediarioMasActivo extends HttpServlet
{

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

	/**
     * Maneja un pedido GET de un cliente
     * @param request Pedido del cliente
     * @param response Respuesta
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
    {
        procesarPedido( request, response );
    }

    /**
     * Maneja un pedido POST de un cliente
     * @param request Pedido del cliente
     * @param response Respuesta
     */
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
    {
        procesarPedido( request, response );
    }

    /**
     * Procesa el pedido de igual manera para todos
     * @param request Pedido del cliente
     * @param response Respuesta
     * @throws IOException Excepción de error al escribir la respuesta
     */
    private void procesarPedido( HttpServletRequest request, HttpServletResponse response ) throws IOException
    {
    	PrintWriter salida = response.getWriter( );
    	try
        {
            //
            // Saca los parámetros de la búsqueda
            String tipoBusqueda = request.getParameter( "tipo.busqueda" );
            if(tipoBusqueda.trim().toLowerCase().equals("tipo"))
            {
            	String id_tipoValor = request.getParameter( "tipo.valor" ).trim().toLowerCase(); 
            	System.out.println("Se ha detectado búsqueda por tipo de valor");
            	//Realizar la consulta
            }
			else if(tipoBusqueda.trim().toLowerCase().equals("continuar"))
			{
				String id_valor=request.getParameter( "valor" ).trim().toLowerCase(); 
				if(id_valor!="")
				{
					//Realizar la consulta
					System.out.println("Se ha detectado una búsqueda por valor");
				}								
			}
			else
			{
				imprimirAcciones(salida, ValorAndes.darInstancia().darTodosLosValores().iterator());
			}
		}
        catch(Exception n)
        {
        	System.out.println("Error al procesar solicitud de agregado");
        }

    }
    
    private void imprimirAcciones (PrintWriter salida, Iterator<Valor> valores)
    {
    	String html=""+
    			"<!DOCTYPE HTML>\r\n"+
    			"<!--\r\n"+
    			"	Miniport 2.5 by HTML5 UP\r\n"+
    			"	html5up.net | @n33co\r\n"+
    			"	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)\r\n"+
    			"-->\r\n"+
    			"<html>\r\n"+
    			"	<head>\r\n"+
    			"		<title>ValorAndes+</title>\r\n"+
    			"		\r\n"+
    			"		 <!-- Bootstrap -->\r\n"+
    			"    	<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n"+
    			"		\r\n"+
    			"		\r\n"+
    			"		<link href=\"http://fonts.googleapis.com/css?family=Open+Sans:300,600,700\" rel=\"stylesheet\" />\r\n"+
    			"		<script src=\"js/jquery.min.js\"></script>\r\n"+
    			"		<script src=\"js/config.js\"></script>\r\n"+
    			"		<script src=\"js/skel.min.js\"></script>\r\n"+
    			"		<noscript>\r\n"+
    			"			<link rel=\"stylesheet\" href=\"css/skel-noscript.css\" />\r\n"+
    			"			<link rel=\"stylesheet\" href=\"css/style.css\" />\r\n"+
    			"			<link rel=\"stylesheet\" href=\"css/style-desktop.css\" />\r\n"+
    			"		</noscript>\r\n"+
    			"		<!--[if lte IE 9]><link rel=\"stylesheet\" href=\"css/ie9.css\" /><![endif]-->\r\n"+
    			"		<!--[if lte IE 8]><script src=\"js/html5shiv.js\"></script><link rel=\"stylesheet\" href=\"css/ie8.css\" /><![endif]-->\r\n"+
    			"		<!--[if lte IE 7]><link rel=\"stylesheet\" href=\"css/ie7.css\" /><![endif]-->\r\n"+
    			"\r\n"+
    			"\r\n"+
    			"	</head>\r\n"+
    			"	<body>\r\n"+
    			"\r\n"+
    			"		<!-- Nav -->\r\n"+
    			"			<nav id=\"nav\">\r\n"+
    			"				<ul class=\"container\">\r\n"+
    			"					<li><a href=\"index.html\"><img src=\"images/valores/home.png\"  height=\"90\" width=\"90\"  alt=\"Home Valorantes\" style=\"height : 73px;padding: 0px; margin: 0px; width : 61px;\"/></a></li>\r\n"+
    			"				</ul>\r\n"+
    			"			</nav>\r\n"+
    			"			\r\n"+
    			"		<!-- Mejor intermediario -->\r\n"+
    			"			<div class=\"wrapper wrapper-style3 \">\r\n"+
    			"				<article class=\"container\" id=\"masActivo\">	\r\n"+
    			"				<div class=\"row\">\r\n"+
    			"						<div class=\"4u\">\r\n"+
    			"						</br></br></br>\r\n"+
    			"							<span class=\"me image image-full\" ><img src=\"images/valores/best.png\" alt=\"Valores más movidos\"  style=\"\"/></span>\r\n"+
    			"						</div>	\r\n"+
    			"						<div class=\"8u\">				\r\n"+
    			"							<header>\r\n"+
    			"								<h1 align=\"center\" style=\"line-height: 40px\"></br></br>Intermediario Más Activo</h1>\r\n"+
    			"														\r\n"+
    			"									<header><p style=\"font-size: 25px\" align=\"center\">\r\n"+
    			"									Seleccione el valor para el que se realizará la consulta\r\n"+
    			"									</p></header>			\r\n"+
    			"							</header>\r\n"+
    			"							\r\n"+
    			"							<form action=\"mejor.htm\" class=\"ok\" method=\"get\">\r\n"+
    			"							<p style=\"\" align=\"center\" >\r\n"+
    			"								<input type=\"hidden\" name=\"tipo.busqueda\" value=\"continuar\">\r\n"+
    			"								<select name=\"valor\" title=\"Seleccione el valor\"  style=\"width: 750px; display: inline;vertical-align: middle; margin: 5px;\" required onchange=\"completarFomulario(this)\" onclick=\"completarFomulario(this)\"  onmouseover=\"completarFomulario(this)\" onselect=\"completarFomulario(this)\"  onmousemove=\"completarFomulario(this)\" onmouseout=\"completarFomulario(this)\">\r\n"+
    			"								<option value=\"\">--seleccione--</option>\r\n";
    			while (valores.hasNext()){
					Valor actual = valores.next();
    				html+="								<option value=\""+actual.getId_valor()+"\">("+actual.getId_valor()+") "+actual.getNombreValor()+" - "+actual.getEmisor().getNombre()+": "+actual.getTipo_Valor().getNombre_valor()+"</option>\r\n";
				}		
    			
    			html+="								</select>\r\n"+
    			"							</p>\r\n"+
    			"							<div id=\"here\">		\r\n"+
    			"							</div>									\r\n"+
    			"							</form>\r\n"+
    			"							<script type=\"text/javascript\">							\r\n"+
    			"							function completarFomulario(tipoc)\r\n"+
    			"							{\r\n"+
    			"								var t2 = document.getElementById(\"here\");\r\n"+
    			"									var inHtml = \"\";									\r\n"+
    			"									if(tipoc.value!='')\r\n"+
    			"									{\r\n"+
    			"										inHtml += \"<div class=\\\"row\\\"> <p></p>\"+\r\n"+
    			"										\"								<div class=\\\"12u\\\" align=\\\"center\\\">												\"+\r\n"+
    			"										\"									<input class=\\\"button form-button-submit\\\" type=\\\"submit\\\" name=\\\"consultar\\\" id=\\\"mejor.consultar\\\" value=\\\"Consultar\\\"/>\"+\r\n"+
    			"										\"								</div>\"+\r\n"+
    			"										\"							</div>\";						                \r\n"+
    			"						                t2.innerHTML = inHtml;\r\n"+
    			"									}\r\n"+
    			"									else\r\n"+
    			"										{\r\n"+
    			"										t2.innerHTML = inHtml;\r\n"+
    			"										}								\r\n"+
    			"							}\r\n"+
    			"				\r\n"+
    			"							</script>\r\n"+
    			"							\r\n"+
    			"						</div>\r\n"+
    			"					</div>\r\n"+
    			"					<p></br></br></br></br></br></p>\r\n"+
    			"				</article>\r\n"+
    			"			</div>\r\n"+
    			"			\r\n"+
    			"			\r\n"+
    			"					\r\n"+
    			"		<!-- Administrar -->\r\n"+
    			"			<div class=\"wrapper wrapper-style4\">\r\n"+
    			"					<footer>\r\n"+
    			"						<ul id=\"copyright\">\r\n"+
    			"							<li>&copy; 2013 Jane Doe</li>\r\n"+
    			"							<li>Brahian David Rangel</li>\r\n"+
    			"							<li>Design: <a href=\"http://html5up.net/\">HTML5 UP</a></li>\r\n"+
    			"						</ul>\r\n"+
    			"					</footer>\r\n"+
    			"				</div>\r\n"+
    			"			</div>\r\n"+
    			"\r\n"+
    			"\r\n"+
    			"	</body>\r\n"+
    			"</html>\r\n";
    	
    		salida.println(html);
    }
}
