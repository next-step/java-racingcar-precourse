package racingcar;

import java.util.Objects;

public class Car {
	private final int MAX_NAME_LENGTH = 5;
	private String name;
	private int position;

	public Car(String name) {
		this.name = isValidCarName(name);
		this.position = 0;
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

	public CarStatus paly(int moveValue) {
		if (isMove(moveValue)) {
			return CarStatus.GO;
		}

		return CarStatus.STOP;
	}

	private boolean isMove(int moveValue) {
		return moveValue >= 4;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Car car = (Car)o;
		return Objects.equals(name, car.name);
	}

}
