package precourse.car;

import precourse.utility.MovementNumber;

public class RacingCar {

	private final RacingCarName name;
	private final RacingCarPosition position;

	public RacingCar(RacingCarName name) {
		this.name = name;
		this.position = new RacingCarPosition();
	}

	public void decideMovement(MovementNumber movementNumber) {
		if (movementNumber.isMovableNumber()) {
			position.moveForward();
		}
	}

	public String getCurrentStatus() {
		return getCarName() + "\t: " + position.describeAsSymbol() + "\n";
	}

	public boolean isWinner(int maxPosition) {
		return position.isMaxPosition(maxPosition);
	}

	public String getCarName() {
		return name.getName();
	}

	public int getPosition() {
		return position.getNumber();
	}
}
