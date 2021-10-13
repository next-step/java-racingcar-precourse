package racinggame.model;

import nextstep.utils.Randoms;

public class Car {
	private static final int THRESHOLD = 4;
	private static final int RANGE_START = 0;
	private static final int RANGE_END = 9;

	private String name;
	private int position;

	public Car(String name){
		this.name = name;
		this.position = 0;
	}

	public String getName(){
		return this.name;
	}

	public int getPosition() { return this.position; }

	public void move() {
		if (isMoving()) {
			this.position++;
		}
	}

	private boolean isMoving(){
		int randomNum = Randoms.pickNumberInRange(Car.RANGE_START, Car.RANGE_END);
		return randomNum >= Car.THRESHOLD;
	}
}
