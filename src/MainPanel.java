

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class MainPanel extends JPanel {
	
	private int _score;
	private JLabel scorelabel;
	private JLabel gameoverlabel;
	public MainPanel(){
		super();
		this.setLayout(new BorderLayout());
		StateHolder holder = new StateHolder();
		// create the drawing panel and add it to the center
		DrawingPanel display = new DrawingPanel(holder, this);
		this.add(display,BorderLayout.CENTER);
		
		//create another row panel for the labels 
		JPanel lblPanel = new JPanel();
		
		//create the labels
		JPanel levelPanel = new JPanel();
		_score = 0;
		scorelabel = new JLabel("Score:" + _score);
		gameoverlabel = new JLabel("");
		levelPanel.add(gameoverlabel);
		levelPanel.add(scorelabel);
				
		//create the Jbuttons
		JPanel jButtonPanel = new JPanel();
//		QuitButton quit = new QuitButton();
		PauseButton pause = new PauseButton(display);
		RetryButton retry = new RetryButton(display);
		JButton quit = new JButton("Quit");
		jButtonPanel.add(quit);
		quit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
				
			}
		});
		//add the button to the panel 
		jButtonPanel.add(retry);
		//pause button stops the AnimTimer
		jButtonPanel.add(pause);
		jButtonPanel.add(quit);
	
		JPanel south = new JPanel(new GridLayout(1,2));
		this.add(south, BorderLayout.SOUTH);
				
		south.add(levelPanel);
		south.add(jButtonPanel);
				
		//create a clo panel for the radiobuttons place it to the east
		JPanel east = new JPanel(new GridLayout(3,1));
		this.add(east, BorderLayout.EAST);
		
	
		//add the radiobuttons
		ButtonGroup rbg = new ButtonGroup();
		ActionRadioButton easy = new ActionRadioButton("Easy", true, 30, display , rbg, holder);
		ActionRadioButton med = new ActionRadioButton("Medium", false, 20, display, rbg, holder);
		ActionRadioButton hard = new ActionRadioButton("Hard", false, 10, display, rbg, holder);
		east.add(easy);
		east.add(med);
		east.add(hard);
		
	}
	
	public void setScore(int score){
		_score = score;
		scorelabel.setText("Score:" + _score);
//		System.out.println(_score);
	}
	public void GameOverScoreLabel(String s){
		gameoverlabel.setText(s);
	}
	public int getScore(){
		return _score;
	}

}
