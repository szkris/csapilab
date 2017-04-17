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
		game.loadMap("tunnelentrance_test_map.xml");
		game.run();
	}

}