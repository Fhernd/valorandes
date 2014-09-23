/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: ConsultaDAO.java,v 1.10 
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 *
 * Ejercicio: VideoAndes
 * Autor: Juan Diego Toro - 1-Marzo-2010
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.valorAndes.DAO;

import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

import uniandes.cupi2.valorAndes.ValueObjetcts.Direccion;
import uniandes.cupi2.valorAndes.ValueObjetcts.Intermediario;
import uniandes.cupi2.valorAndes.ValueObjetcts.Inversionista;


/**
 * Clase ConsultaDAO, encargada de hacer las consultas b�sicas para el cliente
 */
public class ConsultaDAO {

	//----------------------------------------------------
	//Constantes
	//----------------------------------------------------
	/**
	 * ruta donde se encuentra el archivo de conexi�n.
	 */
	private static final String ARCHIVO_CONEXION = "./data/html/conexion.properties";
	
	/**
	 * nombre de la tabla videos
	 */
	private static final String tablaBebedores = "PARRANDEROS.BEBEDORES";

	//----------------------------------------------------
	//Consultas
	//----------------------------------------------------
	
	/**
	 * Consulta que devuelve isan, titulo, y a�o de los videos en orden alfabetico
	 */
	private static final String consultaVideosDefault="SELECT * FROM "+tablaBebedores;
	

	//----------------------------------------------------
	//Atributos
	//----------------------------------------------------
	/**
	 * conexion con la base de datos
	 */
	public Connection conexion;
	
	/**
	 * nombre del usuario para conectarse a la base de datos.
	 */
	private String usuario;
	
	/**
	 * clave de conexi�n a la base de datos.
	 */
	private String clave;
	
	/**
	 * URL al cual se debe conectar para acceder a la base de datos.
	 */
	private String cadenaConexion;
	
	/**
	 * constructor de la clase. No inicializa ningun atributo.
	 */
	public ConsultaDAO() 
	{		
		inicializar();
	}
	
	// -------------------------------------------------
    // M�todos
    // -------------------------------------------------

