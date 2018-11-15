package logico;

import java.util.ArrayList;
import java.util.Date;

public class Factura {
	private double precioTotal;
	private String cedula;
	private ArrayList<Componente> compra;
	private ArrayList<Kit> compraK;
	private Date fecha;
	private String id;
	
	public Factura(double precioTotal, String cedula, ArrayList<Componente> compra, ArrayList<Kit> compraK, Date fecha,
			String id) {
		super();
		this.precioTotal = precioTotal;
		this.cedula = cedula;
		this.compra = compra;
		this.compraK = compraK;
		this.fecha = fecha;
		this.id = id;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public ArrayList<Componente> getCompra() {
		return compra;
	}

	public void setCompra(ArrayList<Componente> compra) {
		this.compra = compra;
	}

	public ArrayList<Kit> getCompraK() {
		return compraK;
	}

	public void setCompraK(ArrayList<Kit> compraK) {
		this.compraK = compraK;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	//////Metodos
	
	
	   
}
