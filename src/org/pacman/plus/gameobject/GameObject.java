package org.pacman.plus.gameobject;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GameObject extends JPanel {

	private Rectangle rect;
	private ImageIcon img;
	private int xRate = 0;
	private int yRate = 0;
	//the last direction the pacman was going
	private Dimension lastDirection = new Dimension(0 ,0);
	
	public GameObject(String name) {
		rect = new Rectangle();
		rect.setLocation(0, 0);

		URL imgUrl = getClass().getResource(name);
		img = new ImageIcon(imgUrl);
		rect.setSize(img.getIconWidth(), img.getIconHeight());
	}

	public GameObject(int x, int y, String name) {
		rect = new Rectangle();
		rect.setLocation(x, y);

		URL imgUrl = getClass().getResource(name);
		img = new ImageIcon(imgUrl);
		rect.setSize(img.getIconWidth(), img.getIconHeight());
	}

	public GameObject(int x, int y, int width, int height, String name) {
		rect = new Rectangle();
		rect.setBounds(x, y, width, height);

		URL imgUrl = getClass().getResource(name);
		img = new ImageIcon(imgUrl);
	}

	public GameObject(int x, int y, int width, int height) {
		rect = new Rectangle();
		setLocation(x, y);
		rect.setSize(width, height);
	}

	public int getWidth() {

		return rect.width;

	}

	public int getHeight() {

		return rect.height;

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

	public void setContiniousMovement(int xRate, int yRate) {
		this.xRate = xRate;
		this.yRate = yRate;
	}

	public void stop() {
		move(0, 0);
		setContiniousMovement(0, 0);
	}

	private void update() {
		setBounds(rect);
		if(xRate != 0) {
			lastDirection = new Dimension(xRate, 0);
		}else if( yRate != 0) {
			lastDirection = new Dimension(0, yRate);
		}
	}

	public boolean hasImage() {
		if (img != null) {
			return true;
		} else
			return false;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		update();
		move(xRate, yRate);
		// if there is no image
		if (hasImage()) {
			g.drawImage(img.getImage(), 0, 0, null);
		} else { // draw the rect if no image
			g.drawRect(0, 0, rect.width - 5, rect.height - 5);
		}
	}

}
