package FarmGame;

import java.awt.*;

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
	private JPanel currentLevelPanel; 
	
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
		
		drawLevel();
		
		//Start Dialog
		StartDialog start = new StartDialog();
		start.setVisible(true);
	}
	
	public void drawLevel(){
		
		//Clear the window
		getContentPane().removeAll();
		
		levelMap = new LevelGUI( theGame.getLevels().get(theGame.getCurrentLevelNumber()).getLookForFile(),
				theGame.getCurrentLevel().getLocations(),
				this );
		currentPanel = levelMap;
		add(currentPanel, BorderLayout.CENTER);
		
		//Build sidebar
		sidebar = new JPanel();
		sidebar.setLayout(new BoxLayout( sidebar, BoxLayout.PAGE_AXIS ));

		//Add level identifier to sidebar
		currentLevelPanel = new JPanel();
		currentLevelPanel.setBorder(new TitledBorder(new EtchedBorder(), ""));
		JLabel levelText = new JLabel("Level " + theGame.getCurrentLevelNumber() );
		Font font = new Font("Comic Sans MS", Font.PLAIN, 45);
		levelText.setFont(font);
		levelText.setHorizontalAlignment(JLabel.CENTER);
		levelText.setVerticalAlignment(JLabel.CENTER);
		currentLevelPanel.add(levelText);
		sidebar.add(currentLevelPanel);
		
		//Add the checklist to the sidebar
		checklist = theGame.getLevels().get(theGame.getCurrentLevelNumber()).getChecklist().draw();
		sidebar.add(checklist);

		//Add sidebar to main gui
		add(sidebar, BorderLayout.WEST);
		
		this.validate();
		this.repaint();
	}
	
	public void goToLocation(JPanel panel){
			remove(currentPanel);
			currentPanel=panel;
			add(panel,BorderLayout.CENTER);
			this.validate();
			this.repaint();
	}
	
	public void returnToMap(){
		
		if(theGame.getCurrentLevel().levelComplete()){
			JOptionPane.showMessageDialog(this, "Congratulations! You Completed Level " + theGame.getCurrentLevelNumber()+"!");
			theGame.nextLevel();
			
			if(theGame.gameOver()) {
				GameOver theEnd = new GameOver();
				theEnd.setVisible(true);
				return;
			}
			
		}
		drawLevel();
		levelMap.startMouseListener();
	}
	
////// Getters and Setters //////
	
	public GameEngine getTheGame(){
		return theGame;
	}
	
}
