package uo.cpm.p3.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lbLogo;
	private JComboBox<String> cbArticulo;
	private JTextField tfPrecio;
	private JSpinner spUnidades;
	private JButton btnAnadir;
	private JButton btnSiguiente;
	private JButton btnCancelar;
	private JLabel lbArticulo;
	private JLabel lbUnidades;
	private JLabel lbPrecio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/logo.png")));
		setResizable(false);
		setTitle("McDonald's Espa\u00F1a");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 727, 524);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLbLogo());
		contentPane.add(getCbArticulo());
		contentPane.add(getTfPrecio());
		contentPane.add(getSpUnidades());
		contentPane.add(getBtnAnadir());
		contentPane.add(getBtnSiguiente());
		contentPane.add(getBtnCancelar());
		contentPane.add(getLbArticulo());
		contentPane.add(getLbUnidades());
		contentPane.add(getLbPrecio());
		
		// Centrar ventana.
		setLocationRelativeTo(null);
	}

	private JLabel getLbLogo() {
		if (lbLogo == null) {
			lbLogo = new JLabel(" McDonald's");
			lbLogo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logo.png")));
			lbLogo.setFont(new Font("Arial Black", Font.PLAIN, 44));
			lbLogo.setBounds(25, 30, 687, 139);
		}
		return lbLogo;
	}
	private JComboBox<String> getCbArticulo() {
		if (cbArticulo == null) {
			cbArticulo = new JComboBox<String>();
			cbArticulo.setFont(new Font("Arial", Font.PLAIN, 14));
			cbArticulo.setBounds(25, 227, 443, 33);
		}
		return cbArticulo;
	}
	private JTextField getTfPrecio() {
		if (tfPrecio == null) {
			tfPrecio = new JTextField();
			tfPrecio.setEditable(false);
			tfPrecio.setFont(new Font("Arial", Font.PLAIN, 14));
			tfPrecio.setBounds(497, 318, 99, 33);
			tfPrecio.setColumns(10);
		}
		return tfPrecio;
	}
	private JSpinner getSpUnidades() {
		if (spUnidades == null) {
			spUnidades = new JSpinner();
			spUnidades.setModel(new SpinnerNumberModel(1, 1, 100, 1));
			spUnidades.setFont(new Font("Arial", Font.PLAIN, 14));
			spUnidades.setBounds(497, 227, 75, 33);
		}
		return spUnidades;
	}
	private JButton getBtnAnadir() {
		if (btnAnadir == null) {
			btnAnadir = new JButton("A\u00F1adir");
			btnAnadir.setMnemonic('A');
			btnAnadir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnAnadir.setForeground(new Color(255, 255, 255));
			btnAnadir.setBackground(new Color(0, 128, 0));
			btnAnadir.setFont(new Font("Arial", Font.PLAIN, 14));
			btnAnadir.setBounds(596, 227, 89, 33);
		}
		return btnAnadir;
	}
	private JButton getBtnSiguiente() {
		if (btnSiguiente == null) {
			btnSiguiente = new JButton("Siguiente");
			btnSiguiente.setMnemonic('S');
			btnSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Creamos la ventana de registro.
					crearVentanaRegistro();;
				}
			});
			btnSiguiente.setForeground(Color.WHITE);
			btnSiguiente.setFont(new Font("Arial", Font.PLAIN, 14));
			btnSiguiente.setBackground(new Color(0, 128, 0));
			btnSiguiente.setBounds(441, 430, 112, 33);
		}
		return btnSiguiente;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setMnemonic('C');
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			btnCancelar.setForeground(Color.WHITE);
			btnCancelar.setFont(new Font("Arial", Font.PLAIN, 14));
			btnCancelar.setBackground(Color.RED);
			btnCancelar.setBounds(573, 430, 112, 33);
		}
		return btnCancelar;
	}
	private JLabel getLbArticulo() {
		if (lbArticulo == null) {
			lbArticulo = new JLabel("Art\u00EDculo:");
			lbArticulo.setLabelFor(getCbArticulo());
			lbArticulo.setDisplayedMnemonic('R');
			lbArticulo.setFont(new Font("Arial", Font.PLAIN, 14));
			lbArticulo.setBounds(27, 193, 75, 23);
		}
		return lbArticulo;
	}
	private JLabel getLbUnidades() {
		if (lbUnidades == null) {
			lbUnidades = new JLabel("Unidades:");
			lbUnidades.setLabelFor(getSpUnidades());
			lbUnidades.setDisplayedMnemonic('U');
			lbUnidades.setFont(new Font("Arial", Font.PLAIN, 14));
			lbUnidades.setBounds(497, 193, 75, 23);
		}
		return lbUnidades;
	}
	private JLabel getLbPrecio() {
		if (lbPrecio == null) {
			lbPrecio = new JLabel("Precio Pedido");
			lbPrecio.setFont(new Font("Arial", Font.PLAIN, 14));
			lbPrecio.setBounds(497, 284, 126, 23);
		}
		return lbPrecio;
	}
	
	// Método que creará y hará visible la ventana de registro cuando proceda.
	private void crearVentanaRegistro() {
		try {
			VentanaRegistro vr = new VentanaRegistro();
			vr.setVisible(true);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
