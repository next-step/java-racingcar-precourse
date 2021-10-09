package racinggame.model;

import java.util.Optional;

public class Car {

	private static final int NAME_MAX_LENGTH = 5;
	private static final String NAME_EXCEPTION_MESSAGE = "자동차의 이름이 잘못되었습니다.";
	private static final String NAME_LENGTH_EXCEPTION_MESSAGE = "자동차는 %d글자 이하의 이름이어야 합니다.";
	private static final String EMPTY_STRING = "";
	private static final int START_POSITION = 0;
	private static final int INCREASE_POSITION_INDEX = 1;
	private static final int MOVED_INDEX = 4;
	private static final String MOVE_NUMBER_EXCEPTION_MESSAGE = "입력 값은 0~9 사이여야 합니다.";

	private final String name;
	private int position;

	private Car(String name) {
		validateName(name);
		this.name = name;
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
		return name;
	}

	public int getPosition() {
		return position;
	}

	private void validateName(String name) {
		if (isNullOrEmpty(name)) {
			throw new IllegalArgumentException(NAME_EXCEPTION_MESSAGE);
		}
		if (name.length() > NAME_MAX_LENGTH) {
			throw new IllegalArgumentException(String.format(NAME_LENGTH_EXCEPTION_MESSAGE, NAME_MAX_LENGTH));
		}
	}

	private boolean isNullOrEmpty(String name) {
		return Optional.ofNullable(name)
			.map(String::trim)
			.orElse(EMPTY_STRING)
			.isEmpty();
	}
}
