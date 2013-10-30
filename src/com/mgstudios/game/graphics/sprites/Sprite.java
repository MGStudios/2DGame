package com.mgstudios.game.graphics.sprites;

public class Sprite {
	private SpriteSheet sheet;
	
	public final int SIZE;
	private int x, y;
	public int[] pixels;
	
	public static Sprite voidSprite = new Sprite(16, 0x1B87E0);
	
	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.outdoors);
	public static Sprite flower = new Sprite(16, 1, 0, SpriteSheet.outdoors);
	public static Sprite rocks = new Sprite(16, 2, 0, SpriteSheet.outdoors);
	
	public static Sprite player_up = new Sprite(32, 0, 3, SpriteSheet.player);
	public static Sprite player_up_1 = new Sprite(32, 1, 3, SpriteSheet.player);
	public static Sprite player_up_2 = new Sprite(32, 3, 3, SpriteSheet.player);
	
	public static Sprite player_down = new Sprite(32, 0, 0, SpriteSheet.player);
	public static Sprite player_down_1 = new Sprite(32, 1, 0, SpriteSheet.player);
	public static Sprite player_down_2 = new Sprite(32, 3, 0, SpriteSheet.player);
	
	public static Sprite player_side = new Sprite(32, 0, 2, SpriteSheet.player);
	public static Sprite player_side_1 = new Sprite(32, 1, 2, SpriteSheet.player);
	public static Sprite player_side_2 = new Sprite(32, 3, 2, SpriteSheet.player);
		
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		 SIZE = size;
		 pixels = new int[SIZE * SIZE];
		 this.x = x * size;
		 this.y = y * size;
		 this.sheet = sheet; 
		 load();
	}
	
	public Sprite(int size, int colour) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColour(colour);
	}
	
	private void setColour(int colour) {
		for(int i = 0; i < pixels.length; i++) {
			pixels[i] = colour;
		}
	}
	
	private void load() {
		for(int y = 0; y < SIZE; y++) {
			for(int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
	}
}
