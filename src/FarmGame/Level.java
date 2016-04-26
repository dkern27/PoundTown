package FarmGame;

import java.util.ArrayList;

public class Level {
	
	private String name;
	private ArrayList<Location> locations;
	private boolean levelComplete;
	private String backgroundFile;
	
	public Level( String name, String backgroundFile) {
		this.name = name;
		this.backgroundFile = backgroundFile;
		levelComplete = false;
		
		//Initialize locations
		
	}
	
	public LevelGUI draw() {
		LevelGUI gui = new LevelGUI( backgroundFile );
		return gui;
	}
	

////// Getters and Setters //////
	
	public ArrayList<Location> getLocations() {
		return locations;
	}

	public String getName() {
		return name;
	}

}