package uniandes.cupi2.valorAndes.ValueObjetcts;

public class Direccion {
	
	private String pais;
	private String departamento;
	private String  ciudad;
	private String direccion;
	private String codigo_postal;
	private String id_direccion;
	
	public Direccion ()
	{
		
	}
	
	public Direccion(String pais, String departamento, String ciudad,
			String direccion, String codigoPostal, String idDireccion) {
		this.pais = pais;
		this.departamento = departamento;
		this.ciudad = ciudad;
		this.direccion = direccion;
		codigo_postal = codigoPostal;
		id_direccion = idDireccion;
	}
	
	public void asignarDatos (String nPais, String nDepto, String nCiudad, String nDireccion, String nCodPostal, String nIdDireccion)
	{
		pais= nPais;
		departamento = nDepto;
		ciudad = nCiudad;
		direccion = nDireccion;
		codigo_postal = nCodPostal;
		id_direccion = nIdDireccion;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCodigo_postal() {
		return codigo_postal;
	}

	public void setCodigo_postal(String codigoPostal) {
		codigo_postal = codigoPostal;
	}

	

	public String getId_direccion() {
		return id_direccion;
	}

	public void setId_direccion(String idDireccion) {
		id_direccion = idDireccion;
	}
	

}
