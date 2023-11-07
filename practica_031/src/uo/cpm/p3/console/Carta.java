package uo.cpm.p3.console;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import uo.cpm.p3.util.FileUtil;

public class Carta {
	
	ArrayList<Producto> carta = new ArrayList<Producto>();
	
	public Carta() {
		try {
			cargarProductos();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public void cargarProductos() throws FileNotFoundException {
		ArrayList<String> salidaArchivo = FileUtil.leerFichero("articulos.dat");
		Parser p = new Parser();
		for(String linea: salidaArchivo) {
			carta.add(p.parse(linea));
		}
	}
	public ArrayList<Producto> getCarta() {
		ArrayList<Producto> cartaCopia = new ArrayList<Producto>();
		for(Producto p: carta) {
			cartaCopia.add(p);
		}
		return cartaCopia;
	}
	
	public boolean comprobarCodigo(String codigo) {
		for(Producto p: carta) {
			if(p.getCodigo().equals(codigo)) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		String str = "";
		for(Producto p: getCarta()) {
			str = str+p.toString()+"€\n";
		}
		return str;
		
	}

}
