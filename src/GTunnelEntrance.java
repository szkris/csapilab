import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GTunnelEntrance extends GElements {

	TunnelEntrance te;
	JLabel label = new JLabel();
	ImageIcon openIcon = null;
	ImageIcon closedIcon = null;

	public GTunnelEntrance(TunnelEntrance te) {
		int id = te.getId();
		this.te = te;

		Point point = View.getPosition(id);
		x = point.x * View.TILE_WIDTH;
		y = point.y * View.TILE_HEIGHT;
		this.setBounds(x, y, View.TILE_WIDTH, View.TILE_HEIGHT + 5);
		this.setOpaque(false);
		ArrayList<Integer> neighbours = te.getNeighbours();
		Point neighbourrail = View.getPosition(neighbours.get(0));

		if (neighbourrail.x > point.x) {
			openIcon = new ImageIcon(new ImageIcon("img/tunnelentrance_open_right.png").getImage()
					.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
			closedIcon = new ImageIcon(new ImageIcon("img/tunnelentrance_closed_right.png").getImage()
					.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));

		} else if (neighbourrail.x < point.x) {
			openIcon = new ImageIcon(new ImageIcon("img/tunnelentrance_open_left.png").getImage()
					.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
			closedIcon = new ImageIcon(new ImageIcon("img/tunnelentrance_closed_left.png").getImage()
					.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
		} else if (neighbourrail.y < point.y) {
			openIcon = new ImageIcon(new ImageIcon("img/tunnelentrance_open_up.png").getImage()
					.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
			closedIcon = new ImageIcon(new ImageIcon("img/tunnelentrance_closed_up.png").getImage()
					.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));

		} else if (neighbourrail.y > point.y) {

			openIcon = new ImageIcon(new ImageIcon("img/tunnelentrance_open_down.png").getImage()
					.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
			closedIcon = new ImageIcon(new ImageIcon("img/tunnelentrance_closed_down.png").getImage()
					.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
		}

		label.setIcon(closedIcon);
		this.add(label, new Integer(0));
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
	}

	@Override
	public void click() {
		te.click();
		if(te.isOpen())
			label.setIcon(openIcon);
		else
			label.setIcon(closedIcon);
		this.repaint();
	}

	@Override
	public int getId() {
		return te.id;
	}

}
