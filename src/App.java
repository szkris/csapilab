
import java.util.*;

/**
 * 
 */
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
public static void main(String[] s) {
	
		System.out.println("Choose one number from below to proceed!");
		System.out.println("1. Init game");
		System.out.println("2. Start train");
		System.out.println("3. Move");
		System.out.println("4. Click on TunnelEntrance");
		
		String choice = null;
		String innerChoice = null;
		Scanner scan = new Scanner(System.in);
	
		do {
			choice = scan.nextLine();
			switch(choice) {
			case "1":
				//TODO init megfelelo szekvencia
				System.out.println("1");
				break;
			case "2":
				System.out.println("Choose one number from below to proceed!");
				System.out.println("1. Appropriate direction");
				System.out.println("2. Wrong direction");
				System.out.println("'q' to go back to previous menu!");
				do {
					innerChoice = scan.nextLine();
					
					switch(innerChoice) {
					case "1":
						//TODO Appropriate direction megfelelo szekvencia
						System.out.println("1");
						break;
					case "2":
						//TODO Wrong direction megfelelo szekvencia
						System.out.println("2");
						break;
					}
					
				} while (!innerChoice.equals("q"));	
			default:
				break;
			}
		} while (!choice.equals("q"));

	}
       
}

/**
 * SourceTree teszt Bence
 * SourceTree teszt masikgepKris
*/