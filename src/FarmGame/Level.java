package FarmGame;

import java.util.ArrayList;
import java.util.Random;

public class Level {
	
	private String name;
	private String backgroundFile;
	private ArrayList<Location> locations;
	private int numDigits;
	private ArrayList<Animal> animals;
	private AnimalType animalType;
	private String drawFile; //For animal
	private boolean levelComplete;
	
	
	public Level( String name, String backgroundFile) {
		this.name = name;
		this.backgroundFile = backgroundFile;
		levelComplete = false;
		
		//Initialize animals
		generateAnimals();
		
	}
	

	public LevelGUI draw() {
		LevelGUI gui = new LevelGUI( backgroundFile );
		return gui;
	}
	


	public void generateAnimals() {
		
		//Caluclate the maximum possible value given the number of binary digits
		double maxNum = Math.pow(2, numDigits) - 1;
		
		//Make an array of all the possible animals
		for( int i=0; i < maxNum; i++ ) {
			animals.add( new Animal( animalType, drawFile, i, numDigits ));
		}
		
	}
	

////// Getters and Setters //////
	
	public ArrayList<Location> getLocations() {
		return locations;
	}
	
	public ArrayList<Animal> getAnimalsList() {
		return animals;
	}

	public String getName() {
		return name;
	}



}