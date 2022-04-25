package racingcar.domain;

import racingcar.utils.Validation;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private List<Car> carList;

    public void generateCars(String carNames) {
        String[] carNameSplit = carNames.split(",");
        validateCarName(carNameSplit);
        validateDuplicate(carNameSplit);
        List<Car> tempCarList = addCars(carNameSplit);
        this.carList = tempCarList;
    }

    public List<Car> addCars(String[] carNameSplit) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNameSplit) {
            Car car = new Car(carName);
            cars.add(car);
        }
        return cars;
    }

    public List<Car> getCars() {
        return this.carList;
    }

    public void validateCarName(String[] carNameSplit) {
        for (String carName : carNameSplit) {
            Validation.isNotEmptyName(carName);
            Validation.isSizeOver(carName);
        }
    }

    public void validateDuplicate(String[] carNameSplit) {
        Set<String> carSet = new HashSet<>();
        for (String carName : carNameSplit) {
            carSet.add(carName);
        }

        if (carNameSplit.length != carSet.size()) {
            throw new IllegalArgumentException(OutputView.printInputError());
        }
    }
}
