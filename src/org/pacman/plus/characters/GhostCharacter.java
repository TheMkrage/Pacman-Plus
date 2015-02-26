package org.pacman.plus.characters;

import java.awt.Dimension;
import java.awt.Graphics;

import org.pacman.plus.characters.ghosts.GhostAPI;
import org.pacman.plus.gameobject.GameObject;

public class GhostCharacter extends GameObject {

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

	public void setContiniousMovement(int xRate, int yRate) {
		System.out.println("Xrate: " + xRate + " YRate: " + yRate);
		System.out.println("Prate: " + -pastXRate + " Prate: " + -pastYRate);
		if ((xRate == -pastXRate)) {
			System.out.println("no move");
			if ((xRate != 0 && yRate == 0)) {
				System.out.println("HERE WED HO");
				return;
			}
		}else if(yRate == -pastYRate) {
			if((yRate != 0 && xRate == 0)) {
				return;
			}
		}

		super.setContiniousMovement(xRate, yRate);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setPoint = api.getTarget();
		Dimension movingDirection = getDirectionToSetPoint();

		this.setContiniousMovement(movingDirection.width,
				movingDirection.height);
	}

	public void setSetPoint(Dimension d) {
		setPoint = d;
	}

	public Dimension getDirectionToSetPoint() {
		Dimension d;

		if (Math.abs(this.getX() - setPoint.getWidth()) > Math.abs(this.getY()
				- setPoint.getHeight())) {
			// we are moving on x
			if (this.getX() > setPoint.getWidth())
				d = new Dimension(-1, 0);
			else
				d = new Dimension(1, 0);
		} else {
			if (this.getY() > setPoint.getHeight())
				d = new Dimension(0, -1);
			else
				d = new Dimension(0, 1);
		}

		// if there is anyWall present
		if (isTouchingAnyWall()) {
			System.out.println("YAYWOALL");
			// if wall below and i need to go down
			if (isWallBelow()) {
				System.out.println("Wall is below");
				System.out.println("I am above the setpoint");
				// left or right?
				if (this.getX() > setPoint.getWidth())
					d = new Dimension(-1, 0);
				else
					d = new Dimension(1, 0);
			}else {
				System.out.println("NO BOTTOM WALL");
			}
		} else
			System.out.println("NO wall");
		return d;
	}

	public double distanceBetween(Dimension one, Dimension two) {
		return Math
				.sqrt((Math.pow(one.getWidth(), 2) - Math.pow(two.getWidth(), 2))
						+ (Math.pow(one.getHeight(), 2) - Math.pow(
								two.getHeight(), 2)));
	}
	
	
}
