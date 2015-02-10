package org.pacman.plus.main;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JFrame;

import org.pacman.plus.characters.specific.MainPacmanCharacter;
import org.pacman.plus.gameobject.GameObject;
import org.pacman.plus.keylisteners.BasicKeyListener;

public class GameFrame extends JFrame{

	public Rectangle rect = new Rectangle(0,0,0,0);
	private static GameFrame instance;
	public static GameFrame getInstance() {
		if(instance == null)
			instance = new GameFrame();
		return instance;
	}
	private GameFrame() {
		//set up JFrame
		super();
		setTitle("Pacman-Plus");
		setSize(800, 700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		add(MainPacmanCharacter.getInstance());
		addKeyListener(new BasicKeyListener());
		
		rect= new Rectangle(50, 50, 50, 50);
		
		gameLoop();
	}
	
	private void gameLoop() {
		while(true) {
			repaint();
		}
	}
	
	public void paint(Graphics g) {
		super.paintComponents(g);
		g.drawRect(rect.x, rect.y, rect.width, rect.height);
	}
}
