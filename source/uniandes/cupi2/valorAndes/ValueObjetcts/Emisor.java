package uniandes.cupi2.valorAndes.ValueObjetcts;

import java.util.ArrayList;

public class Emisor {
	
	private String nombre;
	private String NIT;
	private String pagina_Web;
	private String  registro_RNV;
	private String  id_Empresa;
	private String telefono;
	private String nom_Representante_Legal;
	private String ident_Rep_Legal;
	private Direccion direcciones;
	private Intermediario intermediario_Rep;
	private ArrayList<Valor> emisiones;
	private SolicitudOperacion ultima_Solicitud_Operacion;
	
	
	
	public Emisor(String nombre, String nIT, String paginaWeb,
			String registroRNMV, String idEmpresa, String telefono,
			String nomRepresentanteLegal, String identRepLegal,
			Direccion direcciones, Intermediario intermediarioRep, ArrayList<Valor> emix, SolicitudOperacion solx) {
		super();
		this.nombre = nombre;
		NIT = nIT;
		pagina_Web = paginaWeb;
		registro_RNV = registroRNMV;
		id_Empresa = idEmpresa;
		this.telefono = telefono;
		nom_Representante_Legal = nomRepresentanteLegal;
		ident_Rep_Legal = identRepLegal;
		this.direcciones = direcciones;
		intermediario_Rep = intermediarioRep;
		emisiones = emix;
		ultima_Solicitud_Operacion = solx;
		
	}
	
	public Emisor() {
		this.nombre ="";
		NIT ="";
		pagina_Web ="";
		registro_RNV ="";
		id_Empresa ="";
		this.telefono ="";
		nom_Representante_Legal ="";
		ident_Rep_Legal="";
		this.direcciones = new Direccion();
		intermediario_Rep = new Intermediario();
		emisiones = new ArrayList<Valor>();
		ultima_Solicitud_Operacion = null;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNIT() {
		return NIT;
	}

	public void setNIT(String nIT) {
		NIT = nIT;
	}

	public String getPagina_Web() {
		return pagina_Web;
	}

	public void setPagina_Web(String paginaWeb) {
		pagina_Web = paginaWeb;
	}

	public String getRegistro_RNMV() {
		return registro_RNV;
	}

	public void setRegistro_RNMV(String registroRNMV) {
		registro_RNV = registroRNMV;
	}

	public String getId_Empresa() {
		return id_Empresa;
	}

	public void setId_Empresa(String idEmpresa) {
		id_Empresa = idEmpresa;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNom_Representante_Legal() {
		return nom_Representante_Legal;
	}

	public void setNom_Representante_Legal(String nomRepresentanteLegal) {
		nom_Representante_Legal = nomRepresentanteLegal;
	}

	public String getIdent_Rep_Legal() {
		return ident_Rep_Legal;
	}

	public void setIdent_Rep_Legal(String identRepLegal) {
		ident_Rep_Legal = identRepLegal;
	}

	public Direccion getDireccion() {
		return direcciones;
	}

	public void setDireccion(Direccion direcciones) {
		this.direcciones = direcciones;
	}

	public Intermediario getIntermediario_Rep() {
		return intermediario_Rep;
	}

	public void setIntermediario_Rep(Intermediario intermediarioRep) {
		intermediario_Rep = intermediarioRep;
	}

	/**
	 * @return the emisiones
	 */
	public ArrayList<Valor> getEmisiones() {
		return emisiones;
	}

	/**
	 * @param emisiones the emisiones to set
	 */
	public void setEmisiones(ArrayList<Valor> emisiones) {
		this.emisiones = emisiones;
	}

	/**
	 * @return the ultima_Solicitud_Operacion
	 */
	public SolicitudOperacion getUltima_Solicitud_Operacion() {
		return ultima_Solicitud_Operacion;
	}

	/**
	 * @param ultimaSolicitudOperacion the ultima_Solicitud_Operacion to set
	 */
	public void setUltima_Solicitud_Operacion(
			SolicitudOperacion ultimaSolicitudOperacion) {
		ultima_Solicitud_Operacion = ultimaSolicitudOperacion;
	}
	
	public String toString()
	{
		return "("+NIT+")"+nombre+", "+pagina_Web;
	}
	
}