package racinggame.domain;

import java.util.Objects;

public class Distance {
	private int length;

	private Distance(int length) {
		if (length < 0) {
			throw new IllegalArgumentException("거리는 마이너스가 될 수 없습니다");
		}
		this.length = length;
	}

	public static Distance of(int length) {
		return new Distance(length);
	}

	public void increase() {
		length++;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Distance distance = (Distance) o;
		return length == distance.length;
	}

	@Override
	public int hashCode() {
		return Objects.hash(length);
	}
}
