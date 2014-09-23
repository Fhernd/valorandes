package uniandes.cupi2.valorAndes.ValueObjetcts;

import java.util.ArrayList;

public class Inversionista {
	
	private String id_Inversionista;
	private String identificacion;
	private int tipo_Documento;
	private String  nombre;
	private String telefono;
	private String nombre_Representante_Legal;
	private String ident_Rep_legal;
	private ArrayList<Direccion> direcciones;
	private int tipoInversionista;
	private String nombre_Tipo_Inversionista;
	private Intermediario intermediarioRep;
	private SolicitudOperacion ultima_Solicitud_Operacion;
	private ArrayList<Valor> colocaciones;
	
	
	public Inversionista()
	{
		id_Inversionista = "";
		this.identificacion = "";
		tipo_Documento = 0;
		this.nombre = "";
		this.telefono= "";
		nombre_Representante_Legal = "";
		ident_Rep_legal = "";
		this.direcciones = new ArrayList<Direccion>();
		this.tipoInversionista = 0;
		nombre_Tipo_Inversionista = "";
		intermediarioRep = null;
		ultima_Solicitud_Operacion = null;
		colocaciones = new ArrayList<Valor>();
	}
	
	public Inversionista(String idInversionista, String identificacion,
			int tipoDocumento, String nombre, String telefono,
			String nombreRepresentanteLegal, String identRepLegal,
			ArrayList<Direccion> direcciones, int tipoInversionista,
			String nombreTipoInversionista, Intermediario intermed, SolicitudOperacion ultix, ArrayList<Valor> colocax) {
		
		id_Inversionista = idInversionista;
		this.identificacion = identificacion;
		tipo_Documento = tipoDocumento;
		this.nombre = nombre;
		this.telefono = telefono;
		nombre_Representante_Legal = nombreRepresentanteLegal;
		ident_Rep_legal = identRepLegal;
		this.direcciones = direcciones;
		this.tipoInversionista = tipoInversionista;
		nombre_Tipo_Inversionista = nombreTipoInversionista;
		intermediarioRep = intermed;
		ultima_Solicitud_Operacion = ultix;
		colocaciones = colocax;
	}

	public Intermediario getIntermediarioRep() {
		return intermediarioRep;
	}

	public void setIntermediarioRep(Intermediario intermed) {
		this.intermediarioRep = intermed;
	}

	public String getId_Inversionista() {
		return id_Inversionista;
	}

	public void setId_Inversionista(String idInversionista) {
		id_Inversionista = idInversionista;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public int getTipo_Documento() {
		return tipo_Documento;
	}

	public void setTipo_Documento(int tipoDocumento) {
		tipo_Documento = tipoDocumento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNombre_Representante_Legal() {
		return nombre_Representante_Legal;
	}

	public void setNombre_Representante_Legal(String nombreRepresentanteLegal) {
		nombre_Representante_Legal = nombreRepresentanteLegal;
	}

	public String getIdent_Rep_legal() {
		return ident_Rep_legal;
	}

	public void setIdent_Rep_legal(String identRepLegal) {
		ident_Rep_legal = identRepLegal;
	}

	public ArrayList<Direccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(ArrayList<Direccion> direcciones) {
		this.direcciones = direcciones;
	}

	public int getTipoInversionista() {
		return tipoInversionista;
	}

	public void setTipoInversionista(int tipoInversionista) {
		this.tipoInversionista = tipoInversionista;
	}

	public String getNombre_Tipo_Inversionista() {
		return nombre_Tipo_Inversionista;
	}

	public void setNombre_Tipo_Inversionista(String nombreTipoInversionista) {
		nombre_Tipo_Inversionista = nombreTipoInversionista;
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

	/**
	 * @return the colocaciones
	 */
	public ArrayList<Valor> getColocaciones() {
		return colocaciones;
	}

	/**
	 * @param colocaciones the colocaciones to set
	 */
	public void setColocaciones(ArrayList<Valor> colocaciones) {
		this.colocaciones = colocaciones;
	}
	
	
	
	
}
