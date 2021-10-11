package racinggame;

public class CarName {
	private String carName;

	CarName(String carName) {
		this.carName = carName;
	}

	public String value() {
		return carName;
	}

	@Override
	public String toString() {
		return carName;
	}
}
