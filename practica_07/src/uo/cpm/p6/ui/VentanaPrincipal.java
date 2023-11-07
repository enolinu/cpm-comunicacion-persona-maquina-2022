package uo.cpm.p6.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;

import uo.cpm.p6.game.Juego.Nivel;
import uo.cpm.p6.service.SpaceInvaders;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;

public class VentanaPrincipal extends JFrame {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelPrincipal;
	private JButton botonDado;
	private JLabel labelRotuloPuntos;
	private JPanel panelDisparos;
	private JLabel labelPuntos;
	private JLabel labelTierra;
	private JLabel labelNave;
	private JPanel panelTablero;
	private JButton bt0;
	private JButton bt1;
	private JButton bt2;
	private JButton bt3;
	private JButton bt4;
	private JButton bt5;
	private JButton bt6;
	private JButton bt7;
	
	private ProcesaAccionBoton pab = new ProcesaAccionBoton();
	
	private SpaceInvaders spaceInvaders;
	private JMenuBar menu;
	private JMenu mnJuego;
	private JMenu mnAyuda;
	private JMenuItem mniReiniciar;
	private JMenuItem mniPausar;
	private JSeparator separator;
	private JMenuItem btnSalir;
	private JMenuItem mniContenidos;
	private JSeparator separator_1;
	private JMenuItem mniAcercaDe;
	private JMenu mnNewMenu;
	private JRadioButtonMenuItem mrbNivelDificil;
	private JRadioButtonMenuItem mrbIntermedio;
	private JRadioButtonMenuItem mrbFacil;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(SpaceInvaders spaceInvaders) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				salir();
			}
		});
		
		this.spaceInvaders = spaceInvaders;
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/invader.jpg")));
		setTitle("Invasores Del Espacio");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1080, 419);
		setJMenuBar(getMenuBar_1());
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(Color.BLACK);
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);
		panelPrincipal.add(getBotonDado());
		panelPrincipal.add(getLabelRotuloPuntos());
		panelPrincipal.add(getPanelDisparos());
		panelPrincipal.add(getLabelPuntos());
		panelPrincipal.add(getLabelTierra());
		panelPrincipal.add(getLabelNave());
		panelPrincipal.add(getPanelTablero());
		
		setLocationRelativeTo(null);
		
	}
	private JButton getBotonDado() {
		if (botonDado == null) {
			botonDado = new JButton("");
			botonDado.setDisabledIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/dice.jpg")));
			botonDado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					funcionDado();
				}
			});
			botonDado.setToolTipText("Haz clic para obtener el n\u00FAmero de disparos!");
			botonDado.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/dice.jpg")));
			botonDado.setBorderPainted(false);
			botonDado.setBounds(10, 12, 108, 111);
			botonDado.setFocusPainted(false);
		}
		return botonDado;
	}
	private JLabel getLabelRotuloPuntos() {
		if (labelRotuloPuntos == null) {
			labelRotuloPuntos = new JLabel("Puntos");
			labelRotuloPuntos.setFont(new Font("Segoe Script", Font.BOLD, 16));
			labelRotuloPuntos.setForeground(Color.WHITE);
			labelRotuloPuntos.setBounds(735, 35, 66, 26);
		}
		return labelRotuloPuntos;
	}
	private JPanel getPanelDisparos() {
		if (panelDisparos == null) {
			panelDisparos = new JPanel();
			panelDisparos.setBackground(new Color(0, 0, 0));
			panelDisparos.setBounds(265, 134, 490, 80);
			panelDisparos.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		}
		return panelDisparos;
	}
	private JLabel getLabelPuntos() {
		if (labelPuntos == null) {
			labelPuntos = new JLabel("");
			labelPuntos.setHorizontalAlignment(SwingConstants.CENTER);
			labelPuntos.setForeground(Color.GREEN);
			labelPuntos.setFont(new Font("Source Code Pro", Font.BOLD, 28));
			labelPuntos.setBounds(709, 60, 113, 35);
			
			labelPuntos.setText(String.valueOf(getSpaceInvaders().getPuntuacion()));
		}
		return labelPuntos;
	}
	private JLabel getLabelTierra() {
		if (labelTierra == null) {
			labelTierra = new JLabel("");
			labelTierra.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/earth.jpg")));
			labelTierra.setBounds(872, 12, 182, 196);
		}
		return labelTierra;
	}
	private JLabel getLabelNave() {
		if (labelNave == null) {
			labelNave = new JLabel("");
			labelNave.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/spaceship.png")));
			labelNave.setBounds(440, 12, 142, 111);
		}
		return labelNave;
	}
	private JPanel getPanelTablero() {
		if (panelTablero == null) {
			panelTablero = new JPanel();
			panelTablero.setBorder(new LineBorder(new Color(0, 204, 0), 5));
			panelTablero.setBackground(new Color(0, 204, 0));
			panelTablero.setBounds(160, 235, 700, 100);
			panelTablero.setLayout(new GridLayout(0, 8, 4, 4));
			panelTablero.add(getBt0());
			panelTablero.add(getBt1());
			panelTablero.add(getBt2());
			panelTablero.add(getBt3());
			panelTablero.add(getBt4());
			panelTablero.add(getBt5());
			panelTablero.add(getBt6());
			panelTablero.add(getBt7());
			
			habilitaTablero(false);
		}
		return panelTablero;
	}
	private JButton getBt0() {
		if (bt0 == null) {
			bt0 = new JButton("");
			bt0.setActionCommand("0");
			bt0.setBorderPainted(false);
			bt0.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispara(0);
				}
			});
			bt0.setBackground(new Color(0, 0, 0));
		}
		return bt0;
	}
	private JButton getBt1() {
		if (bt1 == null) {
			bt1 = new JButton("");
			bt1.setActionCommand("1");
			bt1.setBorderPainted(false);
			bt1.addActionListener(pab);
			bt1.setBackground(new Color(0, 0, 0));
		}
		return bt1;
	}
	private JButton getBt2() {
		if (bt2 == null) {
			bt2 = new JButton("");
			bt2.setActionCommand("2");
			bt2.setBorderPainted(false);
			bt2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispara(2);
				}
			});
			bt2.setBackground(new Color(0, 0, 0));
		}
		return bt2;
	}
	private JButton getBt3() {
		if (bt3 == null) {
			bt3 = new JButton("");
			bt3.setActionCommand("3");
			bt3.setBorderPainted(false);
			bt3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispara(3);
				}
			});
			bt3.setBackground(new Color(0, 0, 0));
		}
		return bt3;
	}
	private JButton getBt4() {
		if (bt4 == null) {
			bt4 = new JButton("");
			bt4.setActionCommand("4");
			bt4.setBorderPainted(false);
			bt4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispara(4);
				}
			});
			bt4.setBackground(new Color(0, 0, 0));
		}
		return bt4;
	}
	private JButton getBt5() {
		if (bt5 == null) {
			bt5 = new JButton("");
			bt5.setActionCommand("5");
			bt5.setBorderPainted(false);
			bt5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispara(5);
				}
			});
			bt5.setBackground(new Color(0, 0, 0));
		}
		return bt5;
	}
	private JButton getBt6() {
		if (bt6 == null) {
			bt6 = new JButton("");
			bt6.setActionCommand("6");
			bt6.setBorderPainted(false);
			bt6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispara(6);
				}
			});
			bt6.setBackground(new Color(0, 0, 0));
		}
		return bt6;
	}
	private JButton getBt7() {
		if (bt7 == null) {
			bt7 = new JButton("");
			bt7.setActionCommand("7");
			bt7.setBorderPainted(false);
			bt7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispara(7);
				}
			});
			bt7.setBackground(new Color(0, 0, 0));
		}
		return bt7;
	}
	public SpaceInvaders getSpaceInvaders() {
		return this.spaceInvaders;
	}
	
	// Deshabilitar o habilitar los botones del tablero.
	private void habilitaTablero(boolean estado) {
		for(int i=0; i < getPanelTablero().getComponents().length; i++) {
			getPanelTablero().getComponents()[i].setEnabled(estado);
		}
	}
	
	private void funcionDado() {
		spaceInvaders.lanzarDado();
		pintarDisparo();
		getBotonDado().setEnabled(false);
		habilitaTablero(true);
	}
	
	private void pintarDisparo() {
		for(int i=0; i<spaceInvaders.getDisparos(); i++) {
			getPanelDisparos().add(nuevoDisparo());
		}
		
		// Para que se muestre.
		validate();
	}
	
	private JLabel nuevoDisparo() {
		JLabel labelDisparo = new JLabel("");
		labelDisparo.setBorder(new LineBorder(new Color(0, 204, 0), 1));
		labelDisparo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/shoot.png")));
		
		return labelDisparo;
	}
	private void dispara(int indice) {
		spaceInvaders.dipara(indice);
		representaSpaceInvaders(indice);
	}
	
	private void representaSpaceInvaders(int indice) {
		pintaPuntos();
		despintaDisparo();
		pintaCasilla(indice);
		compruebaFin();
		deshabilitaBoton(indice);
		
	}
	private void despintaDisparo() {
		getPanelDisparos().remove(0);
		getPanelDisparos().repaint();
		
	}
	private void deshabilitaBoton(int indice) {
		((JButton) getPanelTablero().getComponent(indice)).setEnabled(false);
		
	}
	private void compruebaFin() {
		if (spaceInvaders.isPartidaFinalizada()) {
			habilitaTablero(false);
			descubrirTablero();
			JOptionPane.showMessageDialog(this, spaceInvaders.obtenerMensaje(), "Invasión espacial",
					JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	private void pintaCasilla(int indice) {
		ImageIcon imagen = new ImageIcon(VentanaPrincipal.class.getResource(spaceInvaders.obtenerImagen(indice)));
		((JButton) getPanelTablero().getComponent(indice)).setIcon(imagen);
		((JButton) getPanelTablero().getComponent(indice)).setDisabledIcon(imagen);
		
	}
	private void pintaPuntos() {
		getLabelPuntos().setText(String.valueOf(spaceInvaders.getPuntuacion()));
		
	}
	private JMenuBar getMenuBar_1() {
		if (menu == null) {
			menu = new JMenuBar();
			menu.setBackground(Color.BLACK);
			menu.add(getMnJuego());
			menu.add(getMnNewMenu());
			menu.add(getMnAyuda());
		}
		return menu;
	}
	private JMenu getMnJuego() {
		if (mnJuego == null) {
			mnJuego = new JMenu("Juego");
			mnJuego.add(getMniReiniciar());
			mnJuego.add(getMniPausar());
			mnJuego.add(getSeparator());
			mnJuego.add(getBtnSalir());
		}
		return mnJuego;
	}
	private JMenu getMnAyuda() {
		if (mnAyuda == null) {
			mnAyuda = new JMenu("Ayuda");
			mnAyuda.add(getMniContenidos());
			mnAyuda.add(getSeparator_1());
			mnAyuda.add(getMniAcercaDe());
		}
		return mnAyuda;
	}
	private JMenuItem getMniReiniciar() {
		if (mniReiniciar == null) {
			mniReiniciar = new JMenuItem("Reiniciar");
			mniReiniciar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}
		return mniReiniciar;
	}
	private JMenuItem getMniPausar() {
		if (mniPausar == null) {
			mniPausar = new JMenuItem("Pausar");
		}
		return mniPausar;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}
	private JMenuItem getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JMenuItem("Salir");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					salir();
				}
			});
		}
		return btnSalir;
	}
	private JMenuItem getMniContenidos() {
		if (mniContenidos == null) {
			mniContenidos = new JMenuItem("Contenidos");
			mniContenidos.setEnabled(false);
		}
		return mniContenidos;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
		}
		return separator_1;
	}
	private JMenuItem getMniAcercaDe() {
		if (mniAcercaDe == null) {
			mniAcercaDe = new JMenuItem("Acerca De");
		}
		return mniAcercaDe;
	}
	
	private void descubrirTablero() {
		for(int i=0; i<getPanelTablero().getComponentCount(); i++) {
			pintaCasilla(i);
		}
	}
	
	private void salir() {
		if(confirmarSalir()) {
			System.exit(0);
		}
	}
	private boolean confirmarSalir() {
		boolean confirmacion = false;
		int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro que desea salir de la aplicación?)");
		if(respuesta == JOptionPane.YES_OPTION) {
			confirmacion = true;
		}
		return confirmacion;
	}
	
	public class ProcesaAccionBoton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton botonPulsado = (JButton)e.getSource();
			dispara(Integer.parseInt(botonPulsado.getActionCommand()));
			
		}
		
	}
	private JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("Nivel");
			mnNewMenu.add(getMrbFacil());
			mnNewMenu.add(getMrbIntermedio());
			mnNewMenu.add(getMrbNivelDificil());
		}
		return mnNewMenu;
	}
	private JRadioButtonMenuItem getMrbNivelDificil() {
		if (mrbNivelDificil == null) {
			mrbNivelDificil = new JRadioButtonMenuItem("Dificil");
			mrbNivelDificil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inicializar(Nivel.DIFICIL);
				}
			});
			buttonGroup.add(mrbNivelDificil);
		}
		return mrbNivelDificil;
	}
	private JRadioButtonMenuItem getMrbIntermedio() {
		if (mrbIntermedio == null) {
			mrbIntermedio = new JRadioButtonMenuItem("Intermedio");
			mrbIntermedio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inicializar(Nivel.INTERMEDIO);
				}
			});
			mrbIntermedio.setSelected(true);
			buttonGroup.add(mrbIntermedio);
		}
		return mrbIntermedio;
	}
	private JRadioButtonMenuItem getMrbFacil() {
		if (mrbFacil == null) {
			mrbFacil = new JRadioButtonMenuItem("Facil");
			mrbFacil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inicializar(Nivel.FACIL);
				}
			});
			buttonGroup.add(mrbFacil);
		}
		return mrbFacil;
	}
	
	private void inicializar(Nivel nivel) {
		spaceInvaders.inicializar(nivel);
		getBotonDado().setEnabled(true);
		eliminaDisparos();
		pintaPuntos();
		
	}
	
	private void eliminaDisparos() {
		getPanelDisparos().removeAll();
		repaint();
	}
	
	private void redimensionarTablero(int ancho, int x) {
		getPanelTablero().setBounds(x, 208, ancho, 98);
		getPanelTablero().setLayout(new GridLayout(1,spaceInvaders.getDimension(), 4, 0));
		getPanelTablero().removeAll();
		
		for(int i=0; i<spaceInvaders.getDimension(); i++) {
			getPanelTablero().add(nuevoBoton(i));
		}
	}
	private JButton nuevoBoton(int i) {
		JButton bt = new JButton("");
		bt.setActionCommand(String.valueOf(i));
		bt.setBackground(Color.BLACK);
		bt.addActionListener(pab);
		return bt;
	}
	
	private void reiniciar(Nivel nivel) {
		spaceInvaders = new SpaceInvaders();
		inicializar(nivel);
	}
}