package racingcar.domain;

import racingcar.utils.CommonUtil;

import java.util.ArrayList;
import java.util.List;

import static racingcar.constant.Constant.*;

public class Cars {
    private final List<Car> answers;

    public Cars(List<Car> answers) {
        this.answers = answers;
    }

    public List<Car> getAnswers() {
        return answers;
    }

    public static Cars createCars(String names) {
        validationCarNames(names);
        String[] splitNames = names.split(COMMA);
        return new Cars(mapCar(splitNames));
    }

    private static List<Car> mapCar(String[] splitNames) {
        List<Car> cars = new ArrayList<>();
        for (String splitName : splitNames) {
            cars.add(Car.createCar(splitName));
        }
        return cars;
    }

    public static String getWinnerNames(Cars winnerCars) {
        List<String> winnerNames = new ArrayList<>();
        for (Car car : winnerCars.getAnswers()) {
            winnerNames.add(
                    car.getName().getName()

            );
        }
        return String.join(COMMA, winnerNames);
    }

    public Cars getWinnerResult() {
        List<Car> winnerCars = new ArrayList<>();
        int max = 0;
        for (Car car : answers) {
            max = car.getDistance() > max ? car.getDistance() : max;
        }

        for (Car car : answers) {
            if (car.getDistance() == max) {
                winnerCars.add(car);
            }
        }
        return new Cars(winnerCars);
    }

    private static void validationCarNames(String names) {
        if (CommonUtil.isNullOrEmptyCheck(names)) {
            throw new IllegalArgumentException(INPUT_VALUE);
        }
    }

    @Override
    protected Object clone() {
        List<Car> cloneCars = new ArrayList<>();
        for (Car car : answers) {
            Car cloneCar = new Car(car.getName(), car.getDistance());
            cloneCars.add(cloneCar);
        }
        return new Cars(cloneCars);
    }
}
