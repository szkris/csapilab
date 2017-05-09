package main.java;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Menu extends JLayeredPane {

	private static int BUTTON_WIDTH = 80;
	private static int BUTTON_HEIGHT = 50;
	private static int BUTTON_PADDING = 20;
	
	public Menu() {
		JButton newGameButton = new JButton("Új játék");
		JButton exitButton = new JButton("Kilépés");
			
		newGameButton.addActionListener(new newGameButtonActionListener());
		exitButton.addActionListener(new exitButtonActionListener());
		
		JLabel background = new JLabel();
		background.setIcon(new ImageIcon(new ImageIcon(App.cl.getResource("img/menu_background.png")).getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT)));
		background.setBounds(0, 0, App.WIDTH, App.HEIGHT);
		
		newGameButton.setBounds(App.WIDTH/2-BUTTON_WIDTH/2, App.HEIGHT/2-BUTTON_HEIGHT-BUTTON_PADDING, BUTTON_WIDTH, BUTTON_HEIGHT);
		exitButton.setBounds(App.WIDTH/2-BUTTON_WIDTH/2, App.HEIGHT/2+BUTTON_PADDING, BUTTON_WIDTH, BUTTON_HEIGHT);
		
		this.add(background, new Integer(0));
		this.add(newGameButton, new Integer(1));
		this.add(exitButton, new Integer(1));
	}

	public class newGameButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			App.newGame();
		}
	}

	public class exitButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			App.exit();
		}
	}

	public void newGame() {

	}

	public void exit() {

	}
}
