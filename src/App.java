
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
	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = 1L;
	private static App app = new App();
	private static Game game;
	private static Menu menu;
	private static CardLayout cardLayout = new CardLayout();
	
	/**
	 * Default constructor
	 */
	public App() {
		super("Terepasztal");
	}
	
	public static void Initialize(){
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
	
	public static void exit(){
		System.exit(0);
	}
	
	static boolean random = false;
	
	/**
	 * @param String
	 * @return
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Initialize();
		/*
		//Console Controls
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("parancsok:");
        String line;
		while(true){
			line = br.readLine();
			String[] s = line.split(" ");
	        if(s[0].equals("loadMap")){
	        	game.loadMap(s[1]);
	        	game.run();
	        }
	        else if(s[0].equals("startTrain")){
	        	
	        }
	        else if(s[0].equals("setSwitch")){
	        	int i = Integer.parseInt(s[1]);
	        	game.getTable().getTableElement(i).click();
	        }
	        else if(s[0].equals("openTunnelEntrance")){
	        	int i = Integer.parseInt(s[1]);
	        	TunnelEntrance te = (TunnelEntrance)game.getTable().getTableElement(i);
	        	game.getTable().openTunnel(te);
	        }
	        else if(s[0].equals("closeTunnelEntrance")){
	        	int i = Integer.parseInt(s[1]);
	        	TunnelEntrance te = (TunnelEntrance)game.getTable().getTableElement(i);
	        	game.getTable().closeTunnel(te);
	        }
	        else if(s[0].equals("step")){
	        	int i = Integer.parseInt(s[1]);
	        	while(i != 0){
	        		game.move();
	        		i--;
	        	}
	        }
	        else if(s[0].equals("listStations")){
	        	for (int i = 0; i < game.getTable().getTableElements().size(); i++){
	        		if(game.getTable().getTableElements().get(i).getType().equals("station")){
	        			Station station = (Station)game.getTable().getTableElements().get(i);
	        			System.out.println("(" + station.getId() + " " + station.getColor() + ")");
	        		}
	        	}
	        }
	        else if(s[0].equals("listSwitches")){
	        	for (int i = 0; i < game.getTable().getTableElements().size(); i++){
	        		if(game.getTable().getTableElements().get(i).getType().equals("switch")){
	        			Switch sw = (Switch)game.getTable().getTableElements().get(i);
	        			System.out.println("( " + sw.getId() + " " + sw.getFix().getId() + " " + sw.getActive().getId() + " )");
	        		}
	        	}
	        }
	        else if(s[0].equals("listTunnelEntrance")){
	        	System.out.print("(");
	        	for (int i = 0; i < game.getTable().getTableElements().size(); i++){
	        		if(game.getTable().getTableElements().get(i).getType().equals("tunnelEntrance")){
	        			TunnelEntrance te = (TunnelEntrance)game.getTable().getTableElements().get(i);
	        			System.out.print(te.getId());
	        			System.out.print(" ");
	        			if(te.isOpen()){
	        				System.out.println("true");
	        			}
	        			else{
	        				System.out.println("false");
	        			}
	        		}
	        	}
	        	System.out.println(")");
	        }
	        else if(s[0].equals("listTrains")){

	        	for (int i = 0; i < game.getTable().getTrains().size(); i++){
	        		
	        		Train tr = game.getTable().getTrains().get(i);
	        		System.out.println("( Train " + tr.getID());
	        		for (TrainElement te : tr.getTrainElements()){
	        			if(te.getType().equals("car")){
	        				
	        				System.out.print("\tCar " + te.getColor() + " " + te.isEmpty() + " ");
	        				if (te.getcurrentTableElement() == null)
	        					System.out.print("0");
	        				else 
	        					System.out.print(te.getcurrentTableElement().getId());
	        				System.out.println();
	        			}
	        			else if(te.getType().equals("locomotive")){
	        					
	        				System.out.print("\tLocomotive null true ");
	        				if (te.getcurrentTableElement() == null)
	        					System.out.print("0");
	        				else 
	        					System.out.print(te.getcurrentTableElement().getId());
	        				System.out.println();
	        			}
	        			else if(te.getType().equals("coalwagon")){
	        				System.out.print("\tCoalWagon null true ");
	        				if (te.getcurrentTableElement() == null)
	        					System.out.print("0");
	        				else 
	        					System.out.print(te.getcurrentTableElement().getId());
	        				System.out.println();
	        			}
	        		}
	        		System.out.println(")");
	        	}
	        }
	        else if(s[0].equals("hopOn")){
	        	int i = Integer.parseInt(s[1]);
	        	Station te = (Station)game.getTable().getTableElement(i);
	        	te.hopOn();
	        }
	        
		}
		*/
	}
}