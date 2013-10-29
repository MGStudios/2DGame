package com.mgstudios.game.core;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class Game extends Canvas implements Runnable {
	public	static	final			long		serialVersionUID	= 1L;
	
	public	static					int			width				= 300;
	public	static					int			height				= width / 16 * 9;
	public	static					int			scale				= 3;
	
	private							Thread		thread;
	private							boolean		running				= false;
	
	private							JFrame		frame;
	
	public Game() {
		frame = new JFrame();
		
		Dimension size = new Dimension((width * scale), (height * scale));
		setPreferredSize(size);
		
		frame.setResizable(false);
		frame.setTitle("2D Game");
		frame.add(this);
		frame.pack();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		start();
	}
	
	public synchronized void start() {
		if(running) return;
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}
	
	public synchronized void stop() {
		if(!running) return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		manageAppearance();
		
		while(running) {
			update();
			render();
		}
	}
	
	private void update() {
		
	}
	
	private void render() {
		BufferStrategy bs = getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.RED);
		g.fillRect(0, 0, getWidth(), getHeight());
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
