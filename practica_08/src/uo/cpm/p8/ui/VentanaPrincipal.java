package uo.cpm.p8.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.io.File;
import java.awt.event.InputEvent;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JSlider;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;

import uo.cpm.p8.player.MusicPlayer;

import javax.swing.event.ChangeEvent;
import javax.swing.ListSelectionModel;

public class VentanaPrincipal extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnPlay;
	private JMenu mnOptions;
	private JMenu mnHelp;
	private JMenuItem mntmOpen;
	private JMenuItem mntmExit;
	private JMenuItem mntmNext;
	private JMenuItem mntmRandom;
	private JMenuItem mntmContents;
	private JMenuItem mntmAbout;
	private JSeparator separator;
	private JSeparator separator_1;
	private JPanel pnNorte;
	private JPanel pnCentro;
	private JLabel lbLogo;
	private JSlider slVolumen;
	private JLabel lbVol;
	private JLabel lbIndicadorVolumen;
	private JPanel pnLibrary;
	private JPanel pnPlay;
	private JLabel lbLibrary;
	private JScrollPane scListLibrary;
	private JList<File> listLibrary;
	private JPanel pnBtLibrary;
	private JButton btAdd;
	private JButton btDelLib;
	private JLabel lbPlay;
	private JScrollPane scListPlay;
	private JPanel pnBtPlay;
	private JButton btRewind;
	private JList<File> listPlay;
	private JButton btPlay;
	private JButton btStop;
	private JButton btForward;
	private JButton btDel;
	JFileChooser selector;
	private MusicPlayer mP;
	
	private DefaultListModel<File> modeloListLibrary;
	private DefaultListModel<File> modeloListPlaylist;
	private JButton btnNewButton;

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(MusicPlayer mP) {
		
		this.mP = mP;
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/logoTitulo.png")));
		setTitle("EII Music Player");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 854, 577);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnNorte(), BorderLayout.NORTH);
		contentPane.add(getPnCentro());
		setLocationRelativeTo(null);
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
			menuBar.add(getMnPlay());
			menuBar.add(getMnOptions());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}
	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.setMnemonic('F');
			mnFile.add(getMntmOpen());
			mnFile.add(getSeparator());
			mnFile.add(getMntmExit());
		}
		return mnFile;
	}
	private JMenu getMnPlay() {
		if (mnPlay == null) {
			mnPlay = new JMenu("Play");
			mnPlay.setMnemonic('P');
			mnPlay.add(getMntmNext());
		}
		return mnPlay;
	}
	private JMenu getMnOptions() {
		if (mnOptions == null) {
			mnOptions = new JMenu("Options");
			mnOptions.setMnemonic('P');
			mnOptions.add(getMntmRandom());
		}
		return mnOptions;
	}
	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.setMnemonic('H');
			mnHelp.add(getMntmContents());
			mnHelp.add(getSeparator_1());
			mnHelp.add(getMntmAbout());
		}
		return mnHelp;
	}
	private JMenuItem getMntmOpen() {
		if (mntmOpen == null) {
			mntmOpen = new JMenuItem("Open");
			mntmOpen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					abrirFicheros();
				}
			});
			mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
		}
		return mntmOpen;
	}
	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
		}
		return mntmExit;
	}
	private JMenuItem getMntmNext() {
		if (mntmNext == null) {
			mntmNext = new JMenuItem("Next");
			mntmNext.setMnemonic('N');
		}
		return mntmNext;
	}
	private JMenuItem getMntmRandom() {
		if (mntmRandom == null) {
			mntmRandom = new JMenuItem("Random");
			mntmRandom.setMnemonic('R');
		}
		return mntmRandom;
	}
	private JMenuItem getMntmContents() {
		if (mntmContents == null) {
			mntmContents = new JMenuItem("Contents");
			mntmContents.setEnabled(false);
			mntmContents.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		}
		return mntmContents;
	}
	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
		}
		return mntmAbout;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
		}
		return separator_1;
	}
	private JPanel getPnNorte() {
		if (pnNorte == null) {
			pnNorte = new JPanel();
			pnNorte.setBackground(Color.BLACK);
			pnNorte.setLayout(new GridLayout(0, 4, 0, 0));
			pnNorte.add(getLbLogo());
			pnNorte.add(getSlVolumen());
			pnNorte.add(getLbVol());
			pnNorte.add(getLbIndicadorVolumen());
		}
		return pnNorte;
	}
	private JPanel getPnCentro() {
		if (pnCentro == null) {
			pnCentro = new JPanel();
			pnCentro.setBackground(new Color(0, 0, 0));
			pnCentro.setLayout(new GridLayout(1, 2, 0, 0));
			pnCentro.add(getPnLibrary());
			pnCentro.add(getPnPlay());
		}
		return pnCentro;
	}
	private JLabel getLbLogo() {
		if (lbLogo == null) {
			lbLogo = new JLabel("");
			lbLogo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logo.png")));
		}
		return lbLogo;
	}
	private JSlider getSlVolumen() {
		if (slVolumen == null) {
			slVolumen = new JSlider();
			slVolumen.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					cambiarVolumen();
				}
			});
			slVolumen.setFont(new Font("Tahoma", Font.PLAIN, 14));
			slVolumen.setBackground(Color.BLACK);
			slVolumen.setForeground(Color.WHITE);
			slVolumen.setFocusable(false);
			slVolumen.setDoubleBuffered(true);
			slVolumen.setPaintTicks(true);
			slVolumen.setPaintLabels(true);
			slVolumen.setMinorTickSpacing(5);
			slVolumen.setMajorTickSpacing(20);
		}
		return slVolumen;
	}
	private JLabel getLbVol() {
		if (lbVol == null) {
			lbVol = new JLabel("Vol:");
			lbVol.setHorizontalAlignment(SwingConstants.RIGHT);
			lbVol.setForeground(new Color(255, 140, 0));
			lbVol.setFont(new Font("Tahoma", Font.BOLD, 32));
		}
		return lbVol;
	}
	private JLabel getLbIndicadorVolumen() {
		if (lbIndicadorVolumen == null) {
			lbIndicadorVolumen = new JLabel("50");
			lbIndicadorVolumen.setHorizontalAlignment(SwingConstants.LEFT);
			lbIndicadorVolumen.setFont(new Font("Tahoma", Font.BOLD, 40));
			lbIndicadorVolumen.setBackground(new Color(0, 0, 0));
			lbIndicadorVolumen.setForeground(new Color(255, 255, 255));
			lbIndicadorVolumen.setText(String.valueOf(getSlVolumen().getValue()));
	
			
		}
		return lbIndicadorVolumen;
	}
	private JPanel getPnLibrary() {
		if (pnLibrary == null) {
			pnLibrary = new JPanel();
			pnLibrary.setBackground(new Color(0, 0, 0));
			pnLibrary.setLayout(new BorderLayout(0, 0));
			pnLibrary.add(getLbLibrary(), BorderLayout.NORTH);
			pnLibrary.add(getScListLibrary());
			pnLibrary.add(getPnBtLibrary(), BorderLayout.SOUTH);
		}
		return pnLibrary;
	}
	private JPanel getPnPlay() {
		if (pnPlay == null) {
			pnPlay = new JPanel();
			pnPlay.setBackground(new Color(0, 0, 0));
			pnPlay.setLayout(new BorderLayout(0, 0));
			pnPlay.add(getLbPlay(), BorderLayout.NORTH);
			pnPlay.add(getScListPlay(), BorderLayout.CENTER);
			pnPlay.add(getPnBtPlay(), BorderLayout.SOUTH);
		}
		return pnPlay;
	}
	private JLabel getLbLibrary() {
		if (lbLibrary == null) {
			lbLibrary = new JLabel("Library:");
			lbLibrary.setLabelFor(getListLibrary());
			lbLibrary.setDisplayedMnemonic('L');
			lbLibrary.setBackground(new Color(0, 0, 0));
			lbLibrary.setForeground(new Color(255, 140, 0));
			lbLibrary.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbLibrary;
	}
	private JScrollPane getScListLibrary() {
		if (scListLibrary == null) {
			scListLibrary = new JScrollPane();
			scListLibrary.setBorder(new LineBorder(new Color(255, 140, 0), 3, true));
			scListLibrary.setViewportView(getListLibrary());
		}
		return scListLibrary;
	}
	private JList<File> getListLibrary() {
		if (listLibrary == null) {
			modeloListLibrary = new DefaultListModel<File>();
			listLibrary = new JList<File>(modeloListLibrary);
			listLibrary.setBackground(new Color(0, 0, 0));
		}
		return listLibrary;
	}
	private JPanel getPnBtLibrary() {
		if (pnBtLibrary == null) {
			pnBtLibrary = new JPanel();
			pnBtLibrary.setBackground(new Color(0, 0, 0));
			pnBtLibrary.setLayout(new GridLayout(1, 2, 0, 0));
			pnBtLibrary.add(getBtAdd());
			pnBtLibrary.add(getBtDelLib());
		}
		return pnBtLibrary;
	}
	private JButton getBtAdd() {
		if (btAdd == null) {
			btAdd = new JButton("Add To Playlist");
			btAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for(int i=0; i<getListLibrary().getSelectedValuesList().size(); i++) {
						modeloListPlaylist.addElement(getListLibrary().getSelectedValuesList().get(i));
					}
				}
			});
			btAdd.setFont(new Font("Tahoma", Font.BOLD, 14));
		}
		return btAdd;
	}
	private JButton getBtDelLib() {
		if (btDelLib == null) {
			btDelLib = new JButton("Delete");
			btDelLib.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					borrarDeLibreria();
				}
			});
			btDelLib.setFont(new Font("Tahoma", Font.BOLD, 14));
		}
		return btDelLib;
	}
	private JLabel getLbPlay() {
		if (lbPlay == null) {
			lbPlay = new JLabel("Playlist:");
			lbPlay.setLabelFor(getListPlay());
			lbPlay.setDisplayedMnemonic('P');
			lbPlay.setForeground(new Color(255, 140, 0));
			lbPlay.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lbPlay.setBackground(Color.BLACK);
		}
		return lbPlay;
	}
	private JScrollPane getScListPlay() {
		if (scListPlay == null) {
			scListPlay = new JScrollPane();
			scListPlay.setBorder(new LineBorder(new Color(255, 140, 0), 3, true));
			scListPlay.setViewportView(getListPlay());
		}
		return scListPlay;
	}
	private JPanel getPnBtPlay() {
		if (pnBtPlay == null) {
			pnBtPlay = new JPanel();
			pnBtPlay.setBackground(Color.BLACK);
			pnBtPlay.setLayout(new GridLayout(0, 6, 0, 0));
			pnBtPlay.add(getBtAdd_1_1());
			pnBtPlay.add(getBtAdd_1_1_1());
			pnBtPlay.add(getBtStop());
			pnBtPlay.add(getBtForward());
			pnBtPlay.add(getBtDel());
			pnBtPlay.add(getBtnNewButton());
		}
		return pnBtPlay;
	}
	private JButton getBtAdd_1_1() {
		if (btRewind == null) {
			btRewind = new JButton("\u25C4\u25C4");
			btRewind.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					previous();
				}
			});
			btRewind.setToolTipText("Rewind");
			btRewind.setFont(new Font("Tahoma", Font.BOLD, 14));
		}
		return btRewind;
	}
	
	private JFileChooser getSelector() {
		if (selector == null) {
			selector = new JFileChooser();
			selector.setMultiSelectionEnabled(true);
		}
		return selector;
	}
	
	private JList<File> getListPlay() {
		if (listPlay == null) {
			modeloListPlaylist = new DefaultListModel<File>();
			listPlay = new JList<File>(modeloListPlaylist);
			listPlay.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listPlay.setBackground(Color.BLACK);
		}
		return listPlay;
	}
	private JButton getBtAdd_1_1_1() {
		if (btPlay == null) {
			btPlay = new JButton("\u25BA");
			btPlay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					play();
				}
			});
			btPlay.setToolTipText("Play");
			btPlay.setFont(new Font("Tahoma", Font.BOLD, 14));
		}
		return btPlay;
	}
	private JButton getBtStop() {
		if (btStop == null) {
			btStop = new JButton("\u25A0");
			btStop.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					stop();
				}
			});
			btStop.setToolTipText("Stop");
			btStop.setFont(new Font("Tahoma", Font.BOLD, 14));
		}
		return btStop;
	}
	private JButton getBtForward() {
		if (btForward == null) {
			btForward = new JButton("\u25BA\u25BA");
			btForward.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					next();
				}
			});
			btForward.setToolTipText("Forward");
			btForward.setFont(new Font("Tahoma", Font.BOLD, 14));
		}
		return btForward;
	}
	private JButton getBtDel() {
		if (btDel == null) {
			btDel = new JButton("Del");
			btDel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					borrarSeleccionado();
				}
			});
			btDel.setFont(new Font("Tahoma", Font.BOLD, 14));
		}
		return btDel;
	}
	
	private void cambiarVolumen() {
		getLbIndicadorVolumen().setText(String.valueOf(getSlVolumen().getValue()));
		setVolume(getSlVolumen().getValue());
	}
	
	private void setVolume(double vol) {
		double volMax = getSlVolumen().getMaximum();
		mP.setVolume(vol, volMax);
	}
	
	private void abrirFicheros() {
		int resp = getSelector().showOpenDialog(null);
		if(resp == JFileChooser.APPROVE_OPTION) {
			for(int i=0; i<getSelector().getSelectedFiles().length; i++) {
				if(!(modeloListLibrary.contains(getSelector().getSelectedFiles()[i]))) {
					modeloListLibrary.addElement(getSelector().getSelectedFiles()[i]);
				}
			}
		}
	}
	
	private void play() {
		if(getListPlay().getSelectedIndex() == -1) {
			getListPlay().setSelectedIndex(0);
		}
		
		mP.play(getListPlay().getSelectedValue());
	}
	
	private void stop() {
		mP.stop();
	}
	
	private void next() {
		if(getListPlay().getSelectedIndex() < modeloListPlaylist.size()-1) {
			getListPlay().setSelectedIndex(getListPlay().getSelectedIndex()+1);
		} else {
			getListPlay().setSelectedIndex(0);
		}
		mP.play(getListPlay().getSelectedValue());
	}
	
	private void previous() {
		if(getListPlay().getSelectedIndex() != 0) {
			getListPlay().setSelectedIndex(getListPlay().getSelectedIndex()-1);
		} else {
			getListPlay().setSelectedIndex(modeloListPlaylist.size()-1);
		}
		mP.play(getListPlay().getSelectedValue());
	}
	
	@SuppressWarnings("unlikely-arg-type")
	private void borrarSeleccionado() {
		stop();
		if(mP.getCancionSonando() != null && mP.getCancionSonando().equals(modeloListPlaylist.get(getListPlay().getSelectedIndex()))) {
			stop();
			modeloListPlaylist.remove(getListPlay().getSelectedIndex());
		} else {
			modeloListPlaylist.remove(getListPlay().getSelectedIndex());
		}
	}
	
	@SuppressWarnings("unlikely-arg-type")
	private void borrarDeLibreria() {
		if(mP.getCancionSonando() != null && mP.getCancionSonando().equals(modeloListLibrary.get(getListPlay().getSelectedIndex()))) {
			stop();
			modeloListLibrary.remove(getListLibrary().getSelectedIndex());
			buscarCancionPlaylist(modeloListLibrary.get(getListLibrary().getSelectedIndex()));
		} else {
			modeloListLibrary.remove(getListLibrary().getSelectedIndex());
		}
	}
	
	private void buscarCancionPlaylist(File archivo) {
		for(int i=0; i < modeloListPlaylist.getSize(); i++) {
			if(modeloListPlaylist.get(i).equals(archivo)) {
				getListPlay().remove(i);
			}
		}
	}
	
	private void clear() {
		stop();
		// mP.setCancionSonando(null);
		modeloListPlaylist.clear();
	}
	
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Clear");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					clear();
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		}
		return btnNewButton;
	}
}
