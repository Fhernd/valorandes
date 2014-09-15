package uniandes.cupi2.valorAndes.ValueObjetcts;

public class DatoAdicional {
	
	private String nombre;
	private String valor;
	
	public DatoAdicional() {
		
		nombre="";
		valor="";
	}

	/**
	 * @param nombre
	 * @param valor
	 */
	public DatoAdicional(String nombre, String valor) {
		super();
		this.nombre = nombre;
		this.valor = valor;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the valor
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	

}
