package logico;
import java.io.Serializable;
import java.util.ArrayList;

public class Kit implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private ArrayList<Componente> componentes;
	private final int descuento = 10;
	private String id;
	private String nombre;
	private Double precioFinal;
	private int cantidad;
	
	
	public Kit(String id, String nombre,ArrayList<Componente> componentes) {
		super();
		this.componentes = componentes;
		this.id = id;
		this.nombre = nombre;
		this.precioFinal = precioTotal();
		cantidad = 0;
	}

	public String toString()
	{
		String toString = nombre +  " - " + "RD$ " + precioFinal;
		return toString ;
	}

	public ArrayList<Componente> getComponentes() {
		return componentes;
	}
	


	public void setComponentes(ArrayList<Componente> componentes) {
		this.componentes = componentes;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public int getDescuento() {
		return descuento;
	}
	public Double precioTotal() {
		Double total = 0.00 ;
		for (int i = 0; i < componentes.size(); i++) {	
			total+=componentes.get(i).getPrecioVenta()-(componentes.get(i).getPrecioVenta()*0.10);
		}
		return total;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecioFinal() {
		return precioFinal;
	}
	
	public void setCantidad(int cant)
	{
		cantidad = cant;
	}
	
	public int getCantidad()
	{
		return cantidad;
	}

}
