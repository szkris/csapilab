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
		game.run();
		System.out.println("parancsok:");
        String line;
		while(true){
			line = br.readLine();
			String[] s = line.split(" ");
	        if(s[0].equals("loadMap")){
	        	Game.loadMap(s[1]);
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
	        			System.out.print(sw.getFix().getId());
	        			System.out.print(" ");
	        			System.out.print(sw.getActive().getId());
	        			System.out.print(" ");
	        			System.out.println();
	        			// Ki�rja az ID-t a fix poz�ci�t �s az �ppen akt�v poz�ci�t
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
	        else if(s[0].equals("listTrain")){
	        	
	        }
	        else if(s[0].equals("hopOn")){
	        	
	        }
		}
	}

}