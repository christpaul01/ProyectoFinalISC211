package logico;

public class Componente {

	protected String marca;
	protected Double precioCompra;
	protected int cantidad;
	protected String numeroSerie;
	protected String modelo;
	protected Double precioVenta;
	
	
	
	public Componente(String marca, Double precioCompra, int cantidad, String numeroSerie, String modelo,Double precioVenta) {
		super();
		this.marca = marca;
		this.precioCompra = precioCompra;
		this.cantidad = cantidad;
		this.numeroSerie = numeroSerie;
		this.modelo = modelo;
		this.precioVenta=precioVenta;
	}


	public Double getPrecioCompra() {
		return precioCompra;
	}


	public void setPrecioCompra(Double precioCompra) {
		this.precioCompra = precioCompra;
	}


	public Double getPrecioVenta() {
		return precioVenta;
	}


	public void setPrecioVenta(Double precioVenta) {
		this.precioVenta = precioVenta;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public String getNumeroSerie() {
		return numeroSerie;
	}


	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	
	
	
	
}
