package racingcar;

public final class ErrorMessage {
    public final static String PREFIX = "[ERROR] ";
    public final static String CAR_NAME_OVER_LENGTH = PREFIX + "자동차 이름 길이를 초과했습니다.";
    public static final String CAR_NAME_EMPTY = PREFIX + "자동차 이름은 빈값일 수 없습니다.";
    public final static String LAP_COUNT_NOT_NUMBER = PREFIX + "시도 횟수는 숫자여야 한다.";
    public static final String ENTRY_NOT_VALID_SIZE = PREFIX + "레이싱은 최소 두개의 자동차가 있어야합니다.";
}
