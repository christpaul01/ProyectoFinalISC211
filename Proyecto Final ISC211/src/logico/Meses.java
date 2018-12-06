package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Meses implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Ventas> ventas;
	private String Mes;
	private int cantRam;
	private int cantMotherboard;
	private int cantCPU;
	private int cantHDD;
	private int cantKits;
	
	public Meses() {
		// TODO Auto-generated constructor stub
		
		ventas = new ArrayList<Ventas>();
		cantRam = 0;
		cantMotherboard = 0;
		cantCPU = 0;
		cantHDD = 0;
		cantKits = 0;
		
	}
	
	public void insertarVentas(Ventas ventas)
	{
		this.ventas.add(ventas);
		
		for(int i = 0; i< ventas.getComponente().size() ;i++)
		{
			if(ventas.getComponente().get(i) instanceof Ram)
			{
				cantRam++;
			}
			
			
			if(ventas.getComponente().get(i) instanceof Motherboard)
			{
				cantMotherboard++;
			}
			
			
			
			if(ventas.getComponente().get(i) instanceof Procesador)
			{
				cantCPU++;
			}
			
			
			if(ventas.getComponente().get(i) instanceof DiscoDuro)
			{
				cantHDD++;
			}
			
			
		}
		
		for(int i = 0; i< ventas.getKits().size() ;i++)
		{
			cantKits++;
			//Ya que los kits incluyen obligatoriamente todos estos componentes
			cantRam++;
			cantMotherboard++;
			cantCPU++;
			cantHDD++;
		}
		
	}

	public ArrayList<Ventas> getVentas() {
		return ventas;
	}

	public String getMes() {
		return Mes;
	}

	public void setMes(String mes) {
		Mes = mes;
	}

	public int getCantRam() {
		return cantRam;
	}

	public int getCantMotherboard() {
		return cantMotherboard;
	}

	public int getCantCPU() {
		return cantCPU;
	}

	public int getCantHDD() {
		return cantHDD;
	}

	public int getCantKits() {
		return cantKits;
	}
	
	

}
