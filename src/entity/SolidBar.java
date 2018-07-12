package entity;

import java.util.ArrayList;
import java.util.Random;

public class SolidBar {

    private ArrayList<InteractiveObject> blocks;
    private int[] xPositions = new int[18];

    public SolidBar(int xPos, int yPos, int width, int height) {

	blocks = new ArrayList<>();
	// X Y W H
	// 30, 500, 30, 30

	initXPositions(xPos);
	initBlocks(xPos, yPos, width, height);
    }

    private void initXPositions(int xPos) {
	int index = 0;
	
	while (xPos <= 540) {
	    xPositions[index] = xPos;
	    xPos += 30;
	    index++;
	}
    }

    private void initBlocks(int xPos, int yPos, int width, int height) {

	int[] path = generatePath();

	while (xPos <= 540) {

	    if (!(xPos == path[0]) && !(xPos == path[1]))
		blocks.add(new Block(xPos, yPos, width, height));

	    xPos += 30;
	}
    }

    private int[] generatePath() {
	
	//zwei random zahlen von 1 - n-1
	
	Random rand = new Random();

	int path1 = rand.nextInt(17) + 1;
	int path2 = path1 - 1;
	
	int[] path = {xPositions[path1], xPositions[path2]};
	
	return path;
    }

    public ArrayList<InteractiveObject> getBlocks() {
	return blocks;
    }
    
    public boolean isOnCamera() {
	return blocks.get(0).isOnCamera();
    }
}
