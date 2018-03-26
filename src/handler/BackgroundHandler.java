package handler;

import java.awt.Graphics2D;
import java.util.ArrayList;

import background.AbstractBackgrounds;
import background.Background;
import background.BackgroundsEnum;
import background.Level1Backgrounds;
import background.Level2Backgrounds;
import main.GamePanel;

public class BackgroundHandler {

	private static AbstractBackgrounds currentBackgrounds;

	public static void setBackgrounds(BackgroundsEnum level) {
		switch (level) {
		case LEVEL_1:
			currentBackgrounds = new Level1Backgrounds();
			break;
		case LEVEL_2:
			currentBackgrounds = new Level2Backgrounds();
		}
	}

	public static void updateBackgrounds() {
		ArrayList<Background> backgrounds = currentBackgrounds.getBackgrounds();

		for (Background background : backgrounds) {
			int bgYPos = background.getYPos();
			bgYPos--;
			background.setYPos(bgYPos);
		}
	}

	public static void drawBackgrounds(Graphics2D g) {
		ArrayList<Background> backgrounds = currentBackgrounds.getBackgrounds();

		for (Background background : backgrounds) {
			if (background.isOnCamera())
				background.draw(g);
			else if (background.getYPos() < 0) {
				background.setYPos((backgrounds.size() - 1) * GamePanel.HEIGHT - 1);
			}

		}
	}
}
