/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: ConsultaDAO.java,v 1.10 
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
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
import java.util.LinkedList;
import java.util.Properties;

import com.lowagie.text.List;

import uniandes.cupi2.valorAndes.ValueObjetcts.Direccion;
import uniandes.cupi2.valorAndes.ValueObjetcts.Emisor;
import uniandes.cupi2.valorAndes.ValueObjetcts.Intermediario;
import uniandes.cupi2.valorAndes.ValueObjetcts.Inversionista;
import uniandes.cupi2.valorAndes.ValueObjetcts.TipoRentabilidad;
import uniandes.cupi2.valorAndes.ValueObjetcts.TipoValor;
import uniandes.cupi2.valorAndes.ValueObjetcts.Valor;


/**
 * Clase ConsultaDAO, encargada de hacer las consultas básicas para el cliente
 */
public class ConsultaDAO {

	//----------------------------------------------------
	//Constantes
	//----------------------------------------------------
	
	private static final int FALSO = 0;
	private static final int VERDADERO = 1;
	/**
	 * ruta donde se encuentra el archivo de conexión.
	 */
	private static final String ARCHIVO_CONEXION_BRAHIAN = "C:\\Users\\David\\Desktop\\n1_valorAndes\\data\\conexion.properties";
	private static final String ARCHIVO_CONEXION=ARCHIVO_CONEXION_BRAHIAN;
	/**
	 * nombre de la tabla videos
	 */
	private static final String tablaBebedores = "PARRANDEROS.BEBEDORES";

	//----------------------------------------------------
	//Consultas
	//----------------------------------------------------
	
	/**
	 * Consulta que devuelve isan, titulo, y año de los videos en orden alfabetico
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
	 * clave de conexión a la base de datos.
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
    // Métodos
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
			try
			{
				cadenaConexion = "jdbc:oracle:thin:@prod.oracle.virtual.uniandes.edu.co:1531:prod";	// El url, el usuario y passwd deben estar en un archivo de propiedades.			
				usuario = "ISIS2304241420";	
				clave = "bordiona1a1ed";	
				final String driver = "oracle.jdbc.driver.OracleDriver";
				Class.forName(driver);
				System.out.println("Ha fallado la lectura de las properties. Se ha forzado la conexion");
			}
			catch (Exception x)
			{
				x.printStackTrace();
				System.out.println("Imposible obtener el driver de la DB");
			}
			
		}	
	}

	/**
	 * Método que se encarga de crear la conexión con el Driver Manager
	 * a partir de los parametros recibidos.
	 * @param url direccion url de la base de datos a la cual se desea conectar
	 * @param usuario nombre del usuario que se va a conectar a la base de datos
	 * @param clave clave de acceso a la base de datos
	 * @throws SQLException si ocurre un error generando la conexión con la base de datos.
	 */
    private void establecerConexion(String url, String usuario, String clave) throws SQLException
    {
    	try
        {
			conexion = DriverManager.getConnection(url,usuario,clave);
        }
        catch( SQLException exception )
        {
            throw new SQLException( "ERROR: ConsultaDAO obteniendo una conexi—n." );
        }
    }
    
    /**
 	 *Cierra la conexión activa a la base de datos. Además, con=null.
     * @param con objeto de conexión a la base de datos
     * @throws SistemaCinesException Si se presentan errores de conexión
     */
    public void closeConnection(Connection connection) throws Exception {        
		try {
			connection.close();
			connection = null;
		} catch (SQLException exception) {
			throw new Exception("ERROR: ConsultaDAO: closeConnection() = cerrando una conexión.");
		}
    } 
    
    // ---------------------------------------------------
    // Métodos asociados a los casos de uso: Consulta
    // ---------------------------------------------------
    
    
    
