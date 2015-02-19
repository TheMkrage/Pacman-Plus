package org.pacman.plus.characters.ghosts.apis;

import java.awt.Dimension;

import org.pacman.plus.characters.ghosts.GhostAPI;
import org.pacman.plus.characters.specific.MainPacmanCharacter;

public class SimpleAPI extends GhostAPI {

	@Override
	public Dimension getTarget() {
		// TODO Auto-generated method stub
		MainPacmanCharacter pac = MainPacmanCharacter.getInstance();
		Dimension target = new Dimension(pac.getX(), pac.getY());
		return target;
	}

}
