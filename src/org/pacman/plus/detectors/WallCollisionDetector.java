package org.pacman.plus.detectors;

import java.awt.Rectangle;
import java.util.ArrayList;

import org.omg.CORBA.Bounds;
import org.pacman.plus.gameobject.GameObject;
import org.pacman.plus.gameobject.course.Wall;

public class WallCollisionDetector {

	private static ArrayList<Wall> walls;

	public static boolean isBoundsTouchingWall(Rectangle bounds) {
		boolean isTouching = false;
		for(Wall w: walls) {
			if(bounds.intersects(w.getBounds())) {
				isTouching = true;
			}
		}
		return isTouching;
	}
	
	public static void addWall(Wall wall) {
		walls.add(wall);
	}
}
