package org.pacman.plus.main;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JFrame;

import org.pacman.plus.characters.GhostCharacter;
import org.pacman.plus.characters.ghosts.apis.SimpleAPI;
import org.pacman.plus.characters.specific.MainPacmanCharacter;
import org.pacman.plus.gameobject.GameObject;
import org.pacman.plus.gameobject.course.Wall;
import org.pacman.plus.keylisteners.BasicKeyListener;

public class GameFrame extends JFrame {

	public GameFrame() {
		// set up JFrame
		super();
		setTitle("Pacman-Plus");
		setSize(800, 700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		add(MainPacmanCharacter.getInstance());
		GhostCharacter test = new GhostCharacter(600, 200, "redGhost.png", new SimpleAPI());

		add(test);
		
		Wall topBorder = new Wall(186, 0, 597, 15);
		add(topBorder);

		Wall rightBorder = new Wall(768, 0, 15, 665);
		add(rightBorder);

		Wall leftBorder = new Wall(186, 0, 15, 665);
		add(leftBorder);

		Wall bottomBorder = new Wall(186, 647, 597, 15);
		add(bottomBorder);

		Wall centerMidBottom = new Wall(465, 390, 200, 20);
		add(centerMidBottom);

		GameObject Background = new GameObject(200, 0, "GameBackground.png");
		add(Background);

		addKeyListener(new BasicKeyListener());

		// leaves 200 - 800 for game

		gameLoop();
	}

	private void gameLoop() {
		while (true) {
			repaint();
		}
	}

	public void paint(Graphics g) {
		super.paintComponents(g);
		// .drawImage(MainPacmanCharacter.getInstance().getImage().getImage(),
		// 0, 0, null);
	}

}
