package racinggame;

import java.util.List;

public class Message {
    private static final String NAME_DELIMITER = " : ";
    private static final String MOVE_INDICATOR = "-";
    private static final String WINNER_NAME_DELIMITER = ",";
    private static final String WINNER_TEXT_FORWARD = "최종 우승자는 ";
    private static final String WINNER_TEXT_BACKWARD = " 입니다.";
    private static final String INTRO_INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String INTRO_INPUT_GAME_COUNT = "시도할 횟수는 몇 회 인가요?";

    private Message() {
    }

    public static String printCarSpecification(String name, int moveCount) {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(NAME_DELIMITER);
        for (int i=0; i<moveCount; i++) {
            sb.append(MOVE_INDICATOR);
        }

        return sb.toString();
    }

    public static String printCarsSpecification(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        for (Car car: cars) {
            sb.append(car.toString()).append(System.lineSeparator());
        }

        return sb.toString();
    }

    public static String printRaceResult(Cars cars) {
        StringBuilder sb = new StringBuilder();
        sb.append(cars.toString());

        if (RaceManager.getInstance().isGameEnd()) {
            sb.append(System.lineSeparator())
                    .append(getWinnerAsText(cars.getWinnersName()))
                    .append(System.lineSeparator());
        }

        return sb.toString();
    }

    private static String getWinnerAsText(List<String> winners) {
        StringBuilder sb = new StringBuilder();
        sb.append(WINNER_TEXT_FORWARD)
                .append(String.join(WINNER_NAME_DELIMITER, winners))
                .append(WINNER_TEXT_BACKWARD);

        return sb.toString();
    }

    public static void printIntroCarsNameInput() {
        System.out.println(INTRO_INPUT_CAR_NAME);
    }

    public static void printIntroGameCount() {
        System.out.println(INTRO_INPUT_GAME_COUNT);
    }
}
