package com.mgstudios.game.input;

import com.mgstudios.game.core.Game;

public class Controller {
	public void update(boolean forward, boolean backward, boolean left, boolean right) {
		if(forward)
			Game.y--;

		if(backward)
			Game.y++;

		if(left)
			Game.x--;
		
		if(right)
			Game.x++;
	}
}
