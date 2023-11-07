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

}
