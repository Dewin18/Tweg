package levels;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import entity.MovingObject;
import entity.Player;
import gameState.GameState;
import gameState.GameStateManager;

public class Level1 extends GameState {

	private Set<Integer> pressedKeys;

	// velocity
	private double velX = 0;
	private double velY = 0;

	private MovingObject player;

	public Level1(GameStateManager gsm) {

		pressedKeys = new HashSet<>();
		this.gsm = gsm;

		player = new Player(100, 100, 40, 40);

	}

	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		player.draw(g2);

		// if (player.isOnCamera()) {
		// System.out.println("object visible");
		// } else
		// System.out.println("OBJECT OUT OF MAP");

		// System.out.println("x: " + player.getXPos()+ " y: " +
		// player.getYPos());
	}

	public void update() {
		updatePlayerMovements();
		System.out.println(pressedKeys.toString());
	}

	private void updatePlayerMovements() {
		int xPos = player.getXPos();
		int yPos = player.getYPos();

		player.setXPos(xPos += velX);
		player.setYPos(yPos += velY);
	}

	public void handleKeyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		pressedKeys.add(key);

		if (key == KeyEvent.VK_RIGHT) {
			velX = Player.STANDARD_VELOCITY;
		}

		if (key == KeyEvent.VK_UP) {
			velY = -Player.STANDARD_VELOCITY;
		}

		if (key == KeyEvent.VK_LEFT) {
			velX = -Player.STANDARD_VELOCITY;
		}

		if (key == KeyEvent.VK_DOWN) {
			velY = Player.STANDARD_VELOCITY;
		}
	}

	public void handleKeyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		pressedKeys.remove(key);

		if (!pressedKeys.contains(KeyEvent.VK_UP) && !pressedKeys.contains(KeyEvent.VK_DOWN)) {
			velY = 0;
		}

		if (!pressedKeys.contains(KeyEvent.VK_LEFT) && !pressedKeys.contains(KeyEvent.VK_RIGHT)) {
			velX = 0;
		}
	}

	public void handleKeTyped(KeyEvent e) {
		// NOT IMPLEMENTED YET
	}
}
