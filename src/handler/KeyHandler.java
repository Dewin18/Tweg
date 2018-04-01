package handler;

import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

public class KeyHandler {

    private static Set<Integer> pressedKeys;
    private static double velocityX;
    private static double velocityY;

    private KeyHandler() {
    }

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

    public static void handleKeyPressed(KeyEvent e, int movingVelocity) {
	int key = e.getKeyCode();

	pressedKeys.add(key);

	if (key == KeyEvent.VK_RIGHT) {
	    velocityX = movingVelocity;
	}

	if (key == KeyEvent.VK_UP) {
	    velocityY = -movingVelocity;
	}

	if (key == KeyEvent.VK_LEFT) {
	    velocityX = -movingVelocity;
	}

	if (key == KeyEvent.VK_DOWN) {
	    velocityY = movingVelocity;
	}
    }

    public static void handleKeyReleased(KeyEvent e) {
	int key = e.getKeyCode();

	pressedKeys.remove(key);

	if (!pressedKeys.contains(KeyEvent.VK_UP) && !pressedKeys.contains(KeyEvent.VK_DOWN)) {
	    velocityY = -1;
	}

	if (!pressedKeys.contains(KeyEvent.VK_LEFT) && !pressedKeys.contains(KeyEvent.VK_RIGHT)) {
	    velocityX = 0;
	}
    }

    public static void printCurrentKeysOnConsole() {
	System.out.println(pressedKeys.toString());
    }

    public static boolean leftKeyPressed() {
	return pressedKeys.contains(KeyEvent.VK_LEFT);
    }

    public static boolean rightKeyPressed() {
	return pressedKeys.contains(KeyEvent.VK_RIGHT);
    }
}
