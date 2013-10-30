package com.mgstudios.game.level.tile;

import com.mgstudios.game.graphics.sprites.Sprite;

public class SolidTile extends Tile {
	public SolidTile(Sprite sprite) {
		super(sprite);
	}
	
	public boolean solid() {
		return true;
	}
}
