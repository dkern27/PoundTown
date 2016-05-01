package FarmGame;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class MainGUI extends JFrame{
	
	GameEngine theGame;
	public LocationType locationToDraw;
	LevelGUI levelMap;
	LocationGUI locationGUI;
	JPanel currentPanel;
	
	public MainGUI( GameEngine theGame ) {

		this.theGame = theGame;
		//Open new window
		setSize(1020, 535);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		currentPanel = new LevelGUI( theGame.getLevels().get(theGame.getCurrentLevel()).getLookForFile(),
				theGame.getLevels().get(theGame.getCurrentLevel()).getLocations(),
				this );
		add(currentPanel, BorderLayout.CENTER);
		
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
	
	
	public void displayPanel(JPanel panel){
		
			remove(currentPanel);
			currentPanel=panel;
			add(panel,BorderLayout.CENTER);
			this.validate();
			this.repaint();
	}
	


}
