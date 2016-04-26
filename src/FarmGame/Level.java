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
	
<<<<<<< HEAD
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
=======
	public void generateAnimals() {
		
		//Caluclate the maximum possible value given the number of binary digits
		double maxNum = Math.pow(2, numDigits) - 1;
		
		//Make an array of all the possible animals
		for( int i=0; i < maxNum; i++ ) {
			animals.add( new Animal( animalType, drawFile, i, numDigits ));
		}
		
	}
	
>>>>>>> origin/master

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