import java.util.Objects;

public class RacingCar {
	private final RacingCarName racingCarName;
	private int moveCount;

	RacingCar(String name) {
		this.racingCarName = new RacingCarName(name);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		RacingCar car = (RacingCar)o;
		return Objects.equals(racingCarName, car.racingCarName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(racingCarName);
	}

	boolean isMoveNumber(int moveNumber) {
		return moveNumber >= 4;
	}

	public int getMoveCount() {
		return this.moveCount;
	}

	public void moveFront() {
		this.moveCount++;
	}
}
