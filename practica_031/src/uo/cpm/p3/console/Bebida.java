package uo.cpm.p3.console;

public class Bebida extends Producto {

	public Bebida(String nombre, double precio, String codigo) {
		super(nombre, precio, codigo);
	}
	
	public String toString() {
		return "C�digo: "+getCodigo()+" Bebida: "+getNombre()+" Precio: "+getPrecio();  
	}

}
