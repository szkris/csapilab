
import java.util.*;

/**
 * 
 */
public class App {

	static private Game g;
	
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
    
    static void startTrain(){
		Game game = new Game();
		game.move();
	}
	
    public static void Move(){
    	Game g = new Game(); 	
    }
    
    public static void nextElementRailOrStation(){
    	Train t = new Train();
    	Car c = new Car(t);
    	Rail r = new Rail();
    	r.stepOn(c);
    	c.getPreviousElement();
    }
    
    public static void nextElementSwitch(){
    	//TODO
    	Train t = new Train();
    	Car c = new Car(t);
    	Switch sw = new Switch();
    	sw.nextElement(c);
    	c.getPreviousElement();
    }
    
    public static void nextElementTunnelEntrance(){
    	Train t = new Train();
    	Car c = new Car(t);
    	TunnelEntrance tunEn = new TunnelEntrance();
    	
    	System.out.println("Choose one number from below to proceed!");
		System.out.println("1. Open");
		System.out.println("2. Closed");
		System.out.println("'q' to go back to previous menu!");
		
		String innerChoice2 = new String();
		Scanner scan = new Scanner(System.in);
		
		do {
			innerChoice2 = scan.nextLine();
			switch(innerChoice2) {
			case "1":
				c.getPreviousElement();
				break;
			case "2":
				Game.gameOver();
				break;
			}
		} while (!innerChoice2.equals("q"));
		
    }
    
    public static void nextElementTunnel(){
    	//TODO
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
	
	static void stepOnFree(){
		Train t = new Train();
		Locomotive loco = new Locomotive(t);
		TableElement te = new TableElement();
		if(te.occupied) te.setOccupied(false);
		te.stepOn(loco);
	}
	
	static void stepOnOccupied(){
		Train t = new Train();
		Locomotive loco = new Locomotive(t);
		TableElement te = new TableElement();
		if(te.occupied == false) te.setOccupied(true);
		te.stepOn(loco);
	}
	
	static void stepOff(){
		Train t = new Train();
		Locomotive loco = new Locomotive(t);
		TableElement te = new TableElement();
		te.setOccupied(false);
	}
	
	
	static void stepOffTunnelEntrance(){ 
		Train t = new Train();
		Locomotive loco = new Locomotive(t);
		TunnelEntrance te = new TunnelEntrance();
		te.stepOff();
		te.setOccupied(false);
		loco.changeVisibility();
	}
	
	static void hopOffTrain(){
		Train t = new Train();
		Car c = new Car(t);
		Car c2 = new Car(t);
		t.hopOff();
		String choice;
		String choice2;
		Scanner scan = new Scanner(System.in);
		do{
			System.out.println("1 - has more element, 2 - no more element ");
			choice = scan.nextLine();
			c2.isEmpty();
			System.out.println("1 - empty, 2 - not empty");
			choice2 = scan.nextLine();
		} while(choice.equals("1") && choice2.equals("1"));
		System.out.println("1 - Not empty car equals this, 2 - No more cars, or not this car is the first not empty");
		choice = scan.nextLine();
		if(choice.equals("1")){
			c.setEmpty();
			System.out.println("1 - This is the last car, 2 - This is not the last car");
			choice = scan.nextLine();
			if(choice.equals("1")){
				g.mapCompleted();
			}
		}
	}
	
	
	static void hopOffLocomotive(){
		Station s = new Station();
		Train t = new Train();
		Locomotive loco = new Locomotive(t);
		Color c = Color.red;
		loco.hopOff(c);
	}
	
	static void hopOffCar(){
		Station s = new Station();
		Train t = new Train();
		Car c = new Car(t);
		Color col = Color.red;
		c.hopOff(col);
		System.out.println("1 - empty, 2 - not empty");
		Scanner scan = new Scanner(System.in);
		String choice = scan.nextLine();
    	switch (choice) {
    		case "1":
    			return;
    		case "2":
    			t.hopOff();
    			System.out.println("1 - can hop off, 2 - can't hop off");
    			String choice2 = scan.nextLine();
    			switch(choice2) {
    			case "1":
    				c.setEmpty();
    				break;
    			case "2":
    				break;
    			}
    			break;
    		}
	}
		
    public static void clickOnTunnelEntrance(){
    	Table t = new Table();
    	TunnelEntrance ent = new TunnelEntrance();
    }
    
    public static void openTunnelEntrance(){
    	Table t = new Table();
    	TunnelEntrance ent = new TunnelEntrance();
    	ent.click();
    	
    }
    
    public static void closeTunnelEntrance() {
    	String choice;
    	Table t = new Table();
    	TunnelEntrance ent = new TunnelEntrance();
    	ent.click();
    	System.out.println("1 - occupied, 2 - not occupied");
    	Scanner scan = new Scanner(System.in);
    	do {
    		choice = scan.nextLine();
    		switch (choice) {
    		case "1":
    			System.out.println("Can't close tunnel, it's occupied!");
    			break;
    		case "2":
    			System.out.println("Tunnel closed!");
    			break;
    		}
    	} while(!choice.equals("q"));
    }
    
    public static void clickOnSwitch() {
    	String choice;
    	Switch s = new Switch();
    	s.click();
    	System.out.println("1 - occupied, 2 - not occupied");
    	Scanner scan = new Scanner(System.in);
    	do {
    		choice = scan.nextLine();
    		switch (choice) {
    		case "1":
    			System.out.println("Not settable!");
    			break;
    		case "2":
    			System.out.println("inactive = active, active = inactive");
    			break;
    		}
    	} while(!choice.equals("q"));
    }
    
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
				System.out.println("7. StepOn Station");
				System.out.println("8. StepOff");
				System.out.println("9. StepOff TunnelEntrance");
				System.out.println("'q' to go back to previous menu!");
				
				do {
					innerChoice = scan.nextLine();
					
					switch(innerChoice) {
					case "1":
						nextElementRailOrStation();
						break;
					case "2":
						nextElementSwitch();

						System.out.println("Choose one number from below to proceed!");
						System.out.println("1. Appropriate direction");
						System.out.println("2. Wrong direction");
						System.out.println("'q' to go back to previous menu!");
						do {
							innerChoice2 = scan.nextLine();
							switch(innerChoice2) {
							case "1":								
								break;
							case "2":
								Game.gameOver();
								break;
							}
						} while (!innerChoice2.equals("q"));
						break;
					case "3":
						nextElementTunnelEntrance();
						break;
					case "4":
						nextElementTunnel();
						break;
					case "5":
						System.out.println("Choose one number from below to proceed!");
						System.out.println("1. Occupied");
						System.out.println("2. Free");
						System.out.println("'q' to go back to previous menu!");
						do {
							innerChoice2 = scan.nextLine();
							switch(innerChoice2) {
							case "1":
								stepOnOccupied();
								break;
							case "2":
								stepOnFree();
								break;
							}
						} while (!innerChoice2.equals("q"));
						break;
					case "6":		
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
								hopOffTrain();
								break;
							case "2":
								hopOffLocomotive();
								break;
							case "3":
								hopOffCar();
								break;
							}
						} while (!innerChoice2.equals("q"));
						break;
					case "8":
						stepOff();
						break;
					case "9":
						stepOffTunnelEntrance();
						break;
					}
				} while (!innerChoice.equals("q"));
				break;
			case "4":
				
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
						openTunnelEntrance();
						break;
					case "2":
						closeTunnelEntrance();
						break;
					case "3":
						clickOnSwitch();
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