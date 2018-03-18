package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends MovingObject {

	public static final int STANDARD_VELOCITY = 7;

	// player position
	private int xPos;
	private int yPos;

	// player size
	private int width;
	private int height;

	// player image
	private BufferedImage playerImg;

	public Player(int xPos, int yPos, int width, int height) {
		this.width = width;
		this.height = height;

		loadPlayerImage();
	}

	private void loadPlayerImage() {
		playerImg = null;
		try {
			System.out.println("IMAGE LOADED");
			playerImg = ImageIO.read(new File("src/resources/square.PNG"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void draw(Graphics2D g) {
		g.drawImage(playerImg, xPos, yPos, width, height, null);
	}

	// player positions
	public int getXPos() {
		return xPos;
	}

	public int getYPos() {
		return yPos;
	}

	public void setXPos(int xPos) {
		this.xPos = xPos;
	}

	public void setYPos(int yPos) {
		this.yPos = yPos;
	}

	// player size
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

}
