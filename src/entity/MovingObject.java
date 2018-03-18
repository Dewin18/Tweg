package entity;

import java.awt.Graphics2D;

import main.GamePanel;

public abstract class MovingObject {

	public abstract void draw(Graphics2D g2);

	// object position
	public abstract int getXPos();

	public abstract int getYPos();

	public abstract void setXPos(int xPos);

	public abstract void setYPos(int yPos);

	// object size
	public abstract int getWidth();

	public abstract int getHeight();

	// check if object is in visible area
	public boolean isOnCamera() {
		return (this.getXPos() >= (0 - this.getWidth()) && this.getXPos() <= GamePanel.WIDTH) && 
			   (this.getYPos() >= (0 - this.getHeight()) && this.getYPos() <= GamePanel.HEIGHT);
	}
}
