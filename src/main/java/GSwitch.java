package main.java;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * A váltó osztály grafikus megjelenítéséhez szolgáló osztály
 */
@SuppressWarnings("serial")
public class GSwitch extends GElements {

	/**
	 * A megjelenítendö váltó
	 */
	Switch sw;
	JLabel label = new JLabel();
	/**
	 * Aktuális megjelenítendö icon
	 */
	ImageIcon imageIcon = null;
	/**
	 * Kattintásra következö icon
	 */
	ImageIcon nextIcon = null;

	/**
	 * Konstruktor mely megkapja a megjelenítendö váltó
	 * @param sw A megjelenítendö váltó
	 */
	public GSwitch(Switch sw) {
		int id = sw.getId();
		this.sw = sw;

		Point point = View.getPosition(id);
		x = point.x * View.TILE_WIDTH;
		y = point.y * View.TILE_HEIGHT;
		this.setBounds(x, y, View.TILE_WIDTH, View.TILE_HEIGHT + 5);
		this.setOpaque(false);

		// Lekérjük a szomszádokat hogy beállítsuk az állását
		ArrayList<Integer> neighbours = sw.getNeighbours();
		Point fix = View.getPosition(neighbours.get(0));
		Point active = View.getPosition(neighbours.get(1));
		Point inactive = View.getPosition(neighbours.get(2));

		// Vízszintes aktív-fel inaktív
		//   |
		// --X--
		// 
		if(id==62){
			System.out.println("");
		}
		if (inactive.y < point.y
				&& ((fix.x > point.x && active.x < point.x) || (fix.x < point.x && active.x > point.x))) {
			imageIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/switch_horizontal_up.png")).getImage()
					.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
			if(fix.x<point.x)
				nextIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/switch_leftup_horizontal.png")).getImage()
						.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
			else 
				nextIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/switch_rightup_horizontal.png")).getImage()
						.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
		}
		// Vízszintes aktív-le inaktív
		//	  --X--
		//		|
		else if(inactive.y > point.y && ((fix.x>point.x && active.x<point.x) || (fix.x<point.x && active.x>point.x))){
			imageIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/switch_horizontal_down.png")).getImage().getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
			if(fix.x<point.x)
				nextIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/switch_leftdown_horizontal.png")).getImage()
						.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
			else 
				nextIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/switch_rightdown_horizontal.png")).getImage()
						.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
		}
		
		// Függöleges aktív-jobb inaktív
		//		|
		//	    X--
		//		|
		else if(inactive.x > point.x && ((fix.y>point.y && active.y<point.y) || (fix.y<point.y && active.y>point.y))){
			imageIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/switch_vertical_right.png")).getImage().getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
			if(fix.y<point.y)
				nextIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/switch_rightup_vertical.png")).getImage()
						.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
			else 
				nextIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/switch_rightdown_vertical.png")).getImage()
						.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
		}
		
		// Függöleges aktív-bal inaktív
		//		|
		//	  --X
		//		|
		else if(inactive.x < point.x && ((fix.y>point.y && active.y<point.y) || (fix.y<point.y && active.y>point.y))){
			imageIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/switch_vertical_left.png")).getImage().getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
			if(fix.y<point.y)
				nextIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/switch_leftup_vertical.png")).getImage()
						.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
			else 
				nextIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/switch_leftdown_vertical.png")).getImage()
						.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
		}
		
		
		// balle aktív- vízszintes inaktív
		//	  --X--
		//		|
		else if(inactive.x > point.x && ((fix.x<point.x && active.y>point.y) || (fix.y>point.y && active.x<point.x))){
			imageIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/switch_leftdown_horizontal.png")).getImage().getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
			nextIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/switch_horizontal_down.png")).getImage()
					.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
		}
		// jobble aktív- vízszintes inaktív
		//	  --X--
		//		|
		else if(inactive.x < point.x && ((fix.x>point.x && active.y>point.y) || (fix.y>point.y && active.x>point.x))){
			imageIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/switch_rightdown_horizontal.png")).getImage().getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
			nextIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/switch_horizontal_down.png")).getImage()
					.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
		}
		// balfel aktív- vízszintes inaktív
		//		|
		//	  --X--
		else if(inactive.x > point.x && ((fix.x<point.x && active.y<point.y) || (fix.y<point.y && active.x<point.x))){
			imageIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/switch_leftup_horizontal.png")).getImage().getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
			nextIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/switch_horizontal_up.png")).getImage()
					.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
		}
		// jobbfel aktív- vízszintes inaktív
		//		|
		//	  --X--
		else if(inactive.x < point.x && ((fix.x>point.x && active.y<point.y) || (fix.y<point.y && active.x>point.x))){
			imageIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/switch_rightup_horizontal.png")).getImage().getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
			nextIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/switch_horizontal_up.png")).getImage()
					.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
		}
		// balfel aktív- függöleges inaktív
		//		|
		//	  --X
		//		|
		else if(inactive.y > point.y && ((fix.x<point.x && active.y<point.y) || (fix.y<point.y && active.x<point.x))){
			imageIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/switch_leftup_vertical.png")).getImage().getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
			nextIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/switch_vertical_left.png")).getImage()
					.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
		}
		// jobbfel aktív- függöleges inaktív
		//		|
		//	    X--
		//		|
		else if(inactive.y > point.y && ((fix.x>point.x && active.y<point.y) || (fix.y<point.y && active.x>point.x))){
			imageIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/switch_leftup_vertical.png")).getImage().getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
			nextIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/switch_vertical_right.png")).getImage()
					.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
		}
		// jobble aktív- függöleges inaktív
		//		|
		//	    X--
		//		|
		else if(inactive.y < point.y && ((fix.x>point.x && active.y>point.y) || (fix.y>point.y && active.x>point.x))){
			imageIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/switch_rightdown_vertical.png")).getImage().getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
			nextIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/switch_vertical_right.png")).getImage()
					.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
		}
		// balle aktív- függöleges inaktív
		//		|
		//	  --X
		//		|
		else if(inactive.y < point.y && ((fix.x<point.x && active.y>point.y) || (fix.y>point.y && active.x<point.x))){
			imageIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/switch_leftdown_vertical.png")).getImage().getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
			nextIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/switch_vertical_left.png")).getImage()
					.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
		}
		
		label.setIcon(imageIcon);
		this.add(label, new Integer(0));
	}

	@Override
	public void draw(Graphics g) {
		// Változást a kattintásban kezeljük
	}
	
	public int getId(){
		return sw.getId();
	}

	@Override
	public void click() {
		sw.click();
		if(!sw.occupied){
		ImageIcon temp = imageIcon;
		imageIcon = nextIcon;
		nextIcon = temp;
		label.setIcon(imageIcon);
		this.repaint();
		}
	}

}
