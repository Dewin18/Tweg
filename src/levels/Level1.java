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
import handler.keyHandler;

public class Level1 extends GameState {

	private MovingObject player;

	public Level1(GameStateManager gsm) {
		this.gsm = gsm;
		player = new Player(100, 100, 40, 40);
	}

	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		player.draw(g2);

		 if (player.isOnCamera()) {
		 System.out.println("object visible");
		 } else
		 System.out.println("OBJECT OUT OF MAP");
	}

	public void update() {
		updatePlayerMovements();
	}

	private void updatePlayerMovements() {
		int xPos = player.getXPos();
		int yPos = player.getYPos();

		player.setXPos(xPos += keyHandler.getVelX());
		player.setYPos(yPos += keyHandler.getVelY());
	}

	public void handleKeyPressed(KeyEvent e) {
		keyHandler.handleKeyPressed(e);
	}

	public void handleKeyReleased(KeyEvent e) {
		keyHandler.handleKeyReleased(e);
	}
}
