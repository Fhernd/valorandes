package uniandes.cupi2.valorAndes.ValueObjetcts;

import java.util.Date;

public class SolicitudOperacion {
	
	private Date fecha_Solicitud;
	private int cant_productos;
	private double monto_operacion;
	private Valor producto_Asociado;
	private String nombre_tipo_Solicitud;
	private int tipo_Solicitud;
	private SolicitudOperacion operacionCancelacion;
	private Emisor emisor;
	private Inversionista inversionista;
	
	
	/**
	 * @param fechaSolicitud
	 * @param cantProductos
	 * @param montoOperacion
	 * @param productoAsociado
	 * @param tipoSolicitud
	 * @param operacionCancelacion
	 */
	public SolicitudOperacion(Date fechaSolicitud, int cantProductos,
			double montoOperacion, Valor productoAsociado,
			String nombre_tipoSolicitud, int tipoSol, SolicitudOperacion operacionCancelacion, Emisor emix, Inversionista inverx) {
		fecha_Solicitud = fechaSolicitud;
		cant_productos = cantProductos;
		monto_operacion = montoOperacion;
		producto_Asociado = productoAsociado;
		nombre_tipo_Solicitud = nombre_tipoSolicitud;
		tipo_Solicitud=tipoSol;
		this.operacionCancelacion = operacionCancelacion;
		emisor = emix;
		inversionista = emix!=null?null:inverx;
	
	}
	
	public SolicitudOperacion()
	{
		fecha_Solicitud = new Date();
		cant_productos = 0;
		monto_operacion = 0;
		producto_Asociado = new Valor();
		nombre_tipo_Solicitud = "";
		tipo_Solicitud = 0;
		this.operacionCancelacion = null;
		emisor = null;
		inversionista = null;
	}

	
	/**
	 * @return the fecha_Solicitud
	 */
	public Date getFecha_Solicitud() {
		return fecha_Solicitud;
	}

	/**
	 * @param fechaSolicitud the fecha_Solicitud to set
	 */
	public void setFecha_Solicitud(Date fechaSolicitud) {
		fecha_Solicitud = fechaSolicitud;
	}

	/**
	 * @return the cant_productos
	 */
	public int getCant_productos() {
		return cant_productos;
	}

	/**
	 * @param cantProductos the cant_productos to set
	 */
	public void setCant_productos(int cantProductos) {
		cant_productos = cantProductos;
	}

	/**
	 * @return the monto_operacion
	 */
	public double getMonto_operacion() {
		return monto_operacion;
	}

	/**
	 * @param montoOperacion the monto_operacion to set
	 */
	public void setMonto_operacion(double montoOperacion) {
		monto_operacion = montoOperacion;
	}

	/**
	 * @return the producto_Asociado
	 */
	public Valor getProducto_Asociado() {
		return producto_Asociado;
	}

	/**
	 * @param productoAsociado the producto_Asociado to set
	 */
	public void setProducto_Asociado(Valor productoAsociado) {
		producto_Asociado = productoAsociado;
	}

	/**
	 * @return the tipo_Solicitud
	 */
	public String getNombre_Tipo_Solicitud() {
		return nombre_tipo_Solicitud;
	}

	/**
	 * @param tipoSolicitud the tipo_Solicitud to set
	 */
	public void setNombre_Tipo_Solicitud(String nombre_tipoSolicitud) {
		nombre_tipo_Solicitud = nombre_tipoSolicitud;
	}
	
	/**
	 * @return the tipo_Solicitud
	 */
	public int getTipo_Solicitud() {
		return tipo_Solicitud;
	}

	/**
	 * @param tipoSolicitud the tipo_Solicitud to set
	 */
	public void setTipo_Solicitud(int tipoSolicitud) {
		tipo_Solicitud = tipoSolicitud;
	}

	/**
	 * @return the operacionCancelacion
	 */
	public SolicitudOperacion getOperacionCancelacion() {
		return operacionCancelacion;
	}

	/**
	 * @param operacionCancelacion the operacionCancelacion to set
	 */
	public void setOperacionCancelacion(SolicitudOperacion operacionCancelacion) {
		this.operacionCancelacion = operacionCancelacion;
	}

	/**
	 * @return the emisor
	 */
	public Emisor getEmisor() {
		return emisor;
	}

	/**
	 * @param emisor the emisor to set
	 */
	public void setEmisor(Emisor emisor) {
		this.emisor = inversionista==null?emisor:null;
	}

	/**
	 * @return the inversionista
	 */
	public Inversionista getInversionista() {
		return inversionista;
	}

	/**
	 * @param inversionista the inversionista to set
	 */
	public void setInversionista(Inversionista inversionista) {
		this.inversionista = emisor==null?inversionista:null;
	}
	
	
	
	
	
	
	

}
