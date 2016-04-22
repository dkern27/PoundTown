package FarmGame;

import java.util.ArrayList;

public class GameEngine {

	private Player player;
	private ArrayList<Level> levels;
	private int currentLevel;
	
	public GameEngine() {
		// TODO Auto-generated constructor stub
	}
	
	public void nextLevel(){
		currentLevel++;
	}
	
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
	
	public boolean gameOver(){
		return false;
	}

	public static void main(String[] args) {
		
	}
	
	
	
}
