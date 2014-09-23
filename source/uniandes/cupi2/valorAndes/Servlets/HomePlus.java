package uniandes.cupi2.valorAndes.Servlets;

import java.io.PrintWriter;
import java.util.ArrayList;

import uniandes.cupi2.valorAndes.Fachada.ValorAndes;
import uniandes.cupi2.valorAndes.ValueObjetcts.Inversionista;


public class HomePlus 
{
	private PrintWriter out;
	private ValorAndes instancia;
	public HomePlus(PrintWriter salida)
	{
		out = salida;
		instancia= ValorAndes.darInstancia();
		out.println(cabecera);
		printInversionistas();
		out.println(finx);
	}
	
	public void printInversionistas()
	{
		String add ="";
		ArrayList<Inversionista> invs = instancia.darInversionistas();
		for (int i = 0; i < invs.size(); i++)
		{
			Inversionista act = invs.get(i);
			add+="inHtml += \"<option value=\\\""+act.getId_Inversionista()+"\\\">"+"("+act.getId_Inversionista()+")"+act.getNombre()+"</option>\";";
		}
		out.println(add);
	}
	
	
	String cabecera = ""+
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
			"		<link href=\"css/start/jquery-ui-1.10.4.custom.css\" rel=\"stylesheet\">\r\n"+
			"	<script src=\"js/jquery-1.10.2.js\"></script>\r\n"+
			"	<script src=\"js/jquery-ui-1.10.4.custom.js\"></script>\r\n"+
			"	<script>\r\n"+
			"	$(function() {		\r\n"+
			"		$( \"#datepicker\" ).datepicker({\r\n"+
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
			"	<link href=\"css/start/jquery-ui-1.10.4.custom.css\" rel=\"stylesheet\">\r\n"+
			"	<script src=\"js/jquery-1.10.2.js\"></script>\r\n"+
			"	<script src=\"js/jquery-ui-1.10.4.custom.js\"></script>\r\n"+
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
			"	\r\n"+
			"	<link href=\"css/start/jquery-ui-1.10.4.custom.css\" rel=\"stylesheet\">\r\n"+
			"	<script src=\"js/jquery-1.10.2.js\"></script>\r\n"+
			"	<script src=\"js/jquery-ui-1.10.4.custom.js\"></script>\r\n"+
			"	<script>\r\n"+
			"	$(function() {		\r\n"+
			"		$( \"#datepicker4\" ).datepicker({\r\n"+
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
			"	<link href=\"css/start/jquery-ui-1.10.4.custom.css\" rel=\"stylesheet\">\r\n"+
			"	<script src=\"js/jquery-1.10.2.js\"></script>\r\n"+
			"	<script src=\"js/jquery-ui-1.10.4.custom.js\"></script>\r\n"+
			"	<script>\r\n"+
			"	$(function() {		\r\n"+
			"		$( \"#datepicker5\" ).datepicker({\r\n"+
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
			"	\r\n"+
			"	\r\n"+
			"	</head>\r\n"+
			"	<body>\r\n"+
			"\r\n"+
			"		<!-- Nav -->\r\n"+
			"			<nav id=\"nav\">\r\n"+
			"				<ul class=\"container\">\r\n"+
			"					<li><a href=\"#top\"><img src=\"images/valores/home.png\"  height=\"90\" width=\"90\"  alt=\"Home CupiFlights\" style=\"height : 73px;padding: 0px; margin: 0px; width : 61px;\"/></a></li>\r\n"+
			"					<!--  \r\n"+
			"					<li><a href=\"#ordenar\">Ordenar Operacion</a></li>\r\n"+
			"					<li><a href=\"#cancelar\">Cancelar transaccion</a></li>\r\n"+
			"					<li><a href=\"#about\" valign=\"MIDDLE\">Info</a></li>\r\n"+
			"					 --> \r\n"+
			"				</ul>\r\n"+
			"			</nav>\r\n"+
			"\r\n"+
			"		<!-- Bienvenido -->\r\n"+
			"			<div class=\"wrapper wrapper-style6 wrapper-first\">\r\n"+
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
			"			<div class=\"wrapper wrapper-style3 \">\r\n"+
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
			"\r\n"+
			"		<!-- Cancelar transaccion  -->\r\n"+
			"			<div class=\"wrapper wrapper-style2 \">\r\n"+
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
			"							<form action=\"cancelar.htm\" class=\"ok\" method=\"post\" id=\"form_cancelar\">\r\n"+
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
			"												<select name=\"Id Usuario\" style=\"width: 400px\"  id=\"id_usuario_cancel\"  disabled=\"disabled\" required onchange=\"act3(this)\" onfocus=\"act3(this)\" \">\r\n"+
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
			"										inHtml += \"<option value=\\\"null\\\">-- Id Emisor --</option>\";\r\n"+
			"						                inHtml += \"<option value=\\\"actua.darId()\\\"> EMPRESA actual.darNombreUsuario</option>\";\r\n"+
			"						                t2.innerHTML = inHtml;\r\n"+
			"									}\r\n"+
			"									else if(tipoc.value=='Inversionista')\r\n"+
			"									{\r\n"+
			"										t2.disabled=false;\r\n"+
			"										inHtml += \"<option value=\\\"null\\\">-- Id Inversionista --</option>\";\r\n";
									               
