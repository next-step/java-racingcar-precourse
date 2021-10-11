package racinggame.model;

import java.util.Optional;

public class TryNumber {
	private final int number;

	private TryNumber(int number) {
		this.number = number;
	}

	public static TryNumber of(int number) {
		return new TryNumber(number);
	}

	public static Optional<TryNumber> of(String numberStr) {
		try {
			TryNumber newInstance = new TryNumber(Integer.parseInt(numberStr));
			return Optional.of(newInstance);
		} catch (NumberFormatException e) {
			return Optional.empty();
		}
	}

	public int getNumber() {
		return number;
	}

	public boolean isValid() {
		return number > 0;
	}
}
