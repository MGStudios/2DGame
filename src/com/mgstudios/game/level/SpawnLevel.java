package com.mgstudios.game.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpawnLevel extends Level {	
	public SpawnLevel(String fileName) {
		super(fileName);
	}
	
	@Override
	protected void loadLevel(String fileName) {
		try {
			image = ImageIO.read(SpawnLevel.class.getResource("/textures/levels/" + fileName + ".png"));
			
			int w = width = image.getWidth();
			int h = width = image.getHeight();
			tiles = new int[w * h];
			image.getRGB(0, 0, 	w, h, tiles, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Could not load level file!");
		}
	}
	
	@Override
	protected void generateLevel() {
		
	}
}
