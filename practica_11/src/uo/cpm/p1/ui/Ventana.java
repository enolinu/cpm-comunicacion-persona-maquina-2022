package uo.cpm.p1.ui;

import java.awt.Color;

import javax.swing.*;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;
	
	// Atributos de la clase ventana (conenidos en ella).
	private JPanel pnPrincipal;
	private JButton btAceptar;
	private JButton btCancelar;
	private JLabel lbNombre;

	public Ventana() {
		
		// Le asignamos un t�tulo a la ventana.
		this.setTitle("Mi primera ventana");
		// Cambiamos los l�mites. (x, y, ancho, alto).
		this.setBounds(200,200,450,300);
		
		// Creamos el panel principal.
		pnPrincipal = new JPanel();
		// Cambiamos el color de fondo.
		pnPrincipal.setBackground(Color.CYAN);
		// Quitamos el layout.
		pnPrincipal.setLayout(null);
		// A�adimos el panel a la ventana.
		this.setContentPane(pnPrincipal);
		
		// Creamos un bot�n (Se puede usar el constructor para cambiar el texto.
		btAceptar = new JButton("Aceptar");
		// Lo colocamos y le damos tama�o.
		btAceptar.setBounds(200,220,90,30);
		// Cambiamos color de fondo.
		btAceptar.setForeground(Color.BLUE);
		// Agregamos el bot�n al panel.
		pnPrincipal.add(btAceptar);
		
		btCancelar = new JButton("Cancelar");
		btCancelar.setBounds(310,220,90,30);
		btCancelar.setForeground(Color.BLUE);
		pnPrincipal.add(btCancelar);
		
		lbNombre = new JLabel("Introduzca su nombre:");
		pnPrincipal.add(lbNombre);
		
		
	}

	public static void main(String[] args) {
		
		// Crear la ventana.
		Ventana ventana = new Ventana();
		// Hacemos que sea visible.
		ventana.setVisible(true);

	}

}
