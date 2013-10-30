package com.mgstudios.game.graphics.sprites;

public class Sprite {
	private SpriteSheet sheet;
	
	public final int SIZE;
	private int x, y;
	public int[] pixels;
	
	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.outdoors);
	public static Sprite voidSprite = new Sprite(16, 0x1B87E0);
	
	public static Sprite player0 = new Sprite(16, 0, 0, SpriteSheet.player);
	public static Sprite player1 = new Sprite(16, 1, 0, SpriteSheet.player);
	public static Sprite player2 = new Sprite(16, 2, 0, SpriteSheet.player);
	public static Sprite player3 = new Sprite(16, 3, 0, SpriteSheet.player);
	
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
