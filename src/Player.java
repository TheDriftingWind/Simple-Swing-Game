import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Player {

	private Image _player;
	private int _x, _y, _width, _height;
	private int _state; //state 0 = idle | state 1 = move left | state 2 = move right |
	private StateHolder _holder;
	private ArrayList<Enemy> _E;
	private DrawingPanel _dp;
	private MainPanel _main;
	
	public Player(int x, int y, StateHolder holder, ArrayList<Enemy> e, DrawingPanel dp, MainPanel main){
		_player = new ImageIcon("Images/PlayerPlane.png").getImage();
		_main = main;
		_E = e;
		_dp = dp;
		_width = 64;
		_height = 64;
		_x = x;
		_y = y;
		_holder = holder;
		_state = 0;
	}
	
	public void paint(Graphics2D g) {
		g.drawImage(_player, _x, _y, null);
	}
	public void setLocation(int x, int y){
		_x = x;
		_y = y;
	}
	
	public int getX(){
		return _x;
	}
	public int getY(){
		return _y;
	}
	public void setX(int x){
		_x = x;
	}
	public void setY(int y){
		_x = y;
	}
	
	public void move() {
		if (_state == 0){
			setLocation(_x, _y);
		}
		else if (_state == 1){
			if (_x < 0){
				_x = 0;
			}
			setLocation(_x - 10, _y);
		}
		else if (_state == 2){
			if (_x > 500){
				_x = 500-32;
			}
			//move right
			setLocation(_x + 10, _y);
		}
	}
	public void checkCollision() {
		for (int i = 0; i < _E.size(); i++){
//			System.out.println("x = "+ ""+ _E.get(i).getX() + "x2 =" + _E.get(i).getX() + 64 + "y = " +  _E.get(i).getY() +"y2 = " + _E.get(i).getY()+64);
			if (((_x >= _E.get(i).getX() && _x <= _E.get(i).getX() + _E.get(i).getWidth())&&(_y >= _E.get(i).getY() && _y <= _E.get(i).getY()+_E.get(i).getHeight())) || ((_x + _width >= _E.get(i).getX() && _x + _width <= _E.get(i).getX() + _E.get(i).getWidth())&&(_y + _height >= _E.get(i).getY() && _y + _height <= _E.get(i).getY()+_E.get(i).getHeight())) ) {
				_main.GameOverScoreLabel("GAME OVER");
				_dp.stop();
			}
		}
	}
	
	public void react() {
		_state = _holder.getState();
		System.out.println("State:" + _state);
	}
}
