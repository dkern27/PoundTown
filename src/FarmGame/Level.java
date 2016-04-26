package FarmGame;

import java.util.ArrayList;
import java.util.Random;

public class Level {
	
	private String name;
	private String backgroundFile;
	private ArrayList<Location> locations = new ArrayList();
	private CheckList checklist;
	private int numDigits;
	private ArrayList<Animal> animals = new ArrayList();
	private AnimalType animalType;
	private String animalDrawFile; //For animal
	
	
	public Level( String name, String backgroundFile, int numDigits, AnimalType animalType, String animalDrawFile ) {
		this.name = name;
		this.backgroundFile = backgroundFile;
		this.numDigits = numDigits;
		this.animalType = animalType;
		this.animalDrawFile = animalDrawFile;
		
		//Initialize animals
		generateAnimals();
		
		//Create the checklist
		checklist = new CheckList(animals);
		
		//Initialize locations
		generateLocations();
		
	}
	

	public LevelGUI draw() {
		LevelGUI gui = new LevelGUI( backgroundFile );
		return gui;
	}

	public void generateAnimals() {
		
		//Calculate the maximum possible value given the number of binary digits
		double maxNum = Math.pow(2, numDigits);
		
		//Make an array of all the possible animals
		for( int i=0; i < maxNum; i++ ) {
			animals.add( new Animal( animalType, animalDrawFile, i, numDigits ));
		}	
	}
	
	public void generateLocations() {
		
	}
	
	public boolean levelComplete() {
		return checklist.foundAll();
	}

////// Getters and Setters //////
	
	public ArrayList<Location> getLocations() {
		return locations;
	}
	
	public ArrayList<Animal> getAnimalsList() {
		return animals;
	}
	
	public CheckList getChecklist() {
		return checklist;
	}
	
	public String getName() {
		return name;
	}
	
	public int getDigits(){
		return numDigits;
	}



}