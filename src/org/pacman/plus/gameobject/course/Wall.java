package org.pacman.plus.gameobject.course;

import java.awt.Graphics;

import org.pacman.plus.detectors.WallCollisionDetector;
import org.pacman.plus.gameobject.GameObject;

public class Wall extends GameObject{

	public Wall(int x, int y, String name) {
		super(x, y, name);
		WallCollisionDetector.addWall(this);
	}

	public Wall(String name) {
		super(name);
		WallCollisionDetector.addWall(this);
	}

	public Wall(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
}
