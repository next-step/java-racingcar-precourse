package racinggame.domain;

import java.util.Objects;

import racinggame.strategy.MovingStrategy;

public class RacingCar {
	private Name name;
	private Position position;

	public RacingCar(final String name) {
		this.name = new Name(name);
		this.position = new Position();
	}

	public int move(MovingStrategy strategy) {
		if (strategy.isMoveable()) {
			return position.move();
		}
		return position.getCurrentPosition();
	}

	public RacingCarDto toDto() {
		return new RacingCarDto(name.getCarName(), position.getCurrentPosition());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		RacingCar racingCar = (RacingCar)o;
		return name.equals(racingCar.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}