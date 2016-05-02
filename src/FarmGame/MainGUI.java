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
	
	private GameEngine theGame;
	public LocationType locationToDraw;
	private LevelGUI levelMap;
	private JPanel currentPanel;
	private Opener opener;
	private CheckListGUI checklist;
	private JPanel sidebar;
	
	public MainGUI( GameEngine theGame ) {

		this.theGame = theGame;
		
		//Open new window
		setSize(1000, 530);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		//Start with the opening scene
		opener();
	}
	
	public void opener() {
		opener = new Opener(this);
		add(opener);
	}
	
	public void startLevel() {
		
		//Clear the window
		getContentPane().removeAll();
		
		levelMap = new LevelGUI( theGame.getLevels().get(theGame.getCurrentLevel()).getLookForFile(),
				theGame.getLevels().get(theGame.getCurrentLevel()).getLocations(),
				this );
		currentPanel = levelMap;
		add(currentPanel, BorderLayout.CENTER);
		
		//Build sidebar
		sidebar = new JPanel();
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
		checklist = theGame.getLevels().get(theGame.getCurrentLevel()).getChecklist().draw();
		sidebar.add(checklist);

		//Add sidebar to main gui
		add(sidebar, BorderLayout.WEST);
		
		this.validate();
		this.repaint();
		
		//Start Dialog
		StartDialog start = new StartDialog();
		start.setVisible(true);
	}
	
	
	public void goToLocation(JPanel panel){
		
			remove(currentPanel);
			currentPanel=panel;
			add(panel,BorderLayout.CENTER);
			this.validate();
			this.repaint();
	}
	
	public void returnToMap(){
		remove(currentPanel);
		currentPanel = levelMap;
		levelMap.startMouseListener();
		add(currentPanel,BorderLayout.CENTER);
		this.validate();
		this.repaint();
		
	}
	
	
	public void updateChecklistGUI(){
		sidebar.remove(checklist);
		checklist = theGame.getLevels().get(theGame.getCurrentLevel()).getChecklist().draw();
		sidebar.add(checklist);
	}
	
	public GameEngine getTheGame(){
		return theGame;
	}

}
