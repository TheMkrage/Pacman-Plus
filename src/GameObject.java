import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GameObject {

	private Rectangle rect;
	private ImageIcon img;
	protected int xRate = 1;
	protected int yRate = 1;

	protected int pastXRate = 0;
	protected int pastYRate = 0;
	// the last direction the pacman was going
	private Dimension lastDirection = new Dimension(0, 0);

	private boolean facingLeft = false;
	private boolean facingRight = false;

	public boolean isFacingLeft() {
		return facingLeft;
	}

	public void setFacingLeft(boolean facingLeft) {
		this.facingLeft = facingLeft;
	}

	public boolean isFacingRight() {
		return facingRight;
	}

	public void setFacingRight(boolean facingRight) {
		this.facingRight = facingRight;
	}

	public boolean isFacingUp() {
		return facingUp;
	}

	public void setFacingUp(boolean facingUp) {
		this.facingUp = facingUp;
	}

	public boolean isFacingDown() {
		return facingDown;
	}

	public void setFacingDown(boolean facingDown) {
		this.facingDown = facingDown;
	}

	private boolean facingUp = false;
	private boolean facingDown = false;

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
		rect.setLocation(x, y);
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
	
	public Rectangle getRect() {
		return rect;
	}
	
	public void setX(int x) {
		rect.setLocation(x, rect.y);
	}

	public void setY(int y) {
		rect.setLocation(rect.x, y);
	}
	public ImageIcon getImage() {
		return img;
	}

	public void move(int xRate, int yRate) {
		rect.setBounds(rect.x + xRate, rect.y + yRate, rect.width, rect.height);
	}

	private void updateFacingBooleans(int xRate, int yRate) {
		if (xRate > 0) {
			facingRight = true;
		} else if (xRate < 0) {
			facingLeft = true;
		}

		if (yRate > 0) {
			facingDown = true;
		} else {
			facingUp = true;
		}

	}

	public void setContiniousMovement(int xRate, int yRate) {
		this.xRate = xRate;
		this.yRate = yRate;
	}

	public void stop() {
		move(0, 0);
		setContiniousMovement(0, 0);
	}

	public boolean hasImage() {
		if (img != null) {
			return true;
		} else
			return false;
	}

	public Dimension getLastDirection() {
		return lastDirection;
	}

	public void setLastDirection(Dimension lastDirection) {
		this.lastDirection = lastDirection;
	}

	public void setLastDirection(int x, int y) {
		this.lastDirection = new Dimension(x, y);
	}

}