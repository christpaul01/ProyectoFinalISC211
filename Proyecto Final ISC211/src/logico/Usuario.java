package logico;

public abstract class Usuario {
	protected String nombre;
	protected String clave;
	protected String id;
	protected Boolean habilitado;
	
	public Usuario(String nombre, String clave,String id) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.clave = clave;
		habilitado = true;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getId() {
		return id;
	}

	public Boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}
	
	
	
	
	
}
