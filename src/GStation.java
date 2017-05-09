import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GStation extends GElements {

	Station station;
	JLabel label = new JLabel();

	public GStation(Station station) {
		int id = station.getId();
		this.station = station;

		ImageIcon imageIcon = null;
		Point point = View.getPosition(id);
		x = point.x * View.TILE_WIDTH;
		y = point.y * View.TILE_HEIGHT;
		this.setBounds(x, y, View.TILE_WIDTH, View.TILE_HEIGHT + 5);
		this.setOpaque(false);
		ArrayList<Integer> neighbours = station.getNeighbours();
		Point neighbour1 = View.getPosition(neighbours.get(0));
		Point neighbour2 = View.getPosition(neighbours.get(1));

		if (neighbour1.x > point.x || neighbour2.x > point.x) {
			if (station.getColor().equals(Color.GREEN))
				imageIcon = new ImageIcon(new ImageIcon("img/greenstation.png").getImage()
						.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
			else if (station.getColor().equals(Color.RED))
				imageIcon = new ImageIcon(new ImageIcon("img/redstation.png").getImage()
						.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
			else if (station.getColor().equals(Color.BLUE))
				imageIcon = new ImageIcon(new ImageIcon("img/bluestation.png").getImage()
						.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
			else 
				imageIcon = new ImageIcon(new ImageIcon("img/yellowstation.png").getImage()
						.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
				
		} else {
			if (station.getColor().equals(Color.GREEN))
				imageIcon = new ImageIcon(new ImageIcon("img/greenstation_vertical.png").getImage()
						.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
			else if (station.getColor().equals(Color.RED))
				imageIcon = new ImageIcon(new ImageIcon("img/redstation_vertical.png").getImage()
						.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
			else if (station.getColor().equals(Color.BLUE))
				imageIcon = new ImageIcon(new ImageIcon("img/bluestation_vertical.png").getImage()
						.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
			else 
				imageIcon = new ImageIcon(new ImageIcon("img/yellowstation_vertical.png").getImage()
						.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
		}

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
	public int getId() {
		return station.id;
	}

}
