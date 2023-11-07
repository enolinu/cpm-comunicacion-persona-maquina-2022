package uo.cpm.p3.console;

public class Parser {
	
	public Producto parse(String linea) {
		
		String[] datos = linea.split("@");
		String codigo = datos[0];
		String nombre = datos[2];
		double precio = parseDouble(datos[3]);
		
		if(datos[1].equals("Hamburguesa")) {
			return new Hamburguesa(nombre, precio, codigo);
		}
		if(datos[1].equals("Complemento")) {
			return new Complemento(nombre, precio, codigo);
		}
		if(datos[1].equals("Bebida")) {
			return new Bebida(nombre, precio, codigo);
		} else {
			return new Postre(nombre, precio, codigo);
		}
	}
	
	private double parseDouble(String cadena) {
		
		double inDouble = -1;
		inDouble = Double.parseDouble(cadena);
		return inDouble;
		
	}
	

}
