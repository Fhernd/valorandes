package uniandes.cupi2.valorAndes.Servlets;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;

import uniandes.cupi2.valorAndes.Fachada.ValorAndes;
import uniandes.cupi2.valorAndes.ValueObjetcts.Emisor;
import uniandes.cupi2.valorAndes.ValueObjetcts.Intermediario;
import uniandes.cupi2.valorAndes.ValueObjetcts.Inversionista;
import uniandes.cupi2.valorAndes.ValueObjetcts.TipoRentabilidad;
import uniandes.cupi2.valorAndes.ValueObjetcts.TipoValor;


public class HomePlus 
{
	private PrintWriter out;
	private ValorAndes instancia;
	private LinkedList<Inversionista> inversionistasObtenidos;
	private LinkedList<Emisor> emisoresObtenidos;
	private LinkedList<TipoValor> tiposProductosObtenidos;
	private LinkedList<TipoRentabilidad> tiposRentabilidadObtenidos;
	private LinkedList<Intermediario> intermediariosObtenidos;
	
	
	public HomePlus(PrintWriter salida)
	{
		out = salida;
		instancia= ValorAndes.darInstancia();
		inversionistasObtenidos = instancia.darInversionistas();
		emisoresObtenidos = instancia.darEmisores();
		tiposProductosObtenidos = instancia.darTiposValor();
		tiposRentabilidadObtenidos = instancia.darTiposRentabilidad();
		intermediariosObtenidos = instancia.darIntermediarios();
		out.println(cabecera);
		printFormulario1();
		out.println(parte2);
		printFormulario2();
		out.println(parte3);
		printFormulario3();
		out.println(parte4);
		printFormulario4();
		out.println(parte4b);
		printFormulario4b();
		out.println(parte5a);
		printFormulario5a();
		out.println(parte5b);
		printFormulario5b();
		out.println(parte6);
		printFormulario6();
		out.println(parte6b);
		//Cambiar orden, primero imprime formulario y luego parte
		printFormulario7();
		out.println(parte7);
		printFormulario8();
		out.println(parte8);
		printFormulario9();
		out.println(parte9);
		printFormulario10();
		out.println(parte10);
		printFormulario11();
		out.println(parte11);
		printFormulario11bRentabilidades();
		out.println(parte11b);
		printFormulario12();
		out.println(parte12);
		printFormulario13();
		out.println(parte13);
		printFormulario14();
		out.println(parte14);
		
		
	}
	
	private void printFormulario1()
	{
		String add ="";
		Iterator<Inversionista> itera = inversionistasObtenidos.iterator();
		while(itera.hasNext())
		{
			Inversionista actual = itera.next();
			add+="<option value=\""+actual.getId_Inversionista()+"\">( "+actual.getId_Inversionista() + ") "+actual.getNombre()+"</option>\r\n";
			
		}
		out.println(add);
	}
	
	private void printFormulario2()
	{
		String add="";
		Iterator<TipoValor> itera = tiposProductosObtenidos.iterator();
		while(itera.hasNext())
		{
			TipoValor productoActual = itera.next();
			add+="<option value=\""+productoActual.getId_Valor()+"\"> ("+productoActual.getId_Valor()+") "+productoActual.getNombre_valor()+ "</option>\r\n";
		}		
		out.println(add);
	}
	
	private void printFormulario3()
	{
		String add="";
		Iterator<TipoValor> itera = tiposProductosObtenidos.iterator();
		while(itera.hasNext())
		{
			TipoValor productoActual = itera.next();
			add+=""+
					"								else if (tipoc.value=='"+productoActual.getId_Valor()+"') "+
					"								{\r\n"+
					"										var inHtml = \"\";\r\n"+
					"										t3.disabled=false;										\r\n"+
					"										inHtml += \"<option value=\\\"\\\">--Sel. Empresa Oferente--</option>\";\r\n";
			Iterator<Emisor> empresasTipoActual = instancia.darEmpresasOfertanTipo(""+productoActual.getId_Valor()).iterator();
			while (empresasTipoActual.hasNext())
			{
				Emisor empresaActual = empresasTipoActual.next();
				add+="inHtml += \"<option value=\\\""+empresaActual.getNIT()+"\\\">("+empresaActual.getNIT()+") "+empresaActual.getNombre()+"</option>\";\r\n";
			}
			add+=""+												
					"						                t3.innerHTML = inHtml;					\r\n"+
					"								}\r\n";
		}		
		out.println(add);
		
		
			
	}
	
	private void printFormulario4b()
	{
		String add="";
		Iterator<Emisor> itera = emisoresObtenidos.iterator();
		while(itera.hasNext())
		{
			Emisor emisorActual = itera.next();
			add+="else if(tipoc.value=='"+emisorActual.getNIT()+"')"+ 
					"													{\r\n"+
					"														t2.disabled=false;\r\n"+
					"														var inHtml = \"\";\r\n"+
					"														inHtml +=\"<option value=\\\"\\\">--Producto--</option>\";\r\n";
			
			Iterator<TipoValor> productosEmiActual = instancia.darTiposOfertadosEmpresa(emisorActual.getNIT()).iterator();
			while(productosEmiActual.hasNext())
			{
				TipoValor tipoVrActual = productosEmiActual.next();
				add+="														inHtml += \"<option value=\\\""+tipoVrActual.getId_Valor()+"\\\">("+tipoVrActual.getId_Valor()+") "+tipoVrActual.getNombre_valor()+"</option>\";\r\n";
			}
					
			add+="														t2.innerHTML = inHtml;						\r\n"+
			    "													}\r\n";
		}		
		out.println(add);
	}
	private void printFormulario4()
	{
		String add="";
		Iterator<Emisor> itera = emisoresObtenidos.iterator();
		while(itera.hasNext())
		{
			Emisor emisorActual = itera.next();
			add+="												   <option value=\""+emisorActual.getNIT()+"\">("+emisorActual.getNIT()+") "+emisorActual.getNombre()+"</option>\r\n";
		}		
		out.println(add);
	}
	
	
	
	
	private void printFormulario5a()
	{
		String add="";
		Iterator<Emisor> itera = emisoresObtenidos.iterator();
		while(itera.hasNext())
		{
			Emisor emisorActual = itera.next();
			add+="inHtml += \"<option value=\\\""+emisorActual.getNIT()+"\\\">("+emisorActual.getNIT()+") "+ emisorActual.getNombre()+"</option>\";\r\n";
		}		
		out.println(add);
	}
	
	private void printFormulario5b()
	{
		String add="";
		Iterator<Inversionista> itera = inversionistasObtenidos.iterator();
		while(itera.hasNext())
		{
			Inversionista invActual = itera.next();
			add+="						                inHtml += \"<option value=\\\""+invActual.getId_Inversionista()+"\\\">("+invActual.getId_Inversionista()+") "+invActual.getNombre()+"</option>\";\r\n";
		}		
		out.println(add);
	}
	
	private void printFormulario6()
	{
		printFormulario1();
	}
	
	private void printFormulario7()
	{
		String add="";
		Iterator<TipoValor> itera = tiposProductosObtenidos.iterator();
		while(itera.hasNext())
		{
			TipoValor tipoActual = itera.next();
			add+="						                inHtml += \"<option value=\\\""+tipoActual.getId_Valor()+"\\\">("+tipoActual.getId_Valor()+") "+tipoActual.getNombre_valor()+"</option>\";						                \r\n";
		}		
		out.println(add);
	}
	
	private void printFormulario8()
	{
		String add="";
		Iterator<TipoRentabilidad> itera = tiposRentabilidadObtenidos.iterator();
		while(itera.hasNext())
		{
			TipoRentabilidad tipoActual = itera.next();
			add+="						                inHtml += \"<option value=\\\""+tipoActual.getId_rentabilidad()+"\\\">("+tipoActual.getId_rentabilidad()+") "+tipoActual.getNombre()+"</option>\";						                \r\n";
		}		
		out.println(add);
	}
	
	private void printFormulario9()
	{
		String add="";
		Iterator<Emisor> itera = emisoresObtenidos.iterator();
		while(itera.hasNext())
		{
			Emisor emisorActual = itera.next();
			add+="inHtml += \"<option value=\\\""+emisorActual.getNIT()+"\\\">("+emisorActual.getNIT()+") "+ emisorActual.getNombre()+"</option>\";\r\n";
		}		
		out.println(add);
	}
	
