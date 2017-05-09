package main.java;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 * A Crossing megjelen�t�s�hez tartoz� oszt�ly
 */
@SuppressWarnings("serial")
public class GCrossing extends GElements {
	
	/**
	 * A megjelen�tend� keresztez�d�s
	 */
	Crossing crossing;
	JLabel label = new JLabel();
	
	/**
	 * Konstruktor mely param�terk�nt megkapja a megjelen�tend� keresztez�d�st
	 * @param crossing A megjelen�tend� keresztez�d�s
	 */
	public GCrossing(Crossing crossing){
		int id = crossing.getId();
		this.crossing = crossing;
		
		Point point = View.getPosition(id);
		x = point.x*View.TILE_WIDTH;
		y = point.y*View.TILE_HEIGHT;
		this.setBounds(x, y, View.TILE_WIDTH, View.TILE_HEIGHT+5);
		this.setOpaque(false);
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/crossing.png")).getImage().getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));;
		
		label.setIcon(imageIcon);
		this.add(label, new Integer(0));
	}
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub

	}

	@Override
	public void click() {
		// TODO Auto-generated method stub		
	}
	
	@Override
	public int getId(){
		return crossing.id;
	}

}
