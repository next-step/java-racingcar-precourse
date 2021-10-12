package racinggame;

public class Car {
	private final static int MAX_NAME_LENGTH = 5;

	private final String name;
	private CarPosition position;

	public Car(String name) {
		validationLength(name);
		this.name = name;
		position = new CarPosition(0);
	}

	public String getName() {
		return name;
	}

	private void validationLength(String name) {
		if (name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException("[ERROR] 이름은 " + MAX_NAME_LENGTH + "자 이하로 만들어야 합니다.");
		}
	}

	public void moveOrStop(int randomNo) {
		if (randomNo >= 4) {
			position = new CarPosition(position, 1);
		}
	}

	public int getPosition() {
		return position.getPosition();
	}
}
