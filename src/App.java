
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
	
		//TODO Menü
		System.out.println("Kérek egy bemenetet:");
		
		String choice = null;
		Scanner scan = new Scanner(System.in);
	
		
		do {
			choice = scan.nextLine();
			switch(choice) {
			case "a":
				System.out.println("a");
				break;
			case "b":
				System.out.println("b");
				break;
				
			}
		} while (!choice.equals("q"));

	}
       
}

/**
 * SourceTree teszt Bence
 * SourceTree teszt masikgepKris
*/