package racingcar;

public class GameCount {
	private int gameCount;

	public GameCount(String gameCount) {
		this.gameCount = isValidMoveCount(gameCount);
	}

	public int getGameCount() {
		return gameCount;
	}

	private int isValidMoveCount(String gameCount) {
		if (isPresentString(gameCount)) {
			throw new IllegalArgumentException("게임 진행 횟수를 입력하세요.");
		}

		if (!gameCount.chars().allMatch(Character::isDigit)) {
			throw new IllegalArgumentException("숫자만 입력 가능합니다.");
		}

		return Integer.parseInt(gameCount);
	}

	private boolean isPresentString(String moveCount) {
		return moveCount.trim().length() == 0 || moveCount == null;
	}
}
