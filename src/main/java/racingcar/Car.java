package racingcar;

public class Car {
	private final int MAX_NAME_LENGTH = 5;
	private final int MOVE_MIN_VALUE = 4;
	private String name;
	private CarPosition carPosition;

	public CarPosition getCarPosition() {
		return carPosition;
	}

	public String getName() {
		return name;
	}

	public Car(String name) {
		this.name = isValidCarName(name);
		this.carPosition = new CarPosition();
	}

	private String isValidCarName(String name) {
		if (checkLength(name)) {
			throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
		}
		if (name.isEmpty()) {
			throw new IllegalArgumentException("입력된 이름이 없습니다.");
		}
		return name;
	}

	private boolean checkLength(String name) {
		return name.length() > MAX_NAME_LENGTH;
	}

	public CarStatus isForward(int moveValue) {
		if (isMove(moveValue)) {
			return CarStatus.GO;
		}
		return CarStatus.STOP;
	}

	private boolean isMove(int moveValue) {
		return moveValue >= MOVE_MIN_VALUE;
	}
}
