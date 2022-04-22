package racingcar.view;

import racingcar.constant.RacingGameMessage;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class PlayPrinter {

    private static final String HYPHEN = "-";

    public void playPrint(Cars cars) {
        System.out.println(RacingGameMessage.RUN_RESULT_MESSAGE);
        for (Car car : cars.getValues()) {
            System.out.println(String.format(RacingGameMessage.STEP_RESULT_MESSAGE_FORMAT, car.getName(),
                    printDistance(car.getDistance())));
        }
    }

    private String printDistance(Integer distance) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            result.append(HYPHEN);
        }
        return result.toString();
    }

    public void printWinners(String names) {
        System.out.println(String.format(RacingGameMessage.WINNER_MESSAGE_FORMAT, names));
    }
}
