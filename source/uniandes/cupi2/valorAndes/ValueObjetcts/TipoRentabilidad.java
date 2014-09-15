package uniandes.cupi2.valorAndes.ValueObjetcts;

public class TipoRentabilidad {
	
	private String id_rentabilidad;
	private String nombre;
	private String descripcion;
	private String funcionamiento;
	private boolean renta_fija;
	private boolean datos_Adicionales;
	
	
	public TipoRentabilidad(String idRentabilidad, String nombre,
			String descripcion, String funcionamiento, boolean rentaFija,
			boolean datosAdicionales) {
		id_rentabilidad = idRentabilidad;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.funcionamiento = funcionamiento;
		renta_fija = rentaFija;
		datos_Adicionales = datosAdicionales;
	}
	
	public TipoRentabilidad()
	{
		id_rentabilidad = "";
		this.nombre = "";
		this.descripcion = "";
		this.funcionamiento = "";
		renta_fija = true;
		datos_Adicionales = false;
	}

	public String getId_rentabilidad() {
		return id_rentabilidad;
	}

	public void setId_rentabilidad(String idRentabilidad) {
		id_rentabilidad = idRentabilidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFuncionamiento() {
		return funcionamiento;
	}

	public void setFuncionamiento(String funcionamiento) {
		this.funcionamiento = funcionamiento;
	}

	public boolean isRenta_fija() {
		return renta_fija;
	}

	public void setRenta_fija(boolean rentaFija) {
		renta_fija = rentaFija;
	}

	public boolean isDatos_Adicionales() {
		return datos_Adicionales;
	}

	public void setDatos_Adicionales(boolean datosAdicionales) {
		datos_Adicionales = datosAdicionales;
	}
	
	
	
	

}
