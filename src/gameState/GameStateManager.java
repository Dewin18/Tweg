package gameState;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import levels.Level1;

public class GameStateManager {

	ArrayList<GameState> states = new ArrayList<>();

	public GameStateManager() {
		states.add(new Level1(this));
	}

	// graphics update
	public void draw(Graphics2D g) {
		states.get(0).draw(g);
	}

	// logic, velocity update
	public void update() {
		states.get(0).update();
	}

	// movements updates
	public void handleKeyPressed(KeyEvent e) {
		states.get(0).handleKeyPressed(e);
	}

	public void handleKeyReleased(KeyEvent e) {
		states.get(0).handleKeyReleased(e);
	}
}
