package FarmGame;

import java.awt.*;
import javax.swing.*;

public class MainGUI extends JFrame {

	public MainGUI( GameEngine theGame ) {

		//Open new window
		setSize(1000, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Add the level map picture	
		LevelGUI levelMap = theGame.getLevels().get(theGame.getCurrentLevel()).draw();
		add(levelMap, BorderLayout.CENTER);
		
		//Add the checklist
		CheckListGUI checklist = theGame.getLevels().get(theGame.getCurrentLevel()).getChecklist().draw();
		add(checklist, BorderLayout.WEST);
	}

}
