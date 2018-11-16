package logico;

import java.util.ArrayList;

public class Motherboard extends Componente {

	private String socket;
	private String ram;
	private ArrayList<String> discoDuro;	
	

	public Motherboard(String marca, Double precio, int cantidad, String numeroSerie, String modelo, String socket, String ram, ArrayList<String> discoDuro) {
		super(marca, precio, cantidad, numeroSerie, modelo);
		
		this.socket = socket;
		this.ram = ram;
		this.discoDuro = discoDuro;
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


	public ArrayList<String> getDiscoDuro() {
		return discoDuro;
	}


	public void setDiscoDuro(ArrayList<String> discoDuro) {
		this.discoDuro = discoDuro;
	}	
}
