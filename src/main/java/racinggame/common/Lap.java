package racinggame.common;

import racinggame.exception.InvalidNumberException;

public class Lap {
	private final int labs;

	public Lap(String consoleInput) {
		validateLabs(consoleInput);
		validatePositiveNumber(consoleInput);

		this.labs = Integer.parseInt(consoleInput);
	}

	private void validateLabs(String labs) {
		try {
			Integer.parseInt(labs);
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

	public int getLabs() {
		return labs;
	}
}
