package principal;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import poo.gui.JFLogin;

public class Principal {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel.class");
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JFLogin a = new JFLogin();
		a.setVisible(true);
	}
}
