package FarmGame;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LocationGUI extends JPanel{

	public LocationGUI(String fileName) {
		BufferedImage backgroundImage = null;
		try {
			backgroundImage = ImageIO.read( new File(fileName) );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel picLabel = new JLabel(new ImageIcon( backgroundImage ));
		add(picLabel);
	}

}
