package uo.cpm.p3.model;

import java.util.*;

import uo.cpm.p3.util.FileUtil;

public class Carta {

	private static final String FICHERO_ARTICULOS = "articulos.dat";
	private List<Articulo> listaArticulos = null;

	public Carta() {
		listaArticulos = new ArrayList<Articulo>();
		cargarArticulos();
	}

	private void cargarArticulos() {
		FileUtil.loadFile(FICHERO_ARTICULOS, listaArticulos);
	}

	public Articulo[] getArticulos() {
		Articulo[] articulos = listaArticulos.toArray(new Articulo[listaArticulos.size()]);
		return articulos;
	}
	
	public Articulo[] filtrar(char tipo) {
		
		ArrayList<Articulo> listaFiltrada = new ArrayList<Articulo>();
		
		if(tipo=='h') {
			for(Articulo a: listaArticulos) {
				if(a.getTipo().equals("Hamburguesa")) {
					listaFiltrada.add(a);
				}
			}
		}
		if(tipo=='b') {
			for(Articulo a: listaArticulos) {
				if(a.getTipo().equals("Bebida")) {
					listaFiltrada.add(a);
				}
			}
		}
		if(tipo=='c') {
			for(Articulo a: listaArticulos) {
				if(a.getTipo().equals("Complemento")) {
					listaFiltrada.add(a);
				}
			}
		}
		if(tipo=='p') {
			for(Articulo a: listaArticulos) {
				if(a.getTipo().equals("Postre")) {
					listaFiltrada.add(a);
				}
			}
			
		if(tipo == 'a') {
			for(Articulo a: listaArticulos) {
				listaFiltrada.add(a);
			}
			}
		}
		
		Articulo[] articulos = listaFiltrada.toArray(new Articulo[listaFiltrada.size()]);
		return articulos;

	}

}
