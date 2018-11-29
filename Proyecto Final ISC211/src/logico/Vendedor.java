package logico;

public class Vendedor extends Usuario {
	
	private int cantVentas;
	
	
	public Vendedor(String nombre, String clave, String id) {
		super(nombre, clave,id);
		
		cantVentas = 0;
		
	}


	public int getCantVentas() {
		return cantVentas;
	}

	
	


}
