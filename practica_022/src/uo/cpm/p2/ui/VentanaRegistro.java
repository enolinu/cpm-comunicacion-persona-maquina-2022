package uo.cpm.p2.ui;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class VentanaRegistro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btSiguiente;
	private JButton btCancelar;
	private JPanel pnCliente;
	private JPanel pnPedido;
	private JComboBox cbAnos;
	private JLabel lbNombre;
	private JLabel lbAno;
	private JLabel lbConstrasena;
	private JLabel lblReintroduzcaPassword;
	private JTextField tfNombre;
	private JPasswordField pfPassword;
	private JPasswordField pfReintroduzcaPassword;
	private JRadioButton rbLocal;
	private JRadioButton rbLlevar;
	private JLabel label;
	private JLabel label_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistro frame = new VentanaRegistro();
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
	public VentanaRegistro() {
		setResizable(false);
		setTitle("Datos De Registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 548, 358);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtSiguiente());
		contentPane.add(getBtCancelar());
		contentPane.add(getPnCliente());
		contentPane.add(getPnPedido());
	}
	private JButton getBtSiguiente() {
		if (btSiguiente == null) {
			btSiguiente = new JButton("Siguiente");
			btSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					validarFormulario();
				}
			});
			btSiguiente.setForeground(Color.WHITE);
			btSiguiente.setBackground(Color.GREEN);
			btSiguiente.setBounds(308, 268, 89, 23);
		}
		return btSiguiente;
	}
	
	// Condiciones para validar el formulario.
	protected void validarFormulario() {
		
		// Comprobamos que el campo nombre no esté vacío.
		if(getTfNombre().getText().equals(null) || getTfNombre().getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Debe introducir un nombre válido para continuar.");
		//Comprobamos que las contraseñas coincidan.
		}else if(!(String.valueOf(pfPassword.getPassword()).equals(String.valueOf(pfReintroduzcaPassword.getPassword())))) {
			JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
		}
		
	}

	private JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.addActionListener(new ActionListener() {
				
				//Acción del botón cancelar (Sale de la aplicación).
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			btCancelar.setForeground(Color.WHITE);
			btCancelar.setBackground(Color.RED);
			btCancelar.setBounds(421, 268, 89, 23);
		}
		return btCancelar;
	}
	
	private JPanel getPnCliente() {
		if (pnCliente == null) {
			pnCliente = new JPanel();
			pnCliente.setBorder(new TitledBorder(null, "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnCliente.setBackground(Color.WHITE);
			pnCliente.setBounds(25, 11, 485, 233);
			pnCliente.setLayout(null);
			pnCliente.add(getCbAnos());
			pnCliente.add(getLbNombre());
			pnCliente.add(getLbAno());
			pnCliente.add(getLbConstrasena());
			pnCliente.add(getLblReintroduzcaPassword());
			pnCliente.add(getTfNombre());
			pnCliente.add(getPfPassword());
			pnCliente.add(getPfReintroduzcaPassword());
		}
		return pnCliente;
	}
	
	private JPanel getPnPedido() {
		if (pnPedido == null) {
			pnPedido = new JPanel();
			pnPedido.setBorder(new TitledBorder(null, "Pedido", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnPedido.setBackground(Color.WHITE);
			pnPedido.setBounds(25, 247, 263, 61);
			pnPedido.setLayout(null);
			pnPedido.add(getRbLocal());
			pnPedido.add(getLabel());
			pnPedido.add(getLabel_1());
			pnPedido.add(getRbLlevar());
		}
		return pnPedido;
	}
	private JComboBox getCbAnos() {
		if (cbAnos == null) {
			cbAnos = new JComboBox();
			cbAnos.setModel(new DefaultComboBoxModel(rellenarAnos()));
			cbAnos.setBounds(200, 83, 121, 22);
		}
		return cbAnos;
	}
	
	private String[] rellenarAnos() {
		
		String[] anos = new String[101];
		for(int i=2004; i<=1924; i--) {
			anos[i] = String.valueOf(i);
		}
		return anos;
	
	}
	private JLabel getLbNombre() {
		if (lbNombre == null) {
			lbNombre = new JLabel("Nombre y Apellidos:");
			lbNombre.setBounds(22, 43, 149, 14);
		}
		return lbNombre;
	}
	private JLabel getLbAno() {
		if (lbAno == null) {
			lbAno = new JLabel("A\u00F1o de Nacimiento:");
			lbAno.setBounds(22, 87, 149, 14);
		}
		return lbAno;
	}
	private JLabel getLbConstrasena() {
		if (lbConstrasena == null) {
			lbConstrasena = new JLabel("Password:");
			lbConstrasena.setBounds(22, 133, 149, 14);
		}
		return lbConstrasena;
	}
	private JLabel getLblReintroduzcaPassword() {
		if (lblReintroduzcaPassword == null) {
			lblReintroduzcaPassword = new JLabel("Reintroduzca Password:");
			lblReintroduzcaPassword.setBounds(22, 177, 149, 14);
		}
		return lblReintroduzcaPassword;
	}
	private JTextField getTfNombre() {
		if (tfNombre == null) {
			tfNombre = new JTextField();
			tfNombre.setBounds(200, 40, 260, 20);
			tfNombre.setColumns(10);
		}
		return tfNombre;
	}
	private JPasswordField getPfPassword() {
		if (pfPassword == null) {
			pfPassword = new JPasswordField();
			pfPassword.setBounds(200, 130, 180, 20);
		}
		return pfPassword;
	}
	private JPasswordField getPfReintroduzcaPassword() {
		if (pfReintroduzcaPassword == null) {
			pfReintroduzcaPassword = new JPasswordField();
			pfReintroduzcaPassword.setBounds(200, 174, 180, 20);
		}
		return pfReintroduzcaPassword;
	}
	private JRadioButton getRbLocal() {
		if (rbLocal == null) {
			rbLocal = new JRadioButton("Local");
			rbLocal.setBounds(40, 21, 79, 23);
			rbLocal.setBackground(Color.WHITE);
		}
		return rbLocal;
	}
	private JRadioButton getRbLlevar() {
		if (rbLlevar == null) {
			rbLlevar = new JRadioButton("Llevar");
			rbLlevar.setBackground(Color.WHITE);
			rbLlevar.setBounds(155, 21, 79, 23);
		}
		return rbLlevar;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setBounds(125, 32, 0, 0);
		}
		return label;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("");
			label_1.setBounds(130, 32, 0, 0);
		}
		return label_1;
	}
}
