package racinggame.domain;

public class CarPosition {
	private static final String MOVING = "-";

	private StringBuilder position;

	public CarPosition() {
		position = new StringBuilder();
	}

	public void movePosition() {
		position.append(MOVING);
	}

	public String getCarPosition() {
		return position.toString();
	}
}
