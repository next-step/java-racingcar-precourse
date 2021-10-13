package racinggame;

import java.util.Objects;

public class CarName {
	private final String name;

	public CarName(String name) {
		validateLengthOf(name);
		this.name = name;
	}

	private void validateLengthOf(String carName) {
		if (carName.trim().isEmpty()) {
			throw new IllegalArgumentException("자동차의 이름은 공백을 사용할 수 없습니다");
		}

		if (5 < carName.length()) {
			throw new IllegalArgumentException("자동차의 이름은 5자 이하여야 합니다");
		}
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		CarName carName = (CarName)o;
		return Objects.equals(name, carName.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
