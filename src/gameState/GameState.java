package gameState;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

public abstract class GameState {

	protected GameStateManager gsm;

	public abstract void draw(Graphics g);

	public abstract void update();

	public abstract void handleKeyPressed(KeyEvent e);

	public abstract void handleKeyReleased(KeyEvent e);
}
