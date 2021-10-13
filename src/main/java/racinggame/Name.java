package racinggame;

import racinggame.common.CommonCode;
import racinggame.common.CommonMessage;

public class Name {
	private final String name;

	public Name(String name) {
		validateLength(name);
		this.name = name;
	}

	public String value() {
		return this.name;
	}

	private void validateLength(String name) {
		if (isWrongLength(name)) {
			throw new IllegalArgumentException(CommonMessage.ERROR_MESSAGE_VALIDATE_NAME_LENGTH);
		}
	}

	private boolean isWrongLength(String name) {
		int length = name.length();
		if (length < CommonCode.LENGTH_BOUNDARY_MIN_VALUE || length > CommonCode.LENGTH_BOUNDARY_MAX_VALUE) {
			return true;
		}
		return false;
	}
}
