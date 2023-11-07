package uo.cpm.p3.ui;

import javax.swing.JDialog;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import uo.cpm.p3.service.McDonalds;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaConfirmacion extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lbMensaje;
	private JLabel lbCodigo;
	private JTextField textField;
	private JButton btnFinalizar;
	private McDonalds mcDonalds;
	
	private VentanaRegistro vr;
	private VentanaPrincipal vp;


	/**
	 * Create the dialog.
	 */
	public VentanaConfirmacion(McDonalds mcDonalds) {
		
		this.mcDonalds = mcDonalds;
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		getContentPane().add(getLbMensaje());
		getContentPane().add(getLbCodigo());
		getContentPane().add(getTextField());
		getContentPane().add(getBtnFinalizar());
		setTitle("McDonald's: Confirmaci\u00F3n Del Pedido");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaConfirmacion.class.getResource("/img/logo.png")));
		setBounds(100, 100, 502, 310);
		
		// Centrar vantana al abrir
		setLocationRelativeTo(null);

	}

	private JLabel getLbMensaje() {
		if (lbMensaje == null) {
			lbMensaje = new JLabel("Pulse Finalizar para confirmar su pedido");
			lbMensaje.setIcon(new ImageIcon(VentanaConfirmacion.class.getResource("/img/ok.png")));
			lbMensaje.setFont(new Font("Arial Black", Font.PLAIN, 14));
			lbMensaje.setBounds(58, 76, 390, 50);
		}
		return lbMensaje;
	}
	private JLabel getLbCodigo() {
		if (lbCodigo == null) {
			lbCodigo = new JLabel("El c\u00F3digo de recogida es:");
			lbCodigo.setFont(new Font("Arial", Font.PLAIN, 12));
			lbCodigo.setBounds(124, 137, 139, 20);
		}
		return lbCodigo;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			textField.setEditable(false);
			textField.setText(mcDonalds.getCodigoPedido());
			textField.setBounds(273, 132, 91, 31);
			textField.setColumns(10);
		}
		return textField;
	}
	private JButton getBtnFinalizar() {
		if (btnFinalizar == null) {
			btnFinalizar = new JButton("Finalizar");
			btnFinalizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					grabarEnFichero();
					dispose();
					vr.dispose();
					vp.inicializar();
				}
			});
			btnFinalizar.setBackground(new Color(0, 128, 0));
			btnFinalizar.setForeground(Color.WHITE);
			btnFinalizar.setFont(new Font("Arial", Font.PLAIN, 14));
			btnFinalizar.setBounds(351, 228, 103, 23);
		}
		return btnFinalizar;
	}
	
	private void grabarEnFichero() {
		mcDonalds.grabarPedido();
	}

	public void setMcDonalds(McDonalds mcDonalds) {
		this.mcDonalds = mcDonalds;
	}
	
	protected void setVentanaRegistro(VentanaRegistro vr) {
		this.vr = vr;
	}
	
	protected VentanaRegistro getVentanaRegistro() {
		return this.vr;
	}
	
	protected void setVentanaPrincipal(VentanaPrincipal vp) {
		this.vp = vp;
	}
	
	protected VentanaPrincipal getVentanaPrincipal() {
		return this.vp;
	}
}
