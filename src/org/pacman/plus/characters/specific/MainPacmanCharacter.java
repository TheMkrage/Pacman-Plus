package org.pacman.plus.characters.specific;

import org.pacman.plus.characters.PacmanCharacter;

public class MainPacmanCharacter extends PacmanCharacter{
	
	private MainPacmanCharacter instance;
	
	private final int STARTING_X = 50;
	private final int STARTING_Y = 50;
	private final String IMAGE_NAME = "alien1.png";
	public MainPacmanCharacter getInstance() {
		if(instance == null) {
			instance = new MainPacmanCharacter(STARTING_X, STARTING_Y, IMAGE_NAME);
		}
		return instance;
	}
	private MainPacmanCharacter(int x, int y, String name) {
		super(x, y, name);
	}
}
