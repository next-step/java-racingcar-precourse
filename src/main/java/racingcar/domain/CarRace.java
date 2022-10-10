package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarRace {
    private List<Car> cars;
    private int tryCount;

    public CarRace(String carNames, String tryCount) {
        this.cars = initCars(carNames);
        this.tryCount = parseInt(tryCount);
    }

    private static int parseInt(String tryCount) {
        if (!isNumeric(tryCount)) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 합니다.");
        }
        return Integer.parseInt(tryCount);
    }

    public static boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private List<Car> initCars(String carNameString) {
        List<Car> cars = new ArrayList<>();
        String[] carNameArray = carNameString.split(",");

        for (String carName : carNameArray) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public void racingGameStart() {
        while (tryCount > 0) {
            racing();
            tryCount--;
        }
    }

    private void racing() {
        for (Car car : cars) {
            car.moveForward(new RandomMovingStrategy());
        }
    }
}
