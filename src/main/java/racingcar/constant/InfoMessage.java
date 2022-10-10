package racingcar.constant;

public class InfoMessage {
    public static final String ERROR_MESSAGE_BEGIN = "[ERROR]";
    public static final String WRITE_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String TRIAL_COUNT = "시도할 회수는 몇회인가요?";
    public static final String GAME_RESULT = "실행 결과";
    public static final String WINNER = "최종 우승자 :";

    private final String label;

    InfoMessage(String label) {
        this.label = label;
    }

    public String label() {
        return this.label;
    }
}