	/**
	 * obtiene ls datos necesarios para establecer una conexion
	 * Los datos se obtienen a partir de un archivo properties.
	 * @param path ruta donde se encuentra el archivo properties.
	 */
	public void inicializar()
	{
		try
		{
			File arch= new File(ARCHIVO_CONEXION);
			Properties prop = new Properties();
			FileInputStream in = new FileInputStream( arch );

	        prop.load( in );
	        in.close( );

			cadenaConexion = prop.getProperty("url");	// El url, el usuario y passwd deben estar en un archivo de propiedades.
												// url: "jdbc:oracle:thin:@chie.uniandes.edu.co:1521:chie10";
			usuario = prop.getProperty("usuario");	// "s2501aXX";
			clave = prop.getProperty("clave");	// "c2501XX";
			final String driver = prop.getProperty("driver");
			Class.forName(driver);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}

	/**
	 * M�todo que se encarga de crear la conexi�n con el Driver Manager
	 * a partir de los parametros recibidos.
	 * @param url direccion url de la base de datos a la cual se desea conectar
	 * @param usuario nombre del usuario que se va a conectar a la base de datos
	 * @param clave clave de acceso a la base de datos
	 * @throws SQLException si ocurre un error generando la conexi�n con la base de datos.
	 */
    private void establecerConexion(String url, String usuario, String clave) throws SQLException
    {
    	try
        {
			conexion = DriverManager.getConnection(url,usuario,clave);
        }
        catch( SQLException exception )
        {
            throw new SQLException( "ERROR: ConsultaDAO obteniendo una conexi�n." );
        }
    }
    
    /**
 	 *Cierra la conexi�n activa a la base de datos. Adem�s, con=null.
     * @param con objeto de conexi�n a la base de datos
     * @throws SistemaCinesException Si se presentan errores de conexi�n
     */
    public void closeConnection(Connection connection) throws Exception {        
		try {
			connection.close();
			connection = null;
		} catch (SQLException exception) {
			throw new Exception("ERROR: ConsultaDAO: closeConnection() = cerrando una conexi�n.");
		}
    } 
    
    // ---------------------------------------------------
    // M�todos asociados a los casos de uso: Consulta
    // ---------------------------------------------------
    
    /**
     * M�todo que se encarga de realizar la consulta en la base de datos
     * y retorna un ArrayList de elementos tipo VideosValue.
     * @return ArrayList lista que contiene elementos tipo VideosValue.
     * La lista contiene los videos ordenados alfabeticamente
     * @throws Exception se lanza una excepci�n si ocurre un error en
     * la conexi�n o en la consulta. 
     */
    public ArrayList<String> darNombresParranderos() throws Exception
    {
    	PreparedStatement prepStmt = null;
    	
    	ArrayList<String> videos = new ArrayList<String>();
    	
		try {
			establecerConexion(cadenaConexion, usuario, clave);
			prepStmt = conexion.prepareStatement(consultaVideosDefault);
			
			ResultSet rs = prepStmt.executeQuery();
			
			while(rs.next()){
				String idBeb = rs.getString("NOMBRE");
				videos.add(idBeb);
							
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(consultaVideosDefault);
			throw new Exception("ERROR = ConsultaDAO: loadRowsBy(..) Agregando parametros y executando el statement!!!");
		}finally 
		{
			if (prepStmt != null) 
			{
				try {
					prepStmt.close();
				} catch (SQLException exception) {
					
					throw new Exception("ERROR: ConsultaDAO: loadRow() =  cerrando una conexi�n.");
				}
			}
			closeConnection(conexion);
		}		
		return videos;
    }
    
    
    /**
     * Retorna un arrayList con el listado de inversionistas
     */
    public ArrayList<Inversionista> darInversionistas() throws Exception
    {
    	PreparedStatement prepStmt = null;
    	
    	ArrayList<Inversionista> inversionistas = new ArrayList<Inversionista>();
    	
		try {
			establecerConexion(cadenaConexion, usuario, clave);
			prepStmt = conexion.prepareStatement(""+
					"SELECT IX.ID_INVERSIONISTA, ix.TIPO_DOCUMENTO, ix.NOMBRE , IX.TELEFONO, IX.FK_ID_TIPO_INVER AS ID_TIPO_INV , TI.NOMBRE AS NOMBRE_TIPO_INV, IX.FK_ID_INTERMEDIARIO AS ID_INTERMEDIARIO, X.NOMBRE AS NOMBRE_INTERMEDIARIO,DIR.ID_DIRECCION,DIR.PAIS,  DIR.DEPARTAMENTO, DIR.CIUDAD, DIR.DIRECCION, DIR.COD_POSTAL AS CODIGO_POSTAL  FROM"+
					"((INVERSIONISTA IX  LEFT OUTER JOIN  TIPOINVERSIONISTA TI ON IX.FK_ID_TIPO_INVER=TI.ID_TIPO_INVERSIONISTA)"+
					"LEFT OUTER JOIN INTERMEDIARIO X ON IX.FK_ID_INTERMEDIARIO=X.ID_INTERMEDIARIO) LEFT OUTER JOIN DIRECCION DIR ON IX.FK_ID_DIRECCION = DIR.ID_DIRECCION");
			
			ResultSet rs = prepStmt.executeQuery();
			
			while(rs.next()){
				String id_Invers = rs.getString("ID_INVERSIONISTA");
				String identif = rs.getString("TIPO_DOCUMENTO");
				String nombre = rs.getString("NOMBRE");
				String telefono = rs.getString("TELEFONO");
				int tipoInv = rs.getInt("ID_TIPO_INV");
				String nombre_tipo_inv = rs.getString("NOMBRE_TIPO_INV");
				String id_intermediario = rs.getString("ID_INTERMEDIARIO");
				String nombre_intermediario = rs.getString("NOMBRE_INTERMEDIARIO");
				String id_direccion = rs.getString("ID_DIRECCION");
				String pais=rs.getString("PAIS");
				String depto=rs.getString("DEPARTAMENTO");
				String ciudad=rs.getString("CIUDAD");
				String direccion=rs.getString("DIRECCION");
				
				Intermediario intermediario = new Intermediario();
				intermediario.setId_Intermediario(id_intermediario);
				intermediario.setNombre(nombre_intermediario);
				
				Direccion dirInv = new Direccion(pais, depto, ciudad, direccion, rs.getString("CODIGO_POSTAL"), id_direccion);
				ArrayList<Direccion> dirs = new ArrayList<Direccion>();
				dirs.add(dirInv);
				
				Inversionista inv = new Inversionista(id_Invers, identif, 0, nombre, telefono, "", "", dirs, tipoInv, nombre_tipo_inv, intermediario, null, null);
				inversionistas.add(inv);
							
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("ERROR = ConsultaDAO: loadRowsBy(..) Agregando parametros y executando el statement!!!");
		}finally 
		{
			if (prepStmt != null) 
			{
				try {
					prepStmt.close();
				} catch (SQLException exception) {
					
					throw new Exception("ERROR: ConsultaDAO: loadRow() =  cerrando una conexi�n.");
				}
			}
			closeConnection(conexion);
		}		
		return inversionistas;
    }
    
}
