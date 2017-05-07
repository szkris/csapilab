import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Menu {
	protected JPanel panel;
	
	public Menu(){
		panel = new JPanel();
		
		//Buttons
			JButton newGameButton = new JButton("Új játék");
			JButton exitButton = new JButton("Kilépés");
			newGameButton.addActionListener(new newGameButtonActionListener());
			exitButton.addActionListener(new exitButtonActionListener());
			panel.add(newGameButton);
			panel.add(exitButton);
	}
	
	public class newGameButtonActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			newGame();
		}
	}

	public class exitButtonActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			exit();
		}
	}

	public void newGame(){
		
	}
	
	public void exit(){
		
	}
}
