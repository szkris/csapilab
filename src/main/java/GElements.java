package main.java;

import javax.swing.JPanel;

/**
 * A grafikus elemekethez tartozó absztrakt ösosztály mely megvalósítja az IDrawable interfacet
 */
@SuppressWarnings("serial")
public abstract class GElements extends JPanel implements IDrawable {
	
	/**
	 * X, Y koordináta
	 */
	protected int x = 0;
	protected int y = 0;
	
	/**
	 * A kattintást megvalósító függvény
	 */
	public abstract void click();
	
	/**
	 * Getter az x koordinátához
	 */
	public int getX(){
		return x;
	}
	
	/**
	 * Getter az y koordinátához
	 */
	public int getY(){
		return y;
	}
	
	/**
	 * Visszaadja a tárolt TableElement ID-jét
	 * @return A tárolt elem id-je
	 */
	public abstract int getId();
}