package org.pacman.plus.main;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JFrame;

import org.pacman.plus.characters.specific.MainPacmanCharacter;
import org.pacman.plus.gameobject.GameObject;
import org.pacman.plus.gameobject.course.Wall;
import org.pacman.plus.keylisteners.BasicKeyListener;

public class GameFrame extends JFrame{

	Wall rect;
	public GameFrame() {
		//set up JFrame
		super();
		setTitle("Pacman-Plus");
		setSize(800, 700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		add(MainPacmanCharacter.getInstance());
		addKeyListener(new BasicKeyListener());
		
		rect= new Wall(50, 50, 50, 50);
		add(rect);
		gameLoop();
	}
	
	private void gameLoop() {
		while(true) {
			repaint();
		}
	}
	
	public void paint(Graphics g) {
		super.paintComponents(g);
	}
}
