package FarmGame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameOver extends JDialog{

	public GameOver() {
		setSize(500, 110);
		setLocation(200,300);
		setLayout(new GridLayout(2, 1));
		
		JPanel main = new JPanel();
		JPanel button = new JPanel();
		
		JLabel message = new JLabel( "Good Job! You've found all your animals and finished the game.", JLabel.CENTER);
		main.add(message);
	
		JButton close = new JButton("Exit Game");
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		button.add(close);
		
		add(main);
		add(button);
	}
}

