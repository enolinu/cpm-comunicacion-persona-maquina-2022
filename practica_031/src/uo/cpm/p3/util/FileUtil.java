package uo.cpm.p3.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileUtil {

	public FileUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public static ArrayList<String> leerFichero(String nombreArchivo) throws FileNotFoundException {
		
		BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo));
		ArrayList<String> lineas = new ArrayList<String>();
		try {
			try {
				String line;
				while((line = lector.readLine()) != null) {	
					lineas.add(line);	
				}	
			} finally {
				
				lector.close();	
			}
		} catch (IOException exception) {
			System.err.println("NO SE PUDO LEER EL ARCHIVO!");
		}
		return lineas;
	}

}
