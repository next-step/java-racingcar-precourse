package com.racingcar;

public class Location {
	private int value;

	private Location(int value) {
		this.value = value;
	}

	public static Location init() {
		return new Location(0);
	}

	public void increase() {
		this.value++;
	}

	public int getValue() {
		return value;
	}
}
