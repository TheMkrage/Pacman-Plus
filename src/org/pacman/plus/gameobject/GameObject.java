package org.pacman.plus.gameobject;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class GameObject {

	private Rectangle rect;
	private ImageIcon img;

	public GameObject(String name) {
		rect = new Rectangle();
		rect.setLocation(0, 0);
		java.net.URL imgUrl = getClass().getResource(name);
		img = new ImageIcon(imgUrl);
	}

	public GameObject(int x, int y, String name) {
		rect = new Rectangle();
		rect.setLocation(x, y);

		java.net.URL imgUrl = getClass().getResource(name);
		img = new ImageIcon(imgUrl);
	}

	public int getWidth() {
		return img.getIconWidth();
	}

	public int getHeight() {
		return img.getIconHeight();
	}

	public int getX() {

		return rect.x;

	}

	public int getY() {
		return rect.y;
	}

	public ImageIcon getImage() {
		return img;
	}

	public void move(int xRate, int yRate) {
		rect.setBounds(rect.x + xRate, rect.y + yRate, rect.width, rect.height);
	}

}
