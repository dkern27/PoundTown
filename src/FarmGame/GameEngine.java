package FarmGame;

import java.util.ArrayList;

public class GameEngine {

	private Player player;
	private ArrayList<Level> levels;
	private int currentLevel;
	private final int maxLevel = 3;
	
	public GameEngine() {
		//Create the player and start on level one
		player = new Player();
		currentLevel = 1;
		
		//Initialize levels
		
	}
	
	public void nextLevel() {
		//Move to next level if the player has found all the animals
		if( player.foundAll() ) {
			currentLevel++;
		}
		else {
			//Do nothing
		}	
	}
	
	
	public boolean gameOver() {
		//If player has reached beyond the max level then the game is over
		if( currentLevel > maxLevel ) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		
		//Create the game, initializes in the constructor
		GameEngine thegame = new GameEngine();
		
		
	}
	
	
////// Getters and Setters //////
	
	public Player getPlayer() {
		return player;
	}

	public ArrayList<Level> getLevels() {
		return levels;
	}

	public int getCurrentLevel() {
		return currentLevel;
	}
	
	public void setCurrentLevel(int c){
		currentLevel=c;
	}
	
}
