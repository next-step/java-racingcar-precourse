package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Winner;

import java.util.ArrayList;
import java.util.List;

public class ResultMessageView {
    private static final String RESULT_START_MESSAGE = "실행 결과";
    private static final String PROGRESS_BAR = "-";
    private static final String FINAL_WINNER_MESSAGE = "최종 우승자는 %s 입니다.";

    public static void printResultStartMessage() {
        System.out.println(RESULT_START_MESSAGE);
    }

    public static void printRaceProgressStatus(Cars cars) {
        cars.getCars().forEach(ResultMessageView::printCarPosition);
        System.out.println();
    }

    private static void printCarPosition(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(PROGRESS_BAR);
        }
        System.out.println();
    }

    public static void printFinalWinnerMessage(Winner winner) {
        List<String> winnerCarNames = new ArrayList<>();
        winner.getWinners()
                .forEach(car -> winnerCarNames.add(car.getName()));
        System.out.printf(FINAL_WINNER_MESSAGE,
                String.join(",", winnerCarNames));
    }
}