	private void printFormulario10()
	{
		String add="";
		Iterator<Intermediario> itera = intermediariosObtenidos.iterator();
		while(itera.hasNext())
		{
			Intermediario intermediarioActual = itera.next();
			add+="						                inHtml += \"<option value=\\\""+intermediarioActual.getId_Intermediario()+"\\\">("+intermediarioActual.getId_Intermediario()+") "+intermediarioActual.getNombre()+"</option>\";						                \r\n";
		}		
		out.println(add);
	}
	
	private void printFormulario11()
	{
		String add ="";
		Iterator<Inversionista> itera = inversionistasObtenidos.iterator();
		while(itera.hasNext())
		{
			Inversionista invActual = itera.next();
			add+="						                inHtml += \"<option value=\\\""+invActual.getId_Inversionista()+"\\\">("+invActual.getId_Inversionista()+") "+invActual.getNombre()+"</option>\";						                \r\n";
		}
		out.println(add);
	}
	
	private void printFormulario11bRentabilidades()
	{
		String add="";
		Iterator<TipoRentabilidad> itera = tiposRentabilidadObtenidos.iterator();
		while(itera.hasNext())
		{
			TipoRentabilidad tipoActual = itera.next();
			add+="<option value=\\\""+tipoActual.getId_rentabilidad()+"\\\">("+tipoActual.getId_rentabilidad()+") "+tipoActual.getNombre()+"</option>\";						                \r\n";
		}		
		out.println(add);
		
		
	}
	
	private void printFormulario12()
	{
		printFormulario11();
	}
	
	private void printFormulario13()
	{
		printFormulario5a();
	}
	
	private void printFormulario14()
	{
		String add="";
		Iterator<TipoValor> itera = tiposProductosObtenidos.iterator();
		while(itera.hasNext())
		{
			TipoValor tipoActual = itera.next();
			add+="										\"<option value=\\\""+tipoActual.getId_Valor()+"\\\">("+tipoActual.getId_Valor()+") "+tipoActual.getNombre_valor()+"</option>\\r\\n\"+\r\n";
		}		
		out.println(add);
	}
	
	
	private String cabecera = ""+
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
			"		\r\n"+
			"		\r\n"+
			"	\r\n"+
			"	<link href=\"css/start/jquery-ui-1.10.4.custom.css\" rel=\"stylesheet\">\r\n"+
			"	<script src=\"js/jquery-1.10.2.js\"></script>\r\n"+
			"	<script src=\"js/jquery-ui-1.10.4.custom.js\"></script>\r\n"+
			"	<script>\r\n"+
			"	$(function() {		\r\n"+
			"		$( \"#datepicker1\" ).datepicker({\r\n"+
			"			inline: true\r\n"+
			"			\r\n"+
			"		});\r\n"+
			"		\r\n"+
			"		// Hover states on the static widgets\r\n"+
			"		$( \"#dialog-link, #icons li\" ).hover(\r\n"+
			"			function() {\r\n"+
			"				$( this ).addClass( \"ui-state-hover\" );\r\n"+
			"			},\r\n"+
			"			function() {\r\n"+
			"				$( this ).removeClass( \"ui-state-hover\" );\r\n"+
			"			}\r\n"+
			"		);\r\n"+
			"	});\r\n"+
			"	</script>\r\n"+
			"	\r\n"+
			"	<script>\r\n"+
			"	$(function() {		\r\n"+
			"		$( \"#datepicker2\" ).datepicker({\r\n"+
			"			inline: true\r\n"+
			"			\r\n"+
			"		});\r\n"+
			"		\r\n"+
			"		// Hover states on the static widgets\r\n"+
			"		$( \"#dialog-link, #icons li\" ).hover(\r\n"+
			"			function() {\r\n"+
			"				$( this ).addClass( \"ui-state-hover\" );\r\n"+
			"			},\r\n"+
			"			function() {\r\n"+
			"				$( this ).removeClass( \"ui-state-hover\" );\r\n"+
			"			}\r\n"+
			"		);\r\n"+
			"	});\r\n"+
			"	</script>\r\n"+
			"	<script>\r\n"+
			"	$(function() {		\r\n"+
			"		$( \"#datepicker3\" ).datepicker({\r\n"+
			"			inline: true\r\n"+
			"			\r\n"+
			"		});\r\n"+
			"		\r\n"+
			"		// Hover states on the static widgets\r\n"+
			"		$( \"#dialog-link, #icons li\" ).hover(\r\n"+
			"			function() {\r\n"+
			"				$( this ).addClass( \"ui-state-hover\" );\r\n"+
			"			},\r\n"+
			"			function() {\r\n"+
			"				$( this ).removeClass( \"ui-state-hover\" );\r\n"+
			"			}\r\n"+
			"		);\r\n"+
			"	});\r\n"+
			"	</script>\r\n"+
			"\r\n"+
			"	<script>\r\n"+
			"	$(function() {		\r\n"+
			"		$( \"#datepicker6\" ).datepicker({\r\n"+
			"			inline: true\r\n"+
			"			\r\n"+
			"		});\r\n"+
			"		\r\n"+
			"		// Hover states on the static widgets\r\n"+
			"		$( \"#dialog-link, #icons li\" ).hover(\r\n"+
			"			function() {\r\n"+
			"				$( this ).addClass( \"ui-state-hover\" );\r\n"+
			"			},\r\n"+
			"			function() {\r\n"+
			"				$( this ).removeClass( \"ui-state-hover\" );\r\n"+
			"			}\r\n"+
			"		);\r\n"+
			"	});\r\n"+
			"	</script>\r\n"+
			"	\r\n"+
			"	<script>\r\n"+
			"	$(function() {		\r\n"+
			"		$( \"#datepicker7\" ).datepicker({\r\n"+
			"			inline: true\r\n"+
			"			\r\n"+
			"		});\r\n"+
			"		\r\n"+
			"		// Hover states on the static widgets\r\n"+
			"		$( \"#dialog-link, #icons li\" ).hover(\r\n"+
			"			function() {\r\n"+
			"				$( this ).addClass( \"ui-state-hover\" );\r\n"+
			"			},\r\n"+
			"			function() {\r\n"+
			"				$( this ).removeClass( \"ui-state-hover\" );\r\n"+
			"			}\r\n"+
			"		);\r\n"+
			"	});\r\n"+
			"	</script>\r\n"+
			"\r\n"+
			"	</head>\r\n"+
			"	<body>\r\n"+
			"\r\n"+
			"		<!-- Nav -->\r\n"+
			"			<nav id=\"nav\">\r\n"+
			"				<ul class=\"container\">\r\n"+
			"					<li><a href=\"#top\"><img src=\"images/valores/home.png\"  height=\"90\" width=\"90\"  alt=\"Home CupiFlights\" style=\"height : 73px;padding: 0px; margin: 0px; width : 61px;\"/></a></li>\r\n"+
			"				</ul>\r\n"+
			"			</nav>\r\n"+
			"\r\n"+
			"		<!-- Bienvenido -->\r\n"+
			"			<div class=\"wrapper wrapper-style1 wrapper-first\">\r\n"+
			"				<article class=\"container\" id=\"top\">\r\n"+
			"					<div class=\"row\">\r\n"+
			"						<div class=\"4u\">\r\n"+
			"						<p></p>\r\n"+
			"							<span class=\"me image image-full\"><img src=\"images/valores/bi04.png\" alt=\"Bienvenido\" style=\"width : 491px; height : 355px; margin-bottom: 100px\"/></span>\r\n"+
			"						</div>\r\n"+
			"						<div class=\"8u\">\r\n"+
			"							<header>\r\n"+
			"								<h1 align=\"center\">Bienvenido a <strong>ValorAndes+</strong></h1>\r\n"+
			"							</header>\r\n"+
			"							<p align=\"center\">ValorAndes+ es la plataforma que te permite conectarte con el mundo transaccional de la <strong>Bolsa de Valores de Los Andes</strong></p>\r\n"+
			"							<p align=\"justify\">En la plataforma podrás solicitar la realización de operaciones bursátiles de productos registrados en la aplicación. En caso de equivocaciones, <strong>ValorAndes+</strong> te permite hacer la cancelacion de la ultima solicitud.</p> \r\n"+
			"							\r\n"+
			"							<p align=\"center\" style=\"margin-bottom: 0; padding-bottom: 0\">\r\n"+
			"							<a href=\"#ordenar\"><img src=\"images/valores/bw-click.png\"  title=\"Ordenar Transaccion\" alt=\"Ordenar operacion\" style=\"height : 95px; width : 95px;\"/></a>\r\n"+
			"							<a href=\"#cancelar\"><img src=\"images/valores/instant_deposits_business_icon_29.png\"  title=\"Cancelar Transaccion\" alt=\"Cancelar operacion\" style=\"height : 100px; width : 250px;\"/></a>\r\n"+
			"							<a href=\"#registrar\"><img src=\"images/valores/transaction-icon.png\"  title=\"Registrar Operacion\" alt=\"Registrar Operacion\" style=\" valign: middle; height : 100px; width : 100px;\"/></a>\r\n"+
			"							<a href=\"#consultas\" style=\"\"><img src=\"images/valores/Database-Search.png\"  title=\"Consultar Operaciones\" alt=\"Consultas\" style=\" valign: middle; width : 100px; height : 100px; margin-left: 70px\"/></a>\r\n"+
			"							\r\n"+
			"							</p>  \r\n"+
			"						</div>\r\n"+
			"					</div>\r\n"+
			"				</article>\r\n"+
			"			</div>\r\n"+
			"			\r\n"+
			"			<!-- Ordenar Operación -->\r\n"+
			"			<div class=\"wrapper wrapper-style6 \">\r\n"+
			"				<article class=\"container\" id=\"ordenar\">					\r\n"+
			"							<header>\r\n"+
			"								<h1 align=\"center\"><strong>Ordenar Transaccion</strong></h1>\r\n"+
			"							</header>\r\n"+
			"							\r\n"+
			"							\r\n"+
			"							<div align=\"center\" class=\"row\" style=\"display: inline; vertical-align: middle;\">\r\n"+
			"								<p align=\"center\" style=\"margin-right: 130px; margin-left: 160px\"><strong>Comprar productos</strong></br><a href=\"#comprar\"  style=\"\"><img src=\"images/valores/Orange-Sale.png\"  title=\"Comprar productos\" alt=\"Solicitar compra\" style=\"width : 255px; height : 255px;\"/></a></p>\r\n"+
			"								<p align= \"center\"><strong>Vender productos</br></strong><a href=\"#vender\" ><img src=\"images/valores/comprar.png\"  title=\"Vender Productos\" alt=\"Vender Productos\" style=\"width : 255px; height : 255px;\"/></a></p>\r\n"+
			"							</div>\r\n"+
			"							</p>						\r\n"+
			"				</article>\r\n"+
			"			</div>\r\n"+
			"			\r\n"+
			"			\r\n"+
			"		<!-- Comprar Producto  -->\r\n"+
			"			<div class=\"wrapper wrapper-style2 \">\r\n"+
			"				<article class=\"container\" id=\"comprar\">	\r\n"+
			"				<div class=\"row\">\r\n"+
			"						<div class=\"4u\">\r\n"+
			"						</br>\r\n"+
			"							<span class=\"me image image-full\" ><img src=\"images/valores/buy.png\" alt=\"Compra de Productos\" title=\"Compra de Productos\" style=\"border-radius: 20% 20% 20% 20%; background-color: #FFD39B; padding: 30px\"/></span>\r\n"+
			"						</div>	\r\n"+
			"						<div class=\"8u\">				\r\n"+
			"							<header>\r\n"+
			"								<h1 align=\"center\"><strong>Adquisicion de Productos</strong></h1>\r\n"+
			"														\r\n"+
			"									<header><p style=\"font-size: 25px\" align=\"center\">\r\n"+
			"									Por favor indique a nombre de quién se procesará la transacción, el tipo de producto, y cantidad a adquirir, así como el oferente del producto.\r\n"+
			"									</p></header>\r\n"+
			"															\r\n"+
			"							</header>\r\n"+
			"							<form action=\"comprar.htm\" class=\"ok\" method=\"get\"  id=\"form_comprar\" name=\"form_comprar\">\r\n"+
			"							\r\n"+
			"										<p style=\"margin-left: 20px; \" align=\"center\" >\r\n"+
			"											\r\n"+
			"												<select id=\"comprar_inv\" name=\"id_inv\" title=\"Inversionista que solicita la operación\"  style=\"width: 400px; display: inline;vertical-align: middle; margin: 5px;\" required  onchange=\"comprarT2(this)\">\r\n"+
			"												<option value=\"\" label=\"--Seleccione inversionista--\"></option>\r\n";
															
