package FarmTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import FarmGame.Animal;
import FarmGame.AnimalType;
import FarmGame.GameEngine;
import FarmGame.Level;
import FarmGame.Location;

public class LevelTests {
	
		private static Level level;
		private static GameEngine gEngine;
		private static Location location;
		
		
		//We will probably need to modify the BeforeClass once we start to write the methods
		@BeforeClass
		public static void setUp() {
			level = new Level("2",  "AnimalImages/Sheep.png", 3, AnimalType.PIG,"AnimalImages/Pig.png");
			gEngine = new GameEngine();

			location = new Location("1", "AnimalImages/Chicken.png", level.getChecklist().getChecklist(), level.getAnimalsList());
			
			
		}
	
		
		@Test
		public void levelOrderTest() {
			assertEquals(gEngine.getCurrentLevel(),1);
			gEngine.nextLevel();
			assertEquals(gEngine.getCurrentLevel(),2);
			gEngine.nextLevel();
			assertEquals(gEngine.getCurrentLevel(),3);
			//Tests if levels are increased in a sequential order
		}
		
		@Test
		public void animalLocation() {
			assertEquals(location.getAnimals().size(),4);
			//Tests that there are 4 animals per location
			int animalCounter = 0;
			for (Location l : level.getLocations()) {
				animalCounter += l.getAnimals().size();
			}
			assertEquals(animalCounter,16);
			//This goes through every location in levels and adds the amount of animals in each location
			//(I am assuming 4 locations) and tests to see if there is the correct amount of animals in the level
		}
		
		public void locationCorrectAnswer() {
			
		}

}