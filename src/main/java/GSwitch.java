package main.java;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * A v�lt� oszt�ly grafikus megjelen�t�s�hez szolg�l� oszt�ly
 */
@SuppressWarnings("serial")
public class GSwitch extends GElements {

	/**
	 * A megjelen�tend� v�lt�
	 */
	Switch sw;
	JLabel label = new JLabel();
	/**
	 * Aktu�lis megjelen�tend� icon
	 */
	ImageIcon imageIcon = null;
	/**
	 * Kattint�sra k�vetkez� icon
	 */
	ImageIcon nextIcon = null;

	/**
	 * Konstruktor mely megkapja a megjelen�tend� v�lt�
	 * @param sw A megjelen�tend� v�lt�
	 */
	public GSwitch(Switch sw) {
		int id = sw.getId();
		this.sw = sw;

		Point point = View.getPosition(id);
		x = point.x * View.TILE_WIDTH;
		y = point.y * View.TILE_HEIGHT;
		this.setBounds(x, y, View.TILE_WIDTH, View.TILE_HEIGHT + 5);
		this.setOpaque(false);

		// Lek�rj�k a szomsz�dokat hogy be�ll�tsuk az �ll�s�t
		ArrayList<Integer> neighbours = sw.getNeighbours();
		Point fix = View.getPosition(neighbours.get(0));
		Point active = View.getPosition(neighbours.get(1));
		Point inactive = View.getPosition(neighbours.get(2));

		// V�zszintes akt�v-fel inakt�v
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
		// V�zszintes akt�v-le inakt�v
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
		
		// F�gg�leges akt�v-jobb inakt�v
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
		
		// F�gg�leges akt�v-bal inakt�v
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
		
		
		// balle akt�v- v�zszintes inakt�v
		//	  --X--
		//		|
		else if(inactive.x > point.x && ((fix.x<point.x && active.y>point.y) || (fix.y>point.y && active.x<point.x))){
			imageIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/switch_leftdown_horizontal.png")).getImage().getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
			nextIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/switch_horizontal_down.png")).getImage()
					.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
		}
		// jobble akt�v- v�zszintes inakt�v
		//	  --X--
		//		|
		else if(inactive.x < point.x && ((fix.x>point.x && active.y>point.y) || (fix.y>point.y && active.x>point.x))){
			imageIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/switch_rightdown_horizontal.png")).getImage().getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
			nextIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/switch_horizontal_down.png")).getImage()
					.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
		}
		// balfel akt�v- v�zszintes inakt�v
		//		|
		//	  --X--
		else if(inactive.x > point.x && ((fix.x<point.x && active.y<point.y) || (fix.y<point.y && active.x<point.x))){
			imageIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/switch_leftup_horizontal.png")).getImage().getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
			nextIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/switch_horizontal_up.png")).getImage()
					.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
		}
		// jobbfel akt�v- v�zszintes inakt�v
		//		|
		//	  --X--
		else if(inactive.x < point.x && ((fix.x>point.x && active.y<point.y) || (fix.y<point.y && active.x>point.x))){
			imageIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/switch_rightup_horizontal.png")).getImage().getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
			nextIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/switch_horizontal_up.png")).getImage()
					.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
		}
		// balfel akt�v- f�gg�leges inakt�v
		//		|
		//	  --X
		//		|
		else if(inactive.y > point.y && ((fix.x<point.x && active.y<point.y) || (fix.y<point.y && active.x<point.x))){
			imageIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/switch_leftup_vertical.png")).getImage().getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
			nextIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/switch_vertical_left.png")).getImage()
					.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
		}
		// jobbfel akt�v- f�gg�leges inakt�v
		//		|
		//	    X--
		//		|
		else if(inactive.y > point.y && ((fix.x>point.x && active.y<point.y) || (fix.y<point.y && active.x>point.x))){
			imageIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/switch_leftup_vertical.png")).getImage().getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
			nextIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/switch_vertical_right.png")).getImage()
					.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
		}
		// jobble akt�v- f�gg�leges inakt�v
		//		|
		//	    X--
		//		|
		else if(inactive.y < point.y && ((fix.x>point.x && active.y>point.y) || (fix.y>point.y && active.x>point.x))){
			imageIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/switch_rightdown_vertical.png")).getImage().getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
			nextIcon = new ImageIcon(new ImageIcon(App.cl.getResource("img/switch_vertical_right.png")).getImage()
					.getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
		}
		// balle akt�v- f�gg�leges inakt�v
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
		// V�ltoz�st a kattint�sban kezelj�k
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
