package levels;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import background.BackgroundsEnum;
import entity.InteractiveObject;
import entity.Player;
import entity.Wall;
import entity.Block;
import entity.Ceiling;
import gameState.GameState;
import gameState.GameStateManager;
import handler.BackgroundHandler;
import handler.KeyHandler;
import main.GamePanel;

public class Level1 extends GameState {

    private InteractiveObject player;

    private InteractiveObject ceiling;
    private InteractiveObject leftWall;
    private InteractiveObject rightWall;

    private InteractiveObject block1;

    public Level1(GameStateManager gsm) {
	loadBackground();

	this.gsm = gsm;

	player = new Player(GamePanel.WIDTH / 2, GamePanel.HEIGHT / 2, 30, 30);
	ceiling = new Ceiling(0, 0, GamePanel.WIDTH, 60);

	leftWall = new Wall(0, 60, 30, GamePanel.HEIGHT);
	rightWall = new Wall(GamePanel.WIDTH - 30, 60, 30, GamePanel.HEIGHT);

	block1 = new Block(200, 500, 30, 30);
    }

    private void loadBackground() {
	try {
	    BackgroundHandler.setBackgrounds(BackgroundsEnum.LEVEL_1);
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public void draw(Graphics2D g) {
	BackgroundHandler.drawBackgrounds(g);
	drawWalls(g);
	player.draw(g);
	block1.draw(g);
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

	    updateBackground();
	    updatePlayerMovements();

	    int blockYPos = block1.getYPos();

	    blockYPos--;

	    block1.setYPos(blockYPos);
	}

    }

    private void updateBackground() {
	BackgroundHandler.updateBackgrounds();
    }

    private void updatePlayerMovements() {

	int xPos = player.getXPos();
	int yPos = player.getYPos();

	if (player.leftCollision(leftWall) || player.leftCollision(block1)) {

	    if (!KeyHandler.leftKeyPressed()) {
		player.setXPos(xPos += KeyHandler.getVelX());
	    }
	    player.setYPos(yPos += KeyHandler.getVelY());

	} else if (player.rightCollision(rightWall) || player.rightCollision(block1)) {

	    if (!KeyHandler.rightKeyPressed()) {
		player.setXPos(xPos += KeyHandler.getVelX());
	    }
	    player.setYPos(yPos += KeyHandler.getVelY());

	} else if (player.bottomCollision(block1)) {

	    player.setYPos(--yPos);
	    if (!KeyHandler.downKeyPressed()) {
		player.setYPos(yPos += KeyHandler.getVelY());
	    }
	    player.setXPos(xPos += KeyHandler.getVelX());
	} else {

	    player.setXPos(xPos += KeyHandler.getVelX());
	    player.setYPos(yPos += KeyHandler.getVelY());

	    // System.out.println("Player - Block distance:" + (block1.getYPos() -
	    // (player.getYPos() + player.getHeight()))));

	}
    }

    public void handleKeyPressed(KeyEvent event) {

	KeyHandler.handleKeyPressed(event, Player.STANDARD_VELOCITY);

    }

    public void handleKeyReleased(KeyEvent e) {
	KeyHandler.handleKeyReleased(e);
    }
}
