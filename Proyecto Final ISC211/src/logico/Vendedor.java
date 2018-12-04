package logico;

import java.io.Serializable;

public class Vendedor extends Usuario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int cantVentas;
	
	
	public Vendedor(String nombre, char[] clave, String id) {
		super(nombre, clave,id);
		
		cantVentas = 0;
		
	}


	public int getCantVentas() {
		return cantVentas;
	}

	
	


}
