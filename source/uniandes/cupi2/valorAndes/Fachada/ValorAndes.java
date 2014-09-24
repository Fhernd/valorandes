package uniandes.cupi2.valorAndes.Fachada;

import java.util.ArrayList;
import java.util.LinkedList;

import sun.applet.Main;
import uniandes.cupi2.valorAndes.DAO.ConsultaDAO;
import uniandes.cupi2.valorAndes.ValueObjetcts.Emisor;
import uniandes.cupi2.valorAndes.ValueObjetcts.Intermediario;
import uniandes.cupi2.valorAndes.ValueObjetcts.Inversionista;
import uniandes.cupi2.valorAndes.ValueObjetcts.TipoRentabilidad;
import uniandes.cupi2.valorAndes.ValueObjetcts.TipoValor;
import uniandes.cupi2.valorAndes.ValueObjetcts.Valor;

public class ValorAndes {
	
	/**
	 * Conexión con la clase que maneja la base de datos
	 */
	private ConsultaDAO dao;
	
	public static ValorAndes instancia;
	
	/**
     * Devuelve la instancia única de la clase
     * @return Instancia única de la clase
     */
    public static ValorAndes darInstancia( )
    {
        if( instancia == null )
        {
            instancia = new ValorAndes( );
        }
        return instancia;
    }
    
    private ValorAndes()
    {
    	dao = new ConsultaDAO();
    }
    
  
    
    public LinkedList<Inversionista> darInversionistas()
    {
    	LinkedList<Inversionista> resultado = new LinkedList<Inversionista>();
    	try
    	{
    		resultado= dao.darInversionistas();
    	}
    	catch (Exception e) {
			System.out.println("Error al ejecutar sentencia SQL");
		}
    	
    	return resultado;
    	
    }
    
    
    public LinkedList<Emisor> darEmisores()
    {
    	LinkedList<Emisor> resultado = new LinkedList<Emisor>();
    	try
    	{
    		resultado= dao.darEmisores();
    	}
    	catch (Exception e) {
			System.out.println("Error al ejecutar sentencia SQL de darEmisores");
		}
    	
    	return resultado;
    	
    }
    
    public LinkedList<Intermediario> darIntermediarios()
    {
    	LinkedList<Intermediario> resultado = new LinkedList<Intermediario>();
    	try
    	{
    		resultado = dao.darIntermediarios();
    	}
    	catch (Exception e) {
			System.out.println("Error al ejecutar sentencia SQL de dar Intermediarios");
		}
    	return resultado;
    }
    
    public LinkedList<TipoValor> darTiposValor()
    {
    	LinkedList<TipoValor> resultado = new LinkedList<TipoValor>();
    	try
    	{
    		resultado = dao.darTiposDeValor();
    	}
    	catch (Exception e) {
			System.out.println("Error al ejecutar sentencia SQL de dar Tipos de valor");
		}
    	return resultado;
    }
    
    public LinkedList<Emisor> darEmpresasOfertanTipo (String nIdTipo)
    {
    	LinkedList<Emisor> resultado = new LinkedList<Emisor>();
    	try
    	{
    		resultado = dao.darEmpresasOfertanTipo(nIdTipo);
    	}
    	catch (Exception e) {
			System.out.println("Error al ejecutar sentencia SQL de dar las empresas que ofertan un tipo de producto");
		}
    	return resultado;
    }
    
    public LinkedList<TipoValor> darTiposOfertadosEmpresa(String nNit_empresa)
    {
    	LinkedList<TipoValor> resultado = new LinkedList<TipoValor>();
    	try
    	{
    		resultado = dao.darTiposOfertadosEmpresa(nNit_empresa);
    	}
    	catch (Exception e) {
			System.out.println("Error al ejecutar sentencia SQL los tipos que oferta una empresa");
		}
    	return resultado;
    }
    
    public LinkedList<TipoRentabilidad> darTiposRentabilidad()
    {
    	LinkedList<TipoRentabilidad> resultado = new LinkedList<TipoRentabilidad>();
    	try
    	{
    		resultado = dao.darTiposRentabilidad();
    	}
    	catch (Exception e) {
			System.out.println("Error al ejecutar sentencia SQL de TIPOS DE RENTABILIDAD");
		}
    	return resultado;
    }
    
    public LinkedList<Valor> darTodosLosValores()
    {
    	LinkedList<Valor> resultado = new LinkedList<Valor>();
    	try
    	{
    		resultado = dao.darTodosLosValores();
    	}
    	catch (Exception e) {
			System.out.println("Error al ejecutar sentencia SQL de darTodosLosValores");
		}
    	return resultado;
    }
	

}
