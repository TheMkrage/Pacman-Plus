package org.pacman.plus.keylisteners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import org.pacman.plus.characters.specific.MainPacmanCharacter;

public class BasicKeyListener implements KeyListener{

	MainPacmanCharacter character = MainPacmanCharacter.getInstance();
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		System.out.println("aaaaFDASFA");
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			character.move(-1, 0);
			System.out.println("FADSFA");
		}else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			character.move(1, 0);
		}else if(e.getKeyCode() == KeyEvent.VK_UP) {
			character.move(0, 1);
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			character.move(0, -1);
		}else {
			character.stop(); 
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
