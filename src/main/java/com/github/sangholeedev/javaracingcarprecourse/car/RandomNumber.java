package com.github.sangholeedev.javaracingcarprecourse.car;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumber {
	public static final int MIN = 0;
	public static final int MAX = 10;
	private int number;

	public RandomNumber() {
		this.number = -1;
	}

	public int getNumber() {
		return number;
	}

	public void generate() {
		this.number = ThreadLocalRandom.current().nextInt(MIN, MAX);
	}

	public boolean isGreaterThanOrEqualTo4() {
		return number >= 4;
	}
}
