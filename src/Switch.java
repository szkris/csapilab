
import java.util.*;

/**
 * A v�lt�k megval�s�t�s��rt felel�s oszt�ly
 */
public class Switch extends TableElement {

    /**
     * Default constructor
     */
    public Switch(String tab) {
    	System.out.println(tab + "Constructor Switch");
    }

    /**
     * : A v�lt� �lland� ir�nya
     */
    private TableElement fix;

    /**
     * A v�lt� ebbe az ir�nyba �ll, erre halad tov�bb a vonat
     */
    private TableElement active;

    /**
     * A v�lt� lehets�ges m�sik ir�nya, v�lt�skor az active �s inactive �rt�kek megcser�l�dnek
     */
    private TableElement inactive;
}