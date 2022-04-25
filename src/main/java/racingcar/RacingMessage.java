package racingcar;

import static racingcar.ValidUtils.COMPARE_LENGTH;

public class RacingMessage {
    public static final String MESSAGE_ERROR = "[ERROR] ";
    public static final String MESSAGE_ERROR_EMPTY = MESSAGE_ERROR + "자동차 이름을 입력하여 주세요.";
    public static final String MESSAGE_ERROR_OVER_LENGTH = MESSAGE_ERROR + "자동차 이름은 " + COMPARE_LENGTH + "5글자를 넘을 수 없습니다.";
    public static final String MESSAGE_ERROR_NUMBER_FORMAT = MESSAGE_ERROR + "시도 횟수는 숫자여야 합니다.";
    public static final String MESSAGE_SPACE = " ";
    public static final String MESSAGE_COLON = ":";
    public static final String MESSAGE_LAP = "-";
    public static final String MESSAGE_WINNERS_PRE_FIX = "최종 우승자: ";
    public static final String MESSAGE_COMMA = ",";
    public static final String MESSAGE_QUESTION_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String MESSAGE_QUESTION_LAP_COUNT = "시도할 회수는 몇회인가요?";

}
