package racinggame;

public class CarName {
	private static final int NAME_LENGTH_MAX = 5;

	private final String name;

	public CarName(String name) {
		this.name = name;
	}

	public boolean isValid() {
		return this.name.length() <= NAME_LENGTH_MAX;
	}

	public String getName() {
		return name;
	}
}
