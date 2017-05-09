package main.java;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Az alagútbejárat grafikus megjelenítését szolgáló osztály
 */
@SuppressWarnings("serial")
public class GTunnelEntrance extends GElements {

	/**
	 * A megjelenítendö alagútbejárat
	 */
	TunnelEntrance te;
	JLabel label = new JLabel();
	ImageIcon openIcon = null;
	ImageIcon closedIcon = null;

	/**
	 * Konstruktor mely megkapja a megjelenítendö alagútbejáratot
	 * @param te A megjelenítendö alagútbejárat
	 */
	public GTunnelEntrance(TunnelEntrance te) {
		int id = te.getId();
		this.te = te;

		Point point = View.getPosition(id);
		x = point.x * View.TILE_WIDTH;
		y = point.y * View.TILE_HEIGHT;
		this.setBounds(x, y, View.TILE_WIDTH, View.TILE_HEIGHT + 5);
		this.setOpaque(false);
		// Lekérdezzük a szomszédot, hogy megtudjuk merre kell állnia az alagútbejáratnak
		ArrayList<Integer> neighbours = te.getNeighbours();
		Point neighbourrail = View.getPosition(neighbours.get(0));

		// Beállítjuk a megfelelö képet
		if (neighbourrail.x > point.x) {
			openIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/tunnelentrance_open_right.png")).getImage()
					.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
			closedIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/tunnelentrance_closed_right.png")).getImage()
					.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));

		} else if (neighbourrail.x < point.x) {
			openIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/tunnelentrance_open_left.png")).getImage()
					.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
			closedIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/tunnelentrance_closed_left.png")).getImage()
					.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
		} else if (neighbourrail.y < point.y) {
			openIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/tunnelentrance_open_up.png")).getImage()
					.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
			closedIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/tunnelentrance_closed_up.png")).getImage()
					.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));

		} else if (neighbourrail.y > point.y) {

			openIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/tunnelentrance_open_down.png")).getImage()
					.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
			closedIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/tunnelentrance_closed_down.png")).getImage()
					.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
		}

		label.setIcon(closedIcon);
		this.add(label, new Integer(0));
	}

	@Override
	public void draw(Graphics g) {
		//Kattintásra változtatjuk a grafikát
	}

	@Override
	public void click() {
		// Ha nyitva volt és változott az állapot akkor bezárjuk, ha forditva akkor kinyitjuk
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
