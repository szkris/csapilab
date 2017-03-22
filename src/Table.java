
import java.util.*;

/**
 * A Table oszt�ly t�rolja a p�lya elemeit
 */
public class Table {

	/**
     * Szintek sz�ma
     */
    private int numberOfLevels;

    /**
     * Aktu�lis szint
     */
    private int currentLevel;
    
    /**
     * A nyitott alag�tbej�ratok
     */
    private TunnelEntrance openTunnelEntrances;
    
    /**
     * A vonatokat t�rol� lista
     */
    private ArrayList<Train> trains;
	
    /**
     * Default constructor
     */
    public Table(String tab) {
    	System.out.println(tab + "Constructor Table");
    }

    /**
     * bet�lti a k�vetkez p�ly�t
     * @return
     */
    public void loadMap(String tab) {
    	System.out.println(tab + "Table.loadMap");
    }

    /**
     * v�letlenszer�en v�laszt egy bel�p�si pontot a vonatnak
     * @return
     */
    public TableElement getEntryPoint(String tab) {
    	System.out.println(tab + "Table.getEntryPoint");
        return null;
    }

    /**
     * visszaadja a soron k�vetkez� vonatot a trains list�b�l
     * @return
     */
    public Train getNextTrain(String tab) {
    	System.out.println(tab + "Table.getNextTrain");
        return null;
    }

    /**
     * megmmondja hogy a param�terk�nt kapott id�pillanatban kell e ind�tani vonatot
     * @param tick id�pillanat (id�egys�g)
     * @return boolean kell e ind�tani vonatot
     */
    public boolean trainReady(int tick, String tab) {
    	System.out.println(tab + "Table.trainReady()");
        System.out.println(tab + "1-ready, 2-not ready");
        String ready = new Scanner(System.in).nextLine();
        if (ready.equals("1")){
        	return true;
        }
        if (ready.equals("2")){
        	return false;
        }
        return false;
    }

    /**
     * a TunnelEntrance h�vja meg, a table tudja, hogy h�ny alag�tbej�rat van nyitva, ett�l f�gg hogy kattint�sra nyit e �j bej�ratot
     * @param TunnelEntrance alag�t bej�rat
     * @return siker�lt e az alag�t nyit�s
     */
    public boolean openTunnel(TunnelEntrance tunEn, String tab) {
    	System.out.println(tab + "Table.openTunnel");
    	openTunnelEntrances = tunEn;
    	openTunnelEntrances.changeStatus(tab+"\t");
        return false;
    }

}