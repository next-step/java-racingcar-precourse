package domain.car;

import java.util.Objects;

public class Position implements Comparable<Position> {

	public static final int DEFAULT_VALUE = 1;
	public static final String DEFAULT_UNDER_ERROR_MESSAGE = "기본값 1 보다 작을 수 없습니다.";

	private Integer value;

	public Position(Integer value) {
		validateValue(value);
		this.value = value;
	}

	private void validateValue(Integer value) {
		if(value < DEFAULT_VALUE) {
			throw new IllegalArgumentException(DEFAULT_UNDER_ERROR_MESSAGE);
		}
	}

	public Position() {
		this(DEFAULT_VALUE);
	}

	public Integer getValue() {
		return value;
	}

	public void increment() {
		this.value++;
	}

	@Override
	public int compareTo(Position o) {
		return this.value.compareTo(o.getValue());
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
