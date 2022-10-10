package racingcar.domain;

public class Record {

	private final String name;
	private final CurrentPosition position;

	private Record(String name, CurrentPosition position) {
		this.name = name;
		this.position = position;
	}

	public static Record from(RacingCar racingCar) {
		return new Record(racingCar.getName(), racingCar.getCurrentPosition());
	}

	public String getName() {
		return name;
	}

	public CurrentPosition getPosition() {
		return position;
	}
}