    /**
     * Retorna un arrayList con el listado de inversionistas
     */
    public LinkedList<Inversionista> darInversionistas() throws Exception
    {
    	PreparedStatement prepStmt = null;
    	
    	LinkedList<Inversionista> inversionistas = new LinkedList<Inversionista>();
    	
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
				
				Inversionista inv = new Inversionista(id_Invers, identif, 0, nombre, telefono, "", "", dirInv, tipoInv, nombre_tipo_inv, intermediario, null, null);
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
					
					throw new Exception("ERROR: ConsultaDAO: loadRow() =  cerrando una conexión.");
				}
			}
			closeConnection(conexion);
		}		
		return inversionistas;
    }
    
    
    /**
     * Retorna un arrayList con el listado de empresas emisoras
     */
    public LinkedList<Emisor> darEmisores() throws Exception
    {
    	PreparedStatement prepStmt = null;
    	
    	LinkedList<Emisor> emisores = new LinkedList<Emisor>();
    	
		try {
			establecerConexion(cadenaConexion, usuario, clave);
			prepStmt = conexion.prepareStatement("SELECT EMI.* , INTER.ID_INTERMEDIARIO, INTER.NOMBRE AS NOMBRE_INTERMEDIARIO, INTER.REGISTRO_RNMV AS RNMV_INTERMEDIARIO, DIR.* "+
												 "FROM (EMISOR EMI LEFT OUTER JOIN INTERMEDIARIO INTER ON EMI.FK_ID_INTERMEDIARIO=INTER.ID_INTERMEDIARIO) LEFT OUTER JOIN DIRECCION DIR ON EMI.FK_ID_DIRECCION=DIR.ID_DIRECCION");
			
			ResultSet rs = prepStmt.executeQuery();
			
			while(rs.next()){
				
				String nombreEmisor = rs.getString("NOMBRE");
				String nombreInterm = rs.getString("NOMBRE_INTERMEDIARIO");
				String nitEmisor = rs.getString("NIT");
				String paginaWebEmisor = rs.getString("WEB");
				String registroEmisor = rs.getString("REGISTRO_RNV");
				String idEmisor = rs.getString("ID_EMPRESA");
				String telEmisor = rs.getString("TELEFONO");
				String nombreRepLegalEmisor = rs.getString("NOMBRE_REP_LEGAL");
				String identificacion_Rep_Legal_Emisor = rs.getString("ID_REP_LEGAL");
				String id_intermediario = rs.getString("ID_INTERMEDIARIO");
				String registroIntermediario = rs.getString("RNMV_INTERMEDIARIO");
				String id_direccion = rs.getString("ID_DIRECCION");
				String pais=rs.getString("PAIS");
				String depto=rs.getString("DEPARTAMENTO");
				String ciudad=rs.getString("CIUDAD");
				String direccion=rs.getString("DIRECCION");				
				
				Intermediario intermediario = new Intermediario();
				intermediario.setId_Intermediario(id_intermediario);
				intermediario.setNombre(nombreInterm);
				
				Direccion dirEmisor = new Direccion(pais, depto, ciudad, direccion, rs.getString("COD_POSTAL"), id_direccion);
				
				Emisor emisor = new Emisor(nombreEmisor, nitEmisor, paginaWebEmisor, registroEmisor, "0", telEmisor, nombreRepLegalEmisor, identificacion_Rep_Legal_Emisor, dirEmisor, intermediario, null, null);
				emisores.add(emisor);
							
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
					
					throw new Exception("ERROR: ConsultaDAO: loadRow() =  cerrando una conexión.");
				}
			}
			closeConnection(conexion);
		}		
		return emisores;
    }
    
    
    public LinkedList<Intermediario> darIntermediarios() throws Exception
    {
    	PreparedStatement prepStmt = null;
    	LinkedList<Intermediario> intermediarios = new LinkedList<Intermediario>();
    	
    	try {
			establecerConexion(cadenaConexion, usuario, clave);
			prepStmt = conexion.prepareStatement("SELECT * FROM INTERMEDIARIO INTER  INNER JOIN DIRECCION DIR ON INTER.FK_ID_DIRECCION= DIR.ID_DIRECCION");
			
			ResultSet rs = prepStmt.executeQuery();
			
			while(rs.next()){
				
				String id_intermediario = rs.getString("ID_INTERMEDIARIO");
				String nombre_intermediario = rs.getString("NOMBRE");
				String nombre_rep_legal = rs.getString("NOMBRE_REP_LEGAL");
				String tel_inter = rs.getString("TELEFONO");
				String registro_interm = rs.getString("REGISTRO_RNMV");
				String cedula_rep_legal = rs.getString("ID_REP_LEGAL");
				
				String id_direccion = rs.getString("ID_DIRECCION");
				String pais=rs.getString("PAIS");
				String depto=rs.getString("DEPARTAMENTO");
				String ciudad=rs.getString("CIUDAD");
				String direccion=rs.getString("DIRECCION");				
				
				Direccion dirIntermediario = new Direccion(pais, depto, ciudad, direccion, rs.getString("COD_POSTAL"), id_direccion);
				Intermediario nuevo = new Intermediario(nombre_intermediario, tel_inter, registro_interm, id_intermediario, nombre_rep_legal, cedula_rep_legal, dirIntermediario, null);
				intermediarios.add(nuevo);
							
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
					
					throw new Exception("ERROR: ConsultaDAO: loadRow() =  cerrando una conexión.");
				}
			}
			closeConnection(conexion);
		}	
    	
    	return intermediarios;
    }
    
    
    public LinkedList<TipoValor> darTiposDeValor() throws Exception
    {    	
    	LinkedList<TipoValor> tiposValor = new LinkedList<TipoValor>();
    	PreparedStatement prepStmt = null;
    	try {
			establecerConexion(cadenaConexion, usuario, clave);
			prepStmt = conexion.prepareStatement("SELECT * FROM TIPOVALOR");			
			ResultSet rs = prepStmt.executeQuery();			
			while(rs.next())
			{
				int id_valor = rs.getInt("ID_TIPO_VALOR");
				String nombre_valor = rs.getString("NOMBRE_VALOR");
				String descripcion = rs.getString("DESCRIPCION");
				TipoValor nuevoTipo = new TipoValor(""+id_valor, nombre_valor, nombre_valor, false);
				tiposValor.add(nuevoTipo);
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
					
					throw new Exception("ERROR: ConsultaDAO: loadRow() =  cerrando una conexión.");
				}
			}
			closeConnection(conexion);
		}	
    	
    	return tiposValor;
    }
    
    public LinkedList<Emisor> darEmpresasOfertanTipo (String nId_tipo) throws Exception
    {
    	LinkedList<Emisor> empresas = new LinkedList<Emisor>();
    	PreparedStatement prepStmt = null;
    	try {
			establecerConexion(cadenaConexion, usuario, clave);
			prepStmt = conexion.prepareStatement("SELECT EMI.*, DIR.* FROM (EMISOR EMI INNER JOIN DIRECCION DIR ON EMI.FK_ID_DIRECCION=DIR.ID_DIRECCION)INNER JOIN VALOR VAL ON  EMI.NIT = VAL.FK_EMISOR WHERE VAL.FK_ID_TIPO_VALOR='"+nId_tipo.trim()+"'");			
			ResultSet rs = prepStmt.executeQuery();			
			while(rs.next())
			{
				String nombreEmisor = rs.getString("NOMBRE");
				String nitEmisor = rs.getString("NIT");
				String paginaWebEmisor = rs.getString("WEB");
				String registroEmisor = rs.getString("REGISTRO_RNV");
				String idEmisor = rs.getString("ID_EMPRESA");
				String telEmisor = rs.getString("TELEFONO");
				String nombreRepLegalEmisor = rs.getString("NOMBRE_REP_LEGAL");
				String identificacion_Rep_Legal_Emisor = rs.getString("ID_REP_LEGAL");
				String id_direccion = rs.getString("ID_DIRECCION");
				String pais=rs.getString("PAIS");
				String depto=rs.getString("DEPARTAMENTO");
				String ciudad=rs.getString("CIUDAD");
				String direccion=rs.getString("DIRECCION");
				String id_intermediario = rs.getString("FK_ID_INTERMEDIARIO");
				String cod_postal = rs.getString("COD_POSTAL");
				
				Intermediario inter = new Intermediario();
				inter.setId_Intermediario(id_intermediario);
				Emisor nuevo = new Emisor(nombreEmisor, nitEmisor, paginaWebEmisor, registroEmisor, idEmisor, telEmisor, nombreEmisor, identificacion_Rep_Legal_Emisor, new Direccion(pais, depto, ciudad, direccion, cod_postal, id_direccion), inter,null, null);
				empresas.add(nuevo);
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
					
					throw new Exception("ERROR: ConsultaDAO: loadRow() =  cerrando una conexión.");
				}
			}
			closeConnection(conexion);
		}	
    	return empresas;
    }
    
    
    public LinkedList<TipoValor> darTiposOfertadosEmpresa (String nNitEmpresa) throws Exception
    {
    	LinkedList<TipoValor> tipos = new LinkedList<TipoValor>();
    	PreparedStatement prepStmt = null;
    	try {
			establecerConexion(cadenaConexion, usuario, clave);
			prepStmt = conexion.prepareStatement("SELECT * FROM (TIPOVALOR TIPO INNER JOIN VALOR VAL ON TIPO.ID_TIPO_VALOR=VAL.FK_ID_TIPO_VALOR)INNER JOIN EMISOR EMI ON VAL.FK_EMISOR=EMI.NIT WHERE EMI.NIT='"+nNitEmpresa.trim()+"'");			
			ResultSet rs = prepStmt.executeQuery();			
			while(rs.next())
			{
				String nombre_valor = rs.getString("NOMBRE_VALOR");
				int id_tipo_valor = rs.getInt("ID_TIPO_VALOR");
				tipos.add(new TipoValor(""+id_tipo_valor, nombre_valor, "", false));
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
					
					throw new Exception("ERROR: ConsultaDAO: loadRow() =  cerrando una conexión.");
				}
			}
			closeConnection(conexion);
		}	
    	return tipos;
    }
    
    public LinkedList<TipoRentabilidad> darTiposRentabilidad()throws Exception
    {
    	LinkedList<TipoRentabilidad> tipos = new LinkedList<TipoRentabilidad>();
    	PreparedStatement prepStmt = null;
    	try {
			establecerConexion(cadenaConexion, usuario, clave);
			prepStmt = conexion.prepareStatement("SELECT * FROM TIPORENTABILIDAD");			
			ResultSet rs = prepStmt.executeQuery();			
			while(rs.next())
			{
				String id_rentabilidad = rs.getString("ID_RENTABILIDAD");
				String nombre_rentabilidad = rs.getString("NOMBRE");
				String descripcion_rentabilidad = rs.getString("DESCRIPCION");
				String funcionamiento = rs.getString("FUNCIONAMIENTO");
				boolean rentaFija= rs.getInt("RENTA_FIJA")==FALSO?false:true;
				boolean datosAdicionales = rs.getInt("DATOS_ADICIONALES")==FALSO?false:true;
				
				TipoRentabilidad nuevo = new TipoRentabilidad(id_rentabilidad, nombre_rentabilidad, descripcion_rentabilidad, funcionamiento, rentaFija, datosAdicionales);
				tipos.add(nuevo);
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
					
					throw new Exception("ERROR: ConsultaDAO: loadRow() =  cerrando una conexión.");
				}
			}
			closeConnection(conexion);
		}	
    	return tipos;
    }
    
    
    public LinkedList<Valor> darTodosLosValores()throws Exception
    {
    	LinkedList<Valor> valores = new LinkedList<Valor>();
    	PreparedStatement prepStmt = null;
    	try {
			establecerConexion(cadenaConexion, usuario, clave);
			prepStmt = conexion.prepareStatement("Select * from (VALOR VAL inner join TIPOVALOR TIVAL ON VAL.FK_ID_TIPO_VALOR=TIVAL.ID_TIPO_VALOR) INNER JOIN EMISOR EMI ON VAL.FK_EMISOR=EMI.NIT");			
			ResultSet rs = prepStmt.executeQuery();			
			while(rs.next())
			{
				int id_valor = rs.getInt("ID_VALOR");
				String nombre_valor = rs.getString("NOMBRE");
				boolean en_negociacion = rs.getInt("NEGOCIACION")==FALSO?false:true;
				String id_tipo_rentabilidad = rs.getString("FK_ID_RENTABILIDAD");
				String id_tipoVal = ""+rs.getInt("FK_ID_TIPO_VALOR");
				String id_emisor = rs.getString("FK_EMISOR");
				String nombre_tipo = rs.getString("NOMBRE_VALOR");
				String nombre_Emisor = rs.getString(13);
				String id_intermediarioPrimeraVenta = rs.getString("FK_INTERMEDIARIO");
				Intermediario inter = new Intermediario();
				inter.setId_Intermediario(id_intermediarioPrimeraVenta);
				TipoRentabilidad tipoRenta = new TipoRentabilidad(id_tipo_rentabilidad, "", "","", false, false);
				TipoValor tipoVal = new TipoValor();
				tipoVal.setId_Valor(id_tipoVal);
				tipoVal.setNombre_valor(nombre_tipo);
				Emisor emisor = new Emisor();
				emisor.setNIT(id_emisor);
				emisor.setNombre(nombre_Emisor);
				Valor nuevo = new Valor(""+id_valor, nombre_valor, en_negociacion, tipoRenta,tipoVal , null, inter);
				nuevo.setEmisor(emisor);				
				
				valores.add(nuevo);
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
					
					throw new Exception("ERROR: ConsultaDAO: loadRow() =  cerrando una conexión.");
				}
			}
			closeConnection(conexion);
		}	
    	return valores;
    }

    
}
