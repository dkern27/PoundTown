package FarmGame;

import java.util.ArrayList;

public class CheckList {

	private ArrayList<Animal> checklist;
	private ArrayList<Animal> found;
	
	public CheckList(ArrayList<Animal> allAnimals) {
		
	}
	
	public boolean foundAll(){
		
		for (Animal animal: checklist) {
			if (!found.contains(animal)) {
				return false;
			}
		}
		return true;
	}


	public ArrayList<Animal> getChecklist() {
		return checklist;
	}

}