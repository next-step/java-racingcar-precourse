package racinggame;

public class MoveCount {
	public static final String ERROR_MESSAGE = "[ERROR] 이동횟수는 숫자로만 입력이 가능합니다.";

	private int moveCount;

	public MoveCount(String moveCount) {
		try {
			this.moveCount = validatePositive(moveCount);
		} catch (IllegalArgumentException ex) {
			System.out.println(ERROR_MESSAGE);
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

}
