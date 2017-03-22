
import java.util.*;

/**
 * A váltók megvalósításáért felelõs osztály
 */
public class Switch extends TableElement {

    /**
     * Default constructor
     */
    public Switch(String tab) {
    	System.out.println(tab + "Constructor Switch");
    }

    /**
     * : A váltó állandó iránya
     */
    private TableElement fix;

    /**
     * A váltó ebbe az irányba áll, erre halad tovább a vonat
     */
    private TableElement active;

    /**
     * A váltó lehetséges másik iránya, váltáskor az active és inactive értékek megcserélõdnek
     */
    private TableElement inactive;
}