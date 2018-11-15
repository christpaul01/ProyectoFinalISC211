package logico;

public class Procesador extends Componente {
	
	private String socket;
	private Double velocidad;
	private String modelo;

	public Procesador(String marca, Double precio, int cantidad, String numeroSerie, String socket, Double velocidad,
			String modelo) {
		super(marca, precio, cantidad, numeroSerie);
		this.socket = socket;
		this.velocidad = velocidad;
		this.modelo = modelo;
	}

	public String getSocket() {
		return socket;
	}

	public void setSocket(String socket) {
		this.socket = socket;
	}

	public Double getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(Double velocidad) {
		this.velocidad = velocidad;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	

}
