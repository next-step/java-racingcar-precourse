package racingcar.model;

import racingcar.constant.CompareResult;

import java.util.ArrayList;
import java.util.List;

import static racingcar.constant.CompareResult.*;

public class WinCars {

    private List<Car> winCars;
    private CompareResult compareResult;

    public List<Car> getWinCars() {
        return winCars;
    }

    public void generatorWinCars(RacingCars racingCars) {
        Car maxCar = new Car();
        maxCar.initAdvanceCount();
        this.winCars = calcWinCars(racingCars, maxCar);
    }

    private List<Car> calcWinCars(RacingCars racingCars, Car maxCar) {
        List<Car> winCar = new ArrayList<>();
        winCar.add(maxCar);
        for (Car car : racingCars.getRacingCars()) {
            compareWithCars(maxCar, car);
            maxCar = reSettingMaxCar(maxCar, car);
            winCar = resettingWinCars(winCar, car);
        }
        return winCar;
    }

    private void compareWithCars(Car maxCar, Car car) {
        int maxCount = maxCar.getNowAdvanceCount();
        int compareCount = car.getNowAdvanceCount();
        initCompareResult(maxCount, compareCount);
    }

    private void initCompareResult(int maxCount, int compareCount) {
        if (maxCount == compareCount) {
            this.compareResult = SAME;
        }
        if (maxCount > compareCount) {
            this.compareResult = LITTLE;
        }
        if (maxCount < compareCount) {
            this.compareResult = MANY;
        }
    }

    private Car reSettingMaxCar(Car maxCar, Car car) {
        if (compareResult == MANY) {
            return car;
        }
        return maxCar;
    }

    private List<Car> resettingWinCars(List<Car> winCars, Car car) {
        if (compareResult == MANY) {
            winCars = new ArrayList<>();
            winCars.add(car);
            return winCars;
        }
        if (compareResult == SAME) {
            winCars.add(car);
            return winCars;
        }
        return winCars;
    }
}
