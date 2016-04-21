package FarmTests;


import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class GeneralTests {

	private static GameEngine game;
	
	@Before
	public static void setUp() {
		game = new GameEngine();
	}
	
	@Test
	public void testMoveToNextLevel() {
		
		//Load the players checklist
		Player player = game.getPlayer();
		ArrayList checklist = player.getChecklist();
		
		//Find all the animals on the list
		for( Animal a : checklist ) {
			animal.found();
		}
		
		//All the animals should now be found
		assertTrue( player.foundAll() );
		
		//Move to the next level, will trigger if foundAll() is true
		game.nextLevel();
		
		//If everything works, game is now on second level
		assertEquals( 2, game.getCurrentLevel() );
	}
	
	@Test
	public void testGameOver() {
		//Set game at first level
		game.setCurrentLevel(1);
		
		//Game should not be over yet
		assertTrue( !game.gameOver() );
		
		//Set game to a level higher than max level
		game.setCurrentLevel(999);
		
		//Game should be over
		assertTrue( game.gameOver() );
	}
	
}
