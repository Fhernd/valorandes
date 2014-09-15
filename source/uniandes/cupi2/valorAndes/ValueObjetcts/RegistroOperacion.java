package uniandes.cupi2.valorAndes.ValueObjetcts;

import java.util.Date;

public class RegistroOperacion {

	
	private Date fecha_Operacion;
	private double monto_Operación;
	private int cant_Productos;
	private SolicitudOperacion compra;
	private SolicitudOperacion venta;
	
	
	/**
	 * @param fechaOperacion
	 * @param montoOperación
	 * @param cantProductos
	 * @param compra
	 * @param venta
	 */
	public RegistroOperacion(Date fechaOperacion, double montoOperación,
			int cantProductos, SolicitudOperacion compra,
			SolicitudOperacion venta) {
		fecha_Operacion = fechaOperacion;
		monto_Operación = montoOperación;
		cant_Productos = cantProductos;
		this.compra = compra;
		this.venta = venta;
	}
	
	public RegistroOperacion()
	{
		fecha_Operacion = new Date();
		monto_Operación = 0;
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
	 * @return the monto_Operación
	 */
	public double getMonto_Operación() {
		return monto_Operación;
	}

	/**
	 * @param montoOperación the monto_Operación to set
	 */
	public void setMonto_Operación(double montoOperación) {
		monto_Operación = montoOperación;
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
