package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Ventas implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Componente> componente;
	private ArrayList<Kit> kits;


	public Ventas() {
		// TODO Auto-generated constructor stub
		componente = new ArrayList<Componente>();
		kits = new ArrayList<Kit>();
	}

	public ArrayList<Componente> getComponente() {
		return componente;
	}

	public void agregarComponentes(ArrayList<Componente> componente) {
		this.componente = componente;
	}

	public ArrayList<Kit> getKits() {
		return kits;
	}

	public void agregarKits(ArrayList<Kit> kits) {
		this.kits = kits;
	}

}
