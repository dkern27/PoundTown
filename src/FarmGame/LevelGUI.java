package FarmGame;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.*;

public class LevelGUI extends JPanel implements MouseListener {
	
	Map <LocationType,Location> locations;
	
	public LevelGUI( String fileName, Map <LocationType, Location> l ) {
		
		locations = l;
		
		BufferedImage backgroundImage = null;
		try {
			backgroundImage = ImageIO.read( getClass().getResource(fileName) );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel picLabel = new JLabel(new ImageIcon( backgroundImage ));
		add(picLabel);
		
		addMouseListener(this);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		MainGUI.locationToDraw = null;
		for (MapClickBox c : GameEngine.clickBoxes){
			if(c.contains(e.getX(), e.getY())){
				{ 
				MainGUI.locationToDraw = c.getLocationType(); //This tells the MainGUI which location to draw
				System.out.println(c.getLocationType());
				repaint(); //This repaints LevelGUI... but I don't know how to repaint MainGUI from here
				}
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
