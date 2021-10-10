package racinggame.domain;

public class CarName {
	private String carName;

	public CarName(String carName) {
		validateCarName(carName);
		this.carName = carName;
	}

	private void validateCarName(String carName) {
		if (carName.length() > 5 || carName.length() < 1) {
			throw new IllegalArgumentException();
		}
	}

	public String getCarName() {
		return this.carName;
	}
}
