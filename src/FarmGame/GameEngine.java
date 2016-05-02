package FarmGame;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameEngine {

	private ArrayList<Level> levels;
	private int currentLevel;
	private final int maxLevel = 4;
	public static ArrayList<MapClickBox> clickBoxes = new ArrayList<MapClickBox>();

	public static LocationType currentLocation = null;
	
	public GameEngine() {
		currentLevel = 1;
		
		//Initialize levels
		levels = new ArrayList<Level>();
		levels.add(0, null);
		//These should have maps instead of level images... but until then, this will do
		levels.add(1, new Level( "Chicken", "/BackgroundImages/FindHens.jpg", 4, AnimalType.CHICKEN));
		levels.add(2, new Level( "Sheep", "/BackgroundImages/FindSheep.jpg", 5, AnimalType.SHEEP));
		levels.add(3, new Level( "Pig", "/BackgroundImages/FindPigs.jpg", 6, AnimalType.PIG));
		levels.add(4, new Level( "Cow", "/BackgroundImages/FindCows.jpg", 7, AnimalType.COW));
		
		generateClickBoxes();
		
	}
	
	public void nextLevel() {
		//Move to next level if the player has found all the animals
		if( levels.get(currentLevel).levelComplete() ) {
			//have message to display level up? JOptionPane.showMessageDialog(panel, "Congratulations! You beat level " + Integer.toString(currentLevel)) + "!");
			currentLevel++;
		}
		else {
			//Do nothing
		}	
	}
	
	private void generateClickBoxes() {
		clickBoxes.add(new MapClickBox(110,200,150,150,LocationType.FOREST));
		clickBoxes.add(new MapClickBox(110,150,350,40,LocationType.VOLCANO));
		clickBoxes.add(new MapClickBox(75,160,420,200,LocationType.POND));
		clickBoxes.add(new MapClickBox(60,210,320,320,LocationType.FIELD));
		clickBoxes.add(new MapClickBox(115,110,600,260,LocationType.TOWN));
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

	public int getCurrentLevelNumber() {
		return currentLevel;
	}
	
	public Location getCurrentLocation(){
		return levels.get(currentLevel).getLocations().get(currentLocation);
	}
	
	public void setCurrentLevel(int c){
		currentLevel=c;
	}
	
	public Level getCurrentLevel(){
		return levels.get(currentLevel);
	}
	
}