			private String parte2="												</select>												\r\n"+
			"																					\r\n"+
			"												<select id=\"comprar_tipo_prod\" name=\"tipo_prod\" type=\"text\" list=\"tipo_producto\" title=\"Tipo Producto\" placeholder=\"Tipo Producto\" style=\"width: 300px; display: inline; vertical-align: middle;margin: 5px\" required disabled=\"disabled\" onchange=\"comprarT3(this)\">\r\n"+
			"												   <option value=\"\" label=\"--Seleccione producto--\">\r\n";
															   
			private String parte3="												</select>												\r\n"+
			"											\r\n"+
			"												<select id=\"comprar_oferente\" name=\"emisor\" type=\"text\" title=\"Oferente\" placeholder=\"Entidad Emisora\" style=\"width: 340px; vertical-align: middle; margin: 5px\" required disabled=\"disabled\" onchange=\"comprarT4(this)\">\r\n"+
			"												   <option value=\"\">--Sel. empresa oferente--</option>\r\n"+
			"												</select>												\r\n"+
			"											\r\n"+
			"										\r\n"+
			"												<select id=\"comprar_opc\" name=\"opc\" style=\"height: 60px; width: 200px; vertical-align: middle; text-align: center;\" disabled=\"disabled\" onchange=\"comprarT5(this)\">\r\n"+
			"													<option value=\"\" selected=\"selected\"> --comprar por-- </option>\r\n"+
			"													<option value=\"cantidad\" label=\"cantidad\" ></option>\r\n"+
			"													<option value=\"monto\" label=\"monto\"></option> \r\n"+
			"												</select>\r\n"+
			"												\r\n"+
			"												<input id=\"comprar_tipo\" name=\"cantidad\" type=\"number\" title=\"Cantidad\" placeholder=\"00\" ran\" style=\"width: 150px; margin: 5px\" required disabled=\"disabled\" onkeydown=\"comprarT6(this)\" onkeypress=\"comprarT6(this)\" onkeyup=\"comprarT6(this)\">\r\n"+
			"											</p>\r\n"+
			"											\r\n"+
			"											<div class=\"row\">\r\n"+
			"											<div class=\"12u\" align=\"center\" form=\"form_comprar\">												\r\n"+
			"												<input id=\"boton_comprar\" class=\"button form-button-submit\" type=\"submit\" value=\"Generar Transacción\" disabled=\"disabled\"/>									\r\n"+
			"											</div>\r\n"+
			"											<p></p>\r\n"+
			"										</div>\r\n"+
			"											</form>\r\n"+
			"									\r\n"+
			"											</div>							\r\n"+
			"										</div>\r\n"+
			"										\r\n"+
			"									</div>\r\n"+
			"							</form>\r\n"+
			"							<script type=\"text/javascript\" >\r\n"+
			"							function comprarT2(tipoc)\r\n"+
			"							{\r\n"+
			"								var t2 = document.getElementById(\"comprar_tipo_prod\");\r\n"+
			"								\r\n"+
			"								if(tipoc.value=='')\r\n"+
			"								{\r\n"+
			"									t2.disabled=true;\r\n"+
			"								}\r\n"+
			"								else\r\n"+
			"								{\r\n"+
			"										t2.disabled=false;					\r\n"+
			"								}								\r\n"+
			"							}\r\n"+
			"\r\n"+
			"							function comprarT3(tipoc)\r\n"+
			"							{\r\n"+
			"								var t3 = document.getElementById(\"comprar_oferente\");\r\n"+
			"								\r\n"+
			"								if(tipoc.value=='')\r\n"+
			"								{\r\n"+
			"									t3.disabled=true;\r\n"+
			"								}\r\n";
		private String parte4=""+															
			"							}\r\n"+
			"\r\n"+
			"							function comprarT4(tipoc)\r\n"+
			"							{\r\n"+
			"								var t2 = document.getElementById(\"comprar_opc\");								\r\n"+
			"								if(tipoc.value=='')\r\n"+
			"								{\r\n"+
			"									t2.disabled=true;\r\n"+
			"								}\r\n"+
			"								else\r\n"+
			"								{\r\n"+
			"									t2.disabled=false;					\r\n"+
			"								}								\r\n"+
			"							}\r\n"+
			"\r\n"+
			"							function comprarT5(tipoc)\r\n"+
			"							{\r\n"+
			"								var t2 = document.getElementById(\"comprar_tipo\");								\r\n"+
			"								if(tipoc.value=='')\r\n"+
			"								{\r\n"+
			"									t2.disabled=true;\r\n"+
			"								}\r\n"+
			"								else if(tipoc.value=='cantidad')\r\n"+
			"								{\r\n"+
			"									t2.disabled=false;					\r\n"+
			"								}	\r\n"+
			"								else\r\n"+
			"								{\r\n"+
			"									alert('Lo sentimos, en este momento no está habilitada la compra por monto');\r\n"+
			"									t2.disabled=true;\r\n"+
			"								}							\r\n"+
			"							}\r\n"+
			"\r\n"+
			"							function comprarT6(tipoc)\r\n"+
			"							{\r\n"+
			"								var t2 = document.getElementById(\"boton_comprar\");								\r\n"+
			"								if( isNaN(tipoc.value)==false &&  parseFloat(tipoc.value)>0)\r\n"+
			"								{\r\n"+
			"									t2.disabled=false;\r\n"+
			"								}\r\n"+
			"								else\r\n"+
			"								{\r\n"+
			"									t2.disabled=true;					\r\n"+
			"								}								\r\n"+
			"							}\r\n"+
			"							</script>\r\n"+
			"						</div>\r\n"+
			"					</div>\r\n"+
			"				</article>\r\n"+
			"			</div>\r\n"+
			"\r\n"+
			"		\r\n"+
			"			<!--Vender Producto  -->\r\n"+
			"			<div class=\"wrapper wrapper-style3 \">\r\n"+
			"				<article class=\"container\" id=\"vender\">	\r\n"+
			"				<div class=\"row\">\r\n"+
			"						<div class=\"4u\">\r\n"+
			"						</br>\r\n"+
			"							<span class=\"me image image-full\" ><img src=\"images/valores/images(2).jpg\" alt=\"Venta de Productos\" title=\"Venta de Productos\" style=\"border-radius: 20% 20% 20% 20%; background-color: #6495ED; padding: 30px\"/></span>\r\n"+
			"						</div>	\r\n"+
			"						<div class=\"8u\">				\r\n"+
			"							<header>\r\n"+
			"								<h1 align=\"center\"><strong>Venta de Productos</strong></h1>\r\n"+
			"														\r\n"+
			"									<header><p style=\"font-size: 25px\" align=\"center\">\r\n"+
			"									Por favor indique a nombre de quién se procesará la transacción, el tipo de producto, y cantidad de valores a poner en venta.\r\n"+
			"									</p></header>\r\n"+
			"															\r\n"+
			"							</header>\r\n"+
			"							<form action=\"vender.htm\" class=\"ok\" method=\"get\"  id=\"form_vender\" name=\"form_vender\" >\r\n"+
			"							\r\n"+
			"										<p style=\"margin-left: 20px; te\" align=\"center\">\r\n"+
			"												<select title=\"Oferente\" placeholder=\"Entidad Emisora\" name=\"Empresa\" style=\"width: 520px; vertical-align: middle; margin: 5px\" required onchange=\"venderT2(this)\" onclick=\"venderT2(this)\">\r\n"+
			"												   <option value=\"\">--SELECCIONE OFERENTE--</option>\r\n";
			
			
			private String parte4b="												</select>									\r\n"+
			"											</br>\r\n"+
			"											<select id=\"vender.tipo\" title=\"Tipo Producto\" \" name=\"tipoProducto\" style=\"width: 250px; display: inline; vertical-align: middle;margin: 5px;\" required disabled=\"disabled\" onchange=\"venderT3(this)\">\r\n"+
			"												   <option value=\"\" label=\"--Producto--\"></option>\r\n"+
			"											</select>	\r\n"+
			"												\r\n"+
			"												<strong> CANTIDAD: </strong>\r\n"+
			"												 <input id=vender.cantidad name=\"cantidad\"  disabled=\"disabled\" type=\"number\" title=\"Cantidad\" value=\"00\" style=\"width: 150px; margin: 10px\" required  onkeydown=\"venderT4(this)\" onkeypress=\"venderT4(this)\" onkeyup=\"venderT4(this)\">\r\n"+
			"											</p>\r\n"+
			"											\r\n"+
			"											<div class=\"row\">\r\n"+
			"											<div class=\"12u\" align=\"center\" >												\r\n"+
			"												<input disabled=\"disabled\" id=\"vender.btn\" class=\"button form-button-submit\" type=\"submit\" value=\"Poner en Venta\"/>									\r\n"+
			"											</div>\r\n"+
			"											<p></p>\r\n"+
			"										</div>\r\n"+
			"										</form>\r\n"+
			"										\r\n"+
			"												<script type=\"text/javascript\" >\r\n"+
			"												function venderT2(tipoc)\r\n"+
			"												{\r\n"+
			"													var t2 = document.getElementById(\"vender.tipo\");								\r\n"+
			"													if(tipoc.value=='')\r\n"+
			"													{\r\n"+
			"														t2.disabled=true;\r\n"+
			"													}\r\n";
			private String parte5a="													"+
																
