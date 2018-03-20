package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Ceiling extends InteractiveObject {

	private BufferedImage ceilingImg;
	
	public Ceiling(int xPos, int yPos, int width, int height) {
		super(xPos, yPos, width, height);

		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
	}

	public void loadObjectImage() {
		ceilingImg = null;
		try {
			System.out.println("IMAGE LOADED");
			ceilingImg = ImageIO.read(new File("src/resources/ceiling.PNG"));

		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}

	public void draw(Graphics2D g) {
		g.drawImage(ceilingImg, xPos, yPos, width, height, null);
		collisionBox.setLocation(xPos, yPos);
		
		g.setColor(new Color(0, 0, 0, 0F));
		g.draw(collisionBox);
	}

}
