package main.java;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Az állomás grafikus megjelenitéséért felelös osztály
 */
@SuppressWarnings("serial")
public class GStation extends GElements {

	/**
	 * A megjelenítendö állomás
	 */
	Station station;
	JLabel label = new JLabel();

	/**
	 * Konstruktor mely paraméterként megkapja a megjelenítendö állomást 
	 * @param station A megjelenitendö állomás
	 */
	public GStation(Station station) {
		int id = station.getId();
		this.station = station;

		ImageIcon imageIcon = null;
		Point point = View.getPosition(id);
		x = point.x * View.TILE_WIDTH;
		y = point.y * View.TILE_HEIGHT;
		this.setBounds(x, y, View.TILE_WIDTH, View.TILE_HEIGHT + 5);
		this.setOpaque(false);
		
		//Lekérdezzük a szomszédokat, ettöl függ merre fog állni az állomáson a sín
		ArrayList<Integer> neighbours = station.getNeighbours();
		Point neighbour1 = View.getPosition(neighbours.get(0));
		Point neighbour2 = View.getPosition(neighbours.get(1));

		//Beállítjuk a megfelelö képet
		if (neighbour1.x > point.x || neighbour2.x > point.x) {
			if (station.getColor().equals(Color.GREEN))
				imageIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/greenstation.png")).getImage()
						.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
			else if (station.getColor().equals(Color.RED))
				imageIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/redstation.png")).getImage()
						.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
			else if (station.getColor().equals(Color.BLUE))
				imageIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/bluestation.png")).getImage()
						.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
			else 
				imageIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/yellowstation.png")).getImage()
						.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
				
		} else {
			if (station.getColor().equals(Color.GREEN))
				imageIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/greenstation_vertical.png")).getImage()
						.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
			else if (station.getColor().equals(Color.RED))
				imageIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/redstation_vertical.png")).getImage()
						.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
			else if (station.getColor().equals(Color.BLUE))
				imageIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/bluestation_vertical.png")).getImage()
						.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
			else 
				imageIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/yellowstation_vertical.png")).getImage()
						.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
		}

		label.setIcon(imageIcon);
		this.add(label, new Integer(0));
	}

	@Override
	public void draw(Graphics g) {
		// Nem változik a megjelenítés
	}

	@Override
	public void click() {
		// Kattintásra nem történik semmi
	}

	@Override
	public int getId() {
		return station.id;
	}

}
