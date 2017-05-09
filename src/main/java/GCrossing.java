package main.java;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GCrossing extends GElements {

	Crossing crossing;
	JLabel label = new JLabel();
	
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
