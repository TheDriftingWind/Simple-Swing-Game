
public class StateHolder {

	private int _state;
	private int _difficulty;
	
	public StateHolder() {
		_state = 0;
		_difficulty = 30;
	}
	
	public int getState(){
		return _state;
	}
	
	public void setState(int state){
		this._state = state;
	}
	
	public int getDifficulty(){
		return _difficulty;
	}
	public void setDifficulty(int difficulty){
		this._difficulty = difficulty;
	}
}
