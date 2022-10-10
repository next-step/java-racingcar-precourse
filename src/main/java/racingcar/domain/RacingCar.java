package racingcar.domain;

import racingcar.strategy.MovingStrategy;
import racingcar.utils.StringUtils;

import java.util.Objects;

public class RacingCar {

	private static final int STARTING_POSITION = 0;
	private static final int MINIMUM_CAR_NAME_LENGTH = 5;
	private static final String NAME_LENGTH_ERROR_MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다.";
	private static final String NAME_BLANK_ERROR_MESSAGE = "자동차 이름은 공백일 수 없습니다.";

	private final String name;
	private final CurrentPosition currentPosition;

	public RacingCar(String name) {
		validateCarName(name);
		this.name = name;
		this.currentPosition = new CurrentPosition(STARTING_POSITION);
	}

	private void validateCarName(String name) {
		validateEmptyName(name);
		validateNameLength(name);
	}

	private void validateNameLength(String name) {
		if (isExceededMinimumLength(name)) {
			throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
		}
	}

	private boolean isExceededMinimumLength(String name) {
		return name.length() >= MINIMUM_CAR_NAME_LENGTH;
	}

	private void validateEmptyName(String name) {
		if (StringUtils.isBlank(name)) {
			throw new IllegalArgumentException(NAME_BLANK_ERROR_MESSAGE);
		}
	}

	public int getPositionValue() {
		return currentPosition.getValue();
	}

	public CurrentPosition getCurrentPosition() {
		return currentPosition;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		RacingCar racingCar = (RacingCar)o;

		return Objects.equals(name, racingCar.name);
	}

	@Override
	public int hashCode() {
		return name != null ? name.hashCode() : 0;
	}

	public void move(MovingStrategy movingStrategy) {
		if (movingStrategy.isMovable()) {
			move();
		}
	}

	protected void move() {
		currentPosition.increasePosition();
	}
}
