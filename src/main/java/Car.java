public class Car {
	private final int LIMIT_NAME_LENGTH = 5;

	private final String name;
	private int location = 0;

	public Car(String name) {
		if (!hasPassedNameRule(name)) {
			throw new IllegalArgumentException(String.format("자동차 이름은 최대 %d자 까지만 가능합니다.", LIMIT_NAME_LENGTH));
		}
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public int getLocation() {
		return this.location;
	}

	public void go() {
		this.location++;
	}

	boolean hasPassedNameRule(String name) {
		return name != null && name.length() <= LIMIT_NAME_LENGTH;
	}
}
