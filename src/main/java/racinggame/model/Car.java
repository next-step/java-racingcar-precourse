package racinggame.model;

public class Car {

	private static final int MIN_DISTANCE_MOVE = 4;
	private static final int MAX_DISTANCE_MOVE = 9;
	private static final int INIT_CAR_DISTANCE = 0;

	private final CarName name;
	private Distance distance;

	public Car(String name) {
		this.name = new CarName(name);
		this.distance = new Distance(INIT_CAR_DISTANCE);
	}

	public String getName() {
		return name.getName();
	}

	public void move(int number) {
		if (isMove(number)) {
			this.distance = this.distance.move();
		}
	}

	private boolean isMove(int number) {
		return number >= MIN_DISTANCE_MOVE && number <= MAX_DISTANCE_MOVE;
	}

	public int getDistance() {
		return this.distance.getDistance();
	}

}