			"												}\r\n"+
			"												function venderT3(tipoc)\r\n"+
			"												{\r\n"+
			"													var t3 = document.getElementById(\"vender.cantidad\");\r\n"+
			"													\r\n"+
			"													if(tipoc.value=='')\r\n"+
			"													{\r\n"+
			"														t3.disabled=true;\r\n"+
			"													}\r\n"+
			"													else\r\n"+
			"													{\r\n"+
			"														t3.disabled=false;\r\n"+
			"													}\r\n"+
			"																				\r\n"+
			"												}\r\n"+
			"												function venderT4(tipoc)\r\n"+
			"												{\r\n"+
			"													var t2 = document.getElementById(\"vender.btn\");								\r\n"+
			"													if( isNaN(tipoc.value)==false &&  parseFloat(tipoc.value)>0)\r\n"+
			"													{\r\n"+
			"														t2.disabled=false;\r\n"+
			"													}\r\n"+
			"													else\r\n"+
			"													{\r\n"+
			"														t2.disabled=true;					\r\n"+
			"													}								\r\n"+
			"												}\r\n"+
			"					\r\n"+
			"												\r\n"+
			"												</script>\r\n"+
			"											</div>							\r\n"+
			"										</div>\r\n"+
			"										\r\n"+
			"									</div>\r\n"+
			"							</form>\r\n"+
			"						</div>\r\n"+
			"					</div>\r\n"+
			"				</article>\r\n"+
			"			</div>\r\n"+
			"			\r\n"+
			"			\r\n"+
			"			<!-- Cancelar transaccion  -->\r\n"+
			"			<div class=\"wrapper wrapper-style6 \">\r\n"+
			"				<article class=\"container\" id=\"cancelar\">	\r\n"+
			"				<div class=\"row\">\r\n"+
			"						<div class=\"4u\">\r\n"+
			"						</br>\r\n"+
			"							<span class=\"me image image-full\" ><img src=\"images/valores/icon64SignatureForgery.png\" alt=\"RollBack\" title=\"RollBack\" style=\"border-radius: 50% 50% 50% 50%;\"/></span>\r\n"+
			"						</div>	\r\n"+
			"						<div class=\"8u\">				\r\n"+
			"							<header>\r\n"+
			"								<h1 align=\"center\"><strong>Cancelar la ultima solicitud</strong></h1>\r\n"+
			"														\r\n"+
			"									<header><p style=\"font-size: 25px\" align=\"center\">\r\n"+
			"									Por favor seleccione el tipo de usuario del que desea cancelar la ultima solicitud y/o transaccion\r\n"+
			"									</p></header>\r\n"+
			"															\r\n"+
			"							</header>\r\n"+
			"							<form action=\"cancelar.htm\" class=\"ok\" method=\"get\" id=\"form_cancelar\">\r\n"+
			"								<div>\r\n"+
			"										<div class=\"row half\">\r\n"+
			"											<div class=\"6u\" align=\"center\" >\r\n"+
			"												<input type=\"text\" list=tipo_usuario title=\"Seleccione un tipo de Usuario\" placeholder=\"--Tipo de Usuario--\" style=\"width: 250px\" required id=\"tipo_usuario_cancel\" name=\"tipo_usuario\" onclick=\"aT2(this)\" onblur=\"aT2(this)\" onfocus=\"aT2(this)\" onkeyup=\"aT2(this)\" onselect=\"aT2(this)\" onchange=\"aT2(this)\" >\r\n"+
			"												<datalist id=tipo_usuario >\r\n"+
			"												   <option> Empresa Emisora\r\n"+
			"												   <option> Inversionista\r\n"+
			"												</datalist>												\r\n"+
			"											</div>\r\n"+
			"											\r\n"+
			"											<div class=\"6u\" align=\"center\" >\r\n"+
			"												<select name=\"Id_Usuario\" style=\"width: 400px\"  id=\"id_usuario_cancel\"  disabled=\"disabled\" required onchange=\"act3(this)\" onfocus=\"act3(this)\" \">\r\n"+
			"												<option>--Seleccione--</option>\r\n"+
			"												</select>\r\n"+
			"\r\n"+
			"											</div>\r\n"+
			"																				\r\n"+
			"										</div>\r\n"+
			"										<div class=\"row\">\r\n"+
			"											<div class=\"12u\" align=\"center\">												\r\n"+
			"												<input  class=\"button form-button-submit\" type=\"submit\" value=\"Reversar Transaccion\" id=\"btn_cancel\" disabled=\"disabled\" />									\r\n"+
			"											</div>\r\n"+
			"											<p></p>\r\n"+
			"										</div>\r\n"+
			"									</div>\r\n"+
			"							</form>\r\n"+
			"							\r\n"+
			"							<script type=\"text/javascript\" >\r\n"+
			"							function aT2(tipoc)\r\n"+
			"							{\r\n"+
			"								var t2 = document.getElementById(\"id_usuario_cancel\");\r\n"+
			"								\r\n"+
			"								if(tipoc.value==''){\r\n"+
			"									t2.disabled=true;}\r\n"+
			"								else\r\n"+
			"								{\r\n"+
			"									var inHtml = \"\";\r\n"+
			"									if(tipoc.value=='Empresa Emisora')\r\n"+
			"									{\r\n"+
			"										t2.disabled=false;\r\n"+
			"										inHtml += \"<option value=\\\"null\\\">-- Seleccione Emisor --</option>\";\r\n";
													
