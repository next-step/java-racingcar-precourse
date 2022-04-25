package racingcar.domain;

import racingcar.utils.RandomNumber;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGame {

    private Cars cars;
    private NumberOfAttempts numberOfAttempts;

    public CarRacingGame(Cars cars, NumberOfAttempts numberOfAttempts) {
        this.cars = cars;
        this.numberOfAttempts = numberOfAttempts;
    }

    public static CarRacingGame of(String carNameWithComma, int numberOfAttempts) {
        return new CarRacingGame(new Cars(carNameWithComma), NumberOfAttempts.of(numberOfAttempts));
    }

    public List<Car> start() {
        List<Car> carList = this.cars.getCars();
        List<Car> resultList = new ArrayList<>();
        int length = this.numberOfAttempts.getNumberOfAttempts();
        for (int round = 1; round <= length; round++) {
            progressGame(carList, resultList);
        }
        return resultList;
    }

    private void progressGame(List<Car> carList, List<Car> resultList) {
        for (Car car : carList) {
            resultList.add(car.move(RandomNumber.create()));
        }
        resultList.add(null);
    }
}
