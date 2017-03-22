
import java.util.*;

/**
 * 
 */
public class App {

	static private Game g = new Game("");
	
    /**
     * Default constructor
     */
    public App(String tab) {
    	g = new Game(tab);
    }

    public static void initGame(String tab){
    	App a;
		//Létrehozunk egy App példányt
		a = new App(tab);
		//Meghívjuk a Game Run() metódusát
		a.g.run(tab);
    }
    
    static void startTrain(String tab){
		g.move(tab);
	}
	
    static void stepOn(String tab){
    	String choice;
    	do {
			System.out.println(tab + "Choose one number from below to proceed!");
			System.out.println(tab + "1. Occupied");
			System.out.println(tab + "2. Free");
			System.out.println(tab + "'q' to go back to previous menu!");
			Scanner scan = new Scanner(System.in);
			choice = scan.nextLine();
				switch(choice) {
				case "1":
					stepOnOccupied(tab + "\t");
					break;
				case "2":
					stepOnFree(tab + "\t");
					break;
				}
			} while (!choice.equals("q"));		
    }
    
    static void stepOnTunnelEntrance(String tab){
    	String choice;
    	Scanner scan = new Scanner(System.in);
    	do {
			System.out.println(tab + "Choose one number from below to proceed!");
			System.out.println(tab + "1. Occupied");
			System.out.println(tab + "2. Free");
			System.out.println(tab + "'q' to go back to previous menu!");
			choice = scan.nextLine();
				switch(choice) {
				case "1":
					stepOnTunnelEntranceClosed("\t");
					break;
				case "2":
					stepOnTunnelEntranceOpen("\t");
					break;
				}
			} while (!choice.equals("q"));
    }
    
    public static void Move(String tab){
    	String choice;
    	Scanner scan = new Scanner(System.in);
    	do {
			System.out.println(tab + "Choose one number from below to proceed!");
			System.out.println(tab + "1. NextElement Rail or Station");
			System.out.println(tab + "2. NextElement Switch");
			System.out.println(tab + "3. NextElement TunnelEntrance");
			System.out.println(tab + "4. NextElement Tunnel");
			System.out.println(tab + "5. StepOn");
			System.out.println(tab + "6. StepOn TunnelEntrance");
			System.out.println(tab + "7. StepOn Station");
			System.out.println(tab + "8. StepOff");
			System.out.println(tab + "9. StepOff TunnelEntrance");
			System.out.println(tab + "'q' to go back to previous menu!");
				
			choice = scan.nextLine();
				
				switch(choice) {
				case "1":
					nextElementRailOrStation(tab + "\t");
					break;
				case "2":
					nextElementSwitch(tab + "\t");
					break;
				case "3":
					nextElementTunnelEntrance(tab + "\t");
					break;
				case "4":
					nextElementTunnel(tab + "\t");
					break;
				case "5":
					stepOn(tab + "\t");
					break;
				case "6":		
					stepOnTunnelEntrance(tab + "\t");
					break;
				case "7":
					stepOnStation(tab + "\t");
					break;
				case "8":
					stepOff(tab + "\t");
					break;
				case "9":
					stepOffTunnelEntrance(tab + "\t");
					break;
				}
			} while (!choice.equals("q"));
    }
    
    public static void clickOnTunnelEntrance(String tab){
    	Table t = new Table(tab);
    	TunnelEntrance ent = new TunnelEntrance(tab);
    	String choice;
		Scanner scan = new Scanner(System.in);
    	
    	do {				
			System.out.println(tab + "Choose one number from below to proceed!");
			System.out.println(tab + "1. Open");
			System.out.println(tab + "2. Close");
			System.out.println(tab + "3. Click on switch");
			System.out.println(tab + "'q' to go back to previous menu!");
			
			choice = scan.nextLine();
				
				switch(choice) {
				case "1":
					openTunnelEntrance(tab + "\t");
					break;
				case "2":
					closeTunnelEntrance(tab + "\t");
					break;
				case "3":
					clickOnSwitch(tab + "\t");
					break;
				} 
			} while (!choice.equals("q"));
    }
    
    public static void nextElementRailOrStation(String tab){
    	Train t = new Train(tab);
    	Car c = new Car(t, tab);
    	Rail r = new Rail(tab);
    	r.stepOn(c, tab+"\t");
    	c.getPreviousElement(tab);
    }
    
