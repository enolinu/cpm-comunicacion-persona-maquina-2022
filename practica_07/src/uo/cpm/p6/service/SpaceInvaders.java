package uo.cpm.p6.service;

import uo.cpm.p6.game.Juego;
import uo.cpm.p6.game.Juego.Nivel;
import uo.cpm.p6.model.Tablero;

public class SpaceInvaders {

	private Juego juego = new Juego();

	public Tablero getTablero()
	{
		return juego.getTablero();
	}

	public void inicializar(Nivel nivel)
	{
		juego.inicializarJuego(nivel);
	}

	public void dipara(int i)
	{
		juego.dispara(i);
	}

	public boolean isPartidaFinalizada()
	{
		return juego.isPartidaFinalizada();
	}
	
	public int getPuntuacion()
	{
		return juego.getPuntos();
	}

	public void lanzarDado()
	{
		juego.lanzar();
	}

	public int getDisparos()
	{
		return juego.getDisparos();
	}

	public String obtenerImagen(int i) 
	{
		return juego.obtenerImagen(i);
	}
	
	public String obtenerMensaje() 
	{
		return juego.mensajeFinal();
	}
	
	public Nivel getNivel() {
		return juego.getNivel();
	}

	public int getDimension() {
		return juego.getDimension();
	}

}