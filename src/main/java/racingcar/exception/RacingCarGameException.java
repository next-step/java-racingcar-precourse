package racingcar.exception;

public class RacingCarGameException {
    public static IllegalArgumentException throwIllegalArgumentException(String error) {
        return new IllegalArgumentException(error);
    }
}
