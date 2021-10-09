package racinggame.model;

import java.util.Optional;

public class CarName {

	private static final int NAME_MAX_LENGTH = 5;
	private static final String NAME_EXCEPTION_MESSAGE = "자동차의 이름이 잘못되었습니다.";
	private static final String NAME_LENGTH_EXCEPTION_MESSAGE = "자동차는 %d글자 이하의 이름이어야 합니다.";
	private static final String EMPTY_STRING = "";

	private final String name;

	public CarName(String name) {
		validateName(name);
		this.name = name;
	}

	public static CarName valueOf(String name) {
		return new CarName(name);
	}

	public String getName() {
		return name;
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