			String finx ="						                t2.innerHTML = inHtml;\r\n"+
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
			"			\r\n"+
			"			<!-- Comprar Producto  -->\r\n"+
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
			"										<p style=\"margin-left: 20px\" align=\"center\">\r\n"+
			"											\r\n"+
			"												<input type=\"text\" list=\"inversionistas\" title=\"Inversionista\"  placeholder=\"Inversionista\" style=\"width: 200px; display: inline;vertical-align: middle; margin: 5px\" required>\r\n"+
			"												<datalist id=inversionistas >\r\n"+
			"												   <option value=\"id_inv\" label=\"Nombre inversionista\">\r\n"+
			"												</datalist>												\r\n"+
			"																					\r\n"+
			"												<input type=\"text\" list=\"tipo_producto\" title=\"Tipo Producto\" placeholder=\"Tipo Producto\" style=\"width: 250px; display: inline; vertical-align: middle;margin: 5px\" required>\r\n"+
			"												<datalist id=tipo_producto >\r\n"+
			"												   <option value=\"id_producto\" label=\"Nombre del tipo del producto\">\r\n"+
			"												</datalist>												\r\n"+
			"											\r\n"+
			"												<input type=\"text\" list=\"oferentes\" title=\"Oferente\" placeholder=\"Entidad Emisora\" style=\"width: 250px; vertical-align: middle; margin: 5px\" required>\r\n"+
			"												<datalist id=oferentes >\r\n"+
			"												   <option value=\"id_oferente\" label=\"Nombre del oferente\">\r\n"+
			"												</datalist>												\r\n"+
			"											\r\n"+
			"										\r\n"+
			"												<select name=\"opc\" style=\"height: 60px; width: 200px; vertical-align: middle; text-align: center;\">\r\n"+
			"												<option value=\"cantidad\" label=\"cantidad\" ></option>\r\n"+
			"												<option value=\"monto\" label=\"monto\"></option> \r\n"+
			"												</select>\r\n"+
			"												<input type=\"number\" title=\"Cantidad\" value=\"00\" style=\"width: 150px; margin: 5px\" required >\r\n"+
			"											</p>\r\n"+
			"											\r\n"+
			"											<div class=\"row\">\r\n"+
			"											<div class=\"12u\" align=\"center\" form=\"form_comprar\">												\r\n"+
			"												<input  class=\"button form-button-submit\" type=\"submit\" value=\"Generar Transacción\"/>									\r\n"+
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
			"						</div>\r\n"+
			"					</div>\r\n"+
			"				</article>\r\n"+
			"			</div>\r\n"+
			"			\r\n"+
			"			<!--Vener Producto  -->\r\n"+
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
			"							<form action=\"vender.htm\" class=\"ok\" method=\"get\"  id=\"form_vender\" name=\"form_vender\">\r\n"+
			"							\r\n"+
			"										<p style=\"margin-left: 20px\" align=\"center\">\r\n"+
			"																					\r\n"+
			"																							\r\n"+
			"											\r\n"+
			"												<input type=\"text\" list=\"oferentes\" title=\"Oferente\" placeholder=\"Entidad Emisora\" name=\"Empresa\" style=\"width: 250px; vertical-align: middle; margin: 5px\" required>\r\n"+
			"												<datalist id=oferentes >\r\n"+
			"												   <option value=\"id_oferente\" label=\"Nombre del oferente\">\r\n"+
			"												</datalist>	\r\n"+
			"												\r\n"+
			"												<input type=\"text\" list=\"tipo_producto\" title=\"Tipo Producto\" placeholder=\"Tipo Producto\" name=\"tipoProducto\" style=\"width: 250px; display: inline; vertical-align: middle;margin: 5px\" required>\r\n"+
			"												<datalist id=tipo_producto >\r\n"+
			"												   <option value=\"id_producto\" label=\"Nombre del tipo del producto\">\r\n"+
			"												</datalist>	\r\n"+
			"																							\r\n"+
			"											</br>\r\n"+
			"												<strong>CANTIDAD DE PRODUCTOS: </strong>\r\n"+
			"												 <input type=\"number\" title=\"Cantidad\" value=\"00\" style=\"width: 150px; margin: 5px\" required >\r\n"+
			"											</p>\r\n"+
			"											\r\n"+
			"											<div class=\"row\">\r\n"+
			"											<div class=\"12u\" align=\"center\" >												\r\n"+
			"												<input  class=\"button form-button-submit\" type=\"submit\" value=\"Poner en Venta\"/>									\r\n"+
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
			"						</div>\r\n"+
			"					</div>\r\n"+
			"				</article>\r\n"+
			"			</div>\r\n"+
			"			\r\n"+
			"			<!-- Consultas -->\r\n"+
			"			<div class=\"wrapper wrapper-style2\">\r\n"+
			"				<article class=\"container\" id=\"consultas\">\r\n"+
			"							<header>\r\n"+
			"								<h1 align=\"center\"><strong>Consultas</strong></h1>\r\n"+
			"							</header>\r\n"+
			"							\r\n"+
			"							<p>					\r\n"+
			"								<a href=\"#valores\"  style=\"\"><img src=\"images/valores/existencia.png\"  title=\"Valores Disponibles\" alt=\"Valores Disponibles\" style=\"margin: 20px\"/></a>\r\n"+
			"								<a href=\"#movimientos\" ><img src=\"images/valores/movimientos.png\"  title=\"Comprar Productos\" alt=\"Comprar Productos\" style=\"margin: 20px\"/></a>\r\n"+
			"								<a href=\"#masMovidos\" ><img src=\"images/valores/movidos.png\"  title=\"Valor más movido\" alt=\"Valor más movido\" style=\"margin: 20px\"/></a>\r\n"+
			"								<a href=\"#masActivo\" ><img src=\"images/valores/intermediario.png\"  title=\"Intermediario más activo\" alt=\"Intermediario más activo\" style=\"margin: 20px\"/></a>\r\n"+
			"								</p>\r\n"+
			"				</article>\r\n"+
			"			</div>\r\n"+
			"			\r\n"+
			"			<!-- Registrar acuerdo-->\r\n"+
			"			<div class=\"wrapper wrapper-style3 \">\r\n"+
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
			"								<div>\r\n"+
			"										<div class=\"row half\">\r\n"+
			"											<div class=\"6u\" align=\"center\" >\r\n"+
			"												<input type=\"text\" list=id_inv title=\"Inversionista\" placeholder=\"Inversionista\" name=\"Inversionista\" style=\"width: 250px\" required>\r\n"+
			"												<datalist id=id_inv >\r\n"+
			"												   <option value=\"ID_Inv\" label=\"Nombre Inv\">\r\n"+
			"												</datalist>												\r\n"+
			"											</div>\r\n"+
			"											\r\n"+
			"											<div class=\"6u\" align=\"center\" >\r\n"+
			"												<input type=\"text\" list=\"solicitudes\" title=\"Id Solicitud\" placeholder=\"Solicitud\" style=\"width: 400px\" required>\r\n"+
			"												\r\n"+
			"												<datalist id=\"solicitudes\">\r\n"+
			"												<option value=\"id_solicitud\">nombre oferente; cant; producto\r\n"+
			"												<option>empresa2\r\n"+
			"												<option>empresa3\r\n"+
			"												</datalist>\r\n"+
			"											</div>\r\n"+
			"										\r\n"+
			"										</div>\r\n"+
			"										<div class=\"row\">\r\n"+
			"											<div class=\"12u\" align=\"center\">												\r\n"+
			"												<input  class=\"button form-button-submit\" type=\"submit\" value=\"Registrar Operación\"/>									\r\n"+
			"											</div>\r\n"+
			"											<p></p>\r\n"+
			"										</div>\r\n"+
			"									</div>\r\n"+
			"							</form>\r\n"+
			"						</div>\r\n"+
			"					</div>\r\n"+
			"				</article>\r\n"+
			"			</div>\r\n"+
			"			\r\n"+
			"			\r\n"+
			"			<!-- Calificacion vuelos -->\r\n"+
			"			<div class=\"wrapper wrapper-style3\">\r\n"+
			"				<article id=\"registrar\">\r\n"+
			"							<header>\r\n"+
			"								<h1 align=\"center\"><strong>Busqueda de vuelos por Calificacion</strong></h1>\r\n"+
			"							</header>\r\n"+
			"					<form action=\"flightsRating.htm\" class=\"ok\" method=\"post\">	\r\n"+
			"					<input type=hidden name=\"admin\" value=\"false\">							\r\n"+
			"							<div class=\"container\" align=\"center\">\r\n"+
			"								<div class=\"row\">\r\n"+
			"									<div class=\"4u\">\r\n"+
			"										<section class=\"box box-style1\">\r\n"+
			"										<h3>Fecha inicial</h3>\r\n"+
			"										<input type=\"text\"\"text\"  id=\"datepicker4\" name=\"desde\"  placeholder=\"mm/dd/aaaa\" >\r\n"+
			"									</div>\r\n"+
			"									<div class=\"4u\">\r\n"+
			"										<section class=\"box box-style1\">\r\n"+
			"											<h3>Fecha final</br></h3>\r\n"+
			"											<input type=\"text\"\"text\"  id=\"datepicker5\" name=\"hasta\"  placeholder=\"mm/dd/aaaa\" >											\r\n"+
			"											<p></p>\r\n"+
			"										</section>\r\n"+
			"										<input  class=\"button form-button-submit\" type=\"submit\" name=\"consultar\" id=\"consultar\" value=\"Consultar\"/>\r\n"+
			"									</div>\r\n"+
			"									<div class=\"4u\">\r\n"+
			"										<section class=\"box box-style1\">\r\n"+
			"											<h3>Calificacion</br></h3>											\r\n"+
			"											<p><input type=\"number\" name=\"califmin\" min=\"0\" max =\"10\" autocomplete=”off”  placeholder=\"desde\"  required=\"required\" style=\"width: 100px\"> <strong>-</strong> \r\n"+
			"											<input type=\"number\" name=\"califmax\" min=\"0\" max =\"10\" autocomplete=”off”  placeholder=\"hasta\"  required=\"required\" style=\"width: 100px\"></p>\r\n"+
			"										</section>\r\n"+
			"									</div>\r\n"+
			"								</div>\r\n"+
			"							</div>\r\n"+
			"					</form>\r\n"+
			"				</article>\r\n"+
			"			</div>\r\n"+
			"			\r\n"+
			"			\r\n"+
			"			<!-- Valores más movidos -->\r\n"+
			"			<div class=\"wrapper wrapper-style2 \">\r\n"+
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
			"			<!-- Work -->\r\n"+
			"			<div class=\"wrapper wrapper-style2\">\r\n"+
			"				<article id=\"aerolineas\">\r\n"+
			"							<header>\r\n"+
			"								<h1 align=\"center\"><strong>Aerolineas mas puntuales</strong></h1>\r\n"+
			"								<h3 align=\"center\">Consulte cuales son las aerolineas con el menor y el mayor numero de vuelos tardios</h3>\r\n"+
			"							</header>\r\n"+
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
			"								<p><h3><Strong> Brahian David Rangel </br> John Ortiz </br>- ValorAndes+ - Sistemas Transaccionales - Nivel 1 -</br></br>Departamento de Ingeniería de Sistemas y Computación</br> 2014 - 10</strong></h3></p>								\r\n"+
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
