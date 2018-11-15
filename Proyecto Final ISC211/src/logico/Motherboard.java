package logico;

import java.util.ArrayList;

public class Motherboard extends Componente {

	private String socket;
	private String ram;
	private ArrayList<String> discoDuro;
	private String modelo;
	
	
	public Motherboard(String marca, Double precio, int cantidad, String numeroSerie, String socket, String ram, ArrayList<String> discoDuro, String modelo) {
		super(marca, precio, cantidad, numeroSerie);
		
		this.socket = socket;
		this.ram = ram;
		this.discoDuro = discoDuro;
		this.modelo = modelo;
		
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


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	
	
	
}
