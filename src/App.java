import java.io.File;
import java.util.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

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
	static Table table;
	
	public static void main(String[] args) {
		
		try {
			File file = new File("map/tunnelentrance_test_map.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Table.class);
			
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			table = (Table) jaxbUnmarshaller.unmarshal(file);
			System.out.println(table.toString());
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
	}

}