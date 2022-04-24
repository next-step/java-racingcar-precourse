package racingcar.view;

import java.util.List;
import racingcar.model.GameRule;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;

public class GameResultView {

    private static final String GAME_RESULT_TITLE_MESSAGE = "실행결과";
    private static final String LINE_SEPARATOR = "\n";
    private static final String WINNER_SEPARATOR = ", ";
    private static final String GAME_RESULT_FINAL_MESSAGE = "최종 우승자: ";

    public void ResultMessage(Cars cars, GameRule gameRule) {
        System.out.print(LINE_SEPARATOR);
        System.out.println(GAME_RESULT_TITLE_MESSAGE);
        printPerTryCount(cars, gameRule);
        System.out.print(GAME_RESULT_FINAL_MESSAGE);
        printGameResult(cars);
    }

    private void printPerTryCount(Cars cars, GameRule gameRule) {
        for (int tryCountIndex = 0; tryCountIndex < gameRule.getTryCount(); tryCountIndex++) {
            cars.carMovingMessage(tryCountIndex);
            System.out.print(LINE_SEPARATOR);
        }
    }

    private void printGameResult(Cars cars) {
        List<Car> values = cars.getSameScoreCars(cars.getWinner());
        for (int index = 0; index < values.size(); index++) {
            System.out.print(values.get(index).getCarName());
            isPrintWinnerSeparator(values, index);
        }
    }

    private void isPrintWinnerSeparator(List<Car> cars, int index) {
        if (cars == null || cars.size() <= 0) {
            return;
        }

        if (cars.size() == index + 1) {
            return;
        }

        System.out.print(WINNER_SEPARATOR);
    }


}
