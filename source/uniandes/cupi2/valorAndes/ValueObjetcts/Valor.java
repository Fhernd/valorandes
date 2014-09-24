package uniandes.cupi2.valorAndes.ValueObjetcts;

import java.util.ArrayList;

public class Valor {
	
	private String nombreValor;
	private boolean negociacion;
	private TipoRentabilidad tipo_Rentabilidad;
	private TipoValor tipo_Valor;
	private ArrayList<DatoAdicional> datosAdicionales;
	private Intermediario intermediario_Primera_Venta;
	private Emisor emisor;
	private String id_valor;
	
	
	
	/**
	 * @param nombreValor
	 * @param negociacion
	 * @param tipoRentabilidad
	 * @param tipoValor
	 * @param datosAdicionales
	 */
	public Valor(String idValor , String nombreValor, boolean negociacion,
			TipoRentabilidad tipoRentabilidad, TipoValor tipoValor,
			ArrayList<DatoAdicional> datosAdicionales, Intermediario intermediario_Primera_Venta) {
		this.nombreValor = nombreValor;
		this.negociacion = negociacion;
		tipo_Rentabilidad = tipoRentabilidad;
		tipo_Valor = tipoValor;
		this.datosAdicionales = tipo_Rentabilidad!=null && tipoRentabilidad.isDatos_Adicionales() && tipoValor!=null && tipoValor.isDatosAdicionales()? datosAdicionales:null;
		this.intermediario_Primera_Venta = intermediario_Primera_Venta;
		id_valor=idValor;
	}
	
	
	public Valor()
	{
		this.nombreValor = "";
		this.negociacion = false;
		tipo_Rentabilidad = null;
		tipo_Valor = null;
		this.datosAdicionales = null;
		intermediario_Primera_Venta = null;
		emisor = new Emisor();
		id_valor="";
	}


	public String getId_valor() {
		return id_valor;
	}


	public void setId_valor(String id_valor) {
		this.id_valor = id_valor;
	}


	public Emisor getEmisor() {
		return emisor;
	}


	public void setEmisor(Emisor emisor) {
		this.emisor = emisor;
	}


	/**
	 * @return the nombreValor
	 */
	public String getNombreValor() {
		return nombreValor;
	}


	/**
	 * @param nombreValor the nombreValor to set
	 */
	public void setNombreValor(String nombreValor) {
		this.nombreValor = nombreValor;
	}


	/**
	 * @return the negociacion
	 */
	public boolean isNegociacion() {
		return negociacion;
	}


	/**
	 * @param negociacion the negociacion to set
	 */
	public void setNegociacion(boolean negociacion) {
		this.negociacion = negociacion;
	}


	/**
	 * @return the tipo_Rentabilidad
	 */
	public TipoRentabilidad getTipo_Rentabilidad() {
		return tipo_Rentabilidad;
	}


	/**
	 * @param tipoRentabilidad the tipo_Rentabilidad to set
	 */
	public void setTipo_Rentabilidad(TipoRentabilidad tipoRentabilidad) {
		tipo_Rentabilidad = tipoRentabilidad;
	}


	/**
	 * @return the tipo_Valor
	 */
	public TipoValor getTipo_Valor() {
		return tipo_Valor;
	}


	/**
	 * @param tipoValor the tipo_Valor to set
	 */
	public void setTipo_Valor(TipoValor tipoValor) {
		tipo_Valor = tipoValor;
	}


	/**
	 * @return the datosAdicionales
	 */
	public ArrayList<DatoAdicional> getDatosAdicionales() {
		return datosAdicionales;
	}


	/**
	 * @param datosAdicionales the datosAdicionales to set
	 */
	public void setDatosAdicionales(ArrayList<DatoAdicional> datosAdicionales) {
		this.datosAdicionales = datosAdicionales;
	}


	/**
	 * @return the intermediario_Primera_Venta
	 */
	public Intermediario getIntermediario_Primera_Venta() {
		return intermediario_Primera_Venta;
	}


	/**
	 * @param intermediarioPrimeraVenta the intermediario_Primera_Venta to set
	 */
	public void setIntermediario_Primera_Venta(
			Intermediario intermediarioPrimeraVenta) {
		intermediario_Primera_Venta = intermediarioPrimeraVenta;
	}
	
	
	
	
	

}
