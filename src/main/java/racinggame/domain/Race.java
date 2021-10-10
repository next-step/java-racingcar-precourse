package racinggame.domain;

public class Race {

	private final LineUp lineUp;

	private final Integer tryNumber;

	public Race(LineUp lineUp, Integer tryNumber) {
		this.lineUp = lineUp;
		this.tryNumber = tryNumber;
	}

	public void drive() {
		for (int i = 0; i < tryNumber; i++) {
			lineUp.drive();
		}
	}
}
