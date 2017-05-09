package main.java;

import java.util.*;

/**
 * Utasokat szállító vagont megvalósító osztály
 */
public class Car extends TrainElement {

	/**
	 * Létrehoz egy Car elemet a megadott paraméterekkel.
	 * 
	 * @param color
	 *            Szín.
	 * @param empty
	 *            Üres-e.
	 * @param train
	 *            Elemet tartalamzó vonat.
	 */
	public Car(Color color, boolean empty, Train train) {
		super(color, empty, train);
		type = "car";
	}

	@Override
	public void hopOff(Color color) {
		if (isEmpty() || this.getColor() != color)
			return;
		train.hopOff(color, this);
	}

	@Override
	public void hopOn(Color color) {
		if (color != getColor() || !isEmpty())
			return;
		changeEmpty();
	}
}