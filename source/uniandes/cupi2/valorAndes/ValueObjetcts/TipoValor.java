package uniandes.cupi2.valorAndes.ValueObjetcts;

public class TipoValor {
	
	private String id_Valor;
	private String nombre_valor;
	private String descripcion;
	private boolean datosAdicionales;
	
	
	public TipoValor(String idValor, String nombreValor, String descripcion,
			boolean datosAdicionales) {
		
		id_Valor = idValor;
		nombre_valor = nombreValor;
		this.descripcion = descripcion;
		this.datosAdicionales = datosAdicionales;
	}
	
	public TipoValor()
	{
		id_Valor = "";
		nombre_valor = "";
		this.descripcion = "";
		this.datosAdicionales = false;
	}

	/**
	 * @return the id_Valor
	 */
	public String getId_Valor() {
		return id_Valor;
	}

	/**
	 * @param idValor the id_Valor to set
	 */
	public void setId_Valor(String idValor) {
		id_Valor = idValor;
	}

	/**
	 * @return the nombre_valor
	 */
	public String getNombre_valor() {
		return nombre_valor;
	}

	/**
	 * @param nombreValor the nombre_valor to set
	 */
	public void setNombre_valor(String nombreValor) {
		nombre_valor = nombreValor;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the datosAdicionales
	 */
	public boolean isDatosAdicionales() {
		return datosAdicionales;
	}

	/**
	 * @param datosAdicionales the datosAdicionales to set
	 */
	public void setDatosAdicionales(boolean datosAdicionales) {
		this.datosAdicionales = datosAdicionales;
	}
	
	
	
	
	

}
