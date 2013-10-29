package com.mgstudios.game;

public class Game implements Runnable {
	public	static					int			width		= 300;
	public	static					int			height		= width / 16 * 9;
	public	static					int			scale		= 3;
	
	private							Thread		thread;
	private							boolean		running		= false;
	
	public			synchronized	void		start() {
		if(running) return;
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}
	
	public			synchronized	void		stop() {
		if(!running) return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public							void		run() {
		while(running) {
			
		}
	}
}
