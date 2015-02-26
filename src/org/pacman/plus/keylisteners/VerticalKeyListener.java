package org.pacman.plus.keylisteners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import org.pacman.plus.characters.specific.MainPacmanCharacter;

public class VerticalKeyListener implements KeyListener {

	MainPacmanCharacter character = MainPacmanCharacter.getInstance();

	@Override
	public void keyPressed(KeyEvent e) {

		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			character.setContiniousMovement(0, -1);
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			character.setContiniousMovement(0, 1);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
