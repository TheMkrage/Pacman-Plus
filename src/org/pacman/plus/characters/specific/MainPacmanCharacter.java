package org.pacman.plus.characters.specific;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import org.pacman.plus.characters.PacmanCharacter;
import org.pacman.plus.keylisteners.BasicKeyListener;

public class MainPacmanCharacter extends PacmanCharacter {

	private static MainPacmanCharacter instance;

	private static final int STARTING_X = 464;
	private static final int STARTING_Y = 491;
	private static final String IMAGE_NAME = "alien1.png";

	public static MainPacmanCharacter getInstance() {
		if (instance == null) {
			instance = new MainPacmanCharacter(STARTING_X, STARTING_Y,
					IMAGE_NAME);
		}
		return instance;
	}

	private MainPacmanCharacter(int x, int y, String name) {
		super(x, y, name);
		System.out.println("ADDED");
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// if(this.isCollidingWithWall()){
		// this.stop();
		// }
	}
}
