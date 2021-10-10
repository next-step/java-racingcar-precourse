package racinggame.domain;

public class CarName {
	private final String carName;

	public CarName(String carName) {
		validateCarName(carName);
		this.carName = carName;
	}

	private void validateCarName(String carName) {
		if (carName.length() < 1 || carName.length() > 5) {
			throw new IllegalArgumentException();
		}
	}

	public String getCarName() {
		return this.carName;
	}
}
