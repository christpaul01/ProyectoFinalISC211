package logico;

import java.io.Serializable;

public class Ram extends Componente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Double memoria;
	private String tipo;
	
	public Ram(String marca, Double precioCompra, int cantidad, String numeroSerie, String modelo, Double precioVenta,
			String proveedor, Double memoria,String tipo) {
		super(marca, precioCompra, cantidad, numeroSerie, modelo, precioVenta,proveedor);
		this.memoria = memoria;
		this.tipo = tipo;
	}


	public Double getMemoria() {
		return memoria;
	}
	
	public String toStringInventario() {
		Double aux = memoria;
		String aux2;
		if (aux<1) {
			aux=aux*1024;
			aux2 = aux.toString() + "MB";
		}else {
			aux2 = aux.toString() + "GB";
		}
		
		String toString = numeroSerie + " - " + marca + " " + modelo + " " + tipo + " " + aux2 + "  -  " + "Cantidad: " + cantidad + " - " + 
		"Proveedor: " + proveedor + " - " + "Precio de venta: " + "RD$ " + precioVenta;
		return toString;
	}
	
	public String toString()
	{
		String toString = marca + " " + modelo + " - " + "RD$ " +  precioVenta ;
		return toString ;
	}

	public void setMemoria(Double memoria) {
		this.memoria = memoria;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
