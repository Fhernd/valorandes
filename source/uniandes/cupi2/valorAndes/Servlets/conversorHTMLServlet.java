package uniandes.cupi2.valorAndes.Servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class conversorHTMLServlet {
	public final static String RUTA_BRAHIAN_SAVE = "C:\\Users\\David\\Desktop\\n17final\\n17_CupiFlights\\save\\";
	
	public conversorHTMLServlet()
	{
		try
		{
			File ruta = new File("./Data/htmlOrigen.txt");
			File resultado = new File("./Data/servletResultado.txt");
			BufferedReader lector= new BufferedReader(new FileReader(ruta));
			String lectura="";
			String servlet="";
			
			while(lector.ready())
			{
				lectura = lector.readLine();
				if (lectura.contains("***AQUI***"))
				{
					servlet+=lectura+"\n";
				}
				else
				{
					servlet+="\"";
					for(int i = 0; i < lectura.length(); i++)
					{
						char x = lectura.charAt(i);
						if(x=='"')
						{
							servlet+="\\\"";
						}
						else if (x=='\\')
						{
							servlet+="\\\\";
						}
						else
						{
							servlet+=x;
						}
					}
					servlet+="\\r\\n\"+\n";
				}				
			}			
			
			servlet= servlet.substring(0, servlet.length()-2);
			servlet+=";";

			PrintWriter salida = new PrintWriter(new FileWriter(resultado));
			salida.write(servlet);
			salida.close();
			lector.close();
			System.out.println("Conversion finalizada");
			
		}
		catch(Exception x)
		{
			System.out.println("Error en algun procedimiento");
		}
		
		
	}
	
	public static void main(String [] args)
	{
		new conversorHTMLServlet();
	}

}
