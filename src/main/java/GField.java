package main.java;

import java.awt.Graphics;

public class GField extends GElements {

	Field field;
	
	public GField(Field field, int x, int y){
		super(x,y);
		this.field = field;
	}
	
	public GField(Field field){
		this.field = field;
	}
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub

	}

	@Override
	public void click() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public int getId(){
		return field.id;
	}

}
