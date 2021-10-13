package racinggame.domain;

import racinggame.exception.ErrorMessage;
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
			throw new InvalidInputException(ErrorMessage.CAR_NAME_MAX_LENGTH.getMessage());
		}
	}
}
