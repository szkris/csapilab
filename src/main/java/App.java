package main.java;


import java.awt.CardLayout;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;

/**
 * Az alkalmazást megvalósító osztály
 */
@SuppressWarnings("serial")
public class App extends JFrame{

	/**
	 * Az ablak mérete pixelekben
	 */
	public final static int HEIGHT = 600;
	public final static int WIDTH = 600; 
	/**
	 * Közös fájlbetöltö
	 */
	public static ClassLoader cl;
	/**
	 * Panelek inicializálása
	 */
	private static App app = new App();
	private static Game game = null;
	private static Menu menu = null;
	private static CardLayout cardLayout = new CardLayout();
	
	/**
	 * Alapértelmezett konstruktor
	 */
	public App() {
		super("Terepasztal");
	}
	
	/**
	 * Vissatér az applikáció föablakával
	 * @return Az applikáció föablaka
	 */
	public static JFrame getFrame(){
		return app;
	}
	
	/**
	 * Inicializálás
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
	 * Új játék kezdése
	 */
	public static void newGame(){
		game = new Game();
		cardLayout.show(app.getContentPane(), "game");
		game.run();
	}
	/**
	 * Menübe lépés
	 */
	public static void Menu(){
		cardLayout.show(app.getContentPane(), "menu");
	}
	/**
	 * Kilépés
	 */
	public static void exit(){
		System.exit(0);
	}
	
	/**
	 * Random felszállás be/ki
	 */
	static boolean random = true;
	
	
	public static void main(String[] args) throws IOException {
		Initialize();
	}
}