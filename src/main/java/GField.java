package main.java;

import java.awt.Graphics;
/**
 * A mez� megjelenit�s��l szolg�l� oszt�ly
 */
@SuppressWarnings("serial")
public class GField extends GElements {
	
	/**
	 * A t�rolt mez�
	 */
	Field field;
	
	/**
	 * Konstruktor mely param�terk�nt megkapja a megjelenitend� mez�t
	 * @param field A megjelenitend� mez�
	 */
	public GField(Field field){
		this.field = field;
	}
	
	@Override
	public void draw(Graphics g) {
		//Kirajzol�sn�l nem kell semmi, a h�tt�rk�t l�tsz�dik csak
	}

	@Override
	public void click() {
		//Nincs kattint�sra semmi
	}
	
	@Override
	public int getId(){
		return field.id;
	}

}
