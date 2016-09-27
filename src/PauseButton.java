import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class PauseButton extends JButton {
	private DrawingPanel _dp;

	public PauseButton(DrawingPanel dp) {
		super("Pause");
		_dp = dp;
		addActionListener(new PauseListener());
	}

	private class PauseListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (getText().equals("Pause")) {
				_dp.stop();
				setText("Resume");
			} else if (getText().equals("Resume")) {
				_dp.start();
				setText("Pause");
				_dp.refocus();
			}
		}
	}
}
