package com.racingcar;

public class RandomNumber {
	private int value;

	private RandomNumber(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static RandomNumber create() {
		return new RandomNumber((int)(Math.random() * 10));
	}
}
