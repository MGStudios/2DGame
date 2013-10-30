package com.mgstudios.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {
	public boolean[] key = new boolean[68836];
	
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		if(keyCode > 0 && keyCode < key.length) {
			key[keyCode] = true;
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		if(keyCode > 0 && keyCode < key.length) {
			key[keyCode] = false;
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}

}
