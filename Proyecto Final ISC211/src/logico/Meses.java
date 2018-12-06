package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Meses implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Ventas> ventas;
	private String Mes;
	
	public Meses() {
		// TODO Auto-generated constructor stub
		
		ventas = new ArrayList<Ventas>();

		
	}
	
	public void insertarVentas(Ventas ventas)
	{
		this.ventas.add(ventas);
	}

	public ArrayList<Ventas> getVentas() {
		return ventas;
	}

	public String getMes() {
		return Mes;
	}

	public void setMes(String mes) {
		Mes = mes;
	}
	
	

}
