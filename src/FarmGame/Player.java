package FarmGame;

import java.util.ArrayList;

public class Player {

	private ArrayList<Animal> checklist;
	private ArrayList<Animal> found;
	
	public Player() {
		// TODO Auto-generated constructor stub
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