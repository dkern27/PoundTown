package FarmGame;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Location {
	
	private String name;
	private ArrayList<Animal> animals = new ArrayList<Animal>();
	private String backgroundFile;
	private Animal correctAnimal;
	private static final int NUM_ANIMALS = 6;

	public Location(String name, String backgroundFile, ArrayList<Animal> checklist, ArrayList<Animal> allPossibleAnimals) {
		this.name = name;
		this.backgroundFile=backgroundFile;
		
		//Populate location with animals
		Random rand = new Random();
		correctAnimal = checklist.get(rand.nextInt(checklist.size()));
		animals.add(correctAnimal);
		//Get 5 more animals
		while(animals.size() < NUM_ANIMALS){
			Animal a = allPossibleAnimals.get(rand.nextInt(allPossibleAnimals.size()));
			//Add if the animal is not already in animals
			if(!animals.contains(a)){
				animals.add(a);
			}
		}
	}
	
	
	
	public void draw(Graphics g){
		
	}
	
	public ArrayList<Animal> getAnimals() {
		return animals;
	}

}
