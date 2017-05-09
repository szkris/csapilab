import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GCar extends GElements {

	Car car = null;
	Color color = null;
	private static ImageIcon red = new ImageIcon(new ImageIcon("img/car_red.png").getImage()
			.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
	private static ImageIcon green = new ImageIcon(new ImageIcon("img/car_green.png").getImage()
			.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
	private static ImageIcon blue = new ImageIcon(new ImageIcon("img/car_blue.png").getImage()
			.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
	private static ImageIcon yellow = new ImageIcon(new ImageIcon("img/car_yellow.png").getImage()
			.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
	private static ImageIcon red_empty = new ImageIcon(new ImageIcon("img/car_red_empty.png").getImage()
			.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
	private static ImageIcon green_empty = new ImageIcon(new ImageIcon("img/car_green_empty.png").getImage()
			.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
	private static ImageIcon blue_empty = new ImageIcon(new ImageIcon("img/car_blue_empty.png").getImage()
			.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
	private static ImageIcon yellow_empty = new ImageIcon(new ImageIcon("img/car_yellow_empty.png").getImage()
			.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
	JLabel label = new JLabel();

	public GCar(Car car) {

		this.car = car;
		switch (car.getColor()) {
		case RED:
			this.label.setIcon(red);
			this.color = Color.RED;
			break;
		case BLUE:
			this.label.setIcon(blue);
			this.color = Color.BLUE;
			break;
		case YELLOW:
			this.label.setIcon(yellow);
			this.color = Color.YELLOW;
			break;
		case GREEN:
			this.label.setIcon(green);
			this.color = Color.GREEN;
			break;
		}

		this.setOpaque(false);
		this.add(label, new Integer(0));
	}

	@Override
	public void draw(Graphics g) {
		if (car.getcurrentTableElement() != null) {	
			if (car.isEmpty()) {
				if (color.equals(Color.RED))
					this.label.setIcon(red_empty);
				else if (color.equals(Color.BLUE))
					this.label.setIcon(blue_empty);
				else if (color.equals(Color.GREEN))
					this.label.setIcon(green_empty);
				else
					this.label.setIcon(yellow_empty);
			} else {
				if (color.equals(Color.RED))
					this.label.setIcon(red);
				else if (color.equals(Color.BLUE))
					this.label.setIcon(blue);
				else if (color.equals(Color.GREEN))
					this.label.setIcon(green);
				else
					this.label.setIcon(yellow);
			}
			int id = car.getcurrentTableElement().getId();
			Point point = View.getPosition(id);
			x = point.x * View.TILE_WIDTH;
			y = point.y * View.TILE_HEIGHT;
			if (car.isVisible())
				this.setBounds(x, y, View.TILE_WIDTH, View.TILE_HEIGHT + View.TILE_HEIGHT/25);
			else
				this.setBounds(0, 0, 0, 0);
			this.validate();
			this.repaint();
		}
	}

	@Override
	public void click() {
	}

	@Override
	public int getId() {
		return 0;
	}

}
