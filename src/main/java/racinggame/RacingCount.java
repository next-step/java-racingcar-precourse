package racinggame;

public class RacingCount {
	private final int count;

	public RacingCount(String userInput) {
		try {
			this.count = Integer.parseInt(userInput);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 숫자를 입력 해주세요.");
		}
	}

	public int getCount() {
		return count;
	}
}
