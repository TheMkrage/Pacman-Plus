package org.pacman.plus.main;

import javax.swing.JFrame;

import org.pacman.plus.characters.specific.MainPacmanCharacter;
import org.pacman.plus.gameobject.GameObject;
import org.pacman.plus.keylisteners.BasicKeyListener;

public class GameFrame extends JFrame{

	public GameFrame() {
		//set up JFrame
		super();
		setTitle("Pacman-Plus");
		setSize(800, 700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		add(MainPacmanCharacter.getInstance());
		addKeyListener(new BasicKeyListener());
		gameLoop();
	}
	
	private void gameLoop() {
		while(true) {
			repaint();
		}
	}
}
