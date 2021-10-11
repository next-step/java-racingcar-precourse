package racinggame;

public class RacingCar {
	private final int MIN_NAME_LENGTH = 0;
	private final int MAX_NAME_LENGTH = 5;

	private String name;

	public RacingCar(String recingCarName) {
		this.name = recingCarName;
	}

	public boolean checkCarNameLength() {
		int nameLength = getNameLength();
		return nameLength > MIN_NAME_LENGTH && nameLength <= MAX_NAME_LENGTH;
	}

	int getNameLength() {
		return this.name.length();
	}
}
