package domain.car;

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
	public String toString() {
		return this.carName;
	}
}
