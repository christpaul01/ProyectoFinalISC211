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

import javax.swing.JFileChooser;


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
	private static Tienda tienda;

	private Tienda() {
		super();
		
		componentes = new ArrayList<Componente>();
		clientes = new ArrayList<Cliente>();
		facturas = new ArrayList<Factura>();
		usuarios = new ArrayList<Usuario>();
		kits = new ArrayList<Kit>();
		char[] clave = new String("admin").toCharArray();
		
		Administrador defecto = new Administrador("admin",clave,"admin",asignarIdUsuario()); // A cambiar
		insertarAdministrador(defecto);
	}
	
	public static Tienda getInstance() {
		if(tienda==null)
		{
			tienda = new Tienda();
		}
		return tienda;
	}
	
	public String asignarIdCliente() {
		
		String idConCeros = String.format("%06d", (clientes.size() +1 ));
		
		return idConCeros;
		
	}
	
	public String asignarIdUsuario() {
		
		String idConCeros = String.format("%04d", (usuarios.size() +1 ));
		
		return idConCeros;
		
	}
	
	public String asignarSerial() {
		
		String idConCeros = String.format("%010d", (componentes.size() +1 ));
		
		return idConCeros;
		
	}
	
	public String asignarIdKit() {
		
		String idConCeros = String.format("%04d", (kits.size() +1 ));
		
		return idConCeros;
		
	}
	
	public void insertarVendedor(Usuario vendedor)
	{
		usuarios.add(vendedor);
	}
	
	public void insertarCliente(Cliente cliente) {
		clientes.add(cliente);
	}
	
	public void insertarProducto(Componente componente)
	{
		componentes.add(componente);
	}
	
	public int calcRam() {
		
		int cant = 0;
		
		for(int i = 0; i< componentes.size(); i++)
		{
			if(componentes.get(i) instanceof Ram)
				cant+=componentes.get(i).getCantidad();
		}
		
		return cant;
		
	}
	
	public int calcMotherBoard() {
		
		int cant = 0;
		
		for(int i = 0; i< componentes.size(); i++)
		{
			if(componentes.get(i) instanceof Motherboard)
				cant+=componentes.get(i).getCantidad();
		}
		
		return cant;
		
	}
	
	public int calcCPU() {
		
		int cant = 0;
		
		for(int i = 0; i< componentes.size(); i++)
		{
			if(componentes.get(i) instanceof Procesador)
				cant+=componentes.get(i).getCantidad();
		}
		
		return cant;
		
	}
	
	public int calcHDD() {
		
		int cant = 0;
		
		for(int i = 0; i< componentes.size(); i++)
		{
			if(componentes.get(i) instanceof DiscoDuro)
				cant+=componentes.get(i).getCantidad();
		}
		
		return cant;
		
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
	
	
	
	public void guardarDatos() throws IOException, ClassNotFoundException{
		
		
		String url = urlEjecutable();
		
		new File(url).mkdir();
		
		
		FileOutputStream foTienda = new FileOutputStream (url + "//MisDatos.dat");
		ObjectOutputStream oosTienda	= new ObjectOutputStream (foTienda);
		
		oosTienda.writeObject(tienda);
		
		foTienda.close();
		
	}
	
	public void cargarDatos() throws IOException, ClassNotFoundException{
		
		String url = urlEjecutable();
		
		FileInputStream fiTienda = new FileInputStream (url + "//MisDatos.dat");	
		ObjectInputStream oisTienda = new ObjectInputStream(fiTienda);	
			
		tienda = (Tienda)oisTienda.readObject();
		fiTienda.close();
	
	}
	
	public String urlEjecutable() {
		
		//Crea el String del link hacia el folder "Tienda" en 'Mis Documentos'
		String url = new JFileChooser().getFileSystemView().getDefaultDirectory().toString() + "//Tienda" ;
		
		return url;
		
	}


	public String getNombre() {
		return nombre;
	}


}
