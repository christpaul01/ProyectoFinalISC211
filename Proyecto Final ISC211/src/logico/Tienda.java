package logico;


import java.util.ArrayList;

public class Tienda {

	private ArrayList<Componente> componentes;
	private ArrayList<Cliente> clientes;
	private ArrayList<Factura> facturas;
	private ArrayList<Kit> kits;
	private ArrayList<Usuario> usuarios;

	public ArrayList<Componente> getComponentes() {
		return componentes;
	}
 
	public void setComponentes(ArrayList<Componente> componentes) {
		this.componentes = componentes;
	}
}
