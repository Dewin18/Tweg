package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import main.GamePanel;

public abstract class InteractiveObject {

    private final int boxSize = GamePanel.WIDTH;

    // object position
    protected int xPos;
    protected int yPos;

    // object size
    protected int width;
    protected int height;

    // collision box for each moving object
    protected Rectangle collisionBox;

    protected Rectangle topBox;
    protected Rectangle downBox;
    protected Rectangle leftBox;
    protected Rectangle rightBox;

    // constructor set the collision box to the same size of the moving object
    public InteractiveObject(int xPos, int yPos, int width, int height) {
	collisionBox = new Rectangle(xPos, yPos, width, height);

	topBox = new Rectangle(xPos, yPos - boxSize, width, boxSize);
	downBox = new Rectangle(xPos, yPos + height, width, boxSize);

	leftBox = new Rectangle(xPos - boxSize, yPos, boxSize, height);
	rightBox = new Rectangle(xPos + width, yPos, boxSize, height);

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
	return (this.getXPos() >= (0 - this.getWidth()) && this.getXPos() <= GamePanel.WIDTH)
		&& (this.getYPos() >= (0 - this.getHeight()) && this.getYPos() <= GamePanel.HEIGHT);
    }

    public boolean colide(InteractiveObject otherObject) {
	return this.collisionBox.intersects(otherObject.collisionBox);
    }

    public boolean rightOf(InteractiveObject otherObject) {
	return (this.getXPos() - 1) < (otherObject.getXPos() + otherObject.getWidth());
    }

    public boolean leftOf(InteractiveObject otherObject) {
	return (this.getXPos() + this.getWidth() + 1) > (otherObject.getXPos());
    }

    public boolean bottomOf(InteractiveObject otherObject) {
	return (this.getYPos() - 1) < (otherObject.getYPos() + otherObject.getHeight());
    }

    public boolean topOf(InteractiveObject otherObject) {
	return (this.getYPos() + this.getHeight() + 1) > (otherObject.getYPos());
    }

    // COLLISION
    public boolean leftCollision(InteractiveObject otherObject) {
	return this.rightOf(otherObject) && this.leftBox.intersects(otherObject.collisionBox);
    }

    public boolean rightCollision(InteractiveObject otherObject) {
	return this.leftOf(otherObject) && this.rightBox.intersects(otherObject.collisionBox);
    }

    // TODO bottom and up collision
    public boolean bottomCollision(InteractiveObject otherObject) {
	return this.topOf(otherObject) && this.downBox.intersects(otherObject.collisionBox);
    }

    public boolean topCollision(InteractiveObject otherObject) {
	return this.bottomOf(otherObject) && this.topBox.intersects(otherObject.collisionBox);
    }

    public boolean positiveDistance(InteractiveObject otherObject) {
	return (otherObject.getYPos() - (this.getYPos() + this.getHeight())) > 10;
    }

    public boolean negtiveDistance(InteractiveObject otherObject) {
	return (otherObject.getYPos() - (this.getYPos() + this.getHeight())) < 1;
    }

    public boolean nearestDistance(InteractiveObject otherObject) {
	return (otherObject.getYPos() - (this.getYPos() + this.getHeight())) < 2;
    }
}
