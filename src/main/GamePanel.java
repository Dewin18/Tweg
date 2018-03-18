package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import gameState.GameStateManager;

public class GamePanel extends JPanel implements Runnable, KeyListener {

	private static final long serialVersionUID = 1L;

	public final static int WIDTH = 600;
	public final static int HEIGHT = 600;

	private boolean isRunning;
	private Thread thread;
	private GameStateManager gsm;
	private final int FPS = 60;
	private long targetTime = 1000 / FPS;

	public GamePanel() {
		super();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		gsm = new GameStateManager();
		start();

	}

	private void start() {
		isRunning = true;
		thread = new Thread(this);
		addKeyListener(this);
		thread.start();
	}

	public void run() {
		long start, elapsed, wait;

		// game loop
		while (isRunning) {

			start = System.nanoTime();
			update();
	
			repaint();
			elapsed = System.nanoTime() - start;

			wait = targetTime - elapsed / 100000;

			if (wait < 0) {
				wait = 6;
			}
			try {
				Thread.sleep(wait);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void keyTyped(KeyEvent e) {
		//System.out.println(e.getKeyCode());
	}

	public void keyPressed(KeyEvent e) {
		gsm.handleKeyPressed(e);
	}

	public void keyReleased(KeyEvent e) {
		gsm.handleKeyReleased(e);
	}
	
	private void update() {
		gsm.update();
	}
	
	@Override
	public void paintComponent(Graphics g)	{
		super.paintComponent(g);
		gsm.draw(g);
	}

}
