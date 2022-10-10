package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarRace {
    private Cars cars;
    private Number tryCount;
    private RaceSheet raceSheet;

    public CarRace(String carNames) {
        this.cars = new Cars(initCars(carNames));
        this.raceSheet = new RaceSheet();
    }

    public void inputTryCount(String tryCount) {
        this.tryCount = new Number(tryCount);
    }

    private List<Car> initCars(String carNameString) {
        List<Car> cars = new ArrayList<>();
        String[] carNameArray = carNameString.split(",");

        for (String carName : carNameArray) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public List<Cars> racingGameStart() {
        while (tryCount.getNumber() > 0) {
            cars.racing();
            raceSheet.addSheet(cars);
            tryCount.minusNumber();
        }

        return raceSheet.getRaceSheets();
    }

    public List<Car> extractWinner() {
        return cars.extractWinner();
    }
}
