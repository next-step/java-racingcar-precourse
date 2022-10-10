package racingcar.model;

import racingcar.ErrorMessages;
import racingcar.RandomGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {
    private static final String NEW_LINE = System.lineSeparator();
    private static final String DELIMITER = ",";
    private static final int MIN = 0;
    private static final int MAX = 9;

    private final List<Car> cars = new ArrayList<>();

    public Cars(String carNames) {
        String[] carNameArray = reduceBlank(carNames).split(DELIMITER);
        for (String carName : carNameArray) {
            cars.add(new Car(carName));
        }
    }

    public void moveAll() {
        for (Car car : cars) {
            car.goOrStop(RandomGenerator.generateNumber(MIN, MAX + 1));
        }
    }

    public Winners getWinners() {
        return new Winners(cars);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.toString())
                    .append(NEW_LINE);
        }
        return sb.toString();
    }


    private String reduceBlank(String string) {
        return string.replaceAll(" ", "");
    }
}
