package domain.car.name;

import java.util.Objects;

public class CarName {

	public static final int MAX_NAME_LENGTH = 5;

	public static final String SIZE_OVER_ERROR_MESSAGE = "자동차 이름은 5글자 이하만 됩니다.";

	private final String carName;

	public CarName(String carName) {
		this.carName = carName;
	}

	public static CarName of(String name) {
		validateName(name);
		return new CarName(name);
	}

	private static void validateName(String name) {
		if(name == null || name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException(SIZE_OVER_ERROR_MESSAGE);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		CarName carName1 = (CarName)o;
		return Objects.equals(carName, carName1.carName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(carName);
	}

	@Override
	public String toString() {
		return this.carName;
	}
}