			private String parte5b="						                t2.innerHTML = inHtml;\r\n"+
			"									}\r\n"+
			"									else if(tipoc.value=='Inversionista')\r\n"+
			"									{\r\n"+
			"										t2.disabled=false;\r\n"+
			"										inHtml += \"<option value=\\\"null\\\">-- Seleccione Inversionista --</option>\";\r\n";
													
			private String parte6="						                t2.innerHTML = inHtml;\r\n"+
			"									}						\r\n"+
			"								}								\r\n"+
			"							}\r\n"+
			"\r\n"+
			"							function act3(selected)\r\n"+
			"							{	\r\n"+
			"								var t3 = document.getElementById(\"btn_cancel\");\r\n"+
			"								if(selected.value!='null')\r\n"+
			"									{	\r\n"+
			"										t3.disabled=false;\r\n"+
			"									}\r\n"+
			"								else\r\n"+
			"								{	\r\n"+
			"									t3.disabled=true;\r\n"+
			"								}\r\n"+
			"							}\r\n"+
			"							</script>\r\n"+
			"						</div>\r\n"+
			"					</div>\r\n"+
			"				</article>\r\n"+
			"			</div>\r\n"+
			"			\r\n"+
			"			<!-- Registrar acuerdo-->\r\n"+
			"			<div class=\"wrapper wrapper-style2 \">\r\n"+
			"				<article class=\"container\" id=\"registrar\">	\r\n"+
			"				<div class=\"row\">\r\n"+
			"						<div class=\"4u\">\r\n"+
			"						</br>\r\n"+
			"							<span class=\"me image image-full\" ><img src=\"images/valores/deal2.png\" alt=\"RollBack\" title=\"RollBack\" style=\"border-radius: 50% 50% 50% 50%; background-color: #a9d171;\"/></span>\r\n"+
			"						</div>	\r\n"+
			"						<div class=\"8u\">				\r\n"+
			"							<header>\r\n"+
			"								<h1 align=\"center\"><strong>Registrar Solicitud</strong></h1>\r\n"+
			"														\r\n"+
			"									<header><p style=\"font-size: 25px\" align=\"center\">\r\n"+
			"									Por favor seleccione el usuario que ha solicitado la compra, y la solicitud de compra.\r\n"+
			"									</p></header>\r\n"+
			"															\r\n"+
			"							</header>\r\n"+
			"							<form action=\"registrar.htm\" class=\"ok\" method=\"get\">\r\n"+
			"												<p><select name=\"Inversionista\" style=\"width: 450px; text-align: center;\" required title=\"Seleccione un inversionsita\" onchange=\"continue1(this)\">\r\n"+
			"												   <option value=\"\" >--Seleccione Inversionista--</option>\r\n";
			
