package FarmGame;

import java.util.ArrayList;

public class GameEngine {

	private ArrayList<Level> levels;
	private int currentLevel;
	private final int maxLevel = 3;
	
	public GameEngine() {
		currentLevel = 1;
		
		//Initialize levels
		levels = new ArrayList<Level>();
		levels.add(0, null);
		//These should have maps instead of level images... but until then, this will do
		levels.add(1, new Level( "Chicken", "BackgroundImages/ChickenMap.jpg", 4, AnimalType.CHICKEN, "AnimalImages/Chicken.png"));
		levels.add(2, new Level( "Pig", "BackgroundImages/PigMap.jpg", 5, AnimalType.PIG, "AnimalImages/Pig.png"));
		levels.add(3, new Level( "Cow", "BackgroundImages/CowMap.jpg", 5, AnimalType.COW, "AnimalImages/Pig.png"));
		
	}
	
	public void nextLevel() {
		//Move to next level if the player has found all the animals
		if( levels.get(currentLevel).levelComplete() ) {
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
		GameEngine theGame = new GameEngine();
		
		//Start the gui
		MainGUI theGUI = new MainGUI( theGame );
		theGUI.setVisible(true);
		
		
	}
	
	
////// Getters and Setters //////
	

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
