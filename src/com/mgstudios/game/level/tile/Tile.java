package com.mgstudios.game.level.tile;

import com.mgstudios.game.graphics.Screen;
import com.mgstudios.game.graphics.sprites.Sprite;

public class Tile {
	public int x, y;
	public Sprite sprite;
	
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	
	public static Tile grass_1 = new Tile(Sprite.grass_1);
	public static Tile grass_2 = new Tile(Sprite.grass_2);
	public static Tile grass_3 = new Tile(Sprite.grass_3);
	public static Tile grass_4 = new Tile(Sprite.grass_4);
	public static Tile grass_5 = new Tile(Sprite.grass_5);
	public static Tile grass_6 = new Tile(Sprite.grass_6);
	public static Tile grass_7 = new Tile(Sprite.grass_7);
	public static Tile grass_8 = new Tile(Sprite.grass_8);
	
	public static Tile flower = new Tile(Sprite.flower);
	public static Tile brick_1 = new SolidTile(Sprite.brick_1);
	public static Tile brick_2 = new SolidTile(Sprite.brick_2);
	public static Tile brick_3 = new SolidTile(Sprite.brick_3);
	public static Tile brick_4 = new SolidTile(Sprite.brick_4);
	
	public static Tile rocks = new SolidTile(Sprite.rocks);
	public static Tile wall_1 = new SolidTile(Sprite.wall_1);
	public static Tile wall_2 = new SolidTile(Sprite.wall_2);
	public static Tile wall_3 = new SolidTile(Sprite.wall_3);
	public static Tile wall_4 = new SolidTile(Sprite.wall_4);
	public static Tile wall_5 = new SolidTile(Sprite.wall_5);
	public static Tile wall_6 = new SolidTile(Sprite.wall_6);
	
	public static Tile wood_1 = new SolidTile(Sprite.wood_1);
	public static Tile wood_2 = new SolidTile(Sprite.wood_2);
	public static Tile wood_3 = new SolidTile(Sprite.wood_3);
	public static Tile wood_4 = new SolidTile(Sprite.wood_4);
	
	public static Tile water_1 = new Tile(Sprite.water_1);
	public static Tile water_2 = new Tile(Sprite.water_2);
	public static Tile water_3 = new Tile(Sprite.water_3);
	
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
