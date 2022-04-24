package racingcar.common;

public class SystemMessage {

    public static final String INPUT_RACING_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_TIMES = "시도할 회수는 몇 회인가요?";
    public static final String RESULT = "실행결과";
    public static final String WINNER = "최종 우승자: ";

    private static final String ERROR = "[ERROR]";
    public static final String CAR_NAME_LENGTH_EXCEPTION = ERROR + " 자동차 이름은 5글자 이하 입니다.";
    public static final String NUMBER_EXCEPTION = ERROR + " 시도 횟수는 숫자로 입력해주세요.";
}
