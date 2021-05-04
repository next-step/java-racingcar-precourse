package domain;

import java.util.Objects;

import util.RandomUtils;

public class RacingCar {
	private final RacingCarName racingCarName;
	private final Position position;

	public RacingCar(String name) {
		this.racingCarName = new RacingCarName(name);
		this.position = new Position(0);
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

	public boolean isMoveNumber(int moveNumber) {
		return moveNumber >= 4;
	}

	public RacingCarName getRacingCarName() {
		return racingCarName;
	}

	public Position getPosition() {
		return this.position;
	}

	public void move() {
		int randomNumber = RandomUtils.getRandomNumber();
		if (isMoveNumber(randomNumber)) {
			this.position.plus();
		}
	}
}
