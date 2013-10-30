package com.mgstudios.game.level.tile;

import com.mgstudios.game.graphics.Screen;
import com.mgstudios.game.graphics.sprites.Sprite;

public class GrassTile extends Tile {
	public GrassTile(Sprite sprite) {
		super(sprite);
	}
	
	@Override
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x, y, this);
	}
}
