package background;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Background {

	private BufferedImage background;

	// object position
	protected int xPos;
	protected int yPos;

	// object size
	protected int width;
	protected int height;

	public Background(int xPos, int yPos, int width, int height) {

		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
	}

	public void setBackgroundImage(String path) {
		background = null;
		try {
			System.out.println("IMAGE LOADED");
			background = ImageIO.read(new File(path));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void draw(Graphics2D g) {
		Objects.requireNonNull(background);

		g.drawImage(background, xPos, yPos, width, height, null);
	}

	public int getXPos() {
		return this.xPos;
	}

	public int getYPos() {
		return this.yPos;
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

	// check if object is in visible area
	public boolean isOnCamera() {
		return (this.getXPos() >= (0 - this.getWidth()) && this.getXPos() <= GamePanel.WIDTH)
				&& (this.getYPos() >= (0 - this.getHeight()) && this.getYPos() <= GamePanel.HEIGHT);
	}
}
