package logico;


import java.util.ArrayList;

public class Tienda {

	private ArrayList<Componente> componentes;
	private ArrayList<Cliente> clientes;
	private ArrayList<Factura> facturas;
	private ArrayList<Kit> kits;
	private ArrayList<Usuario> usuarios;

	public Tienda(ArrayList<Componente> componentes, ArrayList<Cliente> clientes, ArrayList<Factura> facturas,
			ArrayList<Kit> kits, ArrayList<Usuario> usuarios) {
		super();
		this.componentes = componentes;
		this.clientes = clientes;
		this.facturas = facturas;
		this.kits = kits;
		this.usuarios = usuarios;
	}	
	
	
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}



	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}



	public ArrayList<Factura> getFacturas() {
		return facturas;
	}



	public void setFacturas(ArrayList<Factura> facturas) {
		this.facturas = facturas;
	}



	public ArrayList<Kit> getKits() {
		return kits;
	}



	public void setKits(ArrayList<Kit> kits) {
		this.kits = kits;
	}



	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}



	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}



	public ArrayList<Componente> getComponentes() {
		return componentes;
	}
 
	public void setComponentes(ArrayList<Componente> componentes) {
		this.componentes = componentes;
	}
}
