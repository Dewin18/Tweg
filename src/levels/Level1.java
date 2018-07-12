package levels;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;

import background.BackgroundsEnum;
import entity.InteractiveObject;
import entity.Player;
import entity.SolidBar;
import entity.SolidBarFactory;
import entity.Wall;
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

    private Set<InteractiveObject> allBlocks;

    private Timer timer = new Timer();
    private SolidBarFactory solidBarFactory;
    private ArrayList<SolidBar> allSolidBars;

    private static int scale = 2;

    public Level1(GameStateManager gsm) {
	loadBackground();

	this.gsm = gsm;

	allBlocks = new HashSet<>();
	
	player = new Player(GamePanel.WIDTH / 2, GamePanel.HEIGHT / 2, 30, 30);
	ceiling = new Ceiling(0, 0, GamePanel.WIDTH, 60);

	leftWall = new Wall(0, 60, 30, GamePanel.HEIGHT);
	rightWall = new Wall(GamePanel.WIDTH - 30, 60, 30, GamePanel.HEIGHT);

	solidBarFactory = new SolidBarFactory();
	allSolidBars = solidBarFactory.getSolidbars();
	timer.schedule(solidBarFactory, 1000, 2000);
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

	player.draw(g);

	for (SolidBar solidbar : allSolidBars) {
	    ArrayList<InteractiveObject> blocks = solidbar.getBlocks();
	    allBlocks.addAll(blocks);

	    for (InteractiveObject block : blocks) {
		block.draw(g);
	    }
	}

	// for (InteractiveObject block : blocks1) {
	// block.draw(g);
	// block = null;
	// }
	//
	// for (InteractiveObject block : blocks2) {
	// block.draw(g);
	// block = null;
	// }
	//
	// for (InteractiveObject block : blocks3) {
	// block.draw(g);
	// block = null;
	// }

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

	    updateBackground();
	    updatePlayerMovements();

	    for (SolidBar solidbar : allSolidBars) {
		ArrayList<InteractiveObject> blocks = solidbar.getBlocks();

		for (InteractiveObject block : blocks) {
		    int blockYPos = block.getYPos();
		    blockYPos -= scale;
		    block.setYPos(blockYPos);
		}
	    }
	}

    }

    private void updateBackground() {
	BackgroundHandler.updateBackgrounds();
    }

    private void updatePlayerMovements() {

	int xPos = player.getXPos();
	int yPos = player.getYPos();

	handePlayerWallCollision(xPos, yPos);

	for (InteractiveObject block : allBlocks) {
	    if (player.colideBottom(block)) {

		if (!player.positive_Y_Distance(block)) {
		    yPos = block.getYPos() - player.getHeight();
		    player.setYPos(--yPos);

		    if (!KeyHandler.downKeyPressed()) {
			player.setYPos(yPos += KeyHandler.getVelY());
		    }
		}
	    }

	    else if (player.colideTop(block)) {

		if (!player.negative_Y_Distance(block)) {
		    yPos = block.getYPos() + block.getHeight();
		    player.setYPos(yPos);
		}
	    }

	    // TODO
	    // else if (player.colideLeft(block)) {
	    // if (!player.positive_X_Distance(block) && KeyHandler.leftKeyPressed()) {
	    // player.setXPos(xPos += 1);
	    // }
	    // }
	    //
	    // else if (player.colideRight(block)) {
	    // if (!player.negative_X_Distance(block) && KeyHandler.rightKeyPressed()) {
	    // player.setXPos(xPos += 1);
	    // }
	    // }

	    // else if (player.leftCollision(block)) {
	    //
	    // if (KeyHandler.leftKeyPressed()) {
	    // player.setXPos(xPos += 0);
	    // }
	}
    }

    private void handePlayerWallCollision(int xPos, int yPos) {

	if (player.leftCollision(leftWall)) {

	    if (!KeyHandler.leftKeyPressed()) {
		player.setXPos(xPos += KeyHandler.getVelX());
	    }
	    player.setYPos(yPos += KeyHandler.getVelY());

	} else if (player.rightCollision(rightWall)) {

	    if (!KeyHandler.rightKeyPressed()) {
		player.setXPos(xPos += KeyHandler.getVelX());
	    }
	    player.setYPos(yPos += KeyHandler.getVelY());

	} else {
	    player.setXPos(xPos += KeyHandler.getVelX());
	    player.setYPos(yPos += KeyHandler.getVelY());
	}
    }

    public void handleKeyPressed(KeyEvent event) {
	KeyHandler.handleKeyPressed(event, Player.STANDARD_VELOCITY);
    }

    public void handleKeyReleased(KeyEvent e) {
	KeyHandler.handleKeyReleased(e);
    }
}
