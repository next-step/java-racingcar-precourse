package racinggame.racingcar;

public enum Racing {
	STOP(0), FORWARD(1);

	private final int value;

	Racing(int value) {
		this.value = value;
	}

	public int movable() {
		return this.value;
	}
}
