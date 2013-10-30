package com.mgstudios.game.input;

import java.awt.event.KeyEvent;

public class Keyboard {
	public Controller controller;
	
	public Keyboard() {
		controller = new Controller();
	}
	
	public void update(boolean[] key) {
		boolean forward = key[KeyEvent.VK_W] || key[KeyEvent.VK_UP];
		boolean backward = key[KeyEvent.VK_S] || key[KeyEvent.VK_DOWN];
		boolean left = key[KeyEvent.VK_A] || key[KeyEvent.VK_LEFT];
		boolean right = key[KeyEvent.VK_D] || key[KeyEvent.VK_RIGHT];
		
		controller.update(forward, backward, left, right);
	}
}
