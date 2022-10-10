package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.contant.RacingCarMessage;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

public class RacingCarInput {

    private static final String INPUT_CAR_NAMES_SEPARATOR = ",";

    public Cars getCars() {
        System.out.println(RacingCarMessage.INPUT_CAR_NAMES);
        String carNames = Console.readLine();
        try {
            InputValidator.validateCarNames(carNames);
            return convertStringToCars(carNames);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return this.getCars();
        }
    }

    private Cars convertStringToCars(String carNames) {
        String[] splitCarNames = carNames.split(INPUT_CAR_NAMES_SEPARATOR);
        List<Car> cars = new ArrayList<>();
        for (String carName : splitCarNames) {
            cars.add(Car.from(carName));
        }
        return Cars.from(cars);
    }

    public int getTryCount() {
        System.out.println(RacingCarMessage.TRY_COUNT);
        String tryCount = Console.readLine();
        try {
            InputValidator.validateTryCount(tryCount);
            return Integer.parseInt(tryCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return this.getTryCount();
        }
    }
}
