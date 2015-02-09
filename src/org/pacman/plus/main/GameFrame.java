package org.pacman.plus.main;

import javax.swing.JFrame;

import org.pacman.plus.gameobject.GameObject;

public class GameFrame extends JFrame{

	public GameFrame() {
		//set up JFrame
		super();
		setTitle("Pacman-Plus");
		setSize(800, 700);
		setVisible(true);
		GameObject obj = new GameObject(500, 500, "spaceBackground1.png");
		add(obj);
		gameLoop();
	}
	
	private void gameLoop() {
		while(true) {
			repaint();
			
		}
	}
}
