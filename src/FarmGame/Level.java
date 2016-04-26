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
	
	public String decimalToBinary(int dec) {
		
		//This is the final
		if (dec==0)
			return "0";
		if (dec==1)
			return "1";
		
		int temp = 2;
		while (temp <= dec){ //finds the highest multiple of two, but this will multiply by 2 too many times
			temp=temp*2;
		}
		temp=temp/2; //so divide once.

		return (dec % 2 + decimalToBinary(dec-temp)); //adds a 0 or 1 depending

	}

////// Getters and Setters //////
	
	public ArrayList<Location> getLocations() {
		return locations;
	}

	public String getName() {
		return name;
	}



}