package com.mgstudios.game.level.tile;

import com.mgstudios.game.graphics.Screen;
import com.mgstudios.game.graphics.sprites.Sprite;

public class VoidTile extends Tile {
	public VoidTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x, y, this);
	}
}
