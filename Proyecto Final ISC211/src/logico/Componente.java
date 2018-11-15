package logico;

public class Componente {

	private String marca;
	private Double precio;
	private int cantidad;
	private String numeroSerie;
	
	
	public Componente(String marca, Double precio, int cantidad, String numeroSerie) {
		super();
		this.marca = marca;
		this.precio = precio;
		this.cantidad = cantidad;
		this.numeroSerie = numeroSerie;
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
	
	
	
	
	
}
