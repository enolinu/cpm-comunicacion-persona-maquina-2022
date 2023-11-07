package uo.cpm.p3.console;

public class Parser {
	
	public Producto parse(String linea) {
		
		String[] datos = linea.split("@");
		String tipo = datos[1];
		String codigo = datos[0];
		String nombre = datos[2];
		double precio = parseDouble(datos[3]);
		
		return new Producto(tipo, nombre, precio, codigo);
	}
	
	private double parseDouble(String cadena) {
		
		double inDouble = -1;
		inDouble = Double.parseDouble(cadena);
		return inDouble;
		
	}
	

}
