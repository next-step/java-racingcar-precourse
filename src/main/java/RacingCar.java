import java.util.Objects;

public class RacingCar {
	private final RacingCarName racingCarName;
	private final MoveCount moveCount;

	RacingCar(String name) {
		this.racingCarName = new RacingCarName(name);
		this.moveCount = new MoveCount(0);
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

	public RacingCarName getRacingCarName() {
		return racingCarName;
	}

	public MoveCount getMoveCount() {
		return this.moveCount;
	}

	public void move() {
		int randomNumber = RandomUtils.getRandomNumber();
		if (isMoveNumber(randomNumber)) {
			this.moveCount.plus();
		}
	}
}
