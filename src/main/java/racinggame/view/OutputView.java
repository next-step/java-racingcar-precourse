package racinggame.view;

public class OutputView {
    public static final String CAR_NAMES_INPUT_NOTICE_STR = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String ROUND_INPUT_NOTICE_STR = "시도할 회수는 몇회인가요?";
    public static final String RESULT_NOTICE_STR = "실행 결과";

    public static final String ERR_CAR_NAMES_INPUT = "[ERROR] 올바른 자동차 이름이 아닙니다.";
    public static final String ERR_ROUND_INPUT = "[ERROR] 횟수는 숫자만 입력할 수 있습니다.";

    public static String getFinalWinnerStr(String winners) {
        return "최종 우승자는 " + winners + " 입니다.";
    }
}
