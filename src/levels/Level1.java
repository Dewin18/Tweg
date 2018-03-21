package levels;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import entity.InteractiveObject;
import entity.Player;
import entity.ScrollingBackground;
import entity.Wall;
import entity.Ceiling;
import gameState.GameState;
import gameState.GameStateManager;
import handler.KeyHandler;
import javafx.scene.layout.Background;
import main.GamePanel;

public class Level1 extends GameState {

	private InteractiveObject background1;
	private InteractiveObject background2;
	
	private InteractiveObject player;

	private InteractiveObject ceiling;
	private InteractiveObject leftWall;
	private InteractiveObject rightWall;

	public Level1(GameStateManager gsm) {
		this.gsm = gsm;

		background1 = new ScrollingBackground(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		background2 = new ScrollingBackground(0, GamePanel.HEIGHT, GamePanel.WIDTH, GamePanel.HEIGHT);
		
		player = new Player(GamePanel.WIDTH / 2, GamePanel.HEIGHT / 2, 30, 30);

		ceiling = new Ceiling(0, 0, GamePanel.WIDTH, 60);
		leftWall = new Wall(0, 60, 30, GamePanel.HEIGHT);
		rightWall = new Wall(GamePanel.WIDTH - 29, 60, 30, GamePanel.HEIGHT);
	}

	public void draw(Graphics2D g) {
		background1.draw(g);
		background2.draw(g);
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

			 //KeyHandler.printCurrentKeysOnConsole();
			 
			 int bg1YPos = background1.getYPos();
			 bg1YPos--;
			 
			 int bg2YPos = background2.getYPos();
			 bg2YPos--;
			 
			 background1.setYPos(bg1YPos);
			 background2.setYPos(bg2YPos);
			 
			 if(!background1.isOnCamera())
			 {
				 
				 background1.setYPos(GamePanel.HEIGHT - 1);
				 bg1YPos = background1.getYPos();
				
			 }
			 
			 if(!background2.isOnCamera())
			 {
				 
				 background2.setYPos(GamePanel.HEIGHT - 1);
				 bg2YPos = background2.getYPos();
				
			 }
			 
			 System.out.println(bg1YPos);
			 

			 
			/*
			 * if(player.colide(leftWall)) {
			 * 
			 * } else if(player.colide(rightWall)) { //player.setXPos(rightWall.getXPos() -
			 * rightWall.getWidth()); }
			 */

			updatePlayerMovements();
		}

	}

	private boolean nextToLeftWall() {
		return player.getXPos() - 1 < leftWall.getXPos() + leftWall.getWidth();
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