    public static void nextElementSwitch(String tab){
    	Train t = new Train(tab);
    	Car c = new Car(t, tab);
    	Switch sw = new Switch(tab);
    	sw.nextElement(c, tab+"\t");
    	c.getPreviousElement(tab+"\t");
    	
    	String choice;
    	Scanner scan = new Scanner(System.in);

		do {
		System.out.println(tab + "Choose one number from below to proceed!");
		System.out.println(tab + "1. Appropriate direction");
		System.out.println(tab + "2. Wrong direction");
		System.out.println(tab + "'q' to go back to previous menu!");
			choice = scan.nextLine();
			switch(choice) {
			case "1":								
				break;
			case "2":
				Game.gameOver(tab+"\t");
				break;
			}
		} while (!choice.equals("q"));

    }
    
    public static void nextElementTunnelEntrance(String tab){
    	Train t = new Train(tab);
    	Car c = new Car(t, tab);
    	TunnelEntrance tunEn = new TunnelEntrance(tab);
    	
    	String choice = new String();
		Scanner scan = new Scanner(System.in);
    	
		do {
			System.out.println(tab + "Choose one number from below to proceed!");
			System.out.println(tab + "1. Open");
			System.out.println(tab + "2. Closed");
			System.out.println(tab + "'q' to go back to previous menu!");
			
			choice = scan.nextLine();
			switch(choice) {
			case "1":
				c.getPreviousElement(tab+"\t");
				break;
			case "2":
				Game.gameOver(tab+"\t");
				break;
			}
		} while (!choice.equals("q"));
		
    }
    
    public static void nextElementTunnel(String tab){
    	Train t = new Train(tab);
    	Car c = new Car(t, tab);
    	TunnelEntrance tunEn1 = new TunnelEntrance(tab);
    	TunnelEntrance tunEn2 = new TunnelEntrance(tab);
    	Tunnel tun = new Tunnel(tab);
    	
    	tun.nextElement(c, tab+"\t");
    	tunEn1.isOpen(tab+"\t");
    	tunEn2.isOpen(tab+"\t");
    	
    	c.getPreviousElement(tab+"\t");
    	
    	tun.leadsTo(tunEn2, tab+"\t");
    	tun.leadsTo(tunEn1, tab+"\t");
    }
    
	static void stepOnTunnelEntranceOpen(String tab){
		Train t = new Train(tab);
		Locomotive loco = new Locomotive(t, tab);
		TunnelEntrance te = new TunnelEntrance(tab);
		TableElement tEl = new TableElement(tab);
		if (te.isOpen(tab+"\t") == false) te.changeStatus(tab+"\t");
		te.stepOn(loco,tab+"\t");
	}
	
	static void stepOnTunnelEntranceClosed(String tab){
		Train t = new Train(tab);
		Locomotive loco = new Locomotive(t, tab);
		TunnelEntrance te = new TunnelEntrance(tab+"\t");
		TableElement tEl = new TableElement();
		if (te.isOpen(tab+"\t")) te.changeStatus(tab+"\t");
		te.stepOn(loco,tab+"\t");
	}
	
	static void stepOnStation(String tab){
		Train t = new Train(tab);
		Locomotive loco = new Locomotive(t, tab);
		Station s = new Station(tab);
		s.stepOn(loco, tab+"\t");
		
		String choice;
		Scanner scan = new Scanner(System.in);
		
		do {
			System.out.println(tab + "Choose one number from below to proceed!");
			System.out.println(tab + "1. HopOff Train");
			System.out.println(tab + "2. HopOff Locomotive");
			System.out.println(tab + "3. HopOff Car");
			System.out.println(tab + "'q' to go back to previous menu!");
				choice = scan.nextLine();
				switch(choice) {
				case "1":
					hopOffTrain(tab+"\t");
					break;
				case "2":
					hopOffLocomotive(tab+"\t");
					break;
				case "3":
					hopOffCar(tab+"\t");
					break;
				}
			} while (!choice.equals("q"));
			
	}
	
	static void stepOnFree(String tab){
		Train t = new Train(tab);
		Locomotive loco = new Locomotive(t, tab);
		TableElement te = new TableElement(tab);
		if(te.occupied) te.setOccupied(false, tab+"\t");
		te.stepOn(loco, tab+"\t");
	}
	
	static void stepOnOccupied(String tab){
		Train t = new Train(tab);
		Locomotive loco = new Locomotive(t, tab);
		TableElement te = new TableElement(tab);
		if(te.occupied == false) te.setOccupied(true, tab+"\t");
		te.stepOn(loco, tab+"\t");
		g.gameOver(tab+"\t");
	}
	
	static void stepOff(String tab){
		Train t = new Train(tab);
		Locomotive loco = new Locomotive(t, tab);
		TableElement te = new TableElement(tab);
		te.setOccupied(false, tab+"\t");
	}
	
