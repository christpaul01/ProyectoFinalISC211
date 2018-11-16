package logico;

public class Componente {

	protected String marca;
	protected Double precio;
	protected int cantidad;
	protected String numeroSerie;
	protected String modelo;
	
	
	
	public Componente(String marca, Double precio, int cantidad, String numeroSerie, String modelo) {
		super();
		
		this.marca = marca;
		this.precio = precio;
		this.cantidad = cantidad;
		this.numeroSerie = numeroSerie;
		this.modelo = modelo;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public Double getPrecio() {
		return precio;
	}


	public void setPrecio(Double precio) {
		this.precio = precio;
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
