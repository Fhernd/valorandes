package uniandes.cupi2.valorAndes.Fachada;

import java.util.ArrayList;

import sun.applet.Main;
import uniandes.cupi2.valorAndes.DAO.ConsultaDAO;
import uniandes.cupi2.valorAndes.ValueObjetcts.Inversionista;

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
    
    public ArrayList<String> darNombresParranderos()
    {
    	ArrayList<String> resultado = new ArrayList<String>();
    	try
    	{
    		resultado= dao.darNombresParranderos();
    		
    	}
    	catch (Exception e) {
			System.out.println("Error al ejecutar sentencia SQL");
		}
    	return resultado;
    }
    
    public ArrayList<Inversionista> darInversionistas()
    {
    	ArrayList<Inversionista> resultado = new ArrayList<Inversionista>();
    	try
    	{
    		resultado= dao.darInversionistas();
    		
    	}
    	catch (Exception e) {
			System.out.println("Error al ejecutar sentencia SQL");
		}
    	System.out.println("Se realizo la consulta");
    	return resultado;
    	
    }
    
    
    public static void main(String[] args) {
		ValorAndes o = ValorAndes.darInstancia();
		ArrayList<String> ops = o.darNombresParranderos();
		int c=0;
		for (int i =0; i < ops.size(); i++)
		{
			System.out.println("Nombre:"+ops.get(i));
			c=i;
		}
		System.out.println("Fin");
		System.out.println("Elementos: "+c);
	}
	

}
