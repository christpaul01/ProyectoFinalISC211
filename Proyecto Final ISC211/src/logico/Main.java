package logico;

public class Main {

	public static void main(String[] args) {
		
		Ram a = new Ram("Corsair", 3000.00, 25, Tienda.getInstance().asignarSerial(), 
				"Vengance", 5000.00, "PC Internacional", 0.25, "DDR2");
		Tienda.getInstance().insertarProducto(a);
		Procesador b = new Procesador("Intel", 10000.00, 50, Tienda.getInstance().asignarSerial(),
				"i7 3770k", 15000.00, "PC Internacional", "LGA 1155", 2.5);
		Tienda.getInstance().insertarProducto(b);
		
		
		///////////////////////////////////////////
		System.out.println(a.toStringInventario());
		System.out.println(b.toStringInventario());
	}

}
