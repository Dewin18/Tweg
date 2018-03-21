package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ScrollingBackground extends InteractiveObject {

	private BufferedImage background;
	
	public ScrollingBackground(int xPos, int yPos, int width, int height) {
		super(xPos, yPos, width, height);
		
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
	}

	public void loadObjectImage() {
		background = null;
		try {
			System.out.println("IMAGE LOADED");
			background = ImageIO.read(new File("src/resources/karte.PNG"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void draw(Graphics2D g) {
		g.drawImage(background, xPos, yPos, width, height, null);
	}

}
