package domain.car;

import java.util.Objects;

public class Position implements Comparable<Position> {

	public static final int DEFAULT_VALUE = 1;
	public static final String DEFAULT_UNDER_ERROR_MESSAGE = "기본값 1 보다 작을 수 없습니다.";

	private final int value;

	public Position() {
		this(DEFAULT_VALUE);
	}

	public Position(int value) {
		validateValue(value);
		this.value = value;
	}

	public Position increment() {
		return new Position(this.value + 1);
	}

	public int getValue() {
		return value;
	}

	private void validateValue(int value) {
		if(value < DEFAULT_VALUE) {
			throw new IllegalArgumentException(DEFAULT_UNDER_ERROR_MESSAGE);
		}
	}

	public int toInt() {
		return value;
	}

	@Override
	public int compareTo(Position dest) {
		if (dest.toInt() > toInt()) {
			return -1;
		} else if (dest.toInt() < toInt()) {
			return 1;
		}

		return 0;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Position position = (Position)o;
		return Objects.equals(value, position.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

}
