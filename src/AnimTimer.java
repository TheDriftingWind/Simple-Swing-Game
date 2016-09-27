import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

public class AnimTimer extends Timer {

	private DrawingPanel _dp;
	private MainPanel _main;
	private int _counter;
	private ArrayList<Bullet> _B;
	private ArrayList<Enemy> _E;

	// private int _difficulty; // this will be higher to spawn less enemies,
	// and lesser to spawn more.
	public AnimTimer(DrawingPanel dp, MainPanel main, ArrayList<Bullet> b, ArrayList<Enemy> e) {
		super(25, null);
		_B = b;
		_E = e;
		// this timer animates the image
		_dp = dp;
		_main = main;
		// counter decides when the enemies spawn
		_counter = 0;
		this.addActionListener(new MoveListener());
	}

	private class MoveListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			_dp.move();
			_dp.repaint();
			//collision and bounds detection
			_dp.checkBounds();
			_dp.checkCollision();
			//score
			_main.setScore(_main.getScore() + 1);
			// _counter < _difficulty
			if (_counter < _dp.getDifficulty()) {
				_counter++;
			} else {
				_dp.addEnemy();
				_counter = 0;
			}

		}

	}

}
