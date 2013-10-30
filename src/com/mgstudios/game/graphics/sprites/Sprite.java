package com.mgstudios.game.graphics.sprites;

public class Sprite {
	private SpriteSheet sheet;
	
	public final int SIZE;
	private int x, y;
	public int[] pixels;
	
	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.outdoors);
	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		 SIZE = size;
		 pixels = new int[SIZE * SIZE];
		 this.x = x * size;
		 this.y = y * size;
		 this.sheet = sheet; 
		 load();
	}
	
	private void load() {
		for(int y = 0; y < SIZE; y++) {
			for(int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
	}
}