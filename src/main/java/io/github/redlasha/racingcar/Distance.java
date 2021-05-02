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

}
