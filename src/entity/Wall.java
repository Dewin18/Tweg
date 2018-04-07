package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Wall extends InteractiveObject {
    private BufferedImage wallImg;

    public Wall(int xPos, int yPos, int width, int height) {
	super(xPos, yPos, width, height);

	this.xPos = xPos;
	this.yPos = yPos;
	this.width = width;
	this.height = height;
    }

    public void loadObjectImage() {
	wallImg = null;
	try {
	    System.out.println("IMAGE LOADED");
	    wallImg = ImageIO.read(new File("src/resources/wall2.PNG"));

	} catch (IOException e) {
	    e.printStackTrace();

	}
    }

    public void draw(Graphics2D g) {
	g.drawImage(wallImg, xPos, yPos, width, height, null);
	collisionBox.setLocation(xPos, yPos);
	g.setColor(Color.CYAN);
	// g.setColor(new Color(0, 0, 0, 1F));
	g.draw(collisionBox);
    }
}
