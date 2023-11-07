package uo.cpm.p3.console;

import java.util.Scanner;

public class Console {
	
	private final Carta carta;
	private Pedido pedido;

	public Console() {
		this.carta = new Carta();
		this.pedido = new Pedido();
		mensajeBienvenida();
		
	}
	
	public Carta getCarta() {
		return carta;
	}
	
	public void mensajeBienvenida() {
		System.out.println("-------BIENVENID@ A MCDONALD'S ESPAÑA-------");
		System.out.println("Ésta es nuestra cara de productos: ");
		System.out.print(getCarta().toString());
		pedidoUsuario();
		System.out.println("Gracias por su visita");
	}
	
	private void pedidoUsuario() {
		System.out.println("Introduzca el código del pedido a añadir a la cesta. Introduzca F para finalizar, y X para cancelar");
		String linea;
		Scanner entrada = new Scanner(System.in);
		if(!entrada.nextLine().equals("F") && !entrada.nextLine().equals("F")) {
			linea = entrada.nextLine();
			if(carta.comprobarCodigo(linea)) {
				pedido.addProducto(buscarProducto(linea));
				System.out.println("Precio Total = "+pedido.getPrecioTotal()+" €");
				System.out.println("Introduzca el código del pedido a añadir a la cesta. Introduzca F para finalizar, y X para cancelar");
				pedidoUsuario();
			}
		}if(entrada.nextLine().equals("X")) {
			cancelarCompra();
			System.out.println("Su compra ha sido cancelada con éxito!");
			entrada.close();
		}
		entrada.close();
	}
	
	private void cancelarCompra() {
		pedido.borrarLista();
		
	}
	
	private Producto buscarProducto(String codigo) {
		for(Producto p: getCarta().getCarta()) {
			if(p.getCodigo().equals(codigo)) {
				return p;
			}
		}
		return null;
		
	}

}
