package com.mgstudios.game;

import java.awt.EventQueue;

import com.mgstudios.game.core.Game;

public class Launch {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Game();
			}
		});
	}
}
