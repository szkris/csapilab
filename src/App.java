import java.io.BufferedReader;
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
	 */
	public static void main(String[] args) {
		Game game = new Game();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("parancsok:");
        String line = br.readLine();
        String[] s = line.split(" ");
        if(s[0].equals("loadMap")){
        	game.loadMap("s[1]");
        }
        else if(s[0].equals("startTrain")){
        	
        }
        else if(s[0].equals("setSwitch")){
        	
        }
        else if(s[0].equals("openTunnelEntrance")){
        	
        }
        else if(s[0].equals("closeTunnelEntrance")){
        	
        }
        else if(s[0].equals("step")){
        	
        }
        else if(s[0].equals("listStations")){
        	
        }
        else if(s[0].equals("listSwitches")){
        	
        }
        else if(s[0].equals("listTunnelEntrance")){
        	
        }
        else if(s[0].equals("listTrain")){
        	
        }
        else if(s[0].equals("hopOn")){
        	
        }
		game.loadMap("tunnelentrance_test_map.xml");
		game.run();
	}

}