package logico;

public class DiscoDuro extends Componente {

	private Double capacidad;
	private String conexion;
	private String modelo;
	
	
	public DiscoDuro(String marca, Double precio, int cantidad, String numeroSerie, Double capacidad, String conexion,
			String modelo) {
		super(marca, precio, cantidad, numeroSerie);
		this.capacidad = capacidad;
		this.conexion = conexion;
		this.modelo = modelo;
	}


	public Double getCapacidad() {
		return capacidad;
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


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	

}
