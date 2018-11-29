package logico;

import java.util.ArrayList;

public class Motherboard extends Componente {

	private String socket;
	private String ram;
	private ArrayList<DiscoDuro> discoDuro;	
	

	public Motherboard(String marca, Double precioCompra, int cantidad, String numeroSerie, String modelo,
			Double precioVenta, String socket, String ram) {
		super(marca, precioCompra, cantidad, numeroSerie, modelo, precioVenta);
		this.socket = socket;
		this.ram = ram;
		discoDuro = new ArrayList<>();
	}


	public String getSocket() {
		return socket;
	}


	public void setSocket(String socket) {
		this.socket = socket;
	}


	public String getRam() {
		return ram;
	}


	public void setRam(String ram) {
		this.ram = ram;
	}


	public ArrayList<DiscoDuro> getDiscoDuro() {
		return discoDuro;
	}


	public void setDiscoDuro(ArrayList<DiscoDuro> discoDuro) {
		this.discoDuro = discoDuro;
	}	
}
