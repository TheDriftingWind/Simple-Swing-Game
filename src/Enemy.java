import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Enemy {

	private Image _enemy;
	private int _x, _y;
	private int _height,_width;
	private DrawingPanel _dp;

	
	public Enemy(int x, int y, ArrayList<Bullet> b, Player p, DrawingPanel dp){
		_enemy = new ImageIcon("Images/EnemyCraft.png").getImage();
		_dp = dp;
		_x = x;
		_y = y;
		_height = 64;
		_width = 64;
	}
	
	public void paint(Graphics2D g) {
		g.drawImage(_enemy, _x, _y, null);
	}
	public void setLocation(int x, int y){
		_x = x;
		_y = y;
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
		setLocation(_x, _y + 5);
	}
	
}
