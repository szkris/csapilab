
import java.util.*;

/**
 * 
 */
public class App {

	private Game g;
	
    /**
     * Default constructor
     */
    public App() {
    	//Létrehoz egy Game példányt majd meghívja annak run() metódusát
    	g = new Game();
    }

    public static void initGame(){
    	App a;
		System.out.println("1");
		
		//Létrehozunk egy App példányt
		a = new App();
		//Meghívjuk a Game Run() metódusát
		a.g.run();
    }
    public static void nextElementRailOrStation(){
    	//TODO NextElement Rail or Station szekvencia
    	
    }
    public static void Move(){
    	Game g = new Game();
    	
    }
    
//<<<<<<< HEAD
	static void startTrain(){
		Game game = new Game();
		game.move();
	}
	
	static void hopOffLocomotive(){
		Station s = new Station();
		Train t = new Train();
		Locomotive loco = new Locomotive(t);
		s.stepOn(loco);
	}
	
	static void stepOnTunnelEntranceOpen(){
		Train t = new Train();
		Locomotive loco = new Locomotive(t);
		TunnelEntrance te = new TunnelEntrance();
		TableElement tEl = new TableElement();
		if (te.isOpen() == false) te.changeStatus();
		te.stepOn(loco);

	}
	
	static void stepOnTunnelEntranceClosed(){
		Game g = new Game();
		Train t = new Train();
		Locomotive loco = new Locomotive(t);
		TunnelEntrance te = new TunnelEntrance();
		TableElement tEl = new TableElement();
		if (te.isOpen()) te.changeStatus();
		te.stepOn(loco);
	}
	
	static void stepOnStation(){
		Train t = new Train();
		Locomotive loco = new Locomotive(t);
		Station s = new Station();
		s.stepOn(loco);
	}
	
	static void StepOnFree(){
		Train t = new Train();
		Locomotive loco = new Locomotive(t);
		TableElement te = new TableElement();
		if(te.occupied) te.setOccupied(false);
		te.stepOn(loco);
	}
	
	static void StepOnOccupied(){
		Train t = new Train();
		Locomotive loco = new Locomotive(t);
		TableElement te = new TableElement();
		if(te.occupied == false) te.setOccupied(true);
		te.stepOn(loco);
	}
	
	//TODO
	static void stepOffTunnelEntrance(){ 
		Train t = new Train();
		Locomotive loco = new Locomotive(t);
		TunnelEntrance te = new TunnelEntrance();
	}
	
//=======
    public static void clickOnTunnelEntrance(){
    	Table t = new Table();
    	TunnelEntrance ent = new TunnelEntrance();
    }
    
    public static void openTunnelEntrance(){
    	Table t = new Table();
    	TunnelEntrance ent = new TunnelEntrance();
    	ent.click();
    	
    }
    
    public static void CloseTunnelEntrance() {
    	//TODO
    }
    
