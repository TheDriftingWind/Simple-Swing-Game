import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Bullet {

	private Image _enemy;
	private int _x, _y;
	private ArrayList<Enemy> _E;
	private DrawingPanel _dp;
	private int _height, _width;
	private MainPanel _main;
	
	public Bullet(Player p, ArrayList<Enemy> e, DrawingPanel dp, MainPanel main){
		_enemy = new ImageIcon("Images/Bullet.png").getImage();
		_main = main;
		_x = p.getX();
		_y = p.getY();
		_dp = dp;
		_E = e;
	}
	
	public void paint(Graphics2D g) {
		g.drawImage(_enemy, _x, _y, null);
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
			setLocation(_x, _y - 10);
	}
	public void checkCollision(){
		for (int i = 0; i < _E.size(); i++){
//			System.out.println("x = "+ ""+ _E.get(i).getX() + "x2 =" + _E.get(i).getX() + 64 + "y = " +  _E.get(i).getY() +"y2 = " + _E.get(i).getY()+64);
			if (((_x+32 >= _E.get(i).getX() && _x+32 <= _E.get(i).getX() + _E.get(i).getWidth())&&(_y >= _E.get(i).getY() && _y <= _E.get(i).getY()+_E.get(i).getHeight())) || ((_x + _width+32 >= _E.get(i).getX() && _x + _width +32 <= _E.get(i).getX() + _E.get(i).getWidth())&&(_y + _height >= _E.get(i).getY() && _y + _height <= _E.get(i).getY()+_E.get(i).getHeight())) ) {
				_dp.removeBullet(this);
				_dp.removeEnemy(i);
				_main.setScore(_main.getScore() + 100);
				
			}
		}
	}
	
	public void checkOutOfBounds(){
		if (_y < 0){
			_dp.removeBullet(this);
		}
	}
}
