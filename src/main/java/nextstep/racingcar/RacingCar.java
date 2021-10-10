package nextstep.racingcar;

import java.util.Objects;

import nextstep.move.MoveStatus;
import nextstep.move.MovingStrategy;

public class RacingCar {

	private static final String DELIMITER = " : ";

	private final CarName carName;
	private final Position position;
	private final MovingStrategy movingStrategy;

	public RacingCar(String name, MovingStrategy movingStrategy) {
		this(name, 0, movingStrategy);
	}

	public RacingCar(String name, int position, MovingStrategy movingStrategy) {
		this.carName = new CarName(name);
		this.position = new Position(position);
		this.movingStrategy = movingStrategy;
	}

	public RacingCar(CarName carName, Position position, MovingStrategy movingStrategy) {
		this.carName = carName;
		this.position = position;
		this.movingStrategy = movingStrategy;
	}

	public RacingCar move() {
		if (movingStrategy.move() == MoveStatus.MOVE) {
			return new RacingCar(carName, position.move(), movingStrategy);
		}

		return this;
	}

	public String toString() {
		return carName + DELIMITER + position;
	}

	public Position getGreaterPosition(Position input) {
		return new Position(Math.max(position.getPosition(), input.getPosition()));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		RacingCar racingCar = (RacingCar)o;
		return Objects.equals(carName, racingCar.carName) && Objects.equals(position,
			racingCar.position);
	}

	@Override
	public int hashCode() {
		return Objects.hash(carName, position);
	}
}
