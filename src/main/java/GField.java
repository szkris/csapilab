package main.java;

import java.awt.Graphics;
/**
 * A mezö megjelenitéséül szolgáló osztály
 */
@SuppressWarnings("serial")
public class GField extends GElements {
	
	/**
	 * A tárolt mezö
	 */
	Field field;
	
	/**
	 * Konstruktor mely paraméterként megkapja a megjelenitendö mezöt
	 * @param field A megjelenitendö mezö
	 */
	public GField(Field field){
		this.field = field;
	}
	
	@Override
	public void draw(Graphics g) {
		//Kirajzolásnál nem kell semmi, a háttérkét látszódik csak
	}

	@Override
	public void click() {
		//Nincs kattintásra semmi
	}
	
	@Override
	public int getId(){
		return field.id;
	}

}
