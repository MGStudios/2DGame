package com.mgstudios.game.input;


public class Controller {
	public boolean up, down, left, right;
	
	public void update(boolean forward, boolean backward, boolean left, boolean right) {
		up = forward;
		down = backward;
		this.left = left;
		this.right = right;
		
		if(forward) {
			
		}

		if(backward) {
			
		}

		if(left) {
			
		}
		
		if(right) {
			
		}
	}
}
