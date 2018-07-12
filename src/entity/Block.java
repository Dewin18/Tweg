package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Block extends InteractiveObject {

	private BufferedImage blockImg;

	public Block(int xPos, int yPos, int width, int height) {
		super(xPos, yPos, width, height);
		
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
	}

	public void loadObjectImage() {
		blockImg = null;
		try {
			System.out.println("IMAGE LOADED");
			blockImg = ImageIO.read(new File("src/resources/solid_block.PNG"));

		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}

	public void draw(Graphics2D g) {
		g.drawImage(blockImg, xPos, yPos, width, height, null);
		collisionBox.setLocation(xPos, yPos);
		
//		g.setColor(Color.CYAN);
//		g.draw(collisionBox);
	}

}
