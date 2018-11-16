package logico;

public class Procesador extends Componente {
	
	private String socket;
	private Double velocidad;

	

	public Procesador(String marca, Double precio, int cantidad, String numeroSerie, String modelo, Double velocidad, String socket) {
		super(marca, precio, cantidad, numeroSerie, modelo);
		
		this.socket = socket;
		this.velocidad = velocidad;
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
}
