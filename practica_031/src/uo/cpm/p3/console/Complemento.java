package uo.cpm.p3.console;

public class Complemento extends Producto {

	public Complemento(String nombre, double precio, String codigo) {
		super(nombre, precio, codigo);
	}
	public String toString() {
		return "C�digo: "+getCodigo()+" Complemento: "+getNombre()+" Precio: "+getPrecio();  
	}

}
