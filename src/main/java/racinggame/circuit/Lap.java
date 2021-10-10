package racinggame.circuit;

import java.util.Objects;

import racinggame.exception.InvalidNumberException;

public class Lap {
	private final int laps;

	public Lap(String consoleInput) {
		validateLaps(consoleInput);
		validatePositiveNumber(consoleInput);

		this.laps = Integer.parseInt(consoleInput);
	}

	private void validateLaps(String laps) {
		try {
			Integer.parseInt(laps);
		} catch (NumberFormatException error) {
			throw new NumberFormatException("[ERROR] 1 이상 자연수를 입력하세요.");
		}
	}

	private void validatePositiveNumber(String consoleInput) {
		int lab = Integer.parseInt(consoleInput);

		if (lab <= 0) {
			throw new InvalidNumberException("[ERROR] 1 이상 자연수를 입력하세요.");
		}
	}

	public int getLaps() {
		return laps;
	}
}
