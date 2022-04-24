package racingcar.model.Message;

import racingcar.RacingCarConstants;

public class ErrorMessage {
    public static final String ERROR_PRIFIX = "[ERROR] ";
    public static final String ERROR_INPUT_CAR_NAMES = "자동차 이름은 " + RacingCarConstants.MAX_CAR_NAME_SIZE
            + "이하로 입력 해야한다.";
    public static final String ERROR_PLAY_COUNT = "시도 횟수는 숫자여야 한다.";
}
