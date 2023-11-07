package uo.cpm.p3.ui;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import uo.cpm.p3.service.McDonalds;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaRegistro extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btSiguiente;
	private JButton btCancelar;
	private JPanel pnCliente;
	private JPanel pnPedido;
	private JComboBox<String> cbAnos;
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
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private McDonalds mcDonalds;
	
	private VentanaPrincipal vp;


	/**
	 * Create the frame.
	 */
	public VentanaRegistro() {
		setResizable(false);
		setTitle("Datos De Registro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		// Centrar ventana.
		setLocationRelativeTo(null);
	}
	private JButton getBtSiguiente() {
		if (btSiguiente == null) {
			btSiguiente = new JButton("Siguiente");
			btSiguiente.setMnemonic('S');
			btSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					validarFormulario();
					localOLlevar();
				}
			});
			btSiguiente.setForeground(Color.WHITE);
			btSiguiente.setBackground(new Color(0, 128, 0));
			btSiguiente.setBounds(308, 268, 89, 23);
		}
		return btSiguiente;
	}
	
	// Condiciones para validar el formulario.
	protected void validarFormulario() {
		
		// Comprobamos que el campo nombre no esté vacío.
		if(getTfNombre().getText().equals(null) || getTfNombre().getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Debe introducir un nombre válido para continuar.");
			
		// Comprobamos que se rellenan los dos campos de contraseña.
		} else if(String.valueOf(getPfPassword().getPassword()).equals("") || String.valueOf(getPfReintroduzcaPassword().getPassword()).equals("")) {
			JOptionPane.showMessageDialog(null, "Debe introducir una contraseña en ámbos campos.");
			
		//Comprobamos que las contraseñas coincidan.
		}else if(!(String.valueOf(getPfPassword().getPassword()).equals(String.valueOf(getPfReintroduzcaPassword().getPassword())))) {
			JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
		} else {
			crearVentanaConfirmacion();
		}
		
	}

	private JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.setMnemonic('C');
			btCancelar.addActionListener(new ActionListener() {
				
				//Acción del botón cancelar (Cierra ésta ventana).
				public void actionPerformed(ActionEvent e) {
					dispose();
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
	private JComboBox<String> getCbAnos() {
		if (cbAnos == null) {
			String[] anos = rellenarAnos();
			cbAnos = new JComboBox<String>();
			cbAnos.setModel(new DefaultComboBoxModel<String>(anos));
			cbAnos.setBounds(200, 80, 121, 28);
		}
		return cbAnos;
	}
	
	private String[] rellenarAnos() {
		
		String[] anos = new String[100];
		for(int i=0; i>=100; i++) {
			anos[i] = String.valueOf(2004-i);
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
			tfNombre.setBounds(200, 34, 260, 32);
			tfNombre.setColumns(10);
		}
		return tfNombre;
	}
	private JPasswordField getPfPassword() {
		if (pfPassword == null) {
			pfPassword = new JPasswordField();
			pfPassword.setBounds(200, 124, 180, 33);
		}
		return pfPassword;
	}
	private JPasswordField getPfReintroduzcaPassword() {
		if (pfReintroduzcaPassword == null) {
			pfReintroduzcaPassword = new JPasswordField();
			pfReintroduzcaPassword.setBounds(200, 168, 180, 32);
		}
		return pfReintroduzcaPassword;
	}
	private JRadioButton getRbLocal() {
		if (rbLocal == null) {
			rbLocal = new JRadioButton("Local");
			buttonGroup.add(rbLocal);
			rbLocal.setSelected(true);
			rbLocal.setBounds(40, 21, 79, 23);
			rbLocal.setBackground(Color.WHITE);
		}
		return rbLocal;
	}
	private JRadioButton getRbLlevar() {
		if (rbLlevar == null) {
			rbLlevar = new JRadioButton("Llevar");
			buttonGroup.add(rbLlevar);
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
	
	// Devuelve true si es pa llevar.
	public boolean llevar() {
		if(getRbLlevar().isSelected()) {
			return true;
		}
		return false;
	}
	
	// Crea la ventana de confirmación cuando proceda.
	private void crearVentanaConfirmacion() {
		try {
			VentanaConfirmacion vc = new VentanaConfirmacion();
			
			setVentanaPrincipal(vp);
			vc.setVentanaPrincipal(vp);
			vc.setVentanaRegistro(this);
			
			vc.setMcDonalds(getMcDonalds());
			vc.setModal(true);
			vc.setVisible(true);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	private McDonalds getMcDonalds() {
		return this.mcDonalds;
	}
	
	public void setMcDonalds(McDonalds mcDonalds) {
		this.mcDonalds = mcDonalds;
	}
	
	private void localOLlevar() {
		if(getRbLlevar().isSelected()) {
			getMcDonalds().paraLlevar();
		}
	}
	
	protected void setVentanaPrincipal(VentanaPrincipal vp) {
		this.vp = vp;
	}
	
	protected VentanaPrincipal getVentanaPrincipal() {
		return this.vp;
	}
	
}
