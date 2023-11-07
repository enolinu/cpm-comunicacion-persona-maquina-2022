package uo.cpm.p6.model;

import uo.cpm.p6.game.Juego.Nivel;

public class Tablero {
	
	public  int DIM = 8;
	Casilla[] casillas;
	
	public Tablero() {
		casillas = new Casilla[DIM];
		for (int i=0;i<DIM;i++)
			casillas[i] = new Espacio();
		colocaInvasor();
		colocaMeteorito();
		}

	private void colocaInvasor() {
		int posicionInvasor = (int) (Math.random() * DIM);
		casillas[posicionInvasor] = new Invasor();
		// Pa ver onde ta
		System.out.println(posicionInvasor);
	}
	
	private void colocaMeteorito() {
		int posicionMeteorito;
		do {
			posicionMeteorito = (int) (Math.random() * DIM);
		} while(casillas[posicionMeteorito].getTipo() == "Invasor");
		casillas[posicionMeteorito] = new Meteorito();
		System.out.println(posicionMeteorito);
	}
	
	public void redimensionarTablero(Nivel nivel)  {
		if(nivel == Nivel.FACIL) {
			this.DIM = 6;
		}
		if(nivel == Nivel.INTERMEDIO) {
			this.DIM = 8;
		}
		if(nivel == Nivel.DIFICIL) {
			this.DIM = 12;
		}
		
	}
	
	
	public Casilla[] getCasillas() {
		return casillas;
	}
	
	public String obtenerImagen(int i) {
		return casillas[i].getImagen();
	}
}
