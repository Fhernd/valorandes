package uniandes.cupi2.valorAndes.ValueObjetcts;

import java.util.ArrayList;

public class Intermediario {
	
	private String nombre;
	private String telefono;
	private String registroRNMV;
	private String id_Intermediario;
	private String nombre_Representante_Legal;
	private String cedula_Representante_Legal;
	private Direccion direcciones;
	private ArrayList<Usuario> usuarios;
	
	public Intermediario ()
	{
		this.nombre = "";
		this.telefono = "";
		this.registroRNMV = "";
		id_Intermediario = "";
		nombre_Representante_Legal = "";
		cedula_Representante_Legal = "";
		this.direcciones = new Direccion();
		usuarios = new ArrayList<Usuario>();
	}

	public Intermediario(String nombre, String telefono, String registroRNMV,
			String idIntermediario, String nombreRepresentanteLegal,
			String cedulaRepresentanteLegal, Direccion direcciones,
			ArrayList<Usuario> usuarios) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.registroRNMV = registroRNMV;
		id_Intermediario = idIntermediario;
		nombre_Representante_Legal = nombreRepresentanteLegal;
		cedula_Representante_Legal = cedulaRepresentanteLegal;
		this.direcciones = direcciones;
		this.usuarios = usuarios;
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

	public String getRegistroRNMV() {
		return registroRNMV;
	}

	public void setRegistroRNMV(String registroRNMV) {
		this.registroRNMV = registroRNMV;
	}

	public String getId_Intermediario() {
		return id_Intermediario;
	}

	public void setId_Intermediario(String idIntermediario) {
		id_Intermediario = idIntermediario;
	}

	public String getNombre_Representante_Legal() {
		return nombre_Representante_Legal;
	}

	public void setNombre_Representante_Legal(String nombreRepresentanteLegal) {
		nombre_Representante_Legal = nombreRepresentanteLegal;
	}

	public String getCedula_Representante_Legal() {
		return cedula_Representante_Legal;
	}

	public void setCedula_Representante_Legal(String cedulaRepresentanteLegal) {
		cedula_Representante_Legal = cedulaRepresentanteLegal;
	}

	public Direccion getDireccion() {
		return direcciones;
	}

	public void setDireccion(Direccion direcciones) {
		this.direcciones = direcciones;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
		

}
