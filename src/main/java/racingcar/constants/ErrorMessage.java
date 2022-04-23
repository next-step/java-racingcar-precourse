package racingcar.constants;

public final class ErrorMessage {

    private ErrorMessage() {
        throw new ClassCastException();
    }

    public static final String NAME_IS_REQUIRED = "[ERROR] 이름은 필수 값입니다.";
    public static final String NAME_MUST_BE_UNIQUE = "[ERROR] 이름은 고유 값이어야 합니다.";
    public static final String NAME_MUST_BE_FIVE_CHAR_OR_LESS = "[ERROR] 이름은 5글자 이하여야 합니다.";

    public static final String MOVE_IS_REQUIRED = "[ERROR] 이동 횟수는 필수 값입니다.";
    public static final String MOVE_MUST_BE_ALLOWED_INT = "[ERROR] 이동 횟수는 숫자 범위만 허용합니다.";
    public static final String MOVE_MUST_BE_NUMBER = "[ERROR] 이동 횟수는 숫자여야만 합니다.";

    public static final String MOVE_STATUS_NUMBER_MUST_BE_ALLOWED_RANGE = "[ERROR] 이동상태 입력 값은 특정 범위만 허용합니다.";
    public static final String MOVE_STATUS_MAP_IS_REQUIRED = "[ERROR] 이동상태 맵은 필수 값입니다.";

    public static final String MUST_HAVE_A_COUNT_TO_MOVE = "[ERROR] 이동하기 위해선 횟수가 있어야 합니다.";

}
