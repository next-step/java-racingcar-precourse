package racingcar;

public class Validator {

    private static final Integer CAR_NAME_LIMIT_LENGTH = 5;
    private static final String CAR_LENGTH_ERROR = String.format("차의 이름은 %d자 이내이어야 한다.", CAR_NAME_LIMIT_LENGTH);
    private static final String TRY_COUNT_NUMBER_ERROR = "시도 회수는 숫자여야 한다.";

    public static void validateCarName(String carName) {
        if (carName.length() > CAR_NAME_LIMIT_LENGTH) {
            throw new IllegalArgumentException(CAR_LENGTH_ERROR);
        }
    }

    public static void validateTryCount(String tryCount) {
        try {
            Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TRY_COUNT_NUMBER_ERROR);
        }
    }
}