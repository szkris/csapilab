package main.java;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 * Kocsi grafikát megvalósitó osztály
 */
@SuppressWarnings("serial")
public class GCar extends GElements {

	/**
	 * Az osztályhoz tartozó kocsi
	 */
	Car car = null;
	/**
	 * A kocsihoz tartozó szín
	 */
	Color color = null;
	/**
	 * Az osztály által használt képek.
	 */
	ImageIcon red = null;
	ImageIcon red_empty = null;
	ImageIcon blue = null;
	ImageIcon blue_empty = null;
	ImageIcon yellow = null;
	ImageIcon yellow_empty = null;
	ImageIcon green = null;
	ImageIcon green_empty = null;
	JLabel label = new JLabel();
	
	/**
	 * Konstruktor mely paraméterként átveszi az ábrázolandó kocsit 
	 * @param car Az ábrázolandó kocsi
	 */
	public GCar(Car car) {
		
		// Képek betöltése
		red = new ImageIcon(new ImageIcon(App.cl.getResource("img/car_red.png")).getImage()
				.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
		green = new ImageIcon(new ImageIcon(App.cl.getResource("img/car_green.png")).getImage()
				.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
		blue = new ImageIcon(new ImageIcon(App.cl.getResource("img/car_blue.png")).getImage()
				.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
		yellow = new ImageIcon(new ImageIcon(App.cl.getResource("img/car_yellow.png")).getImage()
				.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
		red_empty = new ImageIcon(new ImageIcon(App.cl.getResource("img/car_red_empty.png")).getImage()
				.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
		green_empty = new ImageIcon(new ImageIcon(App.cl.getResource("img/car_green_empty.png")).getImage()
				.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
		blue_empty = new ImageIcon(new ImageIcon(App.cl.getResource("img/car_blue_empty.png")).getImage()
				.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
	    yellow_empty = new ImageIcon(new ImageIcon(App.cl.getResource("img/car_yellow_empty.png")).getImage()
				.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
		
	    // Szín beoállítása
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
