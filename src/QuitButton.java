

import javax.swing.*;
import java.awt.event.*;
public class QuitButton extends JButton {

	public QuitButton() {
		super("Quit");
		addActionListener(new QuitListener());
	}
	
	private class QuitListener implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);  // exit program
		}
	}
}