package domain;

import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private int racingCount;
    private Cars cars;
    private RandomNumber randomNumber;
    private OutputView outputView = new OutputView();

    public RacingGame(int racingCount, Cars cars) {
        this.racingCount = racingCount;
        this.cars = cars;
    }

    public Cars startRacing() {
        while (this.racingCount-- > 0) {
            racingCars();
            outputView.printGameStatus(this.cars.carList());
        }
        return new Cars(cars.currentFirstCarList());
    }

    private void racingCars() {
        for (Car car : cars.carList) {
            randomNumber = new RandomNumber();
            isMovableCar(car, car.isMovable(randomNumber.number()));
        }
    }

    private List<String> changeStringCarName(List<Car> carList) {
        List<String> carNames = new ArrayList<>();
        for (Car car : carList) {
            carNames.add(car.carName());
        }
        return carNames;
    }

    private void isMovableCar(Car car, boolean isMovable) {
        if (isMovable) {
            car.move();
        }
    }


}
