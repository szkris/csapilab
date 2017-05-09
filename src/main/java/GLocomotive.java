package main.java;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 * A mozdony grafikus megjelenitéséhez szolgáló osztály
 */
@SuppressWarnings("serial")
public class GLocomotive extends GElements {

	/**
	 * A megjelenitendö mozdony 
	 */
	Locomotive loco = null;
	private static ImageIcon imageIcon = null;
	JLabel label = new JLabel();
	
	/**
	 * Konstruktor mely megkapja a megjelenitendö mozdonyt
	 * @param loco A megjelenitendö mozdony
	 */
	public GLocomotive(Locomotive loco){
		this.loco = loco;
		this.label.setIcon(imageIcon);
		imageIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/thomas.png")).getImage()
				.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
		this.setOpaque(false);
		
		label.setIcon(imageIcon);
		this.add(label, new Integer(0));
	}
	
	@Override
	public void draw(Graphics g) {
		//Ha látható, kirajzoljuk
		if(loco.getcurrentTableElement()!=null){
			int id = loco.getcurrentTableElement().getId();
			Point point = View.getPosition(id);
			x = point.x*View.TILE_WIDTH;
			y = point.y*View.TILE_HEIGHT;
			if(loco.isVisible())
				this.setBounds(x, y, View.TILE_WIDTH, View.TILE_HEIGHT+5);
			else
				this.setBounds(0,0,0,0);
			this.validate();
			this.repaint();
		}	
	}

	@Override
	public void click() {
		//Kattintásra nem történik semmi
	}
	@Override
	public int getId(){
		return 0;
	}

}
