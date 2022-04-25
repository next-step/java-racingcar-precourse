package racingcar.domain;

import java.util.Objects;

public class CarLocation implements Comparable<CarLocation> {
	private static final char LOCATION_SYMBOL = '-';
	private final int location;

	public CarLocation(int location) {
		if (location < 0) {
			throw new IllegalArgumentException("자동차의 위치는 마이너스가 될 수 없습니다.");
		}
		this.location = location;
	}

	public CarLocation increase() {
		return new CarLocation(location + 1);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CarLocation that = (CarLocation) o;
		return location == that.location;
	}

	@Override
	public int hashCode() {
		return Objects.hash(location);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < location; i++) {
			builder.append(LOCATION_SYMBOL);
		}
		return builder.toString();
	}

	@Override
	public int compareTo(CarLocation o) {
		return location - o.location;
	}
}
