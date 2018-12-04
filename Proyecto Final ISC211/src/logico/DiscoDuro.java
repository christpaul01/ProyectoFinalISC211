package logico;

import java.io.Serializable;

public class DiscoDuro extends Componente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Double capacidad;
	private String conexion;	
	
	public DiscoDuro(String marca, Double precioCompra, int cantidad, String numeroSerie, String modelo,
			Double precioVenta,String proveedor,Double capacidad, String conexion) {
		super(marca, precioCompra, cantidad, numeroSerie, modelo, precioVenta,proveedor);
		this.capacidad = capacidad;
		this.conexion = conexion;

	}

	public Double getCapacidad() {
		return capacidad;
	}

	public String toString()
	{
		String toString = marca + " " + modelo + " - " + "RD$ " +  precioVenta ;
		return toString ;
	}
	
	public void setCapacidad(Double capacidad) {
		this.capacidad = capacidad;
	}


	public String getConexion() {
		return conexion;
	}


	public void setConexion(String conexion) {
		this.conexion = conexion;
	}
}
