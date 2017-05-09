package main.java;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A megjelen�t�seket kezel� oszt�ly  
 */
@SuppressWarnings("serial")
public class View extends JPanel {

	/**
	 * Oszlopok sz�ma
	 */
	public static int COLUMN = 0;
	/**
	 * Sorok sz�ma
	 */
	public static int ROW = 0;
	/**
	 * Egy mez� sz�less�ge �s magass�ga
	 */
	public static int TILE_HEIGHT = 0;
	public static int TILE_WIDTH = 0;

	/**
	 * Az aktu�lis t�bla
	 */
	private Table tableCopy;
	/**
	 * A megjelen�tend� t�blaelemek grafikus oszt�lyai
	 */
	private ArrayList<GElements> gelements;
	/**
	 * A megjelen�tend� vonatelemek grafikus oszt�lyai
	 */
	private ArrayList<GElements> trainelements;
	/**
	 * H�tt�rk�p
	 */
	JLabel background = new JLabel();

	/**
	 * Konstruktor
	 */
	public View() {
		super();
		// L�trehozzuk a kattint�st �rz�kel� mouselistenert, ami �tadja a click f�ggv�nynek a koordin�t�it
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
		
		background.setIcon(new ImageIcon(new ImageIcon(App.cl.getResource("img/grass.png")).getImage().getScaledInstance(App.WIDTH,
				App.HEIGHT, Image.SCALE_DEFAULT)));
		background.setBounds(0, 0, App.WIDTH, App.HEIGHT);
		this.setLayout(null);
		this.setPreferredSize(new Dimension(App.WIDTH, App.HEIGHT));
	}

	/**
	 * Be�ll�tja a haszn�latban l�v� p�ly�t
	 * @param table A jelenlegi p�lya
	 */
	public void setTable(Table table) {
		tableCopy = table;
	}

	/**
	 * Bet�lti a megadott azonos�t�val rendelkez� p�ly�t
	 * @param id A p�lya azonos�t�ja
	 */
	@SuppressWarnings("static-access")
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
		
		//L�trehozzuk a grafikus oszt�lyokat a t�blaelemekhez
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
		// Hozz�adjuk �ket a panelhez
		for (GElements ge : gelements) {
			this.add(ge, new Integer(2), 0);
		}

		// L�trehozzuk a megjelen�tend� vonatelemekhez tartoz� grafikus oszt�lyokat
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

		// Hozz�adjuk �ket egy panelhez
		for (GElements gElements : trainelements) {
			this.add(gElements, new Integer(4), 0);
		}
		this.validate();
	}

	/**
	 * Megadja, hogy az adott index milyen oszlopban �s sorban szerepel
	 * 
	 * @param index A p�lyaelem indexe
	 * @return Az index helye x: sor y: oszlop
	 */
	public static Point getPosition(int index) {
		Point point = new Point();
		int row = (int) ((index - 1) / COLUMN);
		int column = index - 1 - row * COLUMN;

		point.setLocation(column, row);
		return point;
	}

	/**
	 * Kiralyzolja a vonatelemeket az �j poz�ci�jukba
	 */
	public void drawAll() {
		for (GElements ge : trainelements) {
			ge.draw(this.getGraphics());
		}
		this.repaint();
	}

	/**
	 * �tkonvertelja a megadott x, y koordin�t�t index� 
	 * �s megh�vja az adott index� t�blaelemhez tartoz� grafikus oszt�ly clikk f�ggv�ny�t
	 * @param x X koodin�ta
	 * @param y Y koordin�ta
	 */
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