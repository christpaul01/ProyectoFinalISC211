package logico;

import java.io.Serializable;

public abstract class Usuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	protected String nombre;
	protected char[] clave;
	protected String id;
	protected Boolean habilitado;
	
	public Usuario(String nombre, char[] clave,String id) {
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
	public char[] getClave() {
		return clave;
	}
	public void setClave(char[] clave) {
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
