package racinggame;

public class GameCount {
	private final int gameCount;

	public GameCount(int gameCount) {
		if (gameCount <= 0) {
			throw new IllegalArgumentException("[ERROR] 0보다 큰 값을 입력해주세요.");
		}
		this.gameCount = gameCount;
	}

	public int getCount() {
		return gameCount;
	}
}
