
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import javax.swing.JFrame;

public class App extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public App() {
		super("Terepasztal");
		
		Menu menu = new Menu();
		
		/** JFrame létrehozása **/
		this.setPreferredSize(new Dimension(600, 600));
		this.add(menu.panel);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setFocusable(true);
		menu.panel.setFocusable(true);
	}
	
	static boolean random = false;
	
	/**
	 * @param String
	 * @return
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Game game = new Game();
		
		/** Console Controls **/
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
	}
}