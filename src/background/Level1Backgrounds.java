package background;

import main.GamePanel;

public class Level1Backgrounds extends AbstractBackgrounds {

	public void initBackgrounds() {
		Background background1 = new Background(0, 0 * GamePanel.HEIGHT, GamePanel.WIDTH, GamePanel.HEIGHT);
		Background background2 = new Background(0, 1 * GamePanel.HEIGHT, GamePanel.WIDTH, GamePanel.HEIGHT);

		background1.setBackgroundImage("src/resources/Level1/level01_map01.PNG");
		background2.setBackgroundImage("src/resources/Level1/level01_map02.PNG");

		backgrounds.add(background1);
		backgrounds.add(background2);
	}
}
