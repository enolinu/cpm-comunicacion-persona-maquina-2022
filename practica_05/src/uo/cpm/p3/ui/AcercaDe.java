package uo.cpm.p3.ui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AcercaDe extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lbFoto;
	private JButton btnNewButton;
	private JTextPane txtpnDesarrolladoPorEnol;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AcercaDe dialog = new AcercaDe();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public AcercaDe() {
		setTitle("Mc Donalds Espa\u00F1a - Acerca De");
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		getContentPane().add(getLbFoto());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getTxtpnDesarrolladoPorEnol());
		setBounds(100, 100, 459, 294);
		
		// Centrar ventana.
		setLocationRelativeTo(null);

	}
	private JLabel getLbFoto() {
		if (lbFoto == null) {
			lbFoto = new JLabel("");
			lbFoto.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
			lbFoto.setIcon(new ImageIcon(AcercaDe.class.getResource("/img/ems.png")));
			lbFoto.setBounds(19, 62, 125, 132);
		}
		return lbFoto;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("OK");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnNewButton.setBounds(345, 221, 89, 23);
		}
		return btnNewButton;
	}
	private JTextPane getTxtpnDesarrolladoPorEnol() {
		if (txtpnDesarrolladoPorEnol == null) {
			txtpnDesarrolladoPorEnol = new JTextPane();
			txtpnDesarrolladoPorEnol.setEditable(false);
			txtpnDesarrolladoPorEnol.setFont(new Font("Arial", Font.BOLD, 12));
			txtpnDesarrolladoPorEnol.setText("Desarrollado Por:\r\nEnol Monte Soto (UO287616)\r\n\r\nContexto:\r\nEII 2022/2023 - Comunicaci\u00F3n Persona-M\u00E1quina\r\nUniversidad De Oviedo");
			txtpnDesarrolladoPorEnol.setBounds(154, 77, 289, 104);
		}
		return txtpnDesarrolladoPorEnol;
	}
}
