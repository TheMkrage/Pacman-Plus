package org.pacman.plus.gameobject.course;

import org.pacman.plus.gameobject.GameObject;

public class Wall extends GameObject{

	public Wall(int x, int y, String name) {
		super(x, y, name);
	}

	public Wall(String name) {
		super(name);
	}
}
