package racinggame.model;

public class CarPosition {

	private int position;

	public CarPosition(int position){
		this.position = position;
	}

	public int getPosition(){
		return this.position;
	}

	public CarPosition move(int addPosition){
		return new CarPosition(this.position + addPosition);
	}
}
