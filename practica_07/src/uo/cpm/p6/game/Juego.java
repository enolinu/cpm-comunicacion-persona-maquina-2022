package uo.cpm.p6.game;

import uo.cpm.p6.model.*;

public class Juego {
	
	public static final int maxDisparos = 4;
	int puntos;
	int disparos;
	private Tablero tablero; 
	private String enemigoEncontrado;
	
	private int dim;
	private int numInvasores;
	private int numMeteoritos;
	private int maximosDisparos;
	
	public enum Nivel {
		FACIL, INTERMEDIO, DIFICIL;
	}
	
	private Nivel nivel;
	
	
	public Juego(){
		inicializarJuego(Nivel.INTERMEDIO);
	}
	
	public Juego(Nivel nivel){
		inicializarJuego(nivel);
	}

	public void inicializarJuego(Nivel nivel){
		
		this.nivel = nivel;
		tablero = new Tablero();
		puntos = 1000;
		disparos = 0;
		enemigoEncontrado="Ninguno";
		
		switch(nivel) {
		case FACIL: {
			setParametros(10, 2, 0, 5);
			tablero.redimensionarTablero(Nivel.FACIL);
			break;
		}
		case INTERMEDIO: {
			setParametros(8, 1, 1, 4);
			tablero.redimensionarTablero(Nivel.INTERMEDIO);
			break;
		}
		case DIFICIL: {
			setParametros(8, 1, 1, 4);
			tablero.redimensionarTablero(Nivel.DIFICIL);
			break;
		} }
	}
	
	private void setParametros(int dim, int numInvasores, int numMeteoritos, int maximosDisparos) {
		this.dim = dim;
		this.setNumInvasores(numInvasores);
		this.setNumMeteoritos(numMeteoritos);
		this.maximosDisparos = maximosDisparos;
		
	}
		
	
	public Tablero getTablero() {
		return tablero;
	}
	
	public String getEnemigoEncontrado() {
		return enemigoEncontrado;
	}

	public void setEnemigoEncontrado(String enemigoEncontrado) {
		this.enemigoEncontrado = enemigoEncontrado;
	}
	
	public void dispara(int i){
		disparos --;
		puntos += tablero.getCasillas()[i].descubrir(puntos);
		if (tablero.getCasillas()[i].isEncontrado())
			setEnemigoEncontrado(tablero.getCasillas()[i].getTipo());
		
	}
	
	public boolean isPartidaFinalizada() {
		return (getEnemigoEncontrado().equals("Invasor") || disparos == 0 || getEnemigoEncontrado().equals("Meteorito")) ;
	}
	
	public String mensajeFinal() {
		if(disparos == 0) {
			return "HAS PERDIDO: Te has quedado sin disparos!";
		} if(getEnemigoEncontrado().equals("Invasor") ) {
			return "HAS GANADO: Has matado al invasor malvado!";
		} if(getEnemigoEncontrado().equals("Meteorito")) {
			return "HAS PERDIDO: Te has encontrado a un meteorito!";
		}
		return "";
	}

	public int getPuntos() {
		return puntos;
	}

	public void lanzar() {
		setDisparos(Dado.lanzar(maximosDisparos));	
	}
	
	public int getDisparos() {
		return disparos;
	}

	private void setDisparos(int disparos) {
		this.disparos = disparos;
	}
	
	public String obtenerImagen(int i) {
		return getTablero().obtenerImagen(i);
		
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public int getDimension() {
		return dim;
	}

	public int getNumInvasores() {
		return numInvasores;
	}

	public void setNumInvasores(int numInvasores) {
		this.numInvasores = numInvasores;
	}

	public int getNumMeteoritos() {
		return numMeteoritos;
	}

	public void setNumMeteoritos(int numMeteoritos) {
		this.numMeteoritos = numMeteoritos;
	}
}
