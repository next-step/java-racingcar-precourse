package racinggame.model;

public class Distance {

	private static final int ADD_CAR_DISTANCE = 1;
	private final int distance;

	public Distance(int position){
		this.distance = position;
	}

	public int getDistance(){
		return this.distance;
	}

	public Distance move(){
		return new Distance(this.distance + ADD_CAR_DISTANCE);
	}
}
