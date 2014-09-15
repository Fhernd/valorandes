package uniandes.cupi2.valorAndes.ValueObjetcts;

import java.util.Date;

public class RegistroOperacion {

	
	private Date fecha_Operacion;
	private double monto_Operaci�n;
	private int cant_Productos;
	private SolicitudOperacion compra;
	private SolicitudOperacion venta;
	
	
	/**
	 * @param fechaOperacion
	 * @param montoOperaci�n
	 * @param cantProductos
	 * @param compra
	 * @param venta
	 */
	public RegistroOperacion(Date fechaOperacion, double montoOperaci�n,
			int cantProductos, SolicitudOperacion compra,
			SolicitudOperacion venta) {
		fecha_Operacion = fechaOperacion;
		monto_Operaci�n = montoOperaci�n;
		cant_Productos = cantProductos;
		this.compra = compra;
		this.venta = venta;
	}
	
	public RegistroOperacion()
	{
		fecha_Operacion = new Date();
		monto_Operaci�n = 0;
		cant_Productos = 0;
		this.compra = null;
		this.venta = null;
	}

	/**
	 * @return the fecha_Operacion
	 */
	public Date getFecha_Operacion() {
		return fecha_Operacion;
	}

	/**
	 * @param fechaOperacion the fecha_Operacion to set
	 */
	public void setFecha_Operacion(Date fechaOperacion) {
		fecha_Operacion = fechaOperacion;
	}

	/**
	 * @return the monto_Operaci�n
	 */
	public double getMonto_Operaci�n() {
		return monto_Operaci�n;
	}

	/**
	 * @param montoOperaci�n the monto_Operaci�n to set
	 */
	public void setMonto_Operaci�n(double montoOperaci�n) {
		monto_Operaci�n = montoOperaci�n;
	}

	/**
	 * @return the cant_Productos
	 */
	public int getCant_Productos() {
		return cant_Productos;
	}

	/**
	 * @param cantProductos the cant_Productos to set
	 */
	public void setCant_Productos(int cantProductos) {
		cant_Productos = cantProductos;
	}

	/**
	 * @return the compra
	 */
	public SolicitudOperacion getCompra() {
		return compra;
	}

	/**
	 * @param compra the compra to set
	 */
	public void setCompra(SolicitudOperacion compra) {
		this.compra = compra;
	}

	/**
	 * @return the venta
	 */
	public SolicitudOperacion getVenta() {
		return venta;
	}

	/**
	 * @param venta the venta to set
	 */
	public void setVenta(SolicitudOperacion venta) {
		this.venta = venta;
	}
	
	
	
	
}
