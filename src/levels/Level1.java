package levels;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import entity.InteractiveObject;
import entity.Player;
import entity.Wall;
import entity.Ceiling;
import gameState.GameState;
import gameState.GameStateManager;
import handler.KeyHandler;
import main.GamePanel;

public class Level1 extends GameState {

	private InteractiveObject player;

	private InteractiveObject ceiling;
	private InteractiveObject leftWall;
	private InteractiveObject rightWall;

	public Level1(GameStateManager gsm) {
		this.gsm = gsm;

		player = new Player(GamePanel.WIDTH / 2, GamePanel.HEIGHT / 2, 30, 30);

		ceiling = new Ceiling(0, 0, GamePanel.WIDTH, 60);
		leftWall = new Wall(0, 60, 30, GamePanel.HEIGHT);
		rightWall = new Wall(GamePanel.WIDTH - 29, 60, 30, GamePanel.HEIGHT);
	}

	public void draw(Graphics2D g) {
		player.draw(g);
		drawWalls(g);
	}

	private void drawWalls(Graphics2D g) {
		ceiling.draw(g);
		leftWall.draw(g);
		rightWall.draw(g);
	}

	public void update() {
		if (player.colide(ceiling)) {
			System.out.println("PLAYER DEAD");

		} else {
			updatePlayerMovements();
		}

	}

	private void updatePlayerMovements() {
		int xPos = player.getXPos();
		int yPos = player.getYPos();

		player.setXPos(xPos += KeyHandler.getVelX());
		player.setYPos(yPos += KeyHandler.getVelY());
	}

	public void handleKeyPressed(KeyEvent event) {
		KeyHandler.handleKeyPressed(event, Player.STANDARD_VELOCITY);
	}

	public void handleKeyReleased(KeyEvent e) {
		KeyHandler.handleKeyReleased(e);
	}
}
