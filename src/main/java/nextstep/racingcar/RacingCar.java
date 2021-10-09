package nextstep.racingcar;

import java.util.Objects;

public class RacingCar {

	private static final int MIN_REQUIREMENT_FOR_MOVEMENT = 4;

	private final CarName carName;
	private final Position position;

	public RacingCar(String name) {
		this(name, 0);
	}

	public RacingCar(String name, int position) {
		this.carName = new CarName(name);
		this.position = new Position(position);
	}

	public RacingCar(CarName carName, Position position) {
		this.carName = carName;
		this.position = position;
	}

	public RacingCar move(int input) {
		if (input >= MIN_REQUIREMENT_FOR_MOVEMENT) {
			return new RacingCar(carName, position.move());
		}
		return this;
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
