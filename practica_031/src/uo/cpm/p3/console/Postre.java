package uo.cpm.p3.console;


public class Postre extends Producto {

	public Postre(String nombre, double precio, String codigo) {
		super(nombre, precio, codigo);
	}
	
	public String toString() {
		return "Código: "+getCodigo()+" Postre: "+getNombre()+" Precio: "+getPrecio();  
	}

}
