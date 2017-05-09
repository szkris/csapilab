package main.java;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Az �llom�s grafikus megjelenit�s��rt felel�s oszt�ly
 */
@SuppressWarnings("serial")
public class GStation extends GElements {

	/**
	 * A megjelen�tend� �llom�s
	 */
	Station station;
	JLabel label = new JLabel();

	/**
	 * Konstruktor mely param�terk�nt megkapja a megjelen�tend� �llom�st 
	 * @param station A megjelenitend� �llom�s
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
		
		//Lek�rdezz�k a szomsz�dokat, ett�l f�gg merre fog �llni az �llom�son a s�n
		ArrayList<Integer> neighbours = station.getNeighbours();
		Point neighbour1 = View.getPosition(neighbours.get(0));
		Point neighbour2 = View.getPosition(neighbours.get(1));

		//Be�ll�tjuk a megfelel� k�pet
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
		// Nem v�ltozik a megjelen�t�s
	}

	@Override
	public void click() {
		// Kattint�sra nem t�rt�nik semmi
	}

	@Override
	public int getId() {
		return station.id;
	}

}
