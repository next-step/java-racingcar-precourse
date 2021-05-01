package com.racingcar;

public class RandomNumber {
	private static final int MIN = 0;
	private static final int MAX = 9;

	private int value;

	RandomNumber(int value) {
		if (value < MIN || value > MAX) {
			throw new IllegalArgumentException("랜덤 숫자는 0에서 9사이의 숫자여야 한다.");
		}
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static RandomNumber create() {
		return new RandomNumber((int)(Math.random() * 10));
	}
}
