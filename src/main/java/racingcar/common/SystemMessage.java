package racingcar.common;

public class SystemMessage {
    public static final String INPUT_RACING_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_TIMES = "시도할 회수는 몇 회인가요?";

    private static final String ERROR = "[ERROR] ";
    public static final String CAR_NAME_LENGTH_EXCEPTION = ERROR + "자동차 이름은 5글자 이하 입니다.";
}
