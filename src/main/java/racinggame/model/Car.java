package racinggame.model;

public class Car {

	private static final int START_POSITION = 0;
	private static final int INCREASE_POSITION_INDEX = 1;
	private static final int MOVED_INDEX = 4;
	private static final String MOVE_NUMBER_EXCEPTION_MESSAGE = "입력 값은 0~9 사이여야 합니다.";

	private final CarName carName;
	private int position;

	private Car(String name) {
		this.carName = CarName.valueOf(name);
		this.position = START_POSITION;
	}

	public static Car valueOf(String name) {
		return new Car(name);
	}

	public void move(int moveNumber) {
		if (moveNumber < 0 || moveNumber > 9) {
			throw new IllegalArgumentException(MOVE_NUMBER_EXCEPTION_MESSAGE);
		}
		this.position = moveAction(this.position, moveNumber);
	}

	private int moveAction(int position, int moveNumber) {
		if (isMoved(moveNumber)) {
			return position + INCREASE_POSITION_INDEX;
		}

		return position;
	}

	private boolean isMoved(int moveNumber) {
		return moveNumber >= MOVED_INDEX;
	}

	public String getName() {
		return carName.getName();
	}

	public int getPosition() {
		return position;
	}
}
