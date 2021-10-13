package racinggame;

public class MoveCount {
	private static final int MOVE_COUNT_BOUNDARY_MIN_VALUE = 1;
	private int moveCount;

	private MoveCount(int moveCount) {
		this.moveCount = moveCount;
	}

	public static MoveCount get(String moveCountBeforeValidation) {
		validateType(moveCountBeforeValidation);
		validateRange(moveCountBeforeValidation);
		return new MoveCount(Integer.parseInt(moveCountBeforeValidation));
	}

	private static void validateType(String moveCountBeforeValidation) {
		try {
			Integer.parseInt(moveCountBeforeValidation);
		} catch (NumberFormatException exception) {
			throw new IllegalArgumentException("[ERROR] 이동횟수는 1이상의 숫자만 입력 가능합니다.");
		}
	}

	private static void validateRange(String moveCountBeforeValidation) {
		if (isWrongValue(Integer.parseInt(moveCountBeforeValidation))) {
			throw new IllegalArgumentException("[ERROR] 이동횟수는 1이상의 숫자만 입력 가능합니다.");
		}
	}

	private static boolean isWrongValue(int moveCountAfterValidationType) {
		if (moveCountAfterValidationType < MOVE_COUNT_BOUNDARY_MIN_VALUE) {
			return true;
		}
		return false;
	}

	public int value() {
		return this.moveCount;
	}

	public void decrease() {
		this.moveCount--;
	}
}
