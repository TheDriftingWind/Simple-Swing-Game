import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

public class ActionRadioButton extends JRadioButton {

	private DrawingPanel _dp;
	private int _difficulty;
	private StateHolder _stateHolder;
	
	public ActionRadioButton(String text, boolean selected, int difficulty, DrawingPanel dp, ButtonGroup bg, StateHolder stateHolder){
		super(text, selected);
		_dp = dp;
		_difficulty = difficulty;
		_stateHolder = stateHolder;
		bg.add(this);
		this.addActionListener(new ActionRadioButtonListener());
	}
	
	public int getDifficulty(){
		return _difficulty;
	}
	
	private class ActionRadioButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			//set the difficulty;
			//call drawingpanel.isFocused again to get the plane moving again
			_stateHolder.setDifficulty(_difficulty);
			_dp.setDifficulty(_stateHolder.getDifficulty());
			System.out.println("Difficulty:" + _difficulty);
		}
		
	}
}
