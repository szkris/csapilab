
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
				/*System.out.println("Choose one number from below to proceed!");
				System.out.println("1. Appropriate direction");
				System.out.println("2. Wrong direction");
				
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
					
				} while (!innerChoice.equals("q"));	*/
				
				
				break;
				
			case "3":
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
				break;
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