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
	
	
	public Kit(ArrayList<Componente> componentes, String id) {
		super();
		this.componentes = componentes;
		this.id = id;
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
	public float precioTotal() {
		float total=0;
		for (int i = 0; i < componentes.size(); i++) {	
			total+=componentes.get(i).getPrecioVenta()-(componentes.get(i).getPrecioVenta()*0.10);
		}
		return total;
	}
	
	

}
