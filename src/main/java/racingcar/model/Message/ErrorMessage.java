package racingcar.model.Message;

import racingcar.RacingCarConstants;

public class ErrorMessage {
    public static final String ERROR_PRIFIX = "[ERROR] ";
    public static final String ERROR_INPUT_CAR_NAMES = "자동차 이름은 " + RacingCarConstants.MAX_CAR_NAME_SIZE
            + "이하로 입력 해야한다.";
    public static final String ERROR_PLAY_COUNT_NOT_NUMBER = "시도 횟수는 숫자여야 한다.";
    public static final String ERROR_PLAY_COUNT_NOT_RANGE = "유효한 범위의 숫자를 입력해야 한다.";
}
