package main;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class View extends JPanel {

	public static int COLUMN = 0;
	public static int ROW = 0;
	public static int TILE_HEIGHT = 0;
	public static int TILE_WIDTH = 0;

	private Table tableCopy;
	private ArrayList<GElements> gelements;
	private ArrayList<GElements> trainelements;
	JLabel background = new JLabel();

	public View() {
		super();
		this.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				click(e.getX(), e.getY());
			}
		});

		background.setIcon(new ImageIcon(new ImageIcon("img/grass.png").getImage().getScaledInstance(App.WIDTH,
				App.HEIGHT, Image.SCALE_DEFAULT)));
		background.setBounds(0, 0, App.WIDTH, App.HEIGHT);
		this.setLayout(null);
		this.setPreferredSize(new Dimension(App.WIDTH, App.HEIGHT));
	}

	/**
	 * 
	 * @param table
	 */
	public void setTable(Table table) {
		tableCopy = table;
	}

	/**
	 * 
	 * @param id
	 */
	public void loadMap(int id) {
		this.removeAll();
		this.add(background, new Integer(0), -1);
		ROW = tableCopy.row;
		COLUMN = tableCopy.column;
		if (ROW != 0 && COLUMN != 0) {
			TILE_HEIGHT = App.HEIGHT / ROW;
			TILE_WIDTH = App.WIDTH / COLUMN;
		}
		gelements = new ArrayList<GElements>();
		trainelements = new ArrayList<GElements>();
		FileReader fr;
		int x = 0, y = 0;
		
		ArrayList<TableElement> list = tableCopy.getTableElements();
		for (TableElement te : list) {
			String type = te.getType();

			switch (type) {
			case "rail":
				gelements.add(new GRail((Rail) te));
				break;
			case "field":
				gelements.add(new GField((Field) te));
				break;
			case "switch":
				gelements.add(new GSwitch((Switch) te));
				break;
			case "crossing":
				gelements.add(new GCrossing((Crossing) te));
				break;
			case "station":
				gelements.add(new GStation((Station) te));
				break;
			case "tunnelentrance":
				gelements.add(new GTunnelEntrance((TunnelEntrance) te));
				break;
			default:
				break;
			}
		}
		for (GElements ge : gelements) {
			this.add(ge, new Integer(2), 0);
		}

		for (Train train : tableCopy.getTrains()) {
			for (TrainElement traine : train.getElements()) {
				switch (traine.getType()) {
				case ("locomotive"):
					trainelements.add(new GLocomotive((Locomotive) traine));
					break;
				case ("coalwagon"):
					trainelements.add(new GCoalWagon((CoalWagon)traine));
					break;
				case ("car"):
					trainelements.add(new GCar((Car)traine));
					break;
				}
			}
		}

		for (GElements gElements : trainelements) {
			this.add(gElements, new Integer(4), 0);
		}
		this.validate();
	}

	/**
	 * Megadja, hogy az adott index milyen oszlopban és sorban szerepel
	 * 
	 * @param index
	 * @return
	 */
	public static Point getPosition(int index) {
		Point point = new Point();
		int row = (int) ((index - 1) / COLUMN);
		int column = index - 1 - row * COLUMN;

		point.setLocation(column, row);
		return point;
	}

	public void drawAll() {
		for (GElements ge : trainelements) {
			ge.draw(this.getGraphics());
		}
		this.repaint();
	}

	public void click(int x, int y) {

		int row = y / TILE_HEIGHT;
		int column = x / TILE_WIDTH;

		// 0->N-1
		// 1->N
		int index = row * ROW + column + 1;
		for (GElements ge : gelements) {
			if (ge.getId() == index) {
				ge.click();
				break;
			}
		}
	}
}