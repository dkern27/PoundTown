package FarmGame;

import java.awt.*;
import javax.swing.*;

public class MainGUI extends JFrame {

	public MainGUI( GameEngine theGame ) {

		//Open new window
		setSize(800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Add the level map picture
		LevelGUI levelMap = theGame.getLevels().get(theGame.getCurrentLevel()).draw();
		add(levelMap, BorderLayout.EAST);
	}

}
