package com.mgstudios.game.graphics;

import java.util.Random;

import com.mgstudios.game.graphics.sprites.Sprite;

public class Screen {
	private int width, height;
	public int[] pixels;
	
	private Random random = new Random();
	private final int RESOLUTION = 16;
	private final int MAP_SIZE = 64;
	private final int MAP_SIZE_MASK = MAP_SIZE - 1;
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
	
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		
		for(int i = 0; i < tiles.length; i++) {
			tiles[i] = random.nextInt(0xffffff);
		}
	}
	
	public void clear() {
		for(int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}
	
	public void render(int xOffset, int yOffset) {
		for(int y = 0; y < height; y++) {
			int yp = y + yOffset;
			if(yp < 0 || yp >= height) continue;
			for(int x = 0; x < width; x++) {
				int xp = x + xOffset;
				if(xp < 0 || xp >= width) continue;
				pixels[xp + yp * width] = Sprite.grass.pixels[(x&15) + (y&15) * Sprite.grass.SIZE];
			}
		}
	}
}
