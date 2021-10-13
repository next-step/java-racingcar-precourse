package racinggame.domain;

import racinggame.exception.InvalidInputException;
import racinggame.utils.StringUtils;

public class CarName {

	private static final int MAX_NAME_LENGTH = 5;

	private final String name;

	public CarName(final String name) {
		validateNameLength(name);
		this.name = name;
	}

	private void validateNameLength(final String name) {
		if(StringUtils.isEmpty(name) || name.length() > MAX_NAME_LENGTH) {
			throw new InvalidInputException("자동차 이름은 5글자 이하만 가능합니다.");
		}
	}
}
