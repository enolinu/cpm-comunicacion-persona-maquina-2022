package uo.cpm.p8.player;


import java.io.File;

import javazoom.jlgui.basicplayer.*;

public class MusicPlayer {
	
	private BasicPlayer basicPlayer = null;
	
	private final static double VOLUMEN_MAXIMO = 100;
	private double volumen;
	private String cancionSonando;
	
	public MusicPlayer(){
		volumen = 50;
		basicPlayer = new BasicPlayer();
	}
	
	public void play (File file){
		try {
			basicPlayer.open(file);
			basicPlayer.play();
			cancionSonando = file.toString();
			setVolume(volumen, VOLUMEN_MAXIMO);
		}
		catch (Exception e){	
			
		}
	}
	
	public void stop(){
		try {
			basicPlayer.stop();
		}
		catch (BasicPlayerException e){
		}
	}
	
	public void setVolume(double vol, double volMax){
		try{
			
			basicPlayer.setGain(vol/volMax);
			volumen = vol;
		}
		catch (BasicPlayerException e){
		}
	}

	public String getCancionSonando() {
		// TODO Auto-generated method stub
		return null;
	}
}
