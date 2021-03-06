package main.java;

/**
 * Utasokat sz�ll�t� vagont megval�s�t� oszt�ly
 */
public class Car extends TrainElement {

	/**
	 * L�trehoz egy Car elemet a megadott param�terekkel.
	 * 
	 * @param color
	 *            Sz�n.
	 * @param empty
	 *            �res-e.
	 * @param train
	 *            Elemet tartalamz� vonat.
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