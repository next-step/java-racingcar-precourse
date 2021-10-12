package racinggame.domain;

public class Message {
    public static final String ASK_INPUT_CARS_MSG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String ASK_INPUT_CHANCE_MSG = "시도할 회수는 몇 회인가요?";

    public static final String INPUT_CARS_LEN_ERROR_MSG = "[ERROR] 자동차 이름은 5글자 이하로 해주세요";
    public static final String INPUT_CARS_NULL_ERROR_MSG = "[ERROR] 자동차를 한 대 이상 입력해주세요";
    public static final String INPUT_CHANCES_ERROR_MSG = "[ERROR] 시도할 회수는 숫자여야합니다";
    public static final String INPUT_CHANCES_RANGE_ERROR_MSG = "[ERROR] 시도할 회수는 0이상의 숫자여야합니다";
    public static final String OUTPUT_TITLE = "\n실행결과";
}
