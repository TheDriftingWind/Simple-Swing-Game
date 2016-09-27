import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Mine extends Enemy {

	private Image _mine;
	private int _x , _y;
	private Player _p;
	private int _height, _width;
	private DrawingPanel _dp;
	public Mine(int x, int y, ArrayList<Bullet> b, Player p, DrawingPanel dp) {
		super(x, y, b, p, dp);
		_dp = dp;
		_mine = new ImageIcon("Images/Mine.png").getImage();
		_x = x;
		_y = y;
		_p = p;
		_height = 64;
		_width = 64;
	}
	public int getX(){
		return _x;
	}
	public int getY(){
		return _y;
	}
	public void checkOutofBounds(){
		if (_y >= 500){
			_dp.removeEnemy(this);
		}
	}
	public int getHeight(){
		return _height;
	}
	public int getWidth(){
		return _width;
	}
	public void setLocation(int x, int y){
		_x = x;
		_y = y;
	}
	public void paint(Graphics2D g) {
		g.drawImage(_mine, _x, _y, null);
	}
	
	public void move(){
		int delta = 0;
		if (_x < _p.getX()){
			delta = 2;
		}
		else if (_x > _p.getX()){
			delta = -2;
		}else{
			delta = 0;
		}
		this.setLocation(_x+delta, _y+3);
	}

}