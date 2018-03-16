package main;

import javax.swing.JFrame;

public class GameFrame {

	private JFrame window;
	private GamePanel gamePanel;

	public GameFrame() {
		gamePanel = new GamePanel();
	}

	public void show() {
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(gamePanel);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
}