	static void stepOffTunnelEntrance(String tab){ 
		Train t = new Train(tab);
		Locomotive loco = new Locomotive(t, tab);
		TunnelEntrance te = new TunnelEntrance(tab);
		te.stepOff(tab+"\t");
		te.setOccupied(false, tab+"\t");
		loco.changeVisibility(tab+"\t");
	}
	
	static void hopOffTrain(String tab){
		Train t = new Train(tab);
		Car c = new Car(t, tab);
		Car c2 = new Car(t, tab);
		t.hopOff(tab+"\t");
		String choice;
		String choice2;
		Scanner scan = new Scanner(System.in);
		do{
			System.out.println(tab + "1 - has more element, 2 - no more element ");
			choice = scan.nextLine();
			if(choice.equals("2")) break;
			c2.isEmpty(tab+"\t");
			System.out.println(tab + "1 - empty, 2 - not empty");
			choice2 = scan.nextLine();
		} while(choice.equals("1") && choice2.equals("1"));
		System.out.println(tab + "1 - Not empty car equals this, 2 - No more cars, or not this car is the first not empty");
		choice = scan.nextLine();
		if(choice.equals("1")){
			c.setEmpty(tab+"\t");
			System.out.println(tab + "1 - This is the last car, 2 - This is not the last car");
			choice = scan.nextLine();
			if(choice.equals("1")){
				g.mapCompleted(tab+"\t");
			}
		}
	}
		
	static void hopOffLocomotive(String tab){
		Station s = new Station(tab);
		Train t = new Train(tab);
		Locomotive loco = new Locomotive(t, tab);
		Color c = Color.red;
		loco.hopOff(c, tab+"\t");
	}
	
	static void hopOffCar(String tab){
		Station s = new Station(tab);
		Train t = new Train(tab);
		Car c = new Car(t, tab);
		Color col = Color.red;
		c.hopOff(col, tab+"\t");
		System.out.println(tab + "1 - empty, 2 - not empty");
		Scanner scan = new Scanner(System.in);
		String choice = scan.nextLine();
    	switch (choice) {
    		case "1":
    			return;
    		case "2":
    			t.hopOff(tab+"\t");
    			System.out.println(tab + "1 - can hop off, 2 - can't hop off");
    			String choice2 = scan.nextLine();
    			switch(choice2) {
    			case "1":
    				c.setEmpty(tab+"\t");
    				break;
    			case "2":
    				break;
    			}
    			break;
    		}
	}
    
    public static void openTunnelEntrance(String tab){
    	Table t = new Table(tab);
    	TunnelEntrance ent = new TunnelEntrance(tab+"\t");
    	ent.click(tab+"\t");
    	
    }
    
    public static void closeTunnelEntrance(String tab) {
    	String choice;
    	Table t = new Table(tab);
    	TunnelEntrance ent = new TunnelEntrance(tab+"\t");
    	ent.click(tab+"\t");
    	System.out.println(tab + "1 - occupied, 2 - not occupied");
    	Scanner scan = new Scanner(System.in);
    	do {
    		choice = scan.nextLine();
    		switch (choice) {
    		case "1":
    			System.out.println(tab + "Can't close tunnel, it's occupied!");
    			break;
    		case "2":
    			System.out.println("Tunnel closed!");
    			break;
    		}
    	} while(!choice.equals("q"));
    }
    
    public static void clickOnSwitch(String tab) {
    	String choice;
    	Switch s = new Switch(tab);
    	s.click(tab+"\t");
    	System.out.println(tab + "1 - occupied, 2 - not occupied");
    	Scanner scan = new Scanner(System.in);
    	do {
    		choice = scan.nextLine();
    		switch (choice) {
    		case "1":
    			System.out.println(tab + "Not settable!");
    			break;
    		case "2":
    			System.out.println(tab + "inactive = active, active = inactive");
    			break;
    		}
    	} while(!choice.equals("q"));
    }
    
    /**
     * @param String 
     * @return
     */
public static void main(String[] s) {
	String choice;

	do {
		System.out.println("Choose one number from below to proceed!");
		System.out.println("1. Init game");
		System.out.println("2. Start train");
		System.out.println("3. Move");
		System.out.println("4. Click on TunnelEntrance");
		System.out.println("'q' to exit!");
		
		Scanner scan = new Scanner(System.in);
		choice = scan.nextLine();
			switch(choice) {
			case "1":
				initGame("\t");
				break;
			case "2":
				startTrain("\t");
				break;		
			case "3":
				Move("\t");
				break;
			case "4":
				clickOnTunnelEntrance("\t");
				break;
			default:
				break;
			}
		} while (!choice.equals("q"));
	}
}