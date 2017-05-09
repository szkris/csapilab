package main.java;


import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.text.View;

public class App extends JFrame{

	
	public final static int HEIGHT = 600;
	public final static int WIDTH = 600; 
	
	public static ClassLoader cl;
	
	private static final long serialVersionUID = 1L;
	private static App app = new App();
	private static Game game = null;
	private static Menu menu = null;
	private static CardLayout cardLayout = new CardLayout();
	
	/**
	 * Default constructor
	 */
	public App() {
		super("Terepasztal");
	}
	
	public static JFrame getFrame(){
		return app;
	}
	
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
	
	public static void newGame(){
		game = new Game();
		cardLayout.show(app.getContentPane(), "game");
		game.run();
	}
	
	public static void Menu(){
		cardLayout.show(app.getContentPane(), "menu");
	}
	
	public static void exit(){
		System.exit(0);
	}
	
	static boolean random = true;
	
	/**
	 * @param String
	 * @return
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Initialize();
	}
}