package logico;

import java.util.ArrayList;

public class Kit {
	
	private ArrayList<Componente> componentes;
	private final int descuento = 10;
	private String modelo;
	
	
	public Kit(ArrayList<Componente> componentes, String modelo) {
		super();
		this.componentes = componentes;
		this.modelo = modelo;
	}


	public ArrayList<Componente> getComponentes() {
		return componentes;
	}


	public void setComponentes(ArrayList<Componente> componentes) {
		this.componentes = componentes;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public int getDescuento() {
		return descuento;
	}
	
	

}
