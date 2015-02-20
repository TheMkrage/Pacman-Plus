package org.pacman.plus.characters;

import java.awt.Dimension;
import java.awt.Graphics;

import org.pacman.plus.characters.ghosts.GhostAPI;
import org.pacman.plus.gameobject.GameObject;

public class GhostCharacter extends GameObject{

	GhostAPI api;
	Dimension setPoint;
	public GhostAPI getApi() {
		return api;
	}

	public void setApi(GhostAPI api) {
		this.api = api;
	}

	public GhostCharacter(int x, int y, String name, GhostAPI api) {
		super(x, y, name);
		setApi(api);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setPoint = api.getTarget();
		Dimension movingDirection = getDirectionToSetPoint();
		
		if (isCollidingWithWall()) {
			//moves back once, then stops
			move((int)movingDirection.width, (int)-movingDirection.height);
			
		}else {
			this.move(movingDirection.width, movingDirection.height);
		}
	}
	
	public void setSetPoint(Dimension d) {
		setPoint = d;
	}
	
	public Dimension getDirectionToSetPoint() {
		Dimension d;
		
		if(Math.abs(this.getX() - setPoint.getWidth()) > Math.abs(this.getY() - setPoint.getHeight())) {
			//we are moving on x
			if(this.getX() > setPoint.getWidth())
				d = new Dimension(-1, 0);
			else
				d = new Dimension(1, 0);
		}else {
			if(this.getY() > setPoint.getHeight())
				d = new Dimension(0, -1);
			else
				d = new Dimension(0, 1);
		}
		return d;
	}
	
	public double distanceBetween(Dimension one, Dimension two) {
		return Math.sqrt((Math.pow(one.getWidth(), 2) - Math.pow(two.getWidth(), 2)) + (Math.pow(one.getHeight(), 2) - Math.pow(two.getHeight(), 2)) );
	}
}
