package FarmGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;



public class StartWindow extends JDialog{

	public StartWindow( ) {
		setTitle("Welcome to #Town!");
		setSize(500, 190);
		setLocation(250,200);
		setLayout(new FlowLayout());
		
		JPanel main = new JPanel();
		JPanel button = new JPanel();
		
//		JLabel message = new JLabel("Welcome to #Town! This is a great place, where nothing exciting ever happens. All your farm animals will be very happy here! They'll like.....", JLabel.CENTER);
//		main.add(message);
		
		Font font = new Font("Comic Sans MS", Font.PLAIN, 20);
		
		JTextArea message = new JTextArea("Welcome to #Town! This is a great place, where nothing exciting ever happens. Except lots of tornadoes.");
		message.setBackground(Color.CYAN);
		message.setFont(font);
		message.setSize(new Dimension(450,120));
		message.setLineWrap(true);
		message.setWrapStyleWord(true);
		main.add(message);
		
		
		JButton nextWindow = new JButton("Uhhh...");
		nextWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloseFrame();
				SecondStart start = new SecondStart();
				start.setVisible(true);
				
			}
		});

		
		button.add(nextWindow);
		
		add(main);
		add(button);
	}
	
	public void CloseFrame(){
	    super.dispose();
	}
}
