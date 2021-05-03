package Car;

public class Car {
	public static final int NAME_LENGTH_MAX = 5;

	private final String name;

	public Car(String name) {
		if (name.length() > NAME_LENGTH_MAX) {
			throw new IllegalArgumentException("자동차 이름은 " + NAME_LENGTH_MAX + "자 이하만 가능하다.");
		}
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

}
