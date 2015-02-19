package org.pacman.plus.characters;

import java.awt.Graphics;

import org.pacman.plus.detectors.WallCollisionDetector;
import org.pacman.plus.gameobject.GameObject;
import org.pacman.plus.main.GameFrame;

public class PacmanCharacter extends GameObject {

	
	public PacmanCharacter(int x, int y, String name) {
		super(x, y, name);
		// TODO Auto-generated constructor stub
	}

	public PacmanCharacter(String name) {
		super(name);
	}



	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (isCollidingWithWall()) {
			//moves back once, then stops
			move((int)-this.getLastDirection().getWidth(), (int)-this.getLastDirection().getHeight());
			stop();
		}
	}
}
