package levels;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import entity.MovingObject;
import entity.Player;
import gameState.GameState;
import gameState.GameStateManager;

public class Level1 extends GameState {

	// velocity
	private double velX = 0;
	private double velY = 0;

	private MovingObject player;

	public Level1(GameStateManager gsm) {

		this.gsm = gsm;

		player = new Player(100, 100, 40, 40);

	}

	@Override
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		player.draw(g2);

		if (player.isOnCamera()) {
			System.out.println("object visible");
		} else
			System.out.println("OBJECT OUT OF MAP");

		// System.out.println("x: " + player.getXPos()+ " y: " +
		// player.getYPos());
	}

	@Override
	public void update() {
		updatePlayerMovements();
	}

	private void updatePlayerMovements() {
		int xPos = player.getXPos();
		int yPos = player.getYPos();

		player.setXPos(xPos += velX);
		player.setYPos(yPos += velY);
	}

	@Override
	public void handleKeyPressed(KeyEvent e) {
		int key = e.getKeyCode();

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

	@Override
	public void handleKeyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_RIGHT) {
			velX = 0;
		}

		if (key == KeyEvent.VK_UP) {
			velY = 0;
		}

		if (key == KeyEvent.VK_LEFT) {
			velX = 0;
		}

		if (key == KeyEvent.VK_DOWN) {
			velY = 0;
		}
	}
}
