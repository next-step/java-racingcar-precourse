package game.validator;

import game.exception.constant.ErrorMessage;

/**
 * 시도 횟수 입력에 대한 검증기
 */
public class AttemptCountValidator {

    private AttemptCountValidator() {
    }

    public static void validate(String attemptCountInput) {
        validateNumberFormat(attemptCountInput);
        validatePositiveNumber(attemptCountInput);
    }

    private static void validateNumberFormat(String attemptCountInput) {
        try {
            Integer.parseInt(attemptCountInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_INPUT.getMessage());
        }
    }

    private static void validatePositiveNumber(String attemptCountInput) {
        if (Integer.parseInt(attemptCountInput) <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ATTEMPT_COUNT_INPUT.getMessage());
        }
    }
}
