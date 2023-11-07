package uo.cpm.p3.ui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaConfirmacion extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	  
	private final JPanel contentPanel = new JPanel();
	private JTextField tfCodigo;

	/**
	 * Create the dialog.
	 */
	public VentanaConfirmacion() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaConfirmacion.class.getResource("/img/logo.png")));
		setTitle("McDonald's: Confirmaci\u00F3n Del Pedido");
		setBounds(100, 100, 573, 357);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		setLocationRelativeTo(null);
		{
			JLabel lbTitulo = new JLabel("Pulse \"Finalizar\" para verificar su compra");
			lbTitulo.setIcon(new ImageIcon(VentanaConfirmacion.class.getResource("/img/ok.png")));
			lbTitulo.setFont(new Font("Arial Black", Font.PLAIN, 16));
			lbTitulo.setBounds(63, 91, 439, 59);
			contentPanel.add(lbTitulo);
		}
		{
			JLabel lbCodigo = new JLabel("Su c\u00F3digo de pedido es:");
			lbCodigo.setFont(new Font("Arial", Font.PLAIN, 14));
			lbCodigo.setBounds(144, 157, 153, 25);
			contentPanel.add(lbCodigo);
		}
		{
			tfCodigo = new JTextField();
			tfCodigo.setHorizontalAlignment(SwingConstants.CENTER);
			tfCodigo.setText("<dynamic>");
			tfCodigo.setEditable(false);
			tfCodigo.setFont(new Font("Arial", Font.PLAIN, 14));
			tfCodigo.setBounds(307, 157, 111, 25);
			contentPanel.add(tfCodigo);
			tfCodigo.setColumns(10);
		}
		{
			JButton btnFinalizar = new JButton("Finalizar");
			btnFinalizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			btnFinalizar.setForeground(Color.WHITE);
			btnFinalizar.setFont(new Font("Arial", Font.PLAIN, 14));
			btnFinalizar.setBackground(new Color(0, 128, 0));
			btnFinalizar.setBounds(421, 274, 112, 33);
			contentPanel.add(btnFinalizar);
		}
	}

}
