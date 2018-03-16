package main;

public class Game {
	
	GameFrame game;
	
	public Game() {
		showGame();
	}
	
	private void showGame() {
		game = new GameFrame();
		game.show();
	}
}
