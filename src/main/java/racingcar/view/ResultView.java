package racingcar.view;

import java.util.List;
import java.util.StringJoiner;
import racingcar.constant.GameMessage;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

public class ResultView {
    private static final String WINNER_SEPARATOR = ", ";
    private static final String ROUND_SEPARATOR = "\n";

    public void printResult() {
        System.out.println(GameMessage.GAME_RESULT);
    }

    public void printRound(Cars cars) {
        for (Car car : cars.getValue()) {
            System.out.println(String.format(GameMessage.ROUND_RESULT_PER_CAR, car.getCarName(), printTrack(car.getTrack())));
        }

        System.out.println(ROUND_SEPARATOR);
    }

    private String printTrack(Integer value) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < value; i++) {
            result.append('-');
        }

        return result.toString();
    }

    public void printWinners(List<Car> winners) {
        StringJoiner result = new StringJoiner(WINNER_SEPARATOR);
        for (Car car : winners) {
            result.add(car.getCarName());
        }

        System.out.println(String.format(GameMessage.FINAL_WINNER, result));
    }
}
