package racingcar.model;

public class Round {
    private static final int MIN_ROUND = 1;
    private static final int MAX_ROUND = 10;

    private static final String UNDER_MIN_ROUND_ERROR_MESSAGE = String.format("[ERROR] %d 이상의 시도 횟수를 입력해주세요!", MIN_ROUND);
    private static final String OVER_MAX_ROUND_ERROR_MESSAGE = String.format("[ERROR] %d 이하의 시도 횟수를 입력해주세요!", MAX_ROUND);
    private static final String NOT_NUMBER_ERROR_MESSAGE = "[ERROR] 시도 횟수는 숫자로 입력해주세요!";

    private final int tryTime;

    public Round(String tryTime) {
        int intTryTime = convertToInt(tryTime);
        validateRound(intTryTime);
        this.tryTime = intTryTime;
    }

    private int convertToInt(String tryTime) {
        try {
            return Integer.parseInt(tryTime);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR_MESSAGE);
        }
    }

    private void validateRound(int tryTime) {
        if (tryTime < MIN_ROUND) {
            throw new IllegalArgumentException(UNDER_MIN_ROUND_ERROR_MESSAGE);
        }
        if (tryTime > MAX_ROUND) {
            throw new IllegalArgumentException(OVER_MAX_ROUND_ERROR_MESSAGE);
        }
    }

    public int getTryTime() {
        return tryTime;
    }
}
