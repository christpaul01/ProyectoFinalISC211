package logico;

public class Vendedor extends Usuario {
	private String id;
	
	public Vendedor(String nombre, String clave, String id) {
		super(nombre, clave);
		
		this.setId(id);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
