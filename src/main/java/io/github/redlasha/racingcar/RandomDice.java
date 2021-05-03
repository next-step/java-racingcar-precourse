package io.github.redlasha.racingcar;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class RandomDice implements RandomNumbersGeneratable {

	private static final int MAX_VALUE = 9;
	private final SecureRandom random;

	public RandomDice() {
		this.random = new SecureRandom();
	}

	int nextNumber() {
		return this.random.nextInt(MAX_VALUE);
	}

	@Override
	public List<Integer> nextNumberList(int size) {
		if (size <= 0) {
			throw new IllegalArgumentException("Size must be positive integer.");
		}
		final List<Integer> list = new ArrayList<>(size);
		for (int i = 0; i < size; i++) {
			list.add(nextNumber());
		}
		return list;
	}
}
