package main.java;
import java.awt.Graphics;

/**
 * A rajzon lévö változásokat megvalósító interface
 */
public interface IDrawable {
	/**
	 * Rajzon lézö változásokat megvalósító metódus
	 * @param g Graphics osztály a rajzoláshoz
	 */
	public void draw(Graphics g);
}
