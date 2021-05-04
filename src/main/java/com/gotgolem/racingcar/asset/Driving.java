package com.gotgolem.racingcar.asset;

public class Driving {

	private static final int MIN_NUMBER = 0;
	private static final int MAX_NUMBER = 9;

	private final int number;

	public Driving(int number) {
		if (number < MIN_NUMBER || number > MAX_NUMBER) {
			throw new IllegalArgumentException();
		}
		this.number = number;
	}

	public boolean isMove() {
		return number > 3;
	}

	public boolean isStop() {
		return !isMove();
	}

}
