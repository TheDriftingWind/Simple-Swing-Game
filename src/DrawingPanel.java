

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.*;
import java.util.ArrayList;
public class DrawingPanel extends javax.swing.JPanel {
   
   private Player _player;
   private StateHolder _holder;
   private AnimTimer _timer;
   private ArrayList<Enemy> _Enemies;
   private ArrayList<Bullet> _Bullets;
   private int _Difficulty;
   private MainPanel _main;

   
    public DrawingPanel(StateHolder holder, MainPanel main) {
       super();    
       this.setBackground(java.awt.Color.black);
       this.setPreferredSize(new java.awt.Dimension(500, 500));
       this.setSize(new java.awt.Dimension(500, 500));
       this.setFocusable(true);
       this.addKeyListener(new KeyPressListener(this));
       _main = main;
       _Enemies = new ArrayList();
       _Bullets = new ArrayList();
       _timer = new AnimTimer(this, _main, _Bullets, _Enemies);
       _timer.start();
       _holder = holder;
       _player = new Player(250, 400, _holder, _Enemies, this, _main);
       _Difficulty = _holder.getDifficulty();

    }
    
    public void setDifficulty(int d){
    	_Difficulty = d;
    }
    
    public int getDifficulty(){
    	return _Difficulty;
    }
 
    public void reset(){
    	_player.setLocation(250, 400);
    	_Enemies.clear();
    	_Bullets.clear();
    	_main.setScore(0);
    	_main.GameOverScoreLabel("");
    	refocus();
    	start();

    }
    public void stop(){
    	_timer.stop();
    }
    public void start(){
    	_timer.start();
    }
    public void removeBullet(Bullet b){
    	_Bullets.remove(b);
    }
    public void removeEnemy(int i){
    	_Enemies.remove(i);
    }
    public void removeEnemy(Enemy e){
    	_Enemies.remove(e);
    }
    
    public void checkBounds(){
    	if (_Bullets != null) {
			for (int i = 0; i < _Bullets.size(); i++) {
				_Bullets.get(i).checkOutOfBounds();
			}
		}
    	if (_Enemies != null) {
			System.out.println("_E not null _E.size() = " + _Enemies.size());
			for (int i = 0; i < _Enemies.size(); i++) {
				_Enemies.get(i).checkOutofBounds();
			}
		}
    }
    public void checkCollision(){
    	if (_Bullets != null) {
			System.out.println("_B not null B.size() = " + _Bullets.size() );
			for (int i = 0; i < _Bullets.size(); i++) {
				_Bullets.get(i).checkCollision();
			}
		}
    	_player.checkCollision();
    }
    public void paintComponent(Graphics g) {
       super.paintComponent(g);
       Graphics2D brush = (Graphics2D) g;
       _player.paint(brush);
       for (int i = 0 ; i < _Enemies.size(); i++){
    	   _Enemies.get(i).paint(brush);
       }
       for (int j = 0 ; j < _Bullets.size(); j++){
    	   _Bullets.get(j).paint(brush);
       }
    }
    
    public void addEnemy(){
    	int random;
    	random = (int)(Math.random()*30);
    	if (random > 10 && random <= 25){
    		_Enemies.add(new Enemy((int)(Math.random()*500), -70, _Bullets, _player, this));
    	}else if(random > 0 && random <= 10){
    		_Enemies.add(new Meteor((int)(Math.random()*500-500), -250, _Bullets, _player, this ));
    	}else{
    		_Enemies.add(new Mine((int)(Math.random()*500), -70, _Bullets, _player, this));
    	}
    }
   
    public void move(){
    	_player.move();
    	for (int i = 0 ; i < _Enemies.size(); i++){
    		_Enemies.get(i).move();
    	}
    	for (int i = 0 ; i < _Bullets.size(); i++){
    		_Bullets.get(i).move();
    	}
    }
    public void refocus(){
    	this.grabFocus();
    }
    private class KeyPressListener implements java.awt.event.KeyListener{
    	// make drawing panel focusable
    	private DrawingPanel _dp;
    	public KeyPressListener(DrawingPanel dp){
    		_dp = dp;
    	}
    	@Override
    	public void keyPressed(KeyEvent e) {
    		if (e.getKeyCode() == KeyEvent.VK_A ){
    			_holder.setState(1);
    			_player.react();
    		}
    		else if (e.getKeyCode() == KeyEvent.VK_SPACE){
    			_Bullets.add(new Bullet(_player, _Enemies, _dp, _main));
    		}
    		else if (e.getKeyCode() == KeyEvent.VK_D){
    			_holder.setState(2);
    			_player.react();
    			//move player right
    			//state 2
    		}
    	}

    	@Override
    	public void keyReleased(KeyEvent arg0) {
    		_holder.setState(0);
    		_player.react();
    		//stop the player
    		//state 0
    	}

    	@Override
    	public void keyTyped(KeyEvent arg0) {}

    }
}
   