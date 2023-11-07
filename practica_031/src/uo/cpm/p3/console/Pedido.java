package uo.cpm.p3.console;

import java.util.ArrayList;

public class Pedido {
	
	private ArrayList<Producto> pedido = new ArrayList<Producto>();
	double precioTotal;
	
	public void addProducto(Producto p) {
		pedido.add(p);
		setPrecioTotal(getPrecioTotal()+p.getPrecio());
	}
	
	private void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	public double getPrecioTotal() {
		return precioTotal;
	}

	public void borrarLista() {
		setPedido(new ArrayList<Producto>());
		
	}

	private void setPedido(ArrayList<Producto> pedido) {
		this.pedido = pedido;
		
	}
	

}
