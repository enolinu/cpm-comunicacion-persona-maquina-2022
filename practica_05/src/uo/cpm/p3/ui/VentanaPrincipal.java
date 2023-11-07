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
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.GridLayout;

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
	private JLabel lbImagenArticulo;
	private JMenuBar menuBar;
	private JMenu mnPedido;
	private JMenu mnAyuda;
	private JMenuItem mniNuevo;
	private JMenuItem mniSalir;
	private JSeparator separatorPedido;
	private JMenuItem mniContenidos;
	private JMenuItem mniAcercaDe;
	private JSeparator separatorAyuda;
	private JPanel panelFiltro;
	private JButton BtPostres;
	private JButton btTodos;
	private JButton btHamburgesas;
	private JButton btBebidas;
	private JButton btComplementos;

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(McDonalds mcDonalds) {
		this.mcDonalds = mcDonalds;
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/logo.png")));
		setResizable(false);
		setTitle("McDonald's Espa\u00F1a");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 974, 581);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanelCarrito());
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
		contentPane.add(getLbOferta());
		contentPane.add(getBtnEliminar());
		contentPane.add(getBtnPedido());
		contentPane.add(getLbImagenArticulo());
		contentPane.add(getPanelFiltro());
		
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
					mostrarImagenArticulo();
					
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
				}
			});
			btnSiguiente.setForeground(Color.WHITE);
			btnSiguiente.setFont(new Font("Arial", Font.PLAIN, 14));
			btnSiguiente.setBackground(new Color(0, 128, 0));
			btnSiguiente.setBounds(547, 478, 112, 33);
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
			btnCancelar.setBounds(679, 478, 112, 33);
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
			VentanaRegistro vr = new VentanaRegistro(mcDonalds);
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
	public void inicializar()  {
			
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
	
	public McDonalds getMcDonalds() {
		return this.mcDonalds;
	}
	private JTextArea getAreaCarrito() {
		if (areaCarrito == null) {
			areaCarrito = new JTextArea();
			areaCarrito.setBounds(0, 0, 263, 203);
			areaCarrito.setWrapStyleWord(true);
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
			cadena = cadena + a.mostrarArticulo() +"\n";
		}
		return cadena;
	}
	private JPanel getPanelCarrito() {
		if (panelCarrito == null) {
			panelCarrito = new JPanel();
			panelCarrito.setBorder(null);
			panelCarrito.setBackground(Color.WHITE);
			panelCarrito.setBounds(547, 54, 263, 203);
			panelCarrito.setLayout(null);
			panelCarrito.add(getAreaCarrito());
		}
		return panelCarrito;
	}
	private JLabel getLbOferta() {
		if (lbOferta == null) {
			lbOferta = new JLabel("");
			lbOferta.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/ofertaHappy.png")));
			lbOferta.setBounds(489, 30, 202, 139);
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
				public void mousePressed(MouseEvent e) {
					mostrarCarrito(true);
				}
				
				@Override
				public void mouseReleased(MouseEvent e) {
					mostrarCarrito(false);
				}
			});
			btnPedido.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/pedido.png")));
			btnPedido.setBackground(Color.WHITE);
			btnPedido.setBounds(675, 11, 132, 45);
		}
		return btnPedido;
	}
	
	private void mostrarCarrito(boolean valor) {
			getPanelCarrito().setVisible(valor);	
	}
	private JLabel getLbImagenArticulo() {
		if (lbImagenArticulo == null) {
			lbImagenArticulo = new JLabel("");
			lbImagenArticulo.setHorizontalAlignment(SwingConstants.CENTER);
			lbImagenArticulo.setBounds(25, 301, 443, 160);
			mostrarImagenArticulo();
		}
		return lbImagenArticulo;
	}
	
	private void mostrarImagenArticulo() {
		String fotoArticulo = "/img/"+((Articulo)getCbArticulo().getSelectedItem()).getCodigo()+".png";
		getLbImagenArticulo().setIcon(new ImageIcon(VentanaPrincipal.class.getResource(fotoArticulo)));
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setBackground(Color.WHITE);
			menuBar.add(getMnPedido());
			menuBar.add(getMnAyuda());
		}
		return menuBar;
	}
	private JMenu getMnPedido() {
		if (mnPedido == null) {
			mnPedido = new JMenu("Pedido");
			mnPedido.setMnemonic('P');
			mnPedido.add(getMenuItem_1());
			mnPedido.add(getSeparatorPedido());
			mnPedido.add(getMenuItem_2());
		}
		return mnPedido;
	}
	private JMenu getMnAyuda() {
		if (mnAyuda == null) {
			mnAyuda = new JMenu("Ayuda");
			mnAyuda.setMnemonic('Y');
			mnAyuda.add(getMniContenidos());
			mnAyuda.add(getSeparatorAyuda());
			mnAyuda.add(getMniAcercaDe());
		}
		return mnAyuda;
	}
	private JMenuItem getMenuItem_1() {
		if (mniNuevo == null) {
			mniNuevo = new JMenuItem("Nuevo");
			mniNuevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inicializar();
				}
			});
			mniNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
		}
		return mniNuevo;
	}
	private JMenuItem getMenuItem_2() {
		if (mniSalir == null) {
			mniSalir = new JMenuItem("Salir");
			mniSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return mniSalir;
	}
	private JSeparator getSeparatorPedido() {
		if (separatorPedido == null) {
			separatorPedido = new JSeparator();
		}
		return separatorPedido;
	}
	private JMenuItem getMniContenidos() {
		if (mniContenidos == null) {
			mniContenidos = new JMenuItem("Contenidos");
			mniContenidos.setEnabled(false);
		}
		return mniContenidos;
	}
	private JMenuItem getMniAcercaDe() {
		if (mniAcercaDe == null) {
			mniAcercaDe = new JMenuItem("Acerca de McDonalds Espa\u00F1a");
			mniAcercaDe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
			mniAcercaDe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearVentanaAcercaDe();
				}
			});
		}
		return mniAcercaDe;
	}
	private JSeparator getSeparatorAyuda() {
		if (separatorAyuda == null) {
			separatorAyuda = new JSeparator();
		}
		return separatorAyuda;
	}
	private JPanel getPanelFiltro() {
		if (panelFiltro == null) {
			panelFiltro = new JPanel();
			panelFiltro.setBackground(Color.WHITE);
			panelFiltro.setBounds(827, 11, 120, 500);
			panelFiltro.setLayout(new GridLayout(5, 1, 0, 0));
			panelFiltro.add(getBtTodos());
			panelFiltro.add(getBtHamburgesas());
			panelFiltro.add(getBtBebidas());
			panelFiltro.add(getBtComplementos());
			panelFiltro.add(getBtPostres());
		}
		return panelFiltro;
	}
	private JButton getBtPostres() {
		if (BtPostres == null) {
			BtPostres = new JButton("Postres");
			BtPostres.setMnemonic('P');
			BtPostres.setBackground(Color.WHITE);
			BtPostres.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) {
					cbArticulo.setModel(new DefaultComboBoxModel<Articulo>(mcDonalds.filtrar('p')));
					mostrarImagenArticulo();
				}
			});
			BtPostres.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Postre.png")));
			BtPostres.setVerticalAlignment(SwingConstants.TOP);
			BtPostres.setVerticalAlignment(SwingConstants.TOP);
			BtPostres.setVerticalTextPosition(SwingConstants.BOTTOM);
			BtPostres.setHorizontalTextPosition(SwingConstants.CENTER);
			BtPostres.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/todos.png")));
		}
		return BtPostres;
	}
	private JButton getBtTodos() {
		if (btTodos == null) {
			btTodos = new JButton("Todos");
			btTodos.setMnemonic('T');
			btTodos.setBackground(Color.WHITE);
			btTodos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cbArticulo.setModel(new DefaultComboBoxModel<Articulo>(mcDonalds.getArticulosCarta()));
					mostrarImagenArticulo();
				}
			});
			btTodos.setVerticalAlignment(SwingConstants.TOP);
			btTodos.setVerticalTextPosition(SwingConstants.BOTTOM);
			btTodos.setHorizontalTextPosition(SwingConstants.CENTER);
			btTodos.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/todos.png")));
		}
		return btTodos;
	}
	private JButton getBtHamburgesas() {
		if (btHamburgesas == null) {
			btHamburgesas = new JButton("Hamburguesas");
			btHamburgesas.setMnemonic('H');
			btHamburgesas.setBackground(Color.WHITE);
			btHamburgesas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cbArticulo.setModel(new DefaultComboBoxModel<Articulo>(mcDonalds.filtrar('h')));
					mostrarImagenArticulo();
				}
			});
			btHamburgesas.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Hamburguesa.png")));
			btHamburgesas.setVerticalAlignment(SwingConstants.TOP);
			btHamburgesas.setVerticalTextPosition(SwingConstants.BOTTOM);
			btHamburgesas.setHorizontalTextPosition(SwingConstants.CENTER);
		}
		return btHamburgesas;
	}
	private JButton getBtBebidas() {
		if (btBebidas == null) {
			btBebidas = new JButton("Bebidas");
			btBebidas.setMnemonic('B');
			btBebidas.setBackground(Color.WHITE);
			btBebidas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cbArticulo.setModel(new DefaultComboBoxModel<Articulo>(mcDonalds.filtrar('b')));
					mostrarImagenArticulo();
				}
			});
			btBebidas.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Bebida.png")));
			btBebidas.setVerticalAlignment(SwingConstants.TOP);
			btBebidas.setVerticalTextPosition(SwingConstants.BOTTOM);
			btBebidas.setHorizontalTextPosition(SwingConstants.CENTER);
		}
		return btBebidas;
	}
	private JButton getBtComplementos() {
		if (btComplementos == null) {
			btComplementos = new JButton("Complementos");
			btComplementos.setMnemonic('C');
			btComplementos.setBackground(Color.WHITE);
			btComplementos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cbArticulo.setModel(new DefaultComboBoxModel<Articulo>(mcDonalds.filtrar('c')));
					mostrarImagenArticulo();
				}
			});
			btComplementos.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Complemento.png")));
			btComplementos.setVerticalAlignment(SwingConstants.TOP);
			btComplementos.setVerticalTextPosition(SwingConstants.BOTTOM);
			btComplementos.setHorizontalTextPosition(SwingConstants.CENTER);
		}
		return btComplementos;
	}
	
	private void crearVentanaAcercaDe() {
		try {
			AcercaDe ventanaAd = new AcercaDe();
			ventanaAd.setVisible(true);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
