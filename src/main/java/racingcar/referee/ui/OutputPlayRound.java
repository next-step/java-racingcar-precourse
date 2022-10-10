package racingcar.referee.ui;

import racingcar.car.domain.Car;
import racingcar.referee.domain.RacingCars;

public class OutputPlayRound {

    public static final String DELIMITER = " : ";

    public static void printPlayRound(RacingCars racingCars) {
        for (Car car : racingCars.cars()) {
            StringBuilder content = new StringBuilder(car.carName() + DELIMITER);
            convertFromPositionToDash(car.carPosition().position(), content);
            System.out.println(content);
        }
        System.out.println();
    }

    private static void convertFromPositionToDash(int position, StringBuilder content) {
        for (int i = 0; i < position; i++) {
            content.append("-");
        }
    }
}
