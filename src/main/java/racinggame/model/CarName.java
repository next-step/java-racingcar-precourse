package racinggame.model;

public class CarName {
	private final int MAX_LENGTH = 5;

	private final String name;

	public CarName(String name) {
		if (name.length() > MAX_LENGTH) {
			throw new IllegalArgumentException(MAX_LENGTH + "자 이하만 가능합니다.");
		}
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}
