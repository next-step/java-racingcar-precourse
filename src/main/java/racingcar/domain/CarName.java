package racingcar.domain;

import java.util.Objects;

public class CarName {
	private static final int NAME_MINIMUM_LENGTH = 1;
	private static final int NAME_MAXIMUM_LENGTH = 5;
	private final String name;

	public CarName(String name) {
		if (!isNameLengthValid(name)) {
			throw new IllegalArgumentException("자동차의 이름은 1자 이상 5자 이하여야 합니다.");
		}
		this.name = name;
	}

	private boolean isNameLengthValid(String name) {
		return name.length() >= NAME_MINIMUM_LENGTH && name.length() <= NAME_MAXIMUM_LENGTH;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CarName carName = (CarName) o;
		return Objects.equals(name, carName.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public String toString() {
		return name;
	}
}
