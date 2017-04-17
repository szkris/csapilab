import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class App {

	/**
	 * Default constructor
	 */
	public App() {
	}
	
	static boolean random = false;
	
	/**
	 * @param String
	 * @return
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Game game = new Game();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("parancsok:");
        String line;
		while(true){
			line = br.readLine();
			String[] s = line.split(" ");
	        if(s[0].equals("loadMap")){
	        	Game.loadMap(s[1]);
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
	        	if(!te.isOpen())
	        		game.getTable().getTableElement(i).click();
	        }
	        else if(s[0].equals("closeTunnelEntrance")){
	        	int i = Integer.parseInt(s[1]);
	        	TunnelEntrance te = (TunnelEntrance)game.getTable().getTableElement(i);
	        	if(te.isOpen())
	        		game.getTable().getTableElement(i).click();
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
	        			System.out.println(station.getId() + " " + station.getColor());
	        		}
	        	}
	        }
	        else if(s[0].equals("listSwitches")){
	        	for (int i = 0; i < game.getTable().getTableElements().size(); i++){
	        		if(game.getTable().getTableElements().get(i).getType().equals("switch")){
	        			Switch sw = (Switch)game.getTable().getTableElements().get(i);
	        			System.out.println(sw.getId() + " " + sw.getFix().getId() + " " + sw.getActive().getId());
	        		}
	        	}
	        }
	        else if(s[0].equals("listTunnelEntrance")){
	        	for (int i = 0; i < game.getTable().getTableElements().size(); i++){
	        		if(game.getTable().getTableElements().get(i).getType().equals("station")){
	        			TunnelEntrance te = (TunnelEntrance)game.getTable().getTableElements().get(i);
	        			System.out.print(te.getId());
	        			System.out.print(" ");
	        			if(te.isOpen()){
	        				System.out.print("open");
	        			}
	        			else{
	        				System.out.print("closed");
	        			}
	        			System.out.println();
	        		}
	        	}
	        }
	        else if(s[0].equals("listTrains")){

	        	for (int i = 0; i < game.getTable().getTrains().size(); i++){
	        		
	        			Train tr = (Train)game.getTable().getTrains().get(i);
	        			System.out.println(tr.getID());
	        			for (TrainElement te : tr.getTrainElements()){
	        				if(te.getType().equals("car"))
	        					System.out.println("\tCar " + te.getColor() + " " + te.isEmpty() + " " + te.getcurrentTableElement().getId());
	        				else if(te.getType().equals("locomotive"))
	        					System.out.println("\tLocomotive null true "+ te.getcurrentTableElement().getId());
	        				else if(te.getType().equals("coalwagon"))
	        					System.out.println("\tCoalWagon null true "+ te.getcurrentTableElement().getId());
	        		}
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