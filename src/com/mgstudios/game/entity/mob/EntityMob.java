package com.mgstudios.game.entity.mob;

import com.mgstudios.game.entity.Entity;
import com.mgstudios.game.graphics.sprites.Sprite;

public abstract class EntityMob extends Entity {
	protected Sprite sprite;
	protected int dir = 2; // north, going clockwise
	protected boolean moving = false;
	
	public void move(int xChange, int yChange) {
		if(xChange > 0) dir = 1;
		if(xChange < 0) dir = 3;
		if(yChange > 0) dir = 2;
		if(yChange < 0) dir = 0;
		
		if(!collision()) {
			x += xChange;
			y += yChange;
		}
	}
	
	@Override
	public void update() {
		
	}
	
	public void render() {
		
	}
	
	private boolean collision() {
		return false;
	}
}
