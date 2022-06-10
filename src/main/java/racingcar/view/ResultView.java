package racingcar.view;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.car.Record;

public class ResultView {
    public static final int FIRST_GAME = 1;
    public static final int MARGIN = 1;
    public static final int START_TEXT_INDEX = 0;
    public static final String DASH = "-";
    public static final String COLUMN = " : ";
    public static final String COMMA = ",";
    public static final String GAME_RESULT = "실행결과";
    public static final String WINNER_MESSAGE = "최종 우승자는 ";
    public static final String WINNER_MESSAGE2 = " 입니다.";

    private Cars winners;
    private Record record;

    public ResultView(Cars winners, Record record) {
        this.winners = winners;
        this.record = record;
    }

    public void show() {
        System.out.println(GAME_RESULT);
        for (int count = FIRST_GAME; count <= record.size(); count++) {
            Cars record = this.record.getRecord(count);
            showCarPositions(record);
            System.out.print(System.lineSeparator());
        }
        showWinner();
    }

    private String showGraph(int position) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < position; j++) {
            sb.append(DASH);
        }
        return sb.toString();
    }

    private void showCarPositions(Cars cars) {
        for (Car car : cars.getCars()) {
            final String playerName = String.valueOf(car.getName());
            final String position = showGraph(car.getPosition());
            System.out.println(playerName + COLUMN + position);
        }
    }

    private void showWinner() {
        StringBuilder sb = new StringBuilder();
        for (Car car : winners.getCars()) {
            sb.append(car.getName() + COMMA);
        }
        final String winners = sb.substring(START_TEXT_INDEX, sb.length() - MARGIN);
        System.out.println(WINNER_MESSAGE + winners + WINNER_MESSAGE2);
    }
}
