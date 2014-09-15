package uniandes.cupi2.valorAndes.ValueObjetcts;

import java.util.ArrayList;
import java.util.Date;

public class Usuario {
	
	private String login;
	private String password;
	private String nombre;
	private String doc_Identidad;
	private int tipo_documento;
	private  String nacionalidad;
	private String telefono ;
	private String celular;
	private String email;
	private Date fecha_nacimiento;
	private boolean admin;
	private ArrayList<Direccion> direcciones;
	
	public Usuario ()
	{
		direcciones = new ArrayList<Direccion>();

		this.login = "";
		this.password ="";
		this.nombre ="";
		doc_Identidad ="";
		tipo_documento =0;
		this.nacionalidad ="";
		this.telefono ="";
		this.celular ="";
		this.email="";
		fecha_nacimiento = new Date();
		this.admin = false;
	}
	
	public Usuario(String login, String password, String nombre,
			String docIdentidad, int tipoDocumento, String nacionalidad,
			String telefono, String celular, String email,
			Date fechaNacimiento, boolean admin,
			ArrayList<Direccion> direcciones) {
		
		this.login = login;
		this.password = password;
		this.nombre = nombre;
		doc_Identidad = docIdentidad;
		tipo_documento = tipoDocumento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.celular = celular;
		this.email = email;
		fecha_nacimiento = fechaNacimiento;
		this.admin = admin;
		this.direcciones = direcciones;
	}

	
	public void asignarDatos (String nLogin, String npass, String nNombre, String nDocIdent, int nTipoDoc, String nNacionalidad, String nTelefono, String nCelular, String nEmail, Date nFechaNacimiento, boolean nAdmin, ArrayList<Direccion> nDirecciones)
	{
		login=nLogin;
		password = npass;
		nombre = nNombre;
		doc_Identidad = nDocIdent;
		tipo_documento = nTipoDoc;
		nacionalidad = nNacionalidad;
		telefono = nTelefono;
		celular = nCelular;
		email = nEmail;
		fecha_nacimiento = nFechaNacimiento;
		admin = nAdmin;
		direcciones = nDirecciones;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDoc_Identidad() {
		return doc_Identidad;
	}

	public void setDoc_Identidad(String docIdentidad) {
		doc_Identidad = docIdentidad;
	}

	public int getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(int tipoDocumento) {
		tipo_documento = tipoDocumento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fechaNacimiento) {
		fecha_nacimiento = fechaNacimiento;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public ArrayList<Direccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(ArrayList<Direccion> direcciones) {
		this.direcciones = direcciones;
	}


	
	
	

}
