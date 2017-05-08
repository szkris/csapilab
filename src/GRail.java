import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;

import java.awt.Color;
import java.awt.Dimension;

public class GRail extends GElements {

	Rail rail;
	JLabel label = new JLabel();
	
	public GRail(Rail rail){
		int id = rail.getId();
		int row = (int)((id-1)/View.COLUMN);
		int column = id-1-row*View.COLUMN;
	
		x=column*View.TILE_WIDTH;
		y=row*View.TILE_HEIGHT;
		
		this.rail = rail;
		this.setBounds(x, y, View.TILE_WIDTH, View.TILE_HEIGHT);
		
	    ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/menu_background.png").getImage().getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
		label.setIcon(imageIcon);
		this.add(label, new Integer(0));
	}

	@Override
	public void click() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g) {
	}

}
