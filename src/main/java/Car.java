public class Car {
	private final int LIMIT_NAME_LENGTH = 5;
	private final String name;
	private int location = 0;

	public Car(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public boolean hasPassedNameRule(String name) {
		return name != null && name.length() <= LIMIT_NAME_LENGTH;
	}

	public int getLocation() {
		return this.location;
	}

	public void go() {
		this.location++;
	}
}
