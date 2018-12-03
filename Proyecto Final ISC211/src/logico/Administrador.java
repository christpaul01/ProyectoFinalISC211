package logico;

import java.io.Serializable;

public class Administrador extends Usuario implements Serializable {

	private String nombreUsuario;
	public Administrador(String nombre, String clave, String nombreUsuario,String id) {
		super(nombre, clave,id);
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

}
