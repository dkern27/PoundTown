package FarmGame;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class MainGUI extends JFrame {
	
	GameEngine theGame;
	public LocationType locationToDraw;
	LevelGUI levelMap;
	StartGUI opener;
	
	public MainGUI( GameEngine theGame ) {

		this.theGame = theGame;
		//Open new window
		setSize(1000, 520);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		opener();
		//startGame();
	}
	
	public void opener() {
		opener = new StartGUI(this);
		add(opener);
	}
	
	public void startGame() {
		remove(opener);
		
		//Add the level map picture	
		levelMap = theGame.getLevels().get(theGame.getCurrentLevel()).draw(this);
		add(levelMap, BorderLayout.CENTER);
		System.out.println("Added level map : " + locationToDraw);

		//				LocationGUI locationTest = theGame.getLevels().get(theGame.getCurrentLevel()).getLocations().get(LocationType.VOLCANO).draw();
		//				add(locationTest,BorderLayout.CENTER);

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
		
		this.validate();
		this.repaint();
		
		//Start Dialog
		StartWindow start = new StartWindow();
		start.setVisible(true);
	}
	
	public void goToLocation(LocationType newLocation){
		locationToDraw = newLocation;
		if (locationToDraw != null){
			remove(levelMap);
			System.out.println(locationToDraw);
			LocationGUI locationMap = theGame.getLevels().get(theGame.getCurrentLevel()).getLocations().get(locationToDraw).draw();
			add(locationMap,BorderLayout.CENTER);
			this.validate();
			this.repaint();
		}
	}

}