			private String parte6b="												</select>	</p>\r\n"+
			"										\r\n"+
			"										<div class=\"row\">\r\n"+
			"											<div class=\"12u\" align=\"center\">												\r\n"+
			"												<input id=\"continue.btn\" class=\"button form-button-submit\" type=\"submit\" value=\"Continuar\" disabled=\"disabled\"/>									\r\n"+
			"											</div>\r\n"+
			"											<p></p>\r\n"+
			"										</div>\r\n"+
			"							</form>\r\n"+
			"							<script type=\"text/javascript\">\r\n"+
			"							function continue1(e)\r\n"+
			"							{\r\n"+
			"								var t3 = document.getElementById(\"continue.btn\");\r\n"+
			"								if(e.value!='')\r\n"+
			"								{	\r\n"+
			"									t3.disabled=false;\r\n"+
			"								}\r\n"+
			"								else\r\n"+
			"								{	\r\n"+
			"									t3.disabled=true;\r\n"+
			"								}\r\n"+
			"							}				\r\n"+
			"							</script>\r\n"+
			"						</div>\r\n"+
			"					</div>\r\n"+
			"				</article>\r\n"+
			"			</div>\r\n"+
			"			\r\n"+
			"			<!-- Consultas -->\r\n"+
			"			<div class=\"wrapper wrapper-style3\">\r\n"+
			"				<article class=\"container\" id=\"consultas\">\r\n"+
			"							<header>\r\n"+
			"								<h1 align=\"center\"><strong>Consultas</strong></h1>\r\n"+
			"							</header>\r\n"+
			"							\r\n"+
			"							<p>					\r\n"+
			"								<a href=\"#valores\"  style=\"\"><img src=\"images/valores/existencia.png\"  title=\"Valores Disponibles\" alt=\"Valores Disponibles\" style=\"margin: 20px\"/></a>\r\n"+
			"								<a href=\"#movimientos\" ><img src=\"images/valores/movimientos.png\"  title=\"Comprar Productos\" alt=\"Comprar Productos\" style=\"margin: 20px\"/></a>\r\n"+
			"								<a href=\"#masMovidos\" ><img src=\"images/valores/movidos.png\"  title=\"Valor más movido\" alt=\"Valor más movido\" style=\"margin: 20px\"/></a>\r\n"+
			"								<a href=\"#masActivo\" ><img src=\"images/valores/intermediario.png\"  title=\"Intermediario más activo\" alt=\"Intermediario más activo\" style=\"margin: 20px;\"/></a>\r\n"+
			"								</p>\r\n"+
			"				</article>\r\n"+
			"			</div>\r\n"+
			"			\r\n"+
			"			<!-- Consulta de valores -->\r\n"+
			"			<div class=\"wrapper wrapper-style6 \">\r\n"+
			"				<article class=\"container\" id=\"valores\">	\r\n"+
			"				<div class=\"row\">\r\n"+
			"						<div class=\"4u\">\r\n"+
			"						</br>\r\n"+
			"							<span class=\"me image image-full\" ><img src=\"images/valores/Price-Icon.png\" alt=\"Valores más movidos\"  style=\";\"/></span>\r\n"+
			"						</div>	\r\n"+
			"						<div class=\"8u\">				\r\n"+
			"							<header>\r\n"+
			"								<h1 align=\"center\" style=\"line-height: 40px\">Existencia de Valores</h1>\r\n"+
			"														\r\n"+
			"									<header><p style=\"font-size: 25px\" align=\"center\">\r\n"+
			"									Seleccione los criterios de la consulta.\r\n"+
			"									</p></header>			\r\n"+
			"							</header>\r\n"+
			"							\r\n"+
			"							<form action=\"existencia.htm\" class=\"ok\" method=\"get\">\r\n"+
			"							\r\n"+
			"							<div align=\"center\" class=\"row\" style=\"display: inline; vertical-align: middle;\">\r\n"+
			"								<p>\r\n"+
			"								<select id=existencia.filtro name=\"filtro\" style=\"width:230px;height : 52px;\" onchange=\"existenciaT2(this)\" onclick=\"existenciaT2(this)\">\r\n"+
			"								<option value=\"\">--Filtro--</option>\r\n"+
			"								<option value=\"tipoValor\">Tipo de Valor</option>\r\n"+
			"								<option value=\"TipoRentabilidad\">Tipo de Rentabilidad</option>\r\n"+
			"								<option value=\"Negociación\"> En negociación </option>\r\n"+
			"								<option value=\"Expiración\"> Fecha de expiración </option>\r\n"+
			"								<option value=\"Emisor\">Emisor</option>\r\n"+
			"								<option value=\"Intermediario\">Intermediario</option>\r\n"+
			"								<option value=\"Inversionista\">Inversionista</option>					\r\n"+
			"								</select>\r\n"+
			"								\r\n"+
			"								<select disabled=\"disabled\" id=existencia.opcion title=\"Seleccione un valor para el filtro\" name=\"filtro.value\" style=\"width:400px;height : 52px; margin:10px\" onchange=\"existenciat3(this);activarDatePickerE(this)\" onclick=\"existenciat3(this);activarDatePickerE(this)\" onblur=\"existenciat3(this);activarDatePickerE(this)\" onfocus=\"existenciat3(this);activarDatePickerE(this)\" onmouseover=\"existenciat3(this);activarDatePickerE(this)\">\r\n"+
			"								</select>\r\n"+
			"								\r\n"+
			"								</p>								\r\n"+
			"								\r\n"+
			"								<div>\r\n"+
			"										\r\n"+
			"										<p ><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Fecha de Expiración:&nbsp;&nbsp;&nbsp;</strong>\r\n"+
			"											<input disabled=\"disabled\" type=\"text\"  id=\"datepicker1\" name=\"expiracion\" style=\"width:400px; height : 49px; text-align: center; margin:10px;\" placeholder=\"mm/dd/aaaa\" >\r\n"+
			"										</p>\r\n"+
			"								\r\n"+
			"										<div class=\"row\">\r\n"+
			"											<div class=\"12u\" align=\"center\">												\r\n"+
			"												<input disabled=\"disabled\" class=\"button form-button-submit\" type=\"submit\" name=\"consultar\" id=\"existencia.btn\" value=\"Consultar\"/>								\r\n"+
			"											</div>\r\n"+
			"										</div>\r\n"+
			"								</div>\r\n"+
			"							</form>\r\n"+
			"							<script type=\"text/javascript\">\r\n"+
			"							function activarDatePickerE(tipoc)\r\n"+
			"							{\r\n"+
			"								var picker = document.getElementById(\"datepicker1\");\r\n"+
			"								if(tipoc.value=='1'){\r\n"+
			"									picker.disabled=false;\r\n"+
			"									}\r\n"+
			"								else\r\n"+
			"									{\r\n"+
			"									picker.disabled=true;\r\n"+
			"									}\r\n"+
			"								\r\n"+
			"							}\r\n"+
			"							function existenciaT2(tipoc)\r\n"+
			"							{\r\n"+
			"								var t2 = document.getElementById(\"existencia.opcion\");\r\n"+
			"								\r\n"+
			"								if(tipoc.value==''){\r\n"+
			"									t2.disabled=true;}\r\n"+
			"								else\r\n"+
			"								{\r\n"+
			"									t2.disabled=false;\r\n"+
			"									var inHtml = \"\";\r\n"+
			"									if(tipoc.value=='tipoValor')\r\n"+
			"									{\r\n"+
			"										\r\n"+
			"										inHtml += \"<option value=\\\"\\\">-- TIPO VALOR --</option>\";\r\n";
																							
			
			private String parte7="						                t2.innerHTML = inHtml;\r\n"+
			"									}\r\n"+
			"									else if(tipoc.value=='TipoRentabilidad')\r\n"+
			"									{\r\n"+
			"										inHtml += \"<option value=\\\"\\\">-- TIPO RENTABILIDAD --</option>\";	\r\n";
												
			
			private String parte8="						                t2.innerHTML = inHtml;\r\n"+
			"									}\r\n"+
			"									else if(tipoc.value=='Negociación')\r\n"+
			"									{\r\n"+
			"										inHtml += \"<option value=\\\"\\\">-- NEGOCIACIÓN --</option>\";										\r\n"+
			"						                inHtml += \"<option value=\\\"ON\\\"> (ON) En negociación </option>\";\r\n"+
			"						                inHtml += \"<option value=\\\"OFF\\\"> (OFF) Fuera de negociación </option>\";						                \r\n"+
			"						                t2.innerHTML = inHtml;\r\n"+
			"									}\r\n"+
			"									else if(tipoc.value=='Expiración')\r\n"+
			"									{										\r\n"+
			"						                inHtml += \"<option value=\\\"1\\\"> seleccione fecha (abajo) </option>\";						                \r\n"+
			"						                t2.innerHTML = inHtml;\r\n"+
			"						                activarDatePickerE(t2);\r\n"+
			"									}\r\n"+
			"									else if(tipoc.value=='Emisor')\r\n"+
			"									{\r\n"+
			"										inHtml += \"<option value=\\\"\\\">-- EMISOR --</option>\";	\r\n";
																		
			
			private String parte9="						                t2.innerHTML = inHtml;\r\n"+
			"									}\r\n"+
			"									else if(tipoc.value=='Intermediario')\r\n"+
			"									{\r\n"+
			"										inHtml += \"<option value=\\\"\\\">-- INTERMEDIARIO --</option>\";\r\n";
																				
			
			private String parte10="						                t2.innerHTML = inHtml;\r\n"+
			"									}\r\n"+
			"									else if(tipoc.value=='Inversionista')\r\n"+
			"									{\r\n"+
			"										inHtml += \"<option value=\\\"\\\">-- INVERSIONISTA --</option>\";	\r\n";
			
			private String parte11="						                t2.innerHTML = inHtml;\r\n"+
			"									}			\r\n"+
			"								}								\r\n"+
			"							}\r\n"+
			"							\r\n"+
			"							function existenciat3(selected)\r\n"+
			"							{\r\n"+
			"								var t3 = document.getElementById(\"existencia.btn\");\r\n"+
			"								if(selected.value!='')\r\n"+
			"									{	\r\n"+
			"										t3.disabled=false;\r\n"+
			"									}\r\n"+
			"								else\r\n"+
			"								{	\r\n"+
			"									t3.disabled=true;\r\n"+
			"								}\r\n"+
			"							}\r\n"+
			"				\r\n"+
			"							</script>\r\n"+
			"							\r\n"+
			"						</div>\r\n"+
			"					</div>\r\n"+
			"				</article>\r\n"+
			"			</div>\r\n"+
			"			\r\n"+
			"			<!-- Consulta de valores -->\r\n"+
			"			<div class=\"wrapper wrapper-style2 \">\r\n"+
			"				<article class=\"container\" id=\"movimientos\">	\r\n"+
			"				<div class=\"row\">\r\n"+
			"						<div class=\"4u\">\r\n"+
			"						</br>\r\n"+
			"							<span class=\"me image image-full\" ><img src=\"images/valores/PAdmin-B.png\" alt=\"Valores más movidos\"  style=\"\"/></span>\r\n"+
			"						</div>	\r\n"+
			"						<div class=\"8u\">				\r\n"+
			"							<header>\r\n"+
			"								<h1 align=\"center\" style=\"line-height: 40px\">Operaciones de un Usuario</h1>\r\n"+
			"														\r\n"+
			"									<header><p style=\"font-size: 25px\" align=\"center\">\r\n"+
			"									Seleccione los criterios de la consulta.\r\n"+
			"									</p></header>			\r\n"+
			"							</header>\r\n"+
			"							\r\n"+
			"							<form action=\"movimientos.htm\" class=\"ok\" method=\"get\">\r\n"+
			"							<p style=\"margin-left: 20px; \" align=\"center\" >	\r\n"+
			"																	\r\n"+
			"								<select id=\"movimientos.tipo\" name=\"tipo.usuario\" title=\"tipo de usuario\"  style=\"width: 300px; display: inline;vertical-align: middle; margin: 5px;\" required onchange=\"cambiarUsuariosMovimientos(this)\" onclick=\"cambiarUsuariosMovimientos(this)\">\r\n"+
			"								<option value=\"\">--Tipo de usuario--</option>\r\n"+
			"								<option value=\"inversionista\">Inversionista</option>\r\n"+
			"								<option value=\"emisor\">Empresa emisora</option>\r\n"+
			"								</select>\r\n"+
			"								\r\n"+
			"								<select id=\"movimientos.usuario\" name=\"usuario\" title=\"Identificador de usuario\"  style=\"width: 300px; display: inline;vertical-align: middle; margin: 5px;\" required onchange=\"botonMovimientos(this)\" onclick=\"botonMovimientos(this)\" onmousemove=\"botonMovimientos(this)\" onblur=\"botonMovimientos(this)\" onfocus=\"botonMovimientos(this)\">\r\n"+
			"								</select>\r\n"+
			"								\r\n"+
			"								<select id=\"movimientos.tipo.operacion\" name=\"tipo.operacion\" title=\"tipo de usuario\"  style=\"width: 300px; display: inline;vertical-align: middle; margin: 5px;\" required>\r\n"+
			"								<option value=\"\">--tipo de operacion--</option>\r\n"+
			"								<option value=\"compra\">compra de productos</option>\r\n"+
			"								<option value=\"venta\">venta de productos</option>\r\n"+
			"								</select>\r\n"+
			"								\r\n"+
			"								<select id=\"movimientos.tipo.rentabilidad\" name=\"tipo.rentabilidad\" title=\"Identificador de usuario\"  style=\"width: 300px; display: inline;vertical-align: middle; margin: 5px;\" required>\r\n"+
			"								<option value=\"\">--tipo de rentabilidad--</option>\r\n";
			
