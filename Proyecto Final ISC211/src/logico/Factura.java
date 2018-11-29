package logico;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Factura implements Serializable{
	private double precioTotal;
	private Cliente cliente;
	private Vendedor vendedor;
	private ArrayList<Componente> compra;
	private ArrayList<Kit> compraK;
	private Date fecha;
	private String id;
	
	public Factura(double precioTotal, Cliente cliente,Vendedor vendedor, ArrayList<Componente> compra, ArrayList<Kit> compraK, Date fecha,
			String id) {
		super();
		this.precioTotal = precioTotal;
		this.vendedor=vendedor;
		this.cliente = cliente;
		this.compra = compra;
		this.compraK = compraK;
		this.fecha = fecha;
		this.id = id;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public ArrayList<Componente> getCompra() {
		return compra;
	}

	public void setCompra(ArrayList<Componente> compra) {
		this.compra = compra;
	}

	public ArrayList<Kit> getCompraK() {
		return compraK;
	}

	public void setCompraK(ArrayList<Kit> compraK) {
		this.compraK = compraK;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	//////Metodos
	public void verFactura(File archivo) {
		Factura factura=null;
		FileInputStream re;
		try {
			re = new FileInputStream(archivo);
			ObjectInputStream read = new ObjectInputStream(re);
			factura= (Factura) read.readObject();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File arch= new File("Factura");
		FileWriter escribir;
		try {
			escribir= new FileWriter(arch);
			BufferedWriter escribiendo= new BufferedWriter(escribir);
			escribiendo.write("Tienda");
			escribiendo.newLine();
			escribiendo.write("Factura #: "+factura.getId());
			escribiendo.newLine();
			escribiendo.newLine();
			escribiendo.write("Cliente:");
			escribiendo.write("\t"+factura.getCliente().getNombre());
			escribiendo.write("Vendedor:");
			escribiendo.write("\t"+factura.getVendedor().getNombre());
			escribiendo.newLine();
			escribiendo.write("Cantidad de componentes: "+(factura.getCompra().size()+cantidadKit(factura.getCompraK())));
			escribiendo.newLine();
			escribiendo.write("Cantidad");
			escribiendo.write("\tMarca");
			escribiendo.write("\tmodelo");
			escribiendo.write("\tPrecio");
			escribiendo.newLine();
			for (int i = 0; i < factura.getCompra().size(); i++) {
				escribiendo.write(factura.getCompra().get(i).getCantidad());
				escribiendo.write("\t"+factura.getCompra().get(i).getMarca());
				escribiendo.write("\t"+factura.getCompra().get(i).getModelo());
				escribiendo.write("\t"+factura.getCompra().get(i).getPrecioVenta());
				escribiendo.newLine();
			}
			for(int i=0;i<cantidadKit(factura.getCompraK());i++) {
				for (int j = 0; j < factura.getCompraK().get(i).getComponentes().size(); j++) {
					escribiendo.write(factura.getCompraK().get(i).getComponentes().get(i).getCantidad());
					escribiendo.write("\t"+factura.getCompraK().get(i).getComponentes().get(i).getMarca());
					escribiendo.write("\t"+factura.getCompraK().get(i).getComponentes().get(i).getModelo());
					escribiendo.write("\t"+factura.getCompraK().get(i).getComponentes().get(i).getPrecioCompra());
					escribiendo.newLine();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int cantidadKit(ArrayList<Kit> kits) {
		int ind=0;
		int cant=0;
		while(ind<kits.size()) {
			cant=kits.get(ind).getComponentes().size();
			ind++;
		}
		return cant;
	}
	   
}
