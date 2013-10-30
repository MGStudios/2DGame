package com.mgstudios.game.input;

import com.mgstudios.game.entity.mob.player.EntityPlayer;

public class Controller {
	public boolean up, down, left, right;
	private EntityPlayer player;
	
	public void update(EntityPlayer player, boolean forward, boolean backward, boolean left, boolean right) {
		up = forward;
		down = backward;
		this.left = left;
		this.right = right;
		
		this.player = player;
		
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
