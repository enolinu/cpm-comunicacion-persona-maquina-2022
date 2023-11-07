package uo.cpm.p3.console;

public class Producto {
	
	private final String nombre;
	private final double precio;
	private final String codigo;

	public Producto(String nombre, double precio, String codigo) {
		
		validarString(nombre);
		validarPrecio(precio);
		this.nombre = nombre;
		this.precio = precio;
		this.codigo = codigo;
		
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	
	public double getPrecio() {
		return this.precio;
	}
	
	private void validarPrecio(double precio) {
		if(precio <= 0) {
			throw new IllegalArgumentException("El precio no puede ser cero o negativo!");
		}
	}
	
	private void validarString(String nombre) {
		if(nombre.isEmpty() || nombre.trim().equals(null)) {
			throw new IllegalArgumentException("El producto debe tener un nombre válido!");
		}
	}

}
