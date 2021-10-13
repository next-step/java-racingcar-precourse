package racinggame;

import racinggame.common.CommonCode;
import racinggame.common.CommonMessage;

public class MoveCount {
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
			throw new IllegalArgumentException(CommonMessage.ERROR_MESSAGE_VALIDATE_MOVE_COUNT);
		}
	}

	private static void validateRange(String moveCountBeforeValidation) {
		if (isWrongValue(Integer.parseInt(moveCountBeforeValidation))) {
			throw new IllegalArgumentException(CommonMessage.ERROR_MESSAGE_VALIDATE_MOVE_COUNT);
		}
	}

	private static boolean isWrongValue(int moveCountAfterValidationType) {
		if (moveCountAfterValidationType < CommonCode.MOVE_COUNT_BOUNDARY_MIN_VALUE) {
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
