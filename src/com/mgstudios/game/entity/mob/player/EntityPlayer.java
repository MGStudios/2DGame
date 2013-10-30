package com.mgstudios.game.entity.mob.player;

import com.mgstudios.game.entity.mob.EntityMob;
import com.mgstudios.game.graphics.Screen;
import com.mgstudios.game.graphics.sprites.Sprite;
import com.mgstudios.game.input.Controller;

public class EntityPlayer extends EntityMob {
	private Controller input;
	
	public EntityPlayer(Controller input) {
		this.input = input;
	}
	
	public EntityPlayer(int x, int y, Controller input) {
		this.x = x;
		this.y = y;
		this.input = input;
	}
	
	@Override
	public void update() {		
		int xChange = 0, yChange = 0;
		
		if(input.up) yChange--;
		if(input.down) yChange++;
		if(input.left) xChange--;
		if(input.right) xChange++;
		
		if(xChange != 0 || yChange != 0) move(xChange, yChange);
	}
	
	@Override
	public void render(Screen screen) {
		screen.renderPlayer(x, y, Sprite.player0);
	}
}
