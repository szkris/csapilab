package main.java;

import javax.swing.JPanel;

/**
 * A grafikus elemekethez tartoz� absztrakt �soszt�ly mely megval�s�tja az IDrawable interfacet
 */
@SuppressWarnings("serial")
public abstract class GElements extends JPanel implements IDrawable {
	
	/**
	 * X, Y koordin�ta
	 */
	protected int x = 0;
	protected int y = 0;
	
	/**
	 * A kattint�st megval�s�t� f�ggv�ny
	 */
	public abstract void click();
	
	/**
	 * Getter az x koordin�t�hoz
	 */
	public int getX(){
		return x;
	}
	
	/**
	 * Getter az y koordin�t�hoz
	 */
	public int getY(){
		return y;
	}
	
	/**
	 * Visszaadja a t�rolt TableElement ID-j�t
	 * @return A t�rolt elem id-je
	 */
	public abstract int getId();
}