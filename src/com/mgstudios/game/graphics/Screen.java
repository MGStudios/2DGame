package com.mgstudios.game.graphics;

import java.util.Random;

import com.mgstudios.game.graphics.sprites.Sprite;
import com.mgstudios.game.level.tile.Tile;

public class Screen {
	public int width, height;
	public int[] pixels;
	
	private Random random = new Random();
//	private final int RESOLUTION = 16;
	private final int MAP_SIZE = 64;
//	private final int MAP_SIZE_MASK = MAP_SIZE - 1;
	
	public int xOffset, yOffset;
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
	
	public void renderTile(int xPos, int yPos, Tile tile) {
		xPos -= xOffset;
		yPos -= yOffset;
		
		for(int y = 0; y < tile.sprite.SIZE; y++) {
			int yAbs = y + yPos;
			
			for(int x = 0; x < tile.sprite.SIZE; x++) {
				int xAbs = x + xPos;
				
				if(xAbs < -tile.sprite.SIZE || xAbs >= width || yAbs < 0 || yAbs >= height) break;
				if(xAbs < 0) xAbs = 0;
				pixels[xAbs + yAbs * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
			}
		}
	}
	
	public void renderPlayer(int xPos, int yPos, Sprite sprite, int flip) {
		xPos -= xOffset;
		yPos -= yOffset;
		
		for(int y = 0; y < 32; y++) {
			int yAbs = y + yPos;
			int ySprite = y;
			
			if(flip == 2 || flip == 3) ySprite = 31 - y;
			
			for(int x = 0; x < 32; x++) {
				int xAbs = x + xPos;
				int xSprite = x;
				
				if(flip == 1 || flip == 3) xSprite = 31 - x;
				
				if(xAbs < -32 || xAbs >= width || yAbs < 0 || yAbs >= height) break;
				if(xAbs < 0) xAbs = 0;
				
				int colour = sprite.pixels[xSprite + ySprite * 32];
				if(colour != 0) pixels[xAbs + yAbs * width] = colour;
			}
		}
	}
	
	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
}
