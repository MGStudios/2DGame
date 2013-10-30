package com.mgstudios.game.level.tile;

import com.mgstudios.game.graphics.Screen;
import com.mgstudios.game.graphics.sprites.Sprite;

public class Tile {
	public int x, y;
	public Sprite sprite;
	
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	public static Tile grass = new Tile(Sprite.grass);
	public static Tile flower = new Tile(Sprite.flower);
	public static Tile rocks = new SolidTile(Sprite.rocks);
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
	
	public boolean solid() {
		return false;
	}
}
