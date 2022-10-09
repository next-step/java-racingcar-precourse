package racingcar.common;

public class ExcMessage {
    public static final String INPUT = "경주 할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public static final String TRY = "시도할 회수는 몇회인가요?";

    public static final String WINNER = "최종 우승자 : ";

    public static final String NUMBER_REGEX = "^[0-9]*$";

    public static final String ERROR_NUMBER = "[ERROR] 시도 횟수는 숫자여야 한다.";

    public static final String ERROR_EMPTY = "[ERROR] 값을 입력해주세요.";

    public static final String ERROR_LENGTH = "[ERROR] 이름은 5자리 이하로 입력해주세요.";
}
