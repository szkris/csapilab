import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
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

	public final static int TILE_HEIGHT = 100;
	public final static int TILE_WIDTH = 100;
	public static int COLUMN = 3;
	public static int ROW = 1;

	private Table tableCopy;
	private ArrayList<GElements> gelements;
	
	public View() {		
		super();
		
		JLabel background = new JLabel();
		background.setIcon(new ImageIcon(
				new ImageIcon("img/background.png").getImage().getScaledInstance(App.WIDTH, App.HEIGHT, Image.SCALE_DEFAULT)));
		background.setBounds(0, 0, App.WIDTH, App.HEIGHT);
		this.setLayout(null);
		this.add(background, new Integer(0));
		this.setPreferredSize(new Dimension(App.WIDTH, App.HEIGHT));

		/*JPanel top = new JPanel();
	    top.setBackground(Color.white);
	    top.setBounds(20, 20, 50, 50);
	    JButton middle = new JButton();
	    middle.setBackground(Color.gray);
	    middle.setBounds(40, 40, 50, 50);
	    JButton bottom = new JButton();
	    bottom.setBackground(Color.black);
	    bottom.setBounds(60, 60, 50, 50);
	    this.add(middle, new Integer(2));
	    this.add(top, new Integer(3));
	    this.add(bottom, new Integer(1));
		 */

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
		gelements = new ArrayList<GElements>();
		FileReader fr;
		int x = 0, y = 0;

		ArrayList<TableElement> list = tableCopy.getTableElements();
		for (TableElement te : list) {
			String type = te.getType();
			
			switch(type){
			case "rail":
				gelements.add(new GRail((Rail) te));
				break;
			case "field":
				gelements.add(new GField((Field) te));
				break;
			/*case "switch":
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
			*/
			default:
				break;
			}
		}
		for (GElements ge : gelements) {

			this.add(ge, new Integer(2));
		}
		this.validate();
	}

	public void drawAll() {
		this.repaint();
	}

	public void addTrain(Train t) {

	}

	public void click(int x, int y) {

	}
}
