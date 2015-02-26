package org.pacman.plus.keylisteners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import org.pacman.plus.characters.specific.MainPacmanCharacter;

public class HorizontalKeyListener implements KeyListener {

	MainPacmanCharacter character = MainPacmanCharacter.getInstance();

	@Override
	public void keyPressed(KeyEvent e) {

		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			character.setContiniousMovement(-1, 0);
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			character.setContiniousMovement(1, 0);
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

