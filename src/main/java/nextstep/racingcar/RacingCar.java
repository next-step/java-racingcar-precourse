package nextstep.racingcar;

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

}