    public static void nextElementSwitch(){
    	//TODO
    }
    
//>>>>>>> origin/master
    /**
     * @param String 
     * @return
     */
public static void main(String[] s) {
	
		///////////////////////////////////////////////////////
		///TODO - SZEKVENCIA DIAGRAMOK SZERINTI FÜGGVÉNYHÍVÁSOK
		///////////////////////////////////////////////////////
	
		System.out.println("Choose one number from below to proceed!");
		System.out.println("1. Init game");
		System.out.println("2. Start train");
		System.out.println("3. Move");
		System.out.println("4. Click on TunnelEntrance");
		System.out.println("'q' to exit!");
		
		
		
		String choice;
		String innerChoice;
		String innerChoice2;
		Scanner scan = new Scanner(System.in);
	
		do {
			choice = scan.nextLine();
			switch(choice) {
			case "1":
				//InitGame szekvencia
				initGame();
				break;
			case "2":
				// Start Train szekvencia
				System.out.println("2");
				startTrain();
				break;		
			case "3":
				Move();
				
				
				System.out.println("Choose one number from below to proceed!");
				System.out.println("1. NextElement Rail or Station");
				System.out.println("2. NextElement Switch");
				System.out.println("3. NextElement TunnelEntrance");
				System.out.println("4. NextElement Tunnel");
				System.out.println("5. StepOn");
				System.out.println("6. StepOn TunnelEntrance");
				System.out.println("7. StepOff");
				System.out.println("8. StepOff TunnelEntrance");
				System.out.println("9. StepOn Station");
				System.out.println("'q' to go back to previous menu!");
				
				do {
					innerChoice = scan.nextLine();
					
					switch(innerChoice) {
					case "1":
						nextElementRailOrStation();
						break;
					case "2":
						//TODO NextElement Switch
						System.out.println("Choose one number from below to proceed!");
						System.out.println("1. Appropriate direction");
						System.out.println("2. Wrong direction");
						System.out.println("'q' to go back to previous menu!");
						do {
							innerChoice2 = scan.nextLine();
							switch(innerChoice2) {
							case "1":
								//TODO Appropriate direction szekvencia
								System.out.println("1");
								break;
							case "2":
								//TODO Wrong Direction szekvencia
								System.out.println("2");
								break;
							}
						} while (!innerChoice2.equals("q"));
						break;
					case "3":
						//TODO NextElement TunnelEntrance szekvencia
						System.out.println("Choose one number from below to proceed!");
						System.out.println("1. Open");
						System.out.println("2. Closed");
						System.out.println("'q' to go back to previous menu!");
						do {
							innerChoice2 = scan.nextLine();
							switch(innerChoice2) {
							case "1":
								//TODO Open szekvencia
								System.out.println("1");
								break;
							case "2":
								//TODO Closed szekvencia
								System.out.println("2");
								break;
							}
						} while (!innerChoice2.equals("q"));
						break;
					case "4":
						//TODO NextElementTunnel szekvencia
						System.out.println("4");
						break;
					case "5":
						//TODO StepOn szekvencia
						System.out.println("Choose one number from below to proceed!");
						System.out.println("1. Occupied");
						System.out.println("2. Free");
						System.out.println("'q' to go back to previous menu!");
						do {
							innerChoice2 = scan.nextLine();
							switch(innerChoice2) {
							case "1":
								StepOnOccupied();
								break;
							case "2":
								StepOnFree();
								break;
							}
						} while (!innerChoice2.equals("q"));
						break;
					case "6":
						//StepOn TunnelEntrance szekvencia
						System.out.println("Choose one number from below to proceed!");
						System.out.println("1. Occupied");
						System.out.println("2. Free");
						System.out.println("'q' to go back to previous menu!");
						do {
							innerChoice2 = scan.nextLine();
							switch(innerChoice2) {
							case "1":
								stepOnTunnelEntranceClosed();
								break;
							case "2":
								stepOnTunnelEntranceOpen();
								break;
							}
						} while (!innerChoice2.equals("q"));
						break;
					case "7":
						//TODO StepOff szekvencia
						break;
					case "8":
						//TODO StepOff TunnelEntrance szekvencia
						break;
					case "9":
						stepOnStation();
						System.out.println("Choose one number from below to proceed!");
						System.out.println("1. HopOff Train");
						System.out.println("2. HopOff Locomotive");
						System.out.println("3. HopOff Car");
						System.out.println("'q' to go back to previous menu!");
						do {
							innerChoice2 = scan.nextLine();
							switch(innerChoice2) {
							case "1":
								//TODO HopOff Train szekvencia
								System.out.println("1");
								break;
							case "2":
								//HopOff Locomotive szekvencia
								hopOffLocomotive();
								break;
							case "3":
								//TODO HopOff Car
								System.out.print("3");
								break;
							}
						} while (!innerChoice2.equals("q"));
						//TODO StepOnStation szekvencia
						break;
					}
				} while (!innerChoice.equals("q"));
				break;
			case "4":
				//TODO Click on TunnelEntrance
				clickOnTunnelEntrance();
				
				System.out.println("Choose one number from below to proceed!");
				System.out.println("1. Open");
				System.out.println("2. Close");
				System.out.println("3. Click on switch");
				System.out.println("'q' to go back to previous menu!");
				
				do {
					innerChoice = scan.nextLine();
					
					switch(innerChoice) {
					case "1":
						System.out.println("1");
						openTunnelEntrance();
						break;
					case "2":
						//TODO Close szekvenciája
						System.out.println("2");
						break;
					case "3":
						//TODO Click on Switch szekvenciája
						System.out.println("3");
						break;
					} 
				} while (!innerChoice.equals("q"));
				break;
			default:
				break;
			}
		} while (!choice.equals("q"));
	}
}