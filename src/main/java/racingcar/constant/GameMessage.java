package racingcar.constant;

public final class GameMessage {
    public static final String CAR_NAME_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String CAR_TRY_COUNT_REQUEST_MESSAGE = "시도할 회수는 몇회인가요?";
    public static final String SHOW_WINNER_MESSAGE = "최종 우승자: %s\n";
    public static final String NOT_VALID_TRYCOUNT_NUMBER_MESSAGE = "[ERROR] 시도 횟수는 숫자여야 합니다.";
    private static final String CREATION_ERROR_MESSAGE = "[ERROR] common game message class";

    private GameMessage() {
        throw new IllegalStateException(CREATION_ERROR_MESSAGE);
    }

}