			private String parte11b="								</select>\r\n"+
			"								\r\n"+
			"								<input type=\"text\"  id=\"datepicker2\" name=\"desde\" style=\"width:300px;  text-align: center; margin:5px\" placeholder=\"(mm/dd/aaaa) inicio\" >\r\n"+
			"								\r\n"+
			"								<input type=\"text\"  id=\"datepicker3\" name=\"hasta\" style=\"width:300px; text-align: center;margin:5px\" placeholder=\"(mm/dd/aaaa) fin\" >\r\n"+
			"								\r\n"+
			"								<select id=\"movimientos.cota\" name=\"cota\" title=\"Cota para la búsqueda\"  style=\"width: 300px; display: inline;vertical-align: middle; margin: 5px;\" required>\r\n"+
			"								<option value=\"\">--tipo de costo--</option>\r\n"+
			"								<option value=\"max\">costo máximo</option>\r\n"+
			"								<option value=\"min\">costo mínimo</option>\r\n"+
			"								</select>\r\n"+
			"								\r\n"+
			"								<input type=\"number\" id=\"movimientos.monto\" name=\"monto\" title=\"Cantidad de dinero\"  style=\"width: 300px; display: inline;vertical-align: middle; margin: 5px;\" required placeholder=\"00\">\r\n"+
			"								</select>	\r\n"+
			"							</p>				\r\n"+
			"							<div class=\"row\">\r\n"+
			"								<div class=\"12u\" align=\"center\">												\r\n"+
			"									<input disabled=\"disabled\" class=\"button form-button-submit\" type=\"submit\" name=\"consultar\" id=\"movimiento.btn\" value=\"Consultar\"/>								\r\n"+
			"								</div>\r\n"+
			"							</div>	\r\n"+
			"									\r\n"+
			"							</form>\r\n"+
			"							<script type=\"text/javascript\">							\r\n"+
			"							function cambiarUsuariosMovimientos(tipoc)\r\n"+
			"							{\r\n"+
			"								var t2 = document.getElementById(\"movimientos.usuario\");\r\n"+
			"								\r\n"+
			"								if(tipoc.value==''){\r\n"+
			"									t2.disabled=true;}\r\n"+
			"								else\r\n"+
			"								{\r\n"+
			"									t2.disabled=false;\r\n"+
			"									var inHtml = \"\";\r\n"+
			"									if(tipoc.value=='inversionista')\r\n"+
			"									{\r\n"+
			"										\r\n"+
			"										inHtml += \"<option value=\\\"\\\">-- INVERSIONISTA --</option>\";\r\n";
													
			
			private String parte12="						                t2.innerHTML = inHtml;\r\n"+
			"									}\r\n"+
			"									else if(tipoc.value=='emisor')\r\n"+
			"									{\r\n"+
			"										inHtml += \"<option value=\\\"\\\">-- EMISOR --</option>\";	\r\n";
			
			private String parte13="						                t2.innerHTML = inHtml;\r\n"+
			"									}	\r\n"+
			"								}								\r\n"+
			"							}\r\n"+
			"							\r\n"+
			"							function botonMovimientos(selected)\r\n"+
			"							{\r\n"+
			"								var t3 = document.getElementById(\"movimiento.btn\");\r\n"+
			"								if(selected.value!='')\r\n"+
			"									{	\r\n"+
			"										t3.disabled=false;\r\n"+
			"									}\r\n"+
			"								else\r\n"+
			"								{	\r\n"+
			"									t3.disabled=true;\r\n"+
			"								}\r\n"+
			"							}\r\n"+
			"				\r\n"+
			"							</script>\r\n"+
			"							\r\n"+
			"						</div>\r\n"+
			"					</div>\r\n"+
			"				</article>\r\n"+
			"			</div>\r\n"+
			"			\r\n"+
			"			\r\n"+
			"			\r\n"+
			"			\r\n"+
			"			<!-- Valores más movidos -->\r\n"+
			"			<div class=\"wrapper wrapper-style3 \">\r\n"+
			"				<article class=\"container\" id=\"masMovidos\">	\r\n"+
			"				<div class=\"row\">\r\n"+
			"						<div class=\"4u\">\r\n"+
			"						</br>\r\n"+
			"							<span class=\"me image image-full\" ><img src=\"images/valores/transaction.png\" alt=\"Valores más movidos\"  style=\"border-radius: 50% 10% 50% 50%; background-color: #0f0f63;\"/></span>\r\n"+
			"						</div>	\r\n"+
			"						<div class=\"8u\">				\r\n"+
			"							<header>\r\n"+
			"								<h1 align=\"center\" style=\"line-height: 40px\">Valores con mayor movimiento</h1>\r\n"+
			"														\r\n"+
			"									<header><p style=\"font-size: 25px\" align=\"center\">\r\n"+
			"									Indique un rango de fechas para realizar la consulta.\r\n"+
			"									</p></header>			\r\n"+
			"							</header>\r\n"+
			"							\r\n"+
			"							<form action=\"masMovimiento.htm\" class=\"ok\" method=\"get\">\r\n"+
			"								<div>\r\n"+
			"										<div class=\"row half\">\r\n"+
			"											<div class=\"6u\" align=\"center\">\r\n"+
			"												<p ><strong>Fecha de inicio:</strong></p>	\r\n"+
			"													<input type=\"text\"  id=\"datepicker6\" name=\"desde\" style=\"width:400px; height : 49px; text-align: center;\" placeholder=\"mm/dd/aaaa\" >\r\n"+
			"											</div>\r\n"+
			"											<div class=\"6u\" align=\"center\">\r\n"+
			"												<p ><strong>Fecha de fin:</strong></p>	\r\n"+
			"													<input type=\"text\"  id=\"datepicker7\" name=\"hasta\" style=\"width:400px; height : 49px; text-align: center;\" placeholder=\"mm/dd/aaaa\" >\r\n"+
			"											</div>\r\n"+
			"										</div>\r\n"+
			"										<div class=\"row\">\r\n"+
			"											<div class=\"12u\" align=\"center\">												\r\n"+
			"												<input  class=\"button form-button-submit\" type=\"submit\" name=\"consultar\" id=\"login\" value=\"Consultar\"/>								\r\n"+
			"											</div>\r\n"+
			"										</div>\r\n"+
			"									</div>\r\n"+
			"							</form>\r\n"+
			"							\r\n"+
			"						</div>\r\n"+
			"					</div>\r\n"+
			"				</article>\r\n"+
			"			</div>\r\n"+
			"			\r\n"+
			"		<!-- Mejor intermediario -->\r\n"+
			"			<div class=\"wrapper wrapper-style6 \">\r\n"+
			"				<article class=\"container\" id=\"masActivo\">	\r\n"+
			"				<div class=\"row\">\r\n"+
			"						<div class=\"4u\">\r\n"+
			"						</br>\r\n"+
			"							<span class=\"me image image-full\" ><img src=\"images/valores/best.png\" alt=\"Valores más movidos\"  style=\"\"/></span>\r\n"+
			"						</div>	\r\n"+
			"						<div class=\"8u\">				\r\n"+
			"							<header>\r\n"+
			"								<h1 align=\"center\" style=\"line-height: 40px\">Intermediario Más Activo</h1>\r\n"+
			"														\r\n"+
			"									<header><p style=\"font-size: 25px\" align=\"center\">\r\n"+
			"									Indique los parámetros indicados para realizar la consulta.\r\n"+
			"									</p></header>			\r\n"+
			"							</header>\r\n"+
			"							\r\n"+
			"							<form action=\"mejor.htm\" class=\"ok\" method=\"get\">\r\n"+
			"							<p style=\"\" align=\"center\" >	\r\n"+
			"																	\r\n"+
			"								<select id=\"mejor.criterio\" name=\"tipo.busqueda\" title=\"tipo de usuario\"  style=\"width: 300px; display: inline;vertical-align: middle; margin: 5px;\" required onchange=\"completarFomulario(this)\" onclick=\"completarFomulario(this)\" onmousemove=\"completarFomulario(this)\" onmouseover=\"completarFomulario(this)\" onselect=\"completarFomulario(this)\" >\r\n"+
			"								<option value=\"\">--seleccione--</option>\r\n"+
			"								<option value=\"tipo\">Tipo de Valor</option>\r\n"+
			"								<option value=\"valor\">Valor</option>\r\n"+
			"								</select>\r\n"+
			"							</p>\r\n"+
			"							<div id=\"here\">		\r\n"+
			"							</div>	\r\n"+
			"									\r\n"+
			"							</form>\r\n"+
			"							<script type=\"text/javascript\">							\r\n"+
			"							function completarFomulario(tipoc)\r\n"+
			"							{\r\n"+
			"								var t2 = document.getElementById(\"here\");\r\n"+
			"									var inHtml = \"\";\r\n"+
			"									if(tipoc.value=='tipo')\r\n"+
			"									{\r\n"+
			"										\r\n"+
			"										inHtml += \"<select id=\\\"mejor.tipoValor\\\" name=\\\"tipo.valor\\\" title=\\\"Tipo de valor para buscar\\\"  style=\\\"width: 300px; display: inline;vertical-align: middle; margin: 5px;\\\" required>\"+\r\n";
			
