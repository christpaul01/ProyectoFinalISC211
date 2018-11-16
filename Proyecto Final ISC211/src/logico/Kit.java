package logico;

import java.util.ArrayList;

public class Kit {
	
	private ArrayList<Componente> componentes;
	private final int descuento = 10;
	private String id;
	
	
	public Kit(ArrayList<Componente> componentes, String id) {
		super();
		this.componentes = componentes;
		this.id = id;
	}


	public ArrayList<Componente> getComponentes() {
		return componentes;
	}


	public void setComponentes(ArrayList<Componente> componentes) {
		this.componentes = componentes;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public int getDescuento() {
		return descuento;
	}
	
	

}
