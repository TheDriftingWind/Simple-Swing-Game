import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Meteor extends Enemy {

	private Image _meteor;
	private int _x , _y;
	private int _height, _width;
	private DrawingPanel _dp;
	
	public Meteor(int x, int y, ArrayList<Bullet> b, Player p, DrawingPanel dp) {
		super(x, y, b, p, dp);
		_dp = dp;
		_meteor = new ImageIcon("Images/Meteor.png").getImage();
		_x = x;
		_y = y;
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
		g.drawImage(_meteor, _x, _y, null);
	}
	
	public void move(){
		this.setLocation(_x+5, _y+5);
	}

}
