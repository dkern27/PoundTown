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



public class StartDialog extends JDialog{

	public StartDialog( ) {
		setTitle("Welcome to #Town!");
		setSize(500, 240);
		setLocation(250,200);
		setLayout(new FlowLayout());
		
		JPanel main = new JPanel();
		JPanel button = new JPanel();
		
		Font font = new Font("Comic Sans MS", Font.PLAIN, 20);
		
		JTextArea message = new JTextArea("Oh no! The tornado has swept away all your animals! Explore the island and find the animals on your list. Click on the animal with the binary number corresponding to a decimal number on your checklist to capture it.");
		message.setBackground(Color.CYAN);
		message.setEditable(false);
		message.setFont(font);
		message.setSize(new Dimension(450,120));
		message.setLineWrap(true);
		message.setWrapStyleWord(true);
		main.add(message);
		
		
		JButton nextWindow = new JButton("OK!");
		nextWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloseFrame();
				
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
