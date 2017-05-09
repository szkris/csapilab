package main.java;


import java.awt.CardLayout;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;

/**
 * Az alkalmaz�st megval�s�t� oszt�ly
 */
@SuppressWarnings("serial")
public class App extends JFrame{

	/**
	 * Az ablak m�rete pixelekben
	 */
	public final static int HEIGHT = 600;
	public final static int WIDTH = 600; 
	/**
	 * K�z�s f�jlbet�lt�
	 */
	public static ClassLoader cl;
	/**
	 * Panelek inicializ�l�sa
	 */
	private static App app = new App();
	private static Game game = null;
	private static Menu menu = null;
	private static CardLayout cardLayout = new CardLayout();
	
	/**
	 * Alap�rtelmezett konstruktor
	 */
	public App() {
		super("Terepasztal");
	}
	
	/**
	 * Vissat�r az applik�ci� f�ablak�val
	 * @return Az applik�ci� f�ablaka
	 */
	public static JFrame getFrame(){
		return app;
	}
	
	/**
	 * Inicializ�l�s
	 */
	@SuppressWarnings("static-access")
	public static void Initialize(){
		cl = app.getClass().getClassLoader();
		menu = new Menu();
		game = new Game();
		
		app.setLayout(cardLayout);
		app.getContentPane().add(menu, "menu");
		app.getContentPane().add(game.view, "game");
		app.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setResizable(false);
		app.pack();
		app.setVisible(true);
		app.setFocusable(true);
	}
	
	/**
	 * �j j�t�k kezd�se
	 */
	public static void newGame(){
		game = new Game();
		cardLayout.show(app.getContentPane(), "game");
		game.run();
	}
	/**
	 * Men�be l�p�s
	 */
	public static void Menu(){
		cardLayout.show(app.getContentPane(), "menu");
	}
	/**
	 * Kil�p�s
	 */
	public static void exit(){
		System.exit(0);
	}
	
	/**
	 * Random felsz�ll�s be/ki
	 */
	static boolean random = true;
	
	
	public static void main(String[] args) throws IOException {
		Initialize();
	}
}