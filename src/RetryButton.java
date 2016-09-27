import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class RetryButton extends JButton{
	
	private DrawingPanel _dp;
	
	public RetryButton(DrawingPanel dp){
		super("Retry");
		_dp = dp;
		addActionListener(new RetryListener());
	}
	
	private class RetryListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			_dp.reset();
		
		}
		
	}
}
