package uo.cpm.p3.console;

public class Hamburguesa extends Producto {

	public Hamburguesa(String nombre, double precio, String codigo) {
		super(nombre, precio, codigo);
	}
	
	public String toString() {
		return "C�digo: "+getCodigo()+" Hamburguesa: "+getNombre()+" Precio: "+getPrecio();  
	}

}