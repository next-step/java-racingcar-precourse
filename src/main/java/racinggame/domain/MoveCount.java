package racinggame.domain;

public class MoveCount {
	public static final String ERROR_MESSAGE = "[ERROR] 시도횟수는 숫자로만 입력이 가능합니다.";

	private int moveCount;

	public MoveCount(String moveCount) {
		try {
			this.moveCount = validatePositive(moveCount);
		} catch (NumberFormatException ex) {
			throw new IllegalArgumentException(ERROR_MESSAGE);
		}
	}

	private int validatePositive(String moveCount) {
		int result = Integer.parseInt(moveCount);
		if (result < 0) {
			throw new IllegalArgumentException(ERROR_MESSAGE);
		}
		return result;
	}

	public boolean isEnd(int tryCount) {
		return moveCount == tryCount;
	}
}
