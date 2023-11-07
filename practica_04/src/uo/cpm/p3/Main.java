package uo.cpm.p3;

import java.awt.EventQueue;

import javax.swing.UIManager;

import uo.cpm.p3.service.McDonalds;
import uo.cpm.p3.ui.VentanaPrincipal;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		McDonalds mcDonalds = new McDonalds();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					VentanaPrincipal frame = new VentanaPrincipal(mcDonalds);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
