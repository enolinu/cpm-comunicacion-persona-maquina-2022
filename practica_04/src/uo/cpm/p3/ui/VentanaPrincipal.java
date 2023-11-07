package uo.cpm.p3.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import uo.cpm.p3.model.Articulo;
import uo.cpm.p3.service.McDonalds;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
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
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lbLogo;
	private JComboBox<Articulo> cbArticulo;
	private JTextField tfPrecio;
	private JSpinner spUnidades;
	private JButton btnAnadir;
	private JButton btnSiguiente;
	private JButton btnCancelar;
	private JLabel lbArticulo;
	private JLabel lbUnidades;
	private JLabel lbPrecio;
	McDonalds mcDonalds;
	private JTextArea areaCarrito;
	private JPanel panelCarrito;
	private JLabel lbOferta;
	private JButton btnEliminar;
	private JButton btnPedido;

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(McDonalds mcDonalds) {
		this.mcDonalds = mcDonalds;
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/logo.png")));
		setResizable(false);
		setTitle("McDonald's Espa\u00F1a");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 839, 562);
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
		contentPane.add(getPanelCarrito());
		contentPane.add(getLbOferta());
		contentPane.add(getBtnEliminar());
		contentPane.add(getBtnPedido());
		
		// Centrar ventana.
		setLocationRelativeTo(null);
		
		getPanelCarrito().setVisible(false);
		     
	}

	private JLabel getLbLogo() {
		if (lbLogo == null) {
			lbLogo = new JLabel(" McDonald's");
			lbLogo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logo.png")));
			lbLogo.setFont(new Font("Arial Black", Font.PLAIN, 44));
			lbLogo.setBounds(25, 30, 454, 139);
		}
		return lbLogo;
	}
	private JComboBox<Articulo> getCbArticulo() {
		if (cbArticulo == null) {
			cbArticulo = new JComboBox<>();
			cbArticulo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for(Articulo a: mcDonalds.getListaPedido()) {
						if(a.equals(cbArticulo.getSelectedItem())) {
							getBtnEliminar().setEnabled(true);
							break;
						} else {
							getBtnEliminar().setEnabled(false);
						}
					}
				}
			});
			cbArticulo.setModel(new DefaultComboBoxModel<Articulo>(mcDonalds.getArticulosCarta()));
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
					anadirAPedido();
					anadirALista();
					mostrarOferta();
					getSpUnidades().setValue(1);
					
				}
			});
			btnAnadir.setForeground(new Color(255, 255, 255));
			btnAnadir.setBackground(new Color(0, 128, 0));
			btnAnadir.setFont(new Font("Arial", Font.PLAIN, 14));
			btnAnadir.setBounds(595, 227, 89, 33);
		}
		return btnAnadir;
	}
	private JButton getBtnSiguiente() {
		if (btnSiguiente == null) {
			btnSiguiente = new JButton("Siguiente");
			btnSiguiente.setEnabled(false);
			btnSiguiente.setMnemonic('S');
			btnSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Creamos la ventana de registro.
					crearVentanaRegistro();
					grabarPedido();
				}
			});
			btnSiguiente.setForeground(Color.WHITE);
			btnSiguiente.setFont(new Font("Arial", Font.PLAIN, 14));
			btnSiguiente.setBackground(new Color(0, 128, 0));
			btnSiguiente.setBounds(547, 479, 112, 33);
		}
		return btnSiguiente;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setMnemonic('C');
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inicializar();
				}
			});
			btnCancelar.setForeground(Color.WHITE);
			btnCancelar.setFont(new Font("Arial", Font.PLAIN, 14));
			btnCancelar.setBackground(Color.RED);
			btnCancelar.setBounds(679, 479, 112, 33);
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
			lbPrecio.setBounds(497, 284, 226, 23);
		}
		return lbPrecio;
	}
	
	// Método que creará y hará visible la ventana de registro cuando proceda.
	private void crearVentanaRegistro() {
		try {
			VentanaRegistro vr = new VentanaRegistro();
			vr.setVentanaPrincipal(this);
			
			vr.setMcDonalds(getMcDonalds());
			vr.setModal(true);
			vr.setVisible(true);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Método que añade a pedido.
	private void anadirAPedido() {
		Articulo articuloSeleccionado = (Articulo)getCbArticulo().getSelectedItem();
		int unidadesSeleccionadas = (int)getSpUnidades().getValue();
		mcDonalds.añadirAPedido(articuloSeleccionado, unidadesSeleccionadas);
		String precio = String.format("%.2f", mcDonalds.getTotalPedido());
		getTfPrecio().setText(precio+"€");
		getBtnSiguiente().setEnabled(true);
	}
	
	// Limpia memoria e interfaz para el siguiente usuario.
	void inicializar()  {
			
		// Inicializamos datos del modelo.
		this.mcDonalds.inicializarPedido();
		
		//Inicializamos componentes visuales.
		getCbArticulo().setSelectedIndex(0);
		getSpUnidades().setValue(1);
		getTfPrecio().setText("");
		getAreaCarrito().setText("");
		getBtnSiguiente().setEnabled(false);
		getLbPrecio().setText("Precio Pedido");
	}
	
	private void grabarPedido() {
		mcDonalds.grabarPedido();
	}
	
	public McDonalds getMcDonalds() {
		return this.mcDonalds;
	}
	private JTextArea getAreaCarrito() {
		if (areaCarrito == null) {
			areaCarrito = new JTextArea();
			areaCarrito.setWrapStyleWord(true);
			areaCarrito.setBounds(10, 11, 423, 168);
			areaCarrito.setLineWrap(true);
			areaCarrito.setFont(new Font("Arial", Font.PLAIN, 13));
			areaCarrito.setEditable(false);
		}
		return areaCarrito;
	}
	
	private void anadirALista() {
		getAreaCarrito().setText(getCadenaPedido());
	}
	
	private String getCadenaPedido() {
		String cadena = "";
		for(Articulo a: mcDonalds.getListaPedido()) {
			cadena = cadena + a +"\n";
		}
		return cadena;
	}
	private JPanel getPanelCarrito() {
		if (panelCarrito == null) {
			panelCarrito = new JPanel();
			panelCarrito.setBorder(null);
			panelCarrito.setBackground(Color.WHITE);
			panelCarrito.setBounds(25, 322, 443, 190);
			panelCarrito.setLayout(null);
			panelCarrito.add(getAreaCarrito());
		}
		return panelCarrito;
	}
	private JLabel getLbOferta() {
		if (lbOferta == null) {
			lbOferta = new JLabel("");
			lbOferta.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/ofertaHappy.png")));
			lbOferta.setBounds(547, 30, 202, 139);
		}
		return lbOferta;
	}
	
	private void mostrarOferta() {
		if(mcDonalds.getTotalPedido() >= 60) {
			getLbPrecio().setText("Precio Pedido (Con descuento)");
		}
	}
	private JButton getBtnEliminar() {
		if (btnEliminar == null) {
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					eliminarUnidades();
					anadirALista();
				}
			});
			btnEliminar.setForeground(Color.WHITE);
			btnEliminar.setBackground(Color.RED);
			btnEliminar.setFont(new Font("Arial", Font.PLAIN, 14));
			btnEliminar.setBounds(702, 227, 89, 33);
		}
		return btnEliminar;
	}
	
	private void eliminarUnidades() {
		int unidadesAEliminar = (int) getSpUnidades().getValue();
		Articulo articuloAEliminar = (Articulo) getCbArticulo().getSelectedItem();
		mcDonalds.eliminarUnidades(articuloAEliminar, unidadesAEliminar);
		if(mcDonalds.getTotalPedido() == 0) {
			getTfPrecio().setText(String.valueOf(""));
			getBtnSiguiente().setEnabled(false);
		} else {
			getTfPrecio().setText(String.valueOf(mcDonalds.getTotalPedido())+"€");
		}
	}
	private JButton getBtnPedido() {
		if (btnPedido == null) {
			btnPedido = new JButton("");
			btnPedido.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					mostrarPedido(true);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					mostrarPedido(false);
				}
			});
			btnPedido.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/pedido.png")));
			btnPedido.setBackground(Color.WHITE);
			btnPedido.setBounds(35, 276, 132, 45);
		}
		return btnPedido;
	}
	
	private void mostrarPedido(boolean valor) {
			getPanelCarrito().setVisible(valor);	
	}
}
