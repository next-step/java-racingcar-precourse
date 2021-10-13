package racinggame.model;

public class Car {

	private static final int MIN_POSITION_MOVE = 4;
	private static final int MAX_POSITION_MOVE = 9;
	private static final int INIT_CAR_POSITION = 0;
	private static final int ADD_CAR_POSITION = 1;

	private final CarName name;
	private CarPosition position;

	public Car(String name) {
		this.name = new CarName(name);
		this.position = new CarPosition(INIT_CAR_POSITION);
	}

	public String getName() {
		return name.getName();
	}

	public void race(int number) {
		if (isMove(number)) {
			this.position = this.position.move(ADD_CAR_POSITION);
		}
	}

	private boolean isMove(int number) {
		return number >= MIN_POSITION_MOVE && number <= MAX_POSITION_MOVE;
	}

	public int getPosition() {
		return this.position.getPosition();
	}

}
