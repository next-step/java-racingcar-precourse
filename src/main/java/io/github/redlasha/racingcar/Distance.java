package io.github.redlasha.racingcar;

public class Distance {

	private int distance;

	public Distance() {

	}

	Distance(int distance) {
		this.distance = distance;
	}

	public void add() {
		this.distance++;
	}

	public int get() {
		return this.distance;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		if (distance != ((Distance)obj).distance) {
			return false;
		}
		return true;
	}

}
