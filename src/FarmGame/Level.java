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
	
	
	public Level( String name, String backgroundFile, int numDigits, AnimalType animalType) {
		this.name = name;
		this.backgroundFile = backgroundFile;
		this.numDigits = numDigits;
		this.animalType = animalType;
		
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
		double maxNum = Math.pow(2, (numDigits))-1; 
		
		//Make an array of all the possible animals
		for( int i=0; i <= maxNum; i++ ) {
			animals.add( new Animal( animalType, i, numDigits ));
		}	
	}
	
	public void generateLocations() {
		locations.add( new Location( "name", LocationType.POND, checklist.getChecklist(), animals) );
		locations.add( new Location( "name", LocationType.FOREST, checklist.getChecklist(), animals) );
		locations.add( new Location( "name", LocationType.FIELD, checklist.getChecklist(), animals) );
		locations.add( new Location( "name", LocationType.VOLCANO, checklist.getChecklist(), animals) );
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