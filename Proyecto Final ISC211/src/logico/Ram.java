package logico;

public class Ram extends Componente {

	private Double memoria;
	private String tipo;
	
	public Ram(String marca, Double precioCompra, int cantidad, String numeroSerie, String modelo, Double precioVenta,
			Double memoria,String tipo) {
		super(marca, precioCompra, cantidad, numeroSerie, modelo, precioVenta);
		this.memoria = memoria;
		this.tipo = tipo;
	}


	public Double getMemoria() {
		return memoria;
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
