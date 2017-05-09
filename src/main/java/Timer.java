package main.java;


import java.util.*;

/**
 * Id�zit�t megval�st� oszt�ly
 */
public class Timer {

	java.util.Timer timer;
	
	/**
	 * Konstruktor, mely �tvesz egy j�t�k oszt�ly elemet.
	 * @param game A j�t�k, amelynek a timer-t sz�njuk.
	 */
	public Timer(Game game) {
		this.game = game;
	}

	/**
	 * A timerhez tartoz� j�t�kmenet
	 */
	private Game game;

	/**
	 * Elind�tja az id�zit�t
	 */
	public void start() {
		timer = new java.util.Timer(false);
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				try{
					game.move();					
				} catch(Exception e){
					//e.printStackTrace();
				}
			}
		};
		timer.schedule(task, 0, 1000);
	}

	/**
	 * Le�ll�tja az id�z�t�t
	 */
	public void stop() {
		timer.cancel();
	}
}