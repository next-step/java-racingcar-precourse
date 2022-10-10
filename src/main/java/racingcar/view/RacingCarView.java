package racingcar.view;

import racingcar.contant.RacingCarMessage;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.car.Distance;

public class RacingCarView {

    public static final String HYPHEN = "-";

    public void printStepResultGuide() {
        System.out.println(RacingCarMessage.STEP_RESULT_GUIDE);
    }

    public void printStepResult(Cars cars) {
        for (Car racingCar : cars.getRacingCars()) {
            System.out.printf(
                    (RacingCarMessage.STEP_RESULT_FORMAT) + "%n",
                    racingCar.getName().name(),
                    printDistance(racingCar.getDistance()));
        }
        System.out.println();
    }

    private String printDistance(Distance distance) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < distance.distance(); i++) {
            result.append(HYPHEN);
        }
        return result.toString();
    }

    public void printWinners(Cars cars) {
        System.out.printf((RacingCarMessage.WINNERS) + "%n", printWinnerNames(cars));
    }

    private String printWinnerNames(Cars cars) {
        return String.join(", ", cars.findWinnerNames());
    }
}
