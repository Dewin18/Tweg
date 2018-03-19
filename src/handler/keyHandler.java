package handler;

import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

import entity.Player;

public class keyHandler {

	private static Set<Integer> pressedKeys;
	private static double velocityX;
	private static double velocityY;

	static {
		pressedKeys = new HashSet<>();
		velocityX = 0;
		velocityY = 0;
	}

	public static double getVelX() {
		return velocityX;
	}

	public static double getVelY() {
		return velocityY;
	}

	public static void handleKeyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		pressedKeys.add(key);

		if (key == KeyEvent.VK_RIGHT) {
			velocityX = Player.STANDARD_VELOCITY;
		}

		if (key == KeyEvent.VK_UP) {
			velocityY = -Player.STANDARD_VELOCITY;
		}

		if (key == KeyEvent.VK_LEFT) {
			velocityX = -Player.STANDARD_VELOCITY;
		}

		if (key == KeyEvent.VK_DOWN) {
			velocityY = Player.STANDARD_VELOCITY;
		}
	}

	public static void handleKeyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		pressedKeys.remove(key);

		if (!pressedKeys.contains(KeyEvent.VK_UP) && !pressedKeys.contains(KeyEvent.VK_DOWN)) {
			velocityY = 0;
		}

		if (!pressedKeys.contains(KeyEvent.VK_LEFT) && !pressedKeys.contains(KeyEvent.VK_RIGHT)) {
			velocityX = 0;
		}
	}
}
