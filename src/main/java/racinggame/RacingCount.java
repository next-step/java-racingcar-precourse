package racinggame;

public class RacingCount {
	private final int count;

	public RacingCount(String userInput) {
		this.count = Integer.parseInt(userInput);
	}

	public int getCount() {
		return count;
	}
}
