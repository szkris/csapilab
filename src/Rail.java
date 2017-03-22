
import java.util.*;

/**
 * A vasútelemeket reprezentáló osztály
 */
public class Rail extends TableElement {
	
    /**
     * Default constructor
     */
    public Rail(String tab) {
    	System.out.println(tab + "Constructor Rail");
    }
    
    public Rail(){
    	
    }

    /**
     * a sín elõtt lévõ TableElement
     */
    private TableElement elem1;

    /**
     * a sín után lévõ TableElement
     */
    private TableElement elem2;


}