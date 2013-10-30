package com.mgstudios.game.core;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;
import javax.swing.UIManager;

import com.mgstudios.game.entity.mob.player.EntityPlayer;
import com.mgstudios.game.graphics.Screen;
import com.mgstudios.game.input.InputHandler;
import com.mgstudios.game.input.Keyboard;
import com.mgstudios.game.level.Level;
import com.mgstudios.game.level.SpawnLevel;

public class Game extends Canvas implements Runnable {
	public static final long serialVersionUID = 1L;

	public static int width = 300;
	public static int height = width / 16 * 9;
	public static int scale = 3;
	public static String TITLE = "2D Game";
	
	private Thread thread;
	private boolean running = false;

	private JFrame frame;

	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	
	private Screen screen;
	
	private InputHandler input;
	public Keyboard keyboard;
	
	private Level level;
	
	private EntityPlayer player;
	
	public Game() {
		screen = new Screen(width, height);
		frame = new JFrame();
		
		input = new InputHandler();
		keyboard = new Keyboard();
		player = new EntityPlayer(6 * 16, 4 * 16, keyboard.controller);
		
		addKeyListener(input);
		
		level = new SpawnLevel("generic");
		
		Dimension size = new Dimension((width * scale), (height * scale));
		setPreferredSize(size);

		frame.setResizable(false);
		frame.setTitle(TITLE);
		frame.add(this);
		frame.pack();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		start();
	}

	public synchronized void start() {
		if (running) return;
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}

	public synchronized void stop() {
		if (!running) return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		manageAppearance();
		requestFocus();
		
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double nano = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / nano;
			lastTime = now;
			
			while(delta >= 1) {
				update();
				updates++;
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frame.setTitle(TITLE + "  |  " + updates + " ups, " + frames + " fps");				
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}
	
	private void update() {
		keyboard.update(input.key);
		player.update();
	}

	private void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		screen.clear();
		
		int xScroll = player.x - screen.width / 2;
		int yScroll = player.y - screen.height / 2;
		
		level.render(xScroll, yScroll, screen);
		player.render(screen);
		
		for(int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}

		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		bs.show();
	}

	private void manageAppearance() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
