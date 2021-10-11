package racinggame;

public class TryNumber {
	private final int number;

	public TryNumber(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public boolean isValid() {
		return number > 0;
	}
}
