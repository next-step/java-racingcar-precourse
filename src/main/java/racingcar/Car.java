package racingcar;

public class Car {
	private String name;
	private int position;

	public Car(String name) {
		this.name = name;
		this.position = 0;
	}

	public CarStatus paly(int moveValue) {
		if (isMove(moveValue)) {
			return CarStatus.GO;
		}

		return CarStatus.STOP;
	}

	private boolean isMove(int moveValue) {
		return moveValue >= 4;
	}
}
