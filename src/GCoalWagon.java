import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GCoalWagon extends GElements {

	CoalWagon cw = null;
	private static ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/coalwagon.png").getImage()
			.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
	JLabel label = new JLabel();
	
	public GCoalWagon(CoalWagon cw){
		this.cw = cw;
		
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
