package org.pacman.plus.characters;

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

	public boolean isCollidingWithWall() {
		if(this.getBounds().intersects(GameFrame.getInstance().rect.getBounds())) {
			return true;
		}
		return false;
	}
}
