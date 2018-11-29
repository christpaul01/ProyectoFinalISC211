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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Componente> componentes;
	private ArrayList<Cliente> clientes;
	private ArrayList<Factura> facturas;
	private ArrayList<Kit> kits;
	private ArrayList<Usuario> usuarios;
	private String nombre;

	public Tienda(String nombre) {
		super();
		this.nombre = nombre;
	}	
	
	public String asignarIdCliente() {
		
		String idConCeros = String.format("%06d", (clientes.size() +1 ));
		
		return idConCeros;
		
	}
	
	public String asignarSerial() {
		
		String idConCeros = String.format("%010d", (componentes.size() +1 ));
		
		return idConCeros;
		
	}
	

	public void insertarCliente(Cliente cliente) {
		clientes.add(cliente);
	}

	
	public int indexCliente(String cedula) {
		
		boolean encontrado = false;
		int i = 0;
		
		while(!encontrado && i < clientes.size())
		{
			if(clientes.get(i).getCedula().equals(cedula))
			{
				encontrado = true;
			}
			i++;
		}
		
		return i;
	}
	
	
	public void insertarVendedor(Vendedor vendedor)
	{
		usuarios.add(vendedor);
	}
	
	public int indexUsuario(String id) {
		
		int index = 0;
		boolean encontrado = false;
		while(!encontrado && index < usuarios.size())
		{	
			if(usuarios.get(index).getId().equalsIgnoreCase(id))
			{
				return index;
			}
			index++;
		}
		
		return -1;
		
	}

	
	public void insertarAdministrador(Administrador admin)
	{
		usuarios.add(admin);
	}
	
	public void insertarCliente(Cliente cliente) {
		clientes.add(cliente);
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


	public String getNombre() {
		return nombre;
	}


}
