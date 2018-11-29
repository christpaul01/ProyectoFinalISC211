package logico;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Tienda implements Serializable {

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
	public void guardarTienda(File archivo,Tienda tienda ) {
		ObjectOutputStream save;
		try {
			save = new ObjectOutputStream(new FileOutputStream(archivo));
			save.writeObject(tienda);
			save.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Tienda leerTienda(File archivo) {
		Tienda tienda=null;
		try {
			FileInputStream rd= new FileInputStream(archivo);
			ObjectInputStream read= new ObjectInputStream(rd);
				tienda= (Tienda)read.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return tienda;
	}
}
