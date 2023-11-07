package uo.cpm.p6.model;

public class Meteorito extends Casilla {
	boolean encontrado;

	
	public Meteorito() {
		setPuntos(0);
		setImagen ( "/img/meteorite.jpg");
		setTipo("Meteorito");
	}
	
	public boolean isEncontrado() {
		return encontrado;
	}
	
	public void setEncontrado(boolean encontrado) {
		this.encontrado = encontrado;
	}
	
	public int descubrir (int puntosJuego) {
		setEncontrado(true);
		setPuntos(-getPuntos());
		return getPuntos();	
	}
	
	
}
