package racinggame.domain;

public class Position implements Comparable<Position> {

	private static final int START_POSITION_VALUE = 0;

	private int value;

	private Position(int value) {
		this.value = value;
	}

	public static Position init() {
		return new Position(START_POSITION_VALUE);
	}

	public int getValue() {
		return this.value;
	}

	public void move() {
		value++;
	}

	@Override
	public int compareTo(Position o) {
		return Integer.compare(this.value, o.getValue());
	}

}