			private String parte14="											\"								</select>	\"+\r\n"+
			"											\"							</p>				\"+\r\n"+
			"											\"							<div class=\\\"row\\\">\"+\r\n"+
			"											\"								<div class=\\\"12u\\\" align=\\\"center\\\">												\"+\r\n"+
			"											\"									<input class=\\\"button form-button-submit\\\" type=\\\"submit\\\" name=\\\"consultar\\\" id=\\\"mejor.consultar\\\" value=\\\"Consultar\\\"/>							\"+\r\n"+
			"											\"								</div>\"+\r\n"+
			"											\"							</div>\";\r\n"+
			"										t2.innerHTML = inHtml;\r\n"+
			"									}\r\n"+
			"									else if(tipoc.value=='valor')\r\n"+
			"									{\r\n"+
			"										inHtml += \"<div class=\\\"row\\\">\"+\r\n"+
			"										\"								<div class=\\\"12u\\\" align=\\\"center\\\">												\"+\r\n"+
			"										\"									<input class=\\\"button form-button-submit\\\" type=\\\"submit\\\" name=\\\"consultar\\\" id=\\\"mejor.consultar\\\" value=\\\"Continuar\\\"/>\"+\r\n"+
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
			"				</article>\r\n"+
			"			</div>\r\n"+
			"			\r\n"+
			"			\r\n"+
			"					\r\n"+
			"		<!-- Administrar -->\r\n"+
			"			<div class=\"wrapper wrapper-style4\">\r\n"+
			"				<article id=\"administrar\" class=\"container small\">\r\n"+
			"					<header>\r\n"+
			"						<h2>Ingresar al administrador de ValorAndes<strong>(</strong>+<strong>)</strong></h2>\r\n"+
			"						<span>Introduzca el login y password suministrados por los administradores</span>\r\n"+
			"					</header>\r\n"+
			"					<div>\r\n"+
			"						<div class=\"row\">\r\n"+
			"							<div class=\"12u\">\r\n"+
			"								<form method=\"post\" action=\"login.htm\" autocomplete=\"off\">\r\n"+
			"									<div>\r\n"+
			"										<div class=\"row half\">\r\n"+
			"											<div class=\"6u\">\r\n"+
			"												<p>Usuario:</p>	\r\n"+
			"												<input type=\"text\" name=\"usuario\" id=\"usuario\" placeholder=\"User\" style=\"text-transform: uppercase; text-align: center;font-weight: bold;\"/>\r\n"+
			"											</div>\r\n"+
			"											<div class=\"6u\">\r\n"+
			"												<p>Contrasena:</p>	\r\n"+
			"												<input name=\"pass\" type=\"password\" id=\"pass\" placeholder=\"Password\" style=\"text-align: center;font-weight: bold;\"/>\r\n"+
			"											</div>\r\n"+
			"										</div>\r\n"+
			"										<div class=\"row\">\r\n"+
			"											<div class=\"12u\">												\r\n"+
			"												<input  class=\"button form-button-submit\" type=\"submit\" name=\"login\" id=\"login\" value=\"Ingresar\" />\r\n"+
			"											</div>\r\n"+
			"										</div>\r\n"+
			"										<header><span></br>¿Aun no estas registrado en nuestra version PRO? Crea hoy mismo tu cuenta gratuita <a href=\"register.html\">aqui</strong></a>!</span></header>\r\n"+
			"									</div>\r\n"+
			"								</form>\r\n"+
			"							</div>\r\n"+
			"						</div>\r\n"+
			"						</article>\r\n"+
			"						\r\n"+
			"						<div class=\"row\" >\r\n"+
			"						\r\n"+
			"							<div class=\"12u\">\r\n"+
			"							\r\n"+
			"								<hr />\r\n"+
			"								<article id=\"about\"></article>\r\n"+
			"								<header><h3>Universidad de Los Andes</h3></header>\r\n"+
			"								<p><h3><Strong> Brahian David Rangel </br> John Ortiz </br>- ValorAndes+ - Sistemas Transaccionales - Nivel 1 -</br></br>Departamento de Ingeniería de Sistemas y Computación</br> 2014 - 20</strong></h3></p>								\r\n"+
			"								<ul class=\"social\" >	\r\n"+
			"		\r\n"+
			"									<li class=\"twitter\"><a href=\"http://twitter.com/n33co\" class=\"fa fa-twitter\"><span>Twitter</span></a></li>\r\n"+
			"									<li class=\"facebook\"><a href=\"#\" class=\"fa fa-facebook\"><span>Facebook</span></a></li>\r\n"+
			"									<li class=\"dribbble\"><a href=\"http://dribbble.com/n33\" class=\"fa fa-dribbble\"><span>Dribbble</span></a></li>\r\n"+
			"									<li class=\"linkedin\"><a href=\"#\" class=\"fa fa-linkedin\"><span>LinkedIn</span></a></li>\r\n"+
			"									<li class=\"tumblr\"><a href=\"#\" class=\"fa fa-tumblr\"><span>Tumblr</span></a></li>\r\n"+
			"									<li class=\"googleplus\"><a href=\"#\" class=\"fa fa-google-plus\"><span>Google+</span></a></li>\r\n"+
			"									<li class=\"github\"><a href=\"https://github.com/Fhernd/valorandes\" class=\"fa fa-github\"><span>Github</span></a></li>\r\n"+
			"									<!--\r\n"+
			"									<li class=\"rss\"><a href=\"#\" class=\"fa fa-rss\"><span>RSS</span></a></li>\r\n"+
			"									<li class=\"instagram\"><a href=\"#\" class=\"fa fa-instagram\"><span>Instagram</span></a></li>\r\n"+
			"									<li class=\"foursquare\"><a href=\"#\" class=\"fa fa-foursquare\"><span>Foursquare</span></a></li>\r\n"+
			"									<li class=\"skype\"><a href=\"#\" class=\"fa fa-skype\"><span>Skype</span></a></li>\r\n"+
			"									<li class=\"soundcloud\"><a href=\"#\" class=\"fa fa-soundcloud\"><span>Soundcloud</span></a></li>\r\n"+
			"									<li class=\"youtube\"><a href=\"#\" class=\"fa fa-youtube\"><span>YouTube</span></a></li>\r\n"+
			"									<li class=\"blogger\"><a href=\"#\" class=\"fa fa-blogger\"><span>Blogger</span></a></li>\r\n"+
			"									<li class=\"flickr\"><a href=\"#\" class=\"fa fa-flickr\"><span>Flickr</span></a></li>\r\n"+
			"									<li class=\"vimeo\"><a href=\"#\" class=\"fa fa-vimeo\"><span>Vimeo</span></a></li>\r\n"+
			"									-->\r\n"+
			"								</ul>\r\n"+
			"								<hr />\r\n"+
			"							</div>\r\n"+
			"						</div>\r\n"+
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


}
