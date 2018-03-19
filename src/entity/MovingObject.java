package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import main.GamePanel;

public abstract class MovingObject {

    // object position
    protected int xPos;
    protected int yPos;

    // object size
    protected int width;
    protected int height;

    // collision box for each moving object
    protected Rectangle collisionBox;

    // constructor set the collision box to the same size of the moving object
    public MovingObject(int xPos, int yPos, int width, int height) {
	collisionBox = new Rectangle(xPos, yPos, width, height);
	loadObjectImage();
    }

    public abstract void loadObjectImage();

    public abstract void draw(Graphics2D g2);

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
	return (this.getXPos() >= (0 - this.getWidth()) && this.getXPos() <= GamePanel.WIDTH) && 
	       (this.getYPos() >= (0 - this.getHeight()) && this.getYPos() <= GamePanel.HEIGHT);
    }
}
