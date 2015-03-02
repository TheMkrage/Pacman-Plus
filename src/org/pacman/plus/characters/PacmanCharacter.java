package org.pacman.plus.characters;

import java.awt.Graphics;
import java.awt.Rectangle;

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
			// moves back once, then stops
			move((int) -this.getLastDirection().getWidth(), (int) -this
					.getLastDirection().getHeight());
			stop();
		}
	}

	public void setContiniousMovement(int xRate, int yRate) {
		if ((xRate != pastXRate || yRate != pastYRate)) {
			
			if (isFacingRight()) {
				System.out.println("FACING RIGJT");
				if (yRate > 0) {
					int least = 0;
					for (int i = 0; i < 40; i++) {
						System.out.println("FDSAF");
						if (WallCollisionDetector
								.isBoundsTouchingWall(new Rectangle(this.getX()
										+ i + 1, this.getY() + 45))) {
							System.out.println("THING");
							if (i < least) {
								least = i;
							}
						}
					}
				}
			}
			super.setContiniousMovement(xRate, yRate);
		}
		
	}
}
