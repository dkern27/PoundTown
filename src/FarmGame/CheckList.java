package FarmGame;

import java.util.ArrayList;
import java.util.Random;

public class CheckList {

	private ArrayList<Animal> animals = new ArrayList();
	private static final int NUM_ANIMALS_TO_FIND = 6;
	
	public CheckList(ArrayList<Animal> allAnimals) {
		Random rand = new Random();
		while(animals.size() < NUM_ANIMALS_TO_FIND){
			Animal a = allAnimals.get(rand.nextInt(allAnimals.size()));
			if(!animals.contains(a))
				animals.add(a);
		}
	}
	
	public boolean foundAll(){
		
		for (Animal animal: animals) {
			if (!animal.getFound()) {
				return false;
			}
		}
		return true;
	}


	public ArrayList<Animal> getChecklist() {
		return animals;
	}
	
	public void setChecklist(ArrayList<Animal> check){
		animals = check;
	}

}