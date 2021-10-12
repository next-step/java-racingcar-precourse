package racinggame;

public class CarPosition {
	private int position;

	public CarPosition(int position) {
		this.position = position;
	}

	public CarPosition(CarPosition carPosition, int position) {
		this.position = carPosition.getPosition() + position;
	}

	public int getPosition() {
		return position;
	}
}
