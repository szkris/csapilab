package main.java;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 * CoalWagon oszt�lyhoz tartoz� grafikus megjelen�t�s
 */
@SuppressWarnings("serial")
public class GCoalWagon extends GElements {

	/**
	 * A megjelen�tend� objektum
	 */
	CoalWagon cw = null;
	
	private static ImageIcon imageIcon=null;
	JLabel label = new JLabel();
	
	/**
	 * Konstruktor mely megkapja param�terk�nt a megjelen�tend� szeneskocsit
	 * @param cw A megjelen�tend� szeneskocsi
	 */
	public GCoalWagon(CoalWagon cw){
		this.cw = cw;
		imageIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/coalwagon.png")).getImage()
				.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
		this.setOpaque(false);
		
		label.setIcon(imageIcon);
		this.add(label, new Integer(0));
	}
	
	@Override
	public void draw(Graphics g) {
		if(cw.getcurrentTableElement()!=null){
			int id = cw.getcurrentTableElement().getId();
			Point point = View.getPosition(id);
			x = point.x*View.TILE_WIDTH;
			y = point.y*View.TILE_HEIGHT;
			if(cw.isVisible())
				this.setBounds(x, y, View.TILE_WIDTH, View.TILE_HEIGHT+5);
			else
				this.setBounds(0,0,0,0);
			this.validate();
			this.repaint();
		}	
	}
	@Override
	public void click() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public int getId(){
		return 0;
	}

}
