package FarmGame;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class MainGUI extends JFrame {

	public static LocationType locationToDraw;
	
	public MainGUI( GameEngine theGame ) {

		//Open new window
		setSize(1020, 540);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Add the level map picture	
		LevelGUI levelMap = theGame.getLevels().get(theGame.getCurrentLevel()).draw();
		add(levelMap, BorderLayout.CENTER);
		System.out.println("Added level map : " + locationToDraw);
		
		//To look at a location specifically
		if (locationToDraw != null){
			System.out.println(locationToDraw);
			LocationGUI locationMap = theGame.getLevels().get(theGame.getCurrentLevel()).getLocations().get(locationToDraw).draw();
			add(locationMap,BorderLayout.CENTER);
		}
		System.out.println("Past if");
		
		//Build sidebar
		JPanel sidebar = new JPanel();
		sidebar.setLayout(new BoxLayout( sidebar, BoxLayout.PAGE_AXIS ));
		
		
		//Add level identifier to sidebar
		JPanel level = new JPanel();
		level.setBorder(new TitledBorder(new EtchedBorder(), ""));
		JLabel levelText = new JLabel("Level " + theGame.getCurrentLevel() );
		Font font = new Font("Comic Sans MS", Font.PLAIN, 45);
		levelText.setFont(font);
		levelText.setHorizontalAlignment(JLabel.CENTER);
	    levelText.setVerticalAlignment(JLabel.CENTER);
	    level.add(levelText);
	    sidebar.add(level);
		
		//Add the checklist to the sidebar
		CheckListGUI checklist = theGame.getLevels().get(theGame.getCurrentLevel()).getChecklist().draw();
		sidebar.add(checklist);
		
		//Add sidebar to main gui
		add(sidebar, BorderLayout.WEST);
	}

}
