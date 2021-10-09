package nextstep.racingcar;

import java.util.Objects;

public class RacingCar {

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
		return new RacingCar(carName, position.move(input));
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
