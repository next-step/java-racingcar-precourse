package game.validator;

import game.exception.constant.ErrorMessage;

/**
 * 시도 횟수 입력에 대한 검증기
 */
public class AttemptCountValidator {

    private static final AttemptCountValidator instance = new AttemptCountValidator();

    private AttemptCountValidator() {
    }

    public static AttemptCountValidator getInstance() {
        return instance;
    }

    public void validate(String attemptCountInput) {
        validateNumberFormat(attemptCountInput);
        validatePositiveValue(attemptCountInput);
    }

    private void validateNumberFormat(String attemptCountInput) {
        try {
            Integer.parseInt(attemptCountInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_INPUT.getMessage());
        }
    }

    private void validatePositiveValue(String attemptCountInput) {
        if (Integer.parseInt(attemptCountInput) <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ATTEMPT_COUNT_INPUT.getMessage());
        }
    }
}
