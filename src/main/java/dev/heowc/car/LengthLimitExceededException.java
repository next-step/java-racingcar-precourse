package dev.heowc.car;

public final class LengthLimitExceededException extends RuntimeException {

    private static final String MESSAGE = "길이를 %d를 넘을 수 없습니다. (입력값 길이: %d)";

    LengthLimitExceededException(String value) {
        super(String.format(MESSAGE, RacingCar.NAME_LENGTH_LIMIT, value.length()));
    }
}
