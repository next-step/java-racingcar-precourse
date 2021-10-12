package domain;

public class Car {
	public static final int NAME_MAX_LEN = 5;
	public static final String NAME_MAX_LEN_ERROR_MESSAGE = "[ERROR] 자동차 이름은 5자 이하만 가능합니다.";

	private String name;
	private int distance;

	public Car(String name) {
		if (name.length() > NAME_MAX_LEN) throw new IllegalArgumentException(NAME_MAX_LEN_ERROR_MESSAGE);

		this.name = name;
		this.distance = 0;
	}

	public String getName() {
		return this.name;
	}

	public int getDistance() {
		return this.distance;
	}
}
