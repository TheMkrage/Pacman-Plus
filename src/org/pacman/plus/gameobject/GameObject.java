package org.pacman.plus.gameobject;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GameObject extends JPanel{

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
		update();
	}
	
	public Rectangle getBounds() {
		return rect;
	}
	
	private void update() {
		this.setBounds(rect);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img.getImage(), 0, 0, null);
	}

}
