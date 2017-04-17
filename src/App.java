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
	        	
	        }
	        else if(s[0].equals("listStations")){
	        	for (int i = 0; i < game.getTable().getTableElements().size(); i++){
	        		if(game.getTable().getTableElements().get(i).getType().equals("station")){
	        			Station station = (Station)game.getTable().getTableElements().get(i);
	        			System.out.print(station.getId());
	        			System.out.print(" ");
	        			System.out.print(station.getColor());
	        			System.out.println();
	        		}
	        	}
	        }
	        else if(s[0].equals("listSwitches")){
	        	for (int i = 0; i < game.getTable().getTableElements().size(); i++){
	        		if(game.getTable().getTableElements().get(i).getType().equals("switch")){
	        			Switch sw = (Switch)game.getTable().getTableElements().get(i);
	        			System.out.print(sw.getId());
	        			System.out.print(" ");
	        			System.out.println();
	        			// Doksiban van még itt valami, amit ki kell írnia, de nem tudom, mi az
	        			// Kiírja az ID-t a fix pozíciót és az éppen aktív pozíciót
	        		}
	        	}
	        }
	        else if(s[0].equals("listTunnelEntrance")){
	        	
	        }
	        else if(s[0].equals("listTrain")){
	        	
	        }
	        else if(s[0].equals("hopOn")){
	        	
	        }
		}
	}

}