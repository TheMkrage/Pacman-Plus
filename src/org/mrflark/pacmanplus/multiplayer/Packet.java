package org.mrflark.pacmanplus.multiplayer;

import java.io.Serializable;

public class Packet implements Serializable {
	private static final long serialVersionUID = 7875508046193172177L;
	private int x, y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Packet(int x, int y) {
		this.x = x;
		this.y = y;
	}
}