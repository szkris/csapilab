package main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;

import java.awt.Color;
import java.awt.Dimension;

public class GRail extends GElements {

	Rail rail;
	JLabel label = new JLabel();
	
	public GRail(Rail rail){
		int id = rail.getId();
		this.rail = rail;

		Point point = View.getPosition(id);
		x = point.x*View.TILE_WIDTH;
		y = point.y*View.TILE_HEIGHT;
		this.setBounds(x, y, View.TILE_WIDTH, View.TILE_HEIGHT+5);
		this.setOpaque(false);
		
		
		ImageIcon imageIcon = null;
		ArrayList<Integer> neighbours = rail.getNeighbours();
		Point neighbour1 = View.getPosition(neighbours.get(0));
		Point neighbour2 = View.getPosition(neighbours.get(1));
		
		// Függöleges
		// 		|
		//		X
		//		|
		if(neighbour1.y>point.y && neighbour2.y<point.y || (neighbour2.y>point.y && neighbour1.y<point.y)){
			imageIcon = new ImageIcon(new ImageIcon("img/rail_vertical.png").getImage().getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
		}
		// Vízszintes
		//	  --X--
		else if(neighbour1.x>point.x && neighbour2.x<point.x || (neighbour2.x>point.x && neighbour1.x<point.x)){
			imageIcon = new ImageIcon(new ImageIcon("img/rail_horizontal.png").getImage().getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
		}
		// jobble kanyar
		// 		X--
		// 		|
		else if((neighbour1.x>point.x && neighbour2.y>point.y) || (neighbour2.x>point.x && neighbour1.y>point.y)){
			imageIcon = new ImageIcon(new ImageIcon("img/rail_rightdown.png").getImage().getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
		} 
		// balle kanyar
		//	  --X
		//		|
		else if(neighbour1.x<point.x && neighbour2.y>point.y || (neighbour2.x<point.x && neighbour1.y>point.y)){
			imageIcon = new ImageIcon(new ImageIcon("img/rail_leftdown.png").getImage().getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
		} 
		// jobbffel kanyar
		// 		|
		//		X--
		else if(neighbour1.x>point.x && neighbour2.y<point.y || (neighbour2.x>point.x && neighbour1.y<point.y)){
			imageIcon = new ImageIcon(new ImageIcon("img/rail_rightup.png").getImage().getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
		}
		// balffel kanyar
		// 		|
		//	  --X
		else if(neighbour1.x<point.x && neighbour2.y<point.y || (neighbour2.x<point.x && neighbour1.y<point.y)){
			imageIcon = new ImageIcon(new ImageIcon("img/rail_leftup.png").getImage().getScaledInstance(View.TILE_WIDTH, View.TILE_HEIGHT, Image.SCALE_DEFAULT));
		}
		label.setIcon(imageIcon);
		
		
		this.add(label, new Integer(0));
	}

	@Override
	public void click() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public int getId(){
		return rail.id;
	}

	@Override
	public void draw(Graphics g) {
	}

}
